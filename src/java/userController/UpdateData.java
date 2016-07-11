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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author amr masoud
 */
@WebServlet(name = "UpdateData", urlPatterns = {"/UpdateData"})
public class UpdateData extends HttpServlet {
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        User user = new User(request.getParameter("fname"),request.getParameter("lname"),request.getParameter("email"),request.getParameter("pass"),request.getParameter("credit"));
       
        Database db = new Database();
        String id = request.getSession().getAttribute("userid").toString();
        db.updateUser(user, id);
        RequestDispatcher rs = request.getRequestDispatcher("UpdateDate.jsp");
        rs.include(request, response);
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
