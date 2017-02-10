<%@ page import = "java.util.*,javax.servlet.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*" %>

<%@page import="myAssignment3.*"%>

<%
			MySqlDataStoreUtilities.truncateCart();
			session = request.getSession(true);
			String productName = request.getParameter("productName");
			String productPrice = request.getParameter("productPrice");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String creditcard = request.getParameter("creditcard");			
			String status="Active";
			String user=((String)session.getAttribute("userid"));
			String title = "Your Order Placed Successfully";
			
			Random r = new Random( System.currentTimeMillis() );
			int rand= 10000 + r.nextInt(20000);
			String randString=Integer.toString(rand);			

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 14); // Adding 14 days
		String output = sdf.format(c.getTime());
		
		MySqlDataStoreUtilities.insertOrderHistory(randString,firstName,lastName,productPrice,address,phoneNumber,creditcard);	
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
                
        <HEAD><TITLE>  <%=title %>  </TITLE></HEAD> 
                <BODY BGCOLOR="#FDF5E6">
                <H1 ALIGN="CENTER">  <%=title %>  </H1>
				<H3 ALIGN="CENTER">Your Order Number :  <%=randString %>  </H3>
                <TABLE BORDER="1" ALIGN="CENTER"> 
                <TR BGCOLOR="#FFAD00"> 
                <TH>Order<TH>Details
				
				<TR><TD> First Name </TD>
				<TD>  <%=firstName%> </TD></TR>
				
				
				<TR><TD> Last Name  </TD>
				<TD>  <%=lastName%> </TD></TR>
				
				
				<TR><TD> Phone Number</TD>
				<TD>  <%=phoneNumber%> </TD></TR>
				
				<TR><TD> Address  </TD>
				<TD>  <%=address%> </TD></TR>			
				
					
				<TR><TD> Delivery Date  </TD>
				<TD>  <%=output%>  </TD></TR>
				</TABLE>

					
          </TABLE> 
           <FORM ACTION="OrderHistoryJsp.jsp"   
		    METHOD="get">
           <BIG><CENTER>
		   <p>Thank you for shopping with us...</p>
           <INPUT TYPE="SUBMIT" 
                  VALUE="Order History"> 
		   
           </CENTER></BIG></FORM>
					</div>
			<aside class="sidebar"><ul><li><h4>Categories</h4><ul><li><a href="IndexPageJsp.jsp">Home Page</a></li><li><a>Our Products</a><ul>
            <li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li><li><a href="TabletDisplayJsp.jsp">Tablets</a></li><li><a href="SmartPhoneDisplayJsp.jsp">Laptops</a></li>
            <li><a href="TvDisplayJsp.jsp">TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class="text"><p style="margin: 0;">We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you
            </li></ul></li><li><h4>Search site</h4><ul><li class="text"><form method="get" class="searchform" action="#" ><p><input type="text" size="30" value="" name="s" class="s" /></p>
            </form></li></ul></li></ul></aside><div class="clear"></div></div>
			<div id = "footer"><footer><div class="footer-bottom"><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>		
			</body>
			</html>
