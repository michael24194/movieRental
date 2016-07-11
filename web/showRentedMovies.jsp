<%-- 
    Document   : showRentedMovies
    Created on : Dec 29, 2015, 2:34:07 AM
    Author     : Miki
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataBase.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.Movie"  %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rented movies</title>
    </head>
    <body>
        <h2>Rented movies</h2>
        <%
            String u_ID = session.getAttribute("userid").toString();
            Database database=new Database();
            ArrayList<String>rentedMovies=database.getMoviesRentedBy(u_ID);
            ArrayList<String>rentedMovieID=database.getMoviesIDRentedBy(u_ID);
            session.setAttribute("moviesRented", rentedMovies);
        %>
        <br><br>
        <form action="showRentedMovieDetailsToUser" method="get">
       <%
            for(int i=0;i<rentedMovies.size();i++){
                String s = rentedMovieID.get(i);
       %>
       <input type="submit" value="<%=rentedMovies.get(i)%>" name="<%=rentedMovies.get(i)%>" />
       &nbsp;&nbsp;&nbsp;&nbsp;
       <a href="extendRental?ID=<%=s%>" >Extend rental</a><br><br>
       <%}%>
       </form>
    </body>
</html>