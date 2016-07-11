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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

   
    
    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Database db  =new Database();
        
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        PrintWriter out = response.getWriter();
       
        
        if (db.checkUser(email, pass)==true) {
            HttpSession session = request.getSession(true);
            if (session.isNew() == false) {
                session.invalidate();
                session = request.getSession(true);
            }
            User user = new User();
            session.setAttribute("email", email);
            session.setAttribute("userid", user.getUserId(email, pass));
            System.out.println("id"+user.getUserId(email, pass));
            ServletContext context = this.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/Home.jsp");
            dispatcher.forward(request, response);
        } 
        else {
            out.println("Email or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("Login");
            rs.include(request, response);
        }
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
