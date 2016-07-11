/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.Admin;
import Beans.Movie;
import DataBase.Database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fady
 */
@WebServlet(urlPatterns = {"/UpdateMovie"})
public class UpdateMovie extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Movie</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Update Movie Details</h1>");
            out.println("</body>");
            out.println("</html>");
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
        PrintWriter out = response.getWriter();
        Database database = new Database();
        HttpSession session=request.getSession(true);
        Object  id =  session.getAttribute("m_id");
        System.out.println("id= "+id.toString());
        String temp= id.toString();
        int movieId=Integer.parseInt(temp);
        String movieName = request.getParameter("movieName");
        String releaseDate = request.getParameter("releaseDate");
        float rate = Float.parseFloat(request.getParameter("rate"));
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        Movie movie = new Movie(movieId,movieName, releaseDate, description, rate, price);
        Admin admin = (Admin) session.getAttribute("admin");
        int currentAdminId = database.getIdOfCurrentAdmin(admin);
        database.UpdateMovie(movie, currentAdminId);
        if (database.UpdateMovie(movie, currentAdminId) == true) {
            out.println("Movie Updated successfully");
            response.sendRedirect("movieSuccessfulInserted.jsp");
        }
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
