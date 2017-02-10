<%@ page import = "java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

<%

				DBObject match = null;
				DBObject groupFields = null;
				DBObject group = null;
				DBObject projectFields = null;
				DBObject project = null;
				DBObject sort=null;
				AggregationOutput aggregate = null;
				HashMap<String, Integer> mapInFile;
				HashMap<String, Integer> mapInFile1;
				HashMap<String, Integer> mapInFile2;
%> 

		<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="IndexPageJsp.jsp">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  <span style="width:110px;display:inline-block"></span>  <h2 style="float:right">Welcome  !<span style="width:110px;display:inline-block"><a href="#"></a></span> <a href="SignOutJsp.jsp">Sign <span>Out</span></a></h2>  </div>  </header>
        <div class="menu-wrap">  <nav class="menu">  <ul class="clearfix">   <li><a href="IndexPageJsp.jsp">Home</a></li>  <li>
        <a href="#">Products</a>  <ul class="sub-menu">  <li><a href="#">Smart Phones</a></li>  <li><a href="TabletDisplayJsp.jsp">Tablets</a></li>  <li><a href="#"></a></li>
        <li><a href="LaptopDisplayJsp.jsp">Laptops</a></li>  <li><a href="TvDisplayJsp.jsp">TV</a></li>  </ul>  </li>  </ul>
        </nav>  </div>  <img class="header-image" src="images/multiple_picture_wallpaper.jpg" alt="Buildings" />
        <p>  <p>
        <div id="content_product">
<%

        			DBCollection myReviews = MongoDBDataStoreUtilities.createMongoDB();

        			aggregate=MongoDBDataStoreUtilities.topMostLiked();
        			//topFiveMostLiked(aggregate, out);

      	int rowCount = 0;
		int productCount = 0;
		String tableData = " ";
		String pageContent = " ";
		
		out.println("<h2> Top Most Liked Products </h2>");		
		for (DBObject result : aggregate.results()) {
				System.out.println("IN FOR LOOP");

				BasicDBObject bobj = (BasicDBObject) result;
				BasicDBList productList = (BasicDBList) bobj.get("ProductID");
				BasicDBList productReview = (BasicDBList) bobj.get("ProductName");
				BasicDBList rating = (BasicDBList) bobj.get("ReviewRating");
				System.out.println("ProductList Size::"+productList.size());

				rowCount++;

				while (productCount < productList.size()) {
					System.out.println("Product Count::"+productCount);
					tableData = "<tr rowspan = \"3\"><td> Product: "+productList.get(productCount)+"</br>"
							+   "Rating: "+rating.get(productCount)+"</br>"
							+	"Product Name: "+productReview.get(productCount)+"</td></tr>";
												
					pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
					out.println(pageContent);
					
					productCount++;					
				}	
				
				//Reset product count
				productList.removeAll(productList);
				productReview.removeAll(productReview);
				rating.removeAll(rating);

				productCount =0;
		}		
		
		//No data found
		if(rowCount == 0){
			pageContent = "<h1>No Data Found</h1>";
			out.println(pageContent);
		}
%>

<%

        			mapInFile1=MongoDBDataStoreUtilities.topZipCodes();
        			//topFiveZipCodes(mapInFile,out);

String tableData1 = " ";
String pageContent1 = " ";
out.println("<h2> Top Five Zip Codes With Max Product Sale </h2>");
for (Map.Entry<String,Integer> ee : mapInFile1.entrySet()) 
        {   
        	String zipCode = ee.getKey();                
            int count = ee.getValue();
            tableData1 = "<tr rowspan = \"3\"><td> Zip Code: "+zipCode+"</br>"
							+   "Count: "+count+"</br>"
							+	"</td></tr>";
												
			pageContent1 = "<table class = \"query-table\">"+tableData1+"</table>";		
			out.println(pageContent1);
                                               
        }

%>

<%

        			mapInFile2=MongoDBDataStoreUtilities.topReviewed();
        			//toptopReviewedProducts(mapInFile2,out);

        String tableData2 = " ";
String pageContent2 = " ";
out.println("<h2> Top Five Most Reviewed Products </h2>");
for (Map.Entry<String,Integer> ee1 : mapInFile2.entrySet()) 
        {   
        	String product = ee1.getKey(); 
        	System.out.println("kEY::"+product);               
            int count2 = ee1.getValue();
            System.out.println("Values::"+count2);    
            tableData2 = "<tr rowspan = \"3\"><td> Product: "+product+"</br>"
							+   "Count: "+count2+"</br>"
							+	"</td></tr>";
												
			pageContent2 = "<table class = \"query-table\">"+tableData2+"</table>";		
			out.println(pageContent2);
                                               
        }
 %>
        </div>
        <aside class="sidebar"><ul><li><h4>Categories</h4><ul><li><a href="IndexPageJsp.jsp">Home Page</a></li><li><a>Our Products</a><ul>
        <li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li><li><a href="TabletDisplayJsp.jsp">Tablets</a></li><li><a href="SmartPhoneDisplayJsp.jsp">Laptops</a></li>
        <li><a href="TvDisplayJsp.jsp">TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class="text"><p style="margin: 0;">We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you
        </li></ul></li><li><h4>Search site</h4><ul><li class="text"><form method="get" class="searchform" action="#" ><p><input type="text" size="30" value="" name="s" class="s" /></p>
        </form></li></ul></li></ul></aside><div class="clear"></div></div>
        <div id = "footer"><footer><div class="footer-bottom"><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>
                                         
