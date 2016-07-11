<%-- 
    Document   : Update date
    Created on : Dec 27, 2015, 12:07:11 PM
    Author     : amr masoud
--%>

<%@page import="Beans.User"%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Data</title>
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
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <%
                String email = request.getSession().getAttribute("email").toString();
                String id = request.getSession().getAttribute("userid").toString();
                User user = new User();
                user.getDate(email);
                if(user.getDate(email)!=null){   
        %>
        
            <div class="container">

            <form class="form-signin" action="UpdateData" name="form" id="form"  method="get">
                <h2 class="form-signin-heading">Enter Data You Want Change</h2>

                <label for="inputFirstName" class="sr-only">FirstName </label>
                <input type="text" id="fname" name="fname" class="form-control" placeholder=" FirstName" required="" autofocus="" value="<%= user.getDate(email).Fname %>">

                <label for="inputLastName" class="sr-only">LastName</label>
                <input type="text" id="lname" name="lname" class="form-control" placeholder=" LastName" required="" autofocus="" value="<%= user.getDate(email).Lname %>">

                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="text" id="email" name="email" class="form-control" placeholder="Email address" required="" autofocus="" value="<%= user.getDate(email).Email %>">
                <label for="inputCridet" class="sr-only">Credit </label>
                <input type="text" id="credit" name="credit" class="form-control" placeholder="Credit" required="" value="<%= user.getDate(email).Password %>">
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="text" id="pass" name="pass" class="form-control" placeholder="Password" required="" value="<%= user.getDate(email).Credit %>">
                

                <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
            </form>
        </div>
        <%
                } else{ 
        %>    
        <h6>No Data</h6>
        <% 
                }
        %>
        
        
    </body>
</html>
