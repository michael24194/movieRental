/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author Miki
 */
@WebServlet(urlPatterns = {"/process_ajax"})
public class process_ajax extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String sP  = request.getParameter("searchParameters");
            String name = sP.substring(0, sP.lastIndexOf(" "));
            String mode = sP.substring(sP.lastIndexOf(" ") + 1, sP.length());
            try{
                
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.err.print("Error loaing driver" + cnfe);
        }
            Connection Con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_rent", "root", "123456789");
            Statement stmt = (Statement)Con.createStatement();
            boolean check = false;
            if (mode.equals("actor"))
            {
                ResultSet rs = stmt.executeQuery("select act_id from actor where act_name = '" + name + "'");
                String act_ID = "";
                while(rs.next())
                    act_ID = rs.getString(1);
                if (act_ID.equals(""))
                {
                    out.print("No movies found!");
                    out.close();
                }
                ResultSet rs2 = stmt.executeQuery("select m_id from act where act_ID = " + act_ID);
                Statement stmt2 = (Statement)Con.createStatement();
                while (rs2.next())
                {
                    String m_ID = rs2.getString(1);
                    ResultSet rs3 = stmt2.executeQuery("select m_name,m_ID from movie where m_ID = " + m_ID + " and m_isRent = false");
                    while(rs3.next())
                    {
                        out.print("Movie name : ");
                    out.print("<a href = 'processMovie?ID="+rs3.getString(2)+ "'>"+  rs3.getString(1)+"</a>");
                    out.print("<br>");
                    }
                    check = true;
                }
                if (check == false)
                    out.print("No movies found!");
                check = false;
            }
            else if (mode.equals("movie"))
            {
                ResultSet rs = stmt.executeQuery("select m_name,m_ID from movie where m_name = '" + name + "' and m_isRent = false");
                while (rs.next())
                {
                    out.print("Movie name : ");
                    out.print("<a href = 'processMovie?ID="+rs.getString(2)+ "'>"+  rs.getString(1)+"</a>");
                    out.print("<br>");
                    check = true;
                    
                }
                if (check == false)
                    out.print("No movies found!");
                check = false;
            }
            else if (mode.equals("year"))
            {
                ResultSet rs = stmt.executeQuery("select m_name,m_ID from movie where m_releaseDate = '" + name + "' and m_isRent = false");
                while (rs.next())
                {
                    out.print("Movie name : ");
                    out.print("<a href = 'processMovie?ID="+rs.getString(2)+ "'>"+  rs.getString(1)+"</a>");
                    out.print("<br>");
                    check = true;
                }
                if (check == false)
                    out.print("No movies found!");
                check = false;
            }
            
            /* TODO output your page here. You may use following sample code. */
            
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(process_ajax.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(process_ajax.class.getName()).log(Level.SEVERE, null, ex);
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
