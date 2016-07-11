/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userController;

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

/**
 *
 * @author amr masoud
 */
@WebServlet(name = "rentMovie", urlPatterns = {"/rentMovie"})
public class rentMovie extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Database db = new Database();
        HttpSession session=request.getSession();
        Movie movie=(Movie)session.getAttribute("movieDetailes");
        int numOfDays = Integer.parseInt(session.getAttribute("numOfday").toString());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        movie.setStartDate(sdf.format(c.getTime()));
        try {
            c.setTime(sdf.parse(movie.getStartDate()));
        } catch (ParseException ex) {
            Logger.getLogger(rentMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.add(Calendar.DATE, numOfDays);  // number of days to add
        
        movie.setEndDate(sdf.format(c.getTime()));  // dt is now the new date
        
        String m_id = db.getMovieId(movie.getMovieName(), movie.getReleaseDate());
        
        String u_id = (String)session.getAttribute("userid");
        
       // System.out.print("uid="+u_id+" mid="+m_id);
        
        db.rentMovie(u_id, m_id, movie.getStartDate(), movie.getEndDate());
        PrintWriter out = response.getWriter();
        response.sendRedirect("sucessfulOperation.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
