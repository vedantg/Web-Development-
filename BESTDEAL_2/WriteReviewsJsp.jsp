<%@ page import = "java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,com.mongodb.*" %>

<%@page import="myAssignment3.*"%>

<%
	String productName = " ";
	String productReviewCategory = " ";
	String firstLetter = " ";
	int productPrice = 0;
	String category;
	String retailer;
	HashMap<String,List<Product>> mapInFile = new HashMap<String,List<Product>>();
	List<OrderHistoryModel> updatedOrderHistory_list = new ArrayList<OrderHistoryModel>();

		HttpSession s=request.getSession();
    	String username=(String)s.getAttribute("userid");
		
		String productReviewId= request.getParameter("productReviewId");
		System.out.println("ID_Write::"+productReviewId);
		String productReviewName= request.getParameter("productReviewName");
		String productReviewRetailer= request.getParameter("productReviewRetailer");
		String productReviewCondition= request.getParameter("productReviewCondition");
		String productReviewPrice= request.getParameter("productReviewPrice");
		String productReviewImage= request.getParameter("productReviewImage");

		firstLetter = String.valueOf(productReviewId.charAt(0));
		    
		    if(firstLetter.equals("L"))
		    {
		    	productReviewCategory = "Laptop";

		    }

		    else if(firstLetter.equals("V"))
		    {
		    	productReviewCategory = "TV";

		    }

		    else if(firstLetter.equals("T"))
		    {
		    	productReviewCategory = "Tablet";

		    }

		    else if(firstLetter.equals("S"))
		    {
		    	productReviewCategory = "SmartPhone";

		    }


						
		try{
%>			

        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="IndexPageJsp.jsp">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  <span style="width:110px;display:inline-block"></span>  <h2 style="float:right">Welcome   <%=username %>  !<span style="width:110px;display:inline-block"><a href="#"></a></span> <a href="SignOutJsp.jsp">Sign <span>Out</span></a></h2>  </div>  </header>
        <div class="menu-wrap">  <nav class="menu">  <ul class="clearfix">   <li><a href="IndexPageJsp.jsp">Home</a></li>  <li>
        <a href="#">Products</a>  <ul class="sub-menu">  <li><a href="#">Smart Phones</a></li>  <li><a href="TabletDisplayJsp.jsp">Tablets</a></li>  <li><a href="#"></a></li>
        <li><a href="LaptopDisplayJsp.jsp">Laptops</a></li>  <li><a href="TvDisplayJsp.jsp">TV</a></li>  </ul>  </li>  </ul>
        </nav>  </div>  <img class="header-image" src="images/multiple_picture_wallpaper.jpg" alt="Buildings" />
        <p>  <p>
        <div id="content_product">
			
             <h3> <%=productReviewName%> </h3> 
			<form method="get" action="SubmitReviewJsp.jsp">
			<fieldset>
			<legend>Product information:</legend>
			
			<table>
			
			<tr>
			<td style="width:30%"> Product Name: </td>
			<td><%=productReviewName %></td>
			</tr>
			
			
			<tr>
			<td style="width:30%"> Product Price: </td>
			<td><%=productReviewPrice%> </td>
			</tr>
			</table>
			</fieldset>
			<fieldset>
			<legend>Reviews:</legend>		
		
			
			
			<table>
			<tr>
			<td> Product Model Name: </td>
			<td> <input type="text" name= "productName" readonly value = "<%=productReviewName %>">  </td>
			</tr>
			
			
			<td> <input type="hidden" name= "productID" readonly value = "<%=productReviewId%>">  </td>
			
			

			<tr>
			<td> Product Category: </td>
			<td> <input type="text" name= "category" readonly value = "<%=productReviewCategory%>">  </td>
			</tr>
			
			
			<tr>
			<td> Price </td>
			<td> <input type="text" name= "price" readonly value = "<%=productReviewPrice %>">  </td>
			</tr>
			
			<tr>
			<td> Retailer Name </td>
			<td> <input type="text" name= "retailer" readonly value = "<%=productReviewRetailer %>">  </td>
			</tr>
			
			<tr>
			<td> Retailer Zip</td>
			<td> <input type="number" name= "retailerzip" >  </td>
			</tr>
			
			
			<tr>
			<td> Retailer City</td>
			<td> <input type="text" name= "retailercity" >  </td>
			</tr>
			
		
			<tr>
			<td> Retailer State</td>
			<td> <input type="text" name= "retailerstate" >  </td>
			</tr>
			
			<tr>
			<td> Product on Sale </td>
			<td>
			<select name="sale">
			<option value="Yes" selected>Yes</option>
			<option value="No">No</option>
			</td>
			</tr>
			
			<tr>
			<td> Manufacturer Name </td>
			<td>
			<select name="mfname">
			<option value="LG" selected>LG</option>
			<option value="Dell">Dell</option>
			<option value="Sony">Sony</option>
			<option value="OnePlus" selected>OnePlus</option>
			<option value="Moto">Moto</option>
			<option value="Toshiba">Toshiba</option>
			</td>
			</tr>
			
			<tr>
			<td> Manufacturer Rebate </td>
			<td>
			<select name="rebate">
			<option value="Yes" selected>Yes</option>
			<option value="No">No</option>
			</td>
			</tr>
			
			
			<tr>
			<td> User ID </td>
			<td> <input type="text" name= "userid" readonly value = "<%=username %>">  </td>
			</tr>
			
			<tr>
			<td> User Age: </td>
			<td> <input type="text" name="userAge"> </td>
			</tr>
			
			<tr>
			<td> User Gender: </td>
			<td> <input type="text" name="userGender"> </td>
			</tr>
			
			<tr>
			<td> User Occupation: </td>
			<td> <input type="text" name="userOccupation"> </td>
			</tr>
			
			<tr>
			<td> Review Rating: </td>
			<td>
			<select name="reviewRating">
			<option value="1" selected>1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			</td>
			</tr>			
			
			<tr>
			<td> Review Date: </td>
			<td> <input type="text" name="reviewDate"> </td>
			</tr>
			<tr>
			
			<td> Review Text: </td>
			<td><textarea name="reviewText" rows="4" cols="50"> </textarea></td>
			</tr>
			</table>
			<br><br>
			<input type="submit" value="Submit Review">
			</fieldset>
			</form>
      
    		</div>
            <aside class="sidebar"><ul><li><h4>Categories</h4><ul><li><a href="IndexPageJsp.jsp">Home Page</a></li><li><a>Our Products</a><ul>
            <li><a href="#">Smart Phones</a></li><li><a href="TabletDisplayJsp.jsp">Tablets</a></li><li><a href="SmartPhoneDisplayJsp.jsp">Laptops</a></li>
            <li><a href="TvDisplayJsp.jsp">TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class="text"><p style="margin: 0;">We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you
            </li></ul></li><li><h4>Search site</h4><ul><li class="text"><form method="get" class="searchform" action="#" ><p><input type="text" size="30" value="" name="s" class="s" /></p>
            </form></li></ul></li></ul></aside><div class="clear"></div></div>
            <div id = "footer"><footer><div class="footer-bottom"><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>
<%		
						
	    } catch (MongoException e) {
		e.printStackTrace();
	    }
%>
