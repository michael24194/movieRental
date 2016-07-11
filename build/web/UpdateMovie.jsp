<%-- 
    Document   : UpdateMovie
    Created on : Dec 28, 2015, 11:50:10 PM
    Author     : Fady
--%>

<%@page import="Beans.Movie"%>
<%@page import="DataBase.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% 
        Database database = new Database();
        int x=database.getNumberOfMovies();
        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Movie</title>
    </head>
    <body>
        <h1>Update Movie Details</h1>


        <form  action = "UpdateMovie2.jsp" onsubmit="return validate(this.value)"> 
            Movie ID:<input type="text" id="m_id"  name="m_id"/>
            <input type="submit" value="Submit" onclick=""/>
        </form>
    </body>
</html>
