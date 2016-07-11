/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userController;


import Beans.User;
import DataBase.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {

    Database db = new Database();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String credit = request.getParameter("credit");
        User user = new User(fname, lname , email , password , credit);
        PrintWriter out = response.getWriter();
//            out.println(name +" " + email +" " + password +" " + birthday +" " + credit );
//        //out.print("a7a yad");
//        
//            RequestDispatcher rs = request.getRequestDispatcher("Signup.jsp");
//            rs.include(request, response);
        if (db.checkEmail(email)==false) {
            db.inserNewUser(user);
            HttpSession session = request.getSession(true);
            if (session.isNew() == false) {
                session.invalidate();
                session = request.getSession(true);
            }
            session.setAttribute("email", email);
            session.setAttribute("userid", user.getUserId(email, password));
            ServletContext context = this.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/Home.jsp");
            dispatcher.forward(request, response);
            
        } 
        else {
            out.println("Email is alrady used");
            RequestDispatcher rs = request.getRequestDispatcher("Signup.jsp");
            rs.include(request, response);
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
