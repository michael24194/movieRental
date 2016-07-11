<%-- 
    Document   : rentMovie
    Created on : Dec 28, 2015, 8:33:34 PM
    Author     : amr masoud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.Movie"  %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Details</title>
        <script>
            function check(form) {
                var name = form.numOfday.value.toString();
                if (name === "") {
                    alert("You must Enter number of days !");
                    return false;
                }
                if (isNaN(name)) {
                    alert("You must Enter a number!");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <h2>Movie Details </h2>
        <%
        Movie movie=(Movie)session.getAttribute("movieDetailes");
        %>
        
        <table>
            
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
                <form action="paymentAcceptance" name="form" id="form" onsubmit="return check(form);"> 
             Enter Numbers Of Days : <input type="text" id="numOfday" name="numOfday">
             <input type="submit" value="rent" />   
            </form>
                
           <form action="Home.jsp"> 
             
             <input type="submit" value="Home" />   
            </form>     
    </body>
</html>
