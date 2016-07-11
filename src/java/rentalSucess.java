/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.Movie;
import DataBase.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userController.rentMovie;

/**
 *
 * @author Miki
 */
@WebServlet(urlPatterns = {"/rentalSucess"})
public class rentalSucess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Database db =new Database();
            HttpSession session = request.getSession(true);
            String movieID  = (String) session.getAttribute("m_ID");
            Movie movie = db.getMovieDetailsByID(movieID);
            Movie movie2 = db.getMovieDetails2(movie.getMovieName());
            out.print(movie2.getStartDate());
            int nDays = (int) session.getAttribute("nDays"); 
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        //movie.setStartDate(sdf.format(c.getTime()));
        try {
            c.setTime(sdf.parse(movie2.getEndDate()));
        } catch (ParseException ex) {
            Logger.getLogger(rentMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.add(Calendar.DATE, nDays);  // number of days to add
        
        movie2.setEndDate(sdf.format(c.getTime()));  // dt is now the new date  
         out.print(movie2.getEndDate());
         String id = (String) session.getAttribute("m_ID");
         db.rentMovie(id, movie2);
         response.sendRedirect("goBack.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
