<%@ page import = "java.util.*,javax.servlet.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*" %>

<%@page import="myAssignment3.*"%>

<%
	String imageLocation = " ";
	int productPrice = 0;
		
		session = request.getSession(true);
		String user=((String)session.getAttribute("userid")); 

		String price=request.getParameter("totalprice");
%>
			
		<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="IndexPageJsp.jsp">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  <span style="width:110px;display:inline-block"></span>  <h2 style="float:right">Welcome<span style="width:110px;display:inline-block"><a href="#"></a></span>  <a href="SignOutJsp.jsp">Sign <span>Out</span></a></h2>  </div>  </header>
        <div class="menu-wrap">  <nav class="menu">  <ul class="clearfix">   <li><a href="IndexPageJsp.jsp">Home</a></li>  <li>
        <a href="#">Products</a>  <ul class="sub-menu">  <li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li>  <li><a href="TabletDisplayJsp.jsp">Tablets</a></li>
        <li><a href="LaptopDisplayJsp.jsp">Laptops</a></li>  <li><a href="TvDisplayJsp.jsp">TV</a></li>  </ul>  </li>  </ul>
        </nav>  </div>  <img class="header-image" src="images/multiple_picture_wallpaper.jpg" alt="Buildings" />
        <p>  <p>
        <div id="content_product">
							
		
			 <form method="get" action="SubmitOrderJsp.jsp">
			<fieldset>
			<legend>Order information:</legend>
			
			<table>		
							
			<tr>
			<td>Product Price: </td>
			<td> <input type="text" name="productPrice" value= <%=price %> readonly style="margin-left: 245px;"> </td>
			</tr>
			</table>
			</fieldset>
		
			<fieldset>
			<legend>Personal information:</legend>
			<table>
			<tr>
			<td> First name: </td>
			<td> <input type="text" name="firstName"> </td>
			</tr>				
			<tr>
			<td> Last name: </td>
			<td> <input type="text" name="lastName"> </td>
			</tr>				
			<tr>
			<td> Address: </td>
			<td> <input type="text" name="address"> </td>
			</tr>
			<tr>
			<tr>
			<td> Phone: </td>
			<td> <input type="text" name="phoneNumber"> </td>
			</tr>
			<td> Credit Card Information: </td>
			<td> <input type="text" name="creditcard"> </td>
			</tr>
			</table>
			<br><br>
			<input type="submit" value="Place Order">			
			</fieldset>		
			</form>
			</div>
			<aside class="sidebar"><ul><li><h4>Categories</h4><ul><li><a href="IndexPageJsp.jsp">Home Page</a></li><li><a>Our Products</a><ul>
            <li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li><li><a href="TabletDisplayJsp.jsp">Tablets</a></li><li><a href="SmartPhoneDisplayJsp.jsp">Laptops</a></li>
            <li><a href="TvDisplayJsp.jsp">TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class="text"><p style="margin: 0;">We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you
            </li></ul></li><li><h4>Search site</h4><ul><li class="text"><form method="get" class="searchform" action="#" ><p><input type="text" size="30" value="" name="s" class="s" /></p>
            </form></li></ul></li></ul></aside><div class="clear"></div></div>
			<div id = "footer"><footer><div class="footer-bottom"><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>		
			</body>
			</html>
