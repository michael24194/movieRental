<%-- 
    Document   : AdminHomePage
    Created on : Dec 21, 2015, 6:09:59 PM
    Author     : GIG
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Beans.Admin" %>
<%@page import = "DataBase.Database" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home Page</title>
    </head>
    <body>
        <h2>Admin page</h2>
       <%
       Admin admin=(Admin)session.getAttribute("admin");
       %>
       <a href="addAdmin.html">Add new admin</a><br>
       <a href="UpdateMovie.jsp">Update Movie</a><br>
       <a href="addMovie.html">Add movie</a><br>
       <a href="SendMails">Send Email To Late Customers</a><br>
       <a href="returnMovies">return movie</a><br><br>
       
       <%
       Database database=new Database();
       ArrayList<String>MovieNames=database.getMoviesNames();
       session.setAttribute("movieNames", MovieNames);
       %>
       <br><br>
       <form action="getMovieDetails" method="POST">
       <%
       for(int i=0;i<MovieNames.size();i++){%>
       <input type="submit" value="<%=MovieNames.get(i)%>" name="<%=MovieNames.get(i)%>" /><br><br>
       <%}%>
       </form>
       
    </body>
</html>
