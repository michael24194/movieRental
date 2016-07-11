<%-- 
    Document   : findMovie
    Created on : Dec 27, 2015, 7:10:26 PM
    Author     : Miki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
   
<head>
<title>Find movie</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    
        function sendajax(){
                       
            var name = document.getElementById("name").value;
            var mode = document.getElementById("mode").value;
            var xmlhttp = new XMLHttpRequest();
            
            xmlhttp.open("GET","process_ajax?searchParameters="+name+" "+mode,true);
            xmlhttp.send();
            
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    document.getElementById("show_response").innerHTML=xmlhttp.responseText;
                }
            }
        }
    </script>
<!-- CSS styles for standard search box -->
<style type="text/css">
	#tfheader{
		background-color:#c3dfef;
	}
	.tftextinput{
		margin: -2px;
		padding: 0px 10px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:12px;
		border:1px solid #0076a3;border-right:0px;
		border-top-left-radius: 5px 5px;
		border-bottom-left-radius: 5px 5px;
	}
	.tfbutton {
		margin: -2px;
		padding: 0px 5px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:12px;
		cursor: pointer;
		text-align: center;
		color: #ffffff;
		border: solid 1px #0076a3; border-left:0px;
		background: #0095cd;
		background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
		background: -moz-linear-gradient(top,  #00adee,  #0078a5);
		border-top-right-radius: 5px 5px;
		border-bottom-right-radius: 5px 5px;
	}
	.tfbutton:hover {
		text-decoration: none;
		background: #007ead;
		background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
		background: -moz-linear-gradient(top,  #0095cc,  #00678e);
	}
	/* Fixes submit button height problem in Firefox */
	.tfbutton::-moz-focus-inner {
	  border: 0;
	}
	.tfclear{
		clear:both;
	}
</style>

</head>
<body>
	<!-- HTML for SEARCH BAR -->
	<div>
            <input type="search"  class="tftextinput" style="padding: 0px 15px;height: 18px" id="name" name="q" size="21">
            <select id="mode"name="mode" class="tftextinput" style="border-left:0px;border-top-left-radius: 0px 0px;border-bottom-left-radius: 0px 0px;">
                <option value="movie">Movie name</option>
                <option value="actor">Actor name</option>
                <option value="year">Release date</option>
            </select>
            <input type="button" onclick="sendajax()" value="search" class="tfbutton" style="height: 18px">	
        </div><br>
        <div id="show_response"></div>
</body>
</html>