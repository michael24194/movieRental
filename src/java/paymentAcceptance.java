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
@WebServlet(urlPatterns = {"/paymentAcceptance"})
public class paymentAcceptance extends HttpServlet {

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
            
            HttpSession session = request.getSession();
            Movie movie = (Movie) session.getAttribute("movieDetailes");
            int numOfDays = Integer.parseInt(request.getParameter("numOfday"));
            session.setAttribute("numOfday",numOfDays);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            movie.setStartDate(sdf.format(c.getTime()));
            try {
                c.setTime(sdf.parse(movie.getStartDate()));
            } catch (ParseException ex) {
                Logger.getLogger(rentMovie.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.add(Calendar.DATE, numOfDays);  // number of days to add
            double totalFee = movie.getPrice() * numOfDays;
            session.setAttribute("totalFee", totalFee);
            out.print("Enter your credit card number : ");
            out.print("<form action = 'checkCreditCard' id = 'form' name='form'>");
            out.print("Credit Number : <input type = 'text' name = 'c' id = 'c'>");
            out.print("<br>");
            out.print("<input type = 'submit' value = 'Check in credit card'>");
            out.print("</form");
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
