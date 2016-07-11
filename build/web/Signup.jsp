<%-- 
    Document   : Signup
    Created on : Dec 22, 2015, 4:08:49 PM
    Author     : amr masoud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script>
            function check(form) {

                var fname = form.fname.value.toString();
                var lname = form.lname.value.toString();
                var email = form.email.value.toString();

                var credit = form.credit.value.toString();
                var cpass = form.cpass.value.toString();
                var pass = form.pass.value.toString();
                if (fname === "" || lname === "" || email === "" || credit === "" || cpass === "" || pass === "") {
                    alert("Empty password or username !");
                    return false;
                }

                if (isNaN(credit)) {
                    alert("credit must be number !");
                    return false;
                }

                if (pass !== cpass) {
                    alert("confirm password not match with password ");
                    return false;

                }
                return true;
            }
        </script>
    </head>
    <body>
       
        <div class="container">

            <form class="form-signin" action="Signup" name="form" id="form" onsubmit="return check(form);" method="get">
                <h2 class="form-signin-heading">Please Sign Up</h2>

                <label for="inputFirstName" class="sr-only">FirstName </label>
                <input type="text" id="fname" name="fname" class="form-control" placeholder=" FirstName" required="" autofocus="">

                <label for="inputLastName" class="sr-only">LastName</label>
                <input type="text" id="lname" name="lname" class="form-control" placeholder=" LastName" required="" autofocus="">

                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="text" id="email" name="email" class="form-control" placeholder="Email address" required="" autofocus="">
                <label for="inputCridet" class="sr-only">Credit </label>
                <input type="text" id="credit" name="credit" class="form-control" placeholder="Credit" required="">
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="text" id="pass" name="pass" class="form-control" placeholder="Password" required="">
                <label for="inputPasswordConfirm" class="sr-only">confirm Password</label>
                <input type="text" id="cpass" name="cpass" class="form-control" placeholder="Confirm paPassword" required="">

                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
            </form>
        </div>    
    </body>
</html>
