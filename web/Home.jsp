<%-- 
    Document   : Home
    Created on : Dec 22, 2015, 4:03:11 PM
    Author     : amr masoud
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DataBase.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="Home.jsp">Movie Rental</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="Home.jsp">Home</a></li>
                        <li><a href="showRentedMovies.jsp">Rented Movies</a></li>
                        <li><a href="findMovie.jsp">Find Movie</a></li>
                        <li><a href="UpdateDate.jsp">Update profile </a></li>

                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.html"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <%
            Database database = new Database();
            ArrayList<String> MovieNamesNotRent = database.getMovieNotRent();
            session.setAttribute("movieNamesNotRent", MovieNamesNotRent);
        %>

        <div class="container">
            <h3>Movie List</h3>
            <p></p>

            <div class="btn-group-vertical">
                <form class="form-signin" action="getMovieDetailsToUser" method="get" >
                <%
                    for (int i = 0; i < MovieNamesNotRent.size(); i++) {
                %>
                    
                    <button class="btn btn-lg btn-primary btn-block" name="<%=MovieNamesNotRent.get(i)%>" value="<%=MovieNamesNotRent.get(i)%>" type="submit"><%=MovieNamesNotRent.get(i)%></button>
                </form>
                <%}%>

            </div>
        </div>

    </body>
</html>
