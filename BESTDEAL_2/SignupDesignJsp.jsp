<%@ page import = "java.util.*,javax.servlet.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*" %>

<%@page import="myAssignment3.*"%>

        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="#">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <div id="body">  <section id="content">  <article>  <form method="post" action="SignupJsp.jsp">
        <h4>  Please Provide Your Login Details  </h4>
        <table cellpadding="2" cellspacing="1">  <tr>   <td>User ID</td>  <td><input type="TEXT" size="15" name="userid"></input></td>  </tr>
        <tr>  <td>Password</td>  <td><input type="PASSWORD" size="15" name="password"/></td>  </tr>
        <tr><td>Email ID</td><td><input type="TEXT" size="15" name="email"></input></td></tr>
        <tr><td>Phone Number</td><td><input type="TEXT" size="15" name="phone"></input></td></tr>
        <tr>  <td colspan="2">
        <center><input type="submit" value="Register" style="margin-right:100px;"/></center>  </td>  </tr>  </table>  </form>
        </div> 
        <div class="clear"></div>  </div>  <footer>  <div class="footer-bottom">  <p>MAKING TECHNOLOGY WORK FOR YOU..!!</p>  </div>  </footer>  </div>  </body>  </html>                        
        

