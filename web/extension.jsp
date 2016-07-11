<%-- 
    Document   : extension
    Created on : Dec 29, 2015, 4:09:30 PM
    Author     : Miki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function check(form){
                var name = form.name.value.toString();
                if (isNaN(name)) {
                    alert("You must enter a number !");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <div> Enter days to extend </div>
        <form action="confirmPaymentRentalExtend" name="form" id="form" onsubmit="return check(form);">
            <input type="text" name="name" id="name"> <br><br>
            <input type="submit" value="Extend">
        </form>
    </body>
</html>
