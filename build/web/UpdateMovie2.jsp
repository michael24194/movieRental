<%-- 
    Document   : UpdateMovie2
    Created on : Dec 29, 2015, 2:48:36 AM
    Author     : Fady
--%>

<%@page import="Beans.Movie"%>
<%@page import="DataBase.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function validate() {
                var movieName = document.getElementById("movieName").value;
                var releaseDate = document.getElementById("releaseDate").value;
                var rate = document.getElementById("rate").value;
                var price = document.getElementById("price").value;
                var description = document.getElementById("description").value;

                if (movieName === "") {
                    alert("please enter movie Name");
                    return false;
                } else if (releaseDate === "") {
                    alert("please enter release Date");
                    return false;
                } else if (rate === "") {
                    alert("please enter movie Rate");
                    return false;
                } else if (price === "") {
                    alert("please enter movie Price");
                    return false;

                } else if (description === "") {
                    alert("please enter movie Description");
                    return false;
                } else {
                    return true;
                }
                return false;
            }


        </script>
        <title>Update Movie</title>
    </head>
    <body>
        <h1>Update Movie Details</h1>
        <%
            int movieID = Integer.parseInt(request.getParameter("m_id"));
            session.setAttribute("m_id",movieID);
            Database database = new Database();
            Movie movie = database.getMovieDetailsByID(movieID);
        %>


        <form  method="POST" action="UpdateMovie" onsubmit="return validate()">
            <table>
                <tr>
                    <td>
                        Movie Name         
                    </td>
                    <td>
                        <input type="text" name="movieName" id="movieName" value="<%=movie.getMovieName()%>"/>
                    </td>

                </tr>
                <tr>
                    <td>
                        Movie release date
                    </td>
                    <td>
                        <input type="text" name="releaseDate" id="releaseDate" value="<%=movie.getReleaseDate()%>" />
                    </td>

                </tr>
                <tr>
                    <td>
                        Movie Rate
                    </td>
                    <td>
                        <input type="text" name="rate" id="rate" value="<%=movie.getRate()%>" />
                    </td>

                </tr>
                <tr>
                    <td>
                        Price        
                    </td>
                    <td>
                        <input type="text" name="price" id="price" value="<%=movie.getPrice()%>" />   
                    </td>

                </tr>
                <tr>
                    <td>
                        Description 
                    </td>
                    <td>
                        <input  style="height: 100px;width: 300px"  type="text" name="description" id="description"  value="<%=movie.getDescription()%>" />
                    </td>

                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Update Movie"  />
                    </td>

                </tr>


            </table>
        </form>
    </body>
</html>
