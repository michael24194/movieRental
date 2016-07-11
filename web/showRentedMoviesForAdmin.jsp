<%-- 
    Document   : showRentedMoviesForAdmin
    Created on : Dec 29, 2015, 3:05:29 PM
    Author     : GIG
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        ArrayList<String>movies=(ArrayList<String>)session.getAttribute("movies");
        %>
        
        <p>name </p> &nbsp;   &nbsp;&nbsp; 
         <%
        for(int i=0;i<movies.size();i++){ %> 
        <%= movies.get(i) %><br> 
       <% }
        %>
        <form action="unRegisterMovie" method="POST">
            
            ID : <input type="text" name="movie_id" /><br>
            <input type="submit" value="unRent">
        </form>
        
    </body>
</html>
