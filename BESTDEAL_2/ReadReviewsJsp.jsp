<%@ page import = "java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

<%			
		try{
			 DBCollection myReviewsjsp = MongoDBDataStoreUtilities.createMongoDB();
			 HttpSession s=request.getSession();
        	 String username=(String)s.getAttribute("userid");
			 String productID= request.getParameter("productReadReviewId");
			 DBCursor cursor1 = MongoDBDataStoreUtilities.fetchReviewMongoDB(productID);
			 System.out.println("HIIIIIII::"+cursor1.count());
			 String productName=request.getParameter("productReadReviewName");
			 BasicDBObject obj;
%>
						
			
		<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="IndexPageJsp.jsp">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  <span style="width:110px;display:inline-block"></span>  <h2 style="float:right">Welcome  <%=username %>  !<span style="width:110px;display:inline-block"><a href="#"></a></span> <a href="SignOutJsp.jsp">Sign <span>Out</span></a></h2>  </div>  </header>
        <div class="menu-wrap">  <nav class="menu">  <ul class="clearfix">   <li><a href="IndexPageJsp.jsp">Home</a></li>  <li>
        <a href="#">Products</a>  <ul class="sub-menu">  <li><a href="#">Smart Phones</a></li>  <li><a href="TabletDisplayJsp.jsp">Tablets</a></li>  <li><a href="#"></a></li>
        <li><a href="LaptopDisplayJsp.jsp">Laptops</a></li>  <li><a href="TvDisplayJsp.jsp">TV</a></li>  </ul>  </li>  </ul>
        </nav>  </div>  <img class="header-image" src="images/multiple_picture_wallpaper.jpg" alt="Buildings" />
        <p>  <p>
        <div id="content_product">
		<p>Reviews For: <%=productName%> </p>
<%		
		if(cursor1.count() == 0){
			out.println("There are no reviews for this product.");
		}else{				
								
				int count=0;
				while (cursor1.count()>count) {
				
				count++;
					
				obj = (BasicDBObject) cursor1.next();	
%>			


				<TABLE BORDER=1 ALIGN=CENTER>
                <TR BGCOLOR=#FFAD00>
                <TH>Product<TH>Review(s)


				<TR><TD> Product ID </TD>
				<TD> <%=obj.getString("productID")%></TD></TR>
				


				<TR><TD> Retailer  </TD>
			<%	String r = obj.getString("retailer");
			System.out.println("Ret::"+r);
			%>
				<TD>  <%= r %> </TD></TR>

				<TR><TD> Retailer Zip  </TD>
				<TD> <%= obj.getString("retailerzip") %> </TD></TR>
				
				<TR><TD> Retailer City  </TD>
				<TD>  <%=  obj.getString("retailercity") %>  </TD></TR>

				<TR><TD> Sale  </TD>
				<TD>  <%= obj.getString("sale")  %> </TD></TR>
				
				<TR><TD> Manufacturer Name  </TD>
				<TD>  <%= obj.getString("mfname")  %>   </TD></TR>

				<TR><TD> Review Rating  </TD>
				<TD>  <%=obj.getString("reviewRating") %>  </TD></TR>

				<TR><TD> Review Date  </TD>
				<TD> <%= obj.getString("reviewDate")%>  </TD></TR>

				<TR><TD> Review Text  </TD>
				<TD>  <%=obj.getString("reviewText")%>  </TD></TR>

				</TABLE>
            </TABLE> 
           <FORM ACTION=IndexPageJsp.jsp   
		    METHOD="get">
           <BIG><LEFT> 
		   <INPUT TYPE="SUBMIT" 
                  VALUE="Back"> 
		   
           </CENTER></BIG></FORM>			
			
			
<%			
		} 
		}
%>
			</div>
            <aside class="sidebar"><ul><li><h4>Categories</h4><ul>
            <li><a href="IndexPageJsp.jsp">Home Page</a></li><li><a>Our Products</a><ul><li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li><li><a href="TabletDisplayJsp.jsp">Tablets</a></li><li><a href="LaptopDisplayJsp.jsp">Laptops</a></li><li><a href="TvDisplayJsp.jsp">TV</a></li></ul></li><li><a href="FindReviewsJsp.jsp">Trending</a></li></ul></li>
            <li><h4>About us</h4><ul><li class="text"><p style="margin: 0;">We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you</li>
            </ul></li><li><h4>Search site</h4><ul><li class="text"><form method="get" class="searchform" action="#" ><p><input type="text" size="30" value="" name="s" class="s" /></p>
            </form></li></ul></li></ul></aside><div class="clear"></div></div><footer><div class="footer-bottom"><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>
<%
		}catch (MongoException e) {
				e.printStackTrace();
		}  
%>