<%-- 
    Document   : Login
    Created on : Dec 22, 2015, 3:38:30 PM
    Author     : amr masoud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script>
            function check(form) {
                var name = form.email.value.toString();
                var pass = form.pass.value.toString();
                if (name === "" || pass === "") {
                    alert("Empty password or username !");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        
        <div class="container">

        <form class="form-signin" action="Login" name="form" id="form" onsubmit="return check(form);" method="get">
        <h2 class="form-signin-heading">Please Login</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="email" name="email" class="form-control" placeholder="Email address" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="text" id="pass" name="pass" class="form-control" placeholder="Password" required="">
        <div class="checkbox">
           
        </div>
        <button class="btn btn-lg btn-primary btn-block"  type="submit">Login</button>
      </form>

    </div>  
    </body>
</html>
