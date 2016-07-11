<%-- 
    Document   : confirmPay
    Created on : Dec 29, 2015, 9:57:57 AM
    Author     : GIG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String s = session.getAttribute("totalFee").toString();
        %>
        <div>You will pay  <%=s%> </div>
        <form action="rentMovie" method="get">
       <input type="submit" value="continue"  /><br>
       </form>
        <form action="Home.jsp" method="get">
       <input type="submit" value="go home"  /><br>
       </form>
        
    
    </body>
</html>
