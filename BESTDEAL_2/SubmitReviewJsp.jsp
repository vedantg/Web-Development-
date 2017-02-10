<%@ page import = "java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*" %>

<%@page import="myAssignment3.*"%>

<%
	MongoClient mongo;
	mongo = new MongoClient("localhost", 27017);

%>

<%		
		try{
			//Get the values from the form
			String productName = request.getParameter("productName");
			String productID = request.getParameter("productID");
			String category = request.getParameter("category");
			String price = request.getParameter("price").trim();
			int price1= Integer.parseInt(price);
			String retailer = request.getParameter("retailer");
			Integer retailerzip = Integer.parseInt(request.getParameter("retailerzip"));
			String retailercity = request.getParameter("retailercity");
			String retailerstate = request.getParameter("retailerstate");
			String sale = request.getParameter("sale");
			String mfname = request.getParameter("mfname");
			String rebate = request.getParameter("rebate");
			String user = request.getParameter("userid");
			String userage = request.getParameter("userAge");
			String usergender = request.getParameter("userGender");
			String userOccupation = request.getParameter("userOccupation");
			int reviewRating = Integer.parseInt(request.getParameter("reviewRating"));	
			String reviewDate = request.getParameter("reviewDate");
			String reviewText = request.getParameter("reviewText");
			
			
										
			// If database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("bestdealmongodbjsp");
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myReviewsjsp = db.getCollection("myReviewsjsp");
							
			BasicDBObject doc = new BasicDBObject("title", "myReviewsjsp").
				append("productName", productName).
				append("productID", productID).
				append("category", category).
				append("price", price1).
				append("retailer", retailer).
				append("retailerzip", retailerzip).
				append("retailercity", retailercity).
				append("retailerstate", retailerstate).
				append("sale", sale).
				append("mfname", mfname).
				append("rebate",rebate).
				append("userid", user).
				append("userage", userage).
				append("usergender", usergender).
				append("userOccupation",userOccupation).
				append("reviewRating", reviewRating).
				append("reviewDate", reviewDate).
				append("reviewText", reviewText);
									
			myReviewsjsp.insert(doc);
%>				
			
		<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Reviews : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="#">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <h4>  <span style="width:310px;display:inline-block"></span>  Your Review has been Saved Successfully For:  <%=productName %>  </h4>
<%
        if(category.equals("Laptop")){
%>
        	<span style="width:310px;display:inline-block"></span><a href="LaptopDisplayJsp.jsp">Click here to redirect</a>
<%        	
        }

        else if(category.equals("TV")){
%>
        	<span style="width:310px;display:inline-block"></span><a href="TvDisplayJsp.jsp">Click here to redirect</a>
<%
        }

        else if(category.equals("Tablet")){
%>
        	<span style="width:310px;display:inline-block"></span><a href="TabletDisplayJsp.jsp">Click here to redirect</a>
<%
        }

        else if(category.equals("SmartPhone")){
%>
        	<span style="width:310px;display:inline-block"></span><a href="SmartPhoneDisplayJsp.jsp">Click here to redirect</a>
<%
        }	
%>			
			
			</body>
			</html>               
<%
		} catch (MongoException e) {
			e.printStackTrace();
		}
%>
	
