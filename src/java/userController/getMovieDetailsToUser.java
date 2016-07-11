package userController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.Movie;
import DataBase.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GIG
 */
@WebServlet(urlPatterns = {"/getMovieDetailsToUser"})
public class getMovieDetailsToUser extends HttpServlet {

   
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        PrintWriter out=response.getWriter();
        ArrayList<String>movieNames=new ArrayList<>();
        movieNames=(ArrayList<String>) session.getAttribute("movieNamesNotRent");
        for(int i=0;i<movieNames.size();i++){
            if(request.getParameter(movieNames.get(i))!=null){
                  Database database=new Database();
                Movie movie=database.getMovieDetails(movieNames.get(i));
                session.setAttribute("movieDetailes", movie);
                response.sendRedirect("rentMovie.jsp");
            }
        }
        
        
        //processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
