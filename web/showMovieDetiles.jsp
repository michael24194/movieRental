<%-- 
    Document   : showMovieDetiles
    Created on : Dec 26, 2015, 11:56:01 AM
    Author     : GIG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.Movie"  %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Details</title>
    </head>
    <body>
        <h2>Movie Details </h2>
        <%
        Movie movie=(Movie)session.getAttribute("movieDetailes");
        %>
        
        <table>
           
             <tr>
                <td>
                    Movie ID
                </td>
                <td>
                    &nbsp;&nbsp;
             <%= movie.getID()  %>
                </td>
            </tr>
            <tr>
                <td>
                    Movie Name
                </td>
                <td>
                    &nbsp;&nbsp;
             <%= movie.getMovieName()  %>
                </td>
            </tr>
            <tr>
                <td>
                    Movie Description
                </td>
                <td>
                    &nbsp;&nbsp;
        <%=  movie.getDescription()   %>
                </td>
            </tr>
            <tr>
                <td>
                    Movie Release Date
                </td>
                <td>
                    &nbsp;&nbsp;
         <%=  movie.getReleaseDate()   %>
         
                </td>
            </tr>
               <tr>
                <td>
                    Movie Price
                </td>
                <td>
                    &nbsp;&nbsp;
                    <%=   movie.getPrice()  %>
                </td>
            </tr>
            <tr>
                <td>
                    Movie Rate
                </td>
                <td>
                    &nbsp;&nbsp;
                  <%=  movie.getRate()   %>
                </td>
            </tr>
           
        </table>
         <form action="adminHomePage.jsp"> 
             <input type="submit" value="back to admin Home page" />   
            </form>
    </body>
</html>
