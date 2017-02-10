import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.AggregationOutput;
import com.mongodb.client.AggregateIterable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;


public class FindReviewsServlet extends HttpServlet {

				DBObject match = null;
				DBObject groupFields = null;
				DBObject group = null;
				DBObject projectFields = null;
				DBObject project = null;
				DBObject sort=null;
				AggregationOutput aggregate = null;
				HashMap<String, Integer>  ee ;
				HashMap<String, Integer>  ee1 ;
				HashMap<String, Integer> mapInFile;
				HashMap<String, Integer> mapInFile2;
 
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
 /*DBCollection myReviews = MongoDBDataStoreUtilities.createMongoDB();
PrintWriter out= response.getWriter();
BasicDBObject query = new BasicDBObject();*/
	PrintWriter out= response.getWriter();

		out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment4/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+" !"+"<span style='width:110px;display:inline-block'><a href='#'></a></span>" +"<a href='/Assignment4/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment4/IndexPageServlet'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='#'>Smart Phones</a></li>" + "<li><a href='/Assignment4/TabletDisplayServlet'>Tablets</a></li>"+ " <li><a href='#'></a></li>");
        out.println("<li><a href='/Assignment4/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment4/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");

        			DBCollection myReviews = MongoDBDataStoreUtilities.createMongoDB();

        			DBCursor cursor=MongoDBDataStoreUtilities.topMostLiked(myReviews);
        			topFiveMostLiked(cursor, out);

        			mapInFile=MongoDBDataStoreUtilities.topZipCodes();
        			topFiveZipCodes(mapInFile,out);

        			mapInFile2=MongoDBDataStoreUtilities.topReviewed();
        			toptopReviewedProducts(mapInFile2,out);
        out.println("</div>");
        out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul><li><a href='/Assignment4/IndexPageServlet'>Home Page</a></li><li><a>Our Products</a><ul>");
        out.println("<li><a href='/Assignment4/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment4/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment4/SmartPhoneDisplayServlet'>Laptops</a></li>");
        out.println("<li><a href='/Assignment4/TvDisplayServlet'>TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you");
        out.println("</li></ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
        out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div>");
        out.println("<div id = 'footer'><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");
                                         
        out.close();


        			  			


}

public void toptopReviewedProducts(HashMap<String, Integer>  mapInFile2 ,PrintWriter output){
String tableData2 = " ";
String pageContent2 = " ";
output.println("<h2> Top Five Most Reviewed Products </h2>");
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
			output.println(pageContent2);
                                               
        }

}

public void topFiveZipCodes(HashMap<String, Integer>  mapInFile1 ,PrintWriter output){
String tableData1 = " ";
String pageContent1 = " ";
output.println("<h2> Top Five Zip Codes With Max Product Sale </h2>");
for (Map.Entry<String,Integer> ee : mapInFile1.entrySet()) 
        {   
        	String zipCode = ee.getKey();                
            int count = ee.getValue();
            tableData1 = "<tr rowspan = \"3\"><td> Zip Code: "+zipCode+"</br>"
							+   "Count: "+count+"</br>"
							+	"</td></tr>";
												
			pageContent1 = "<table class = \"query-table\">"+tableData1+"</table>";		
			output.println(pageContent1);
                                               
        }

}

public void topFiveMostLiked(DBCursor cursor,PrintWriter output){
		List<String> listUnique=new ArrayList<String>();
	System.out.println("The count of cursor is::::"+cursor.count());
	int counter=0;
	String tableData4 = " ";
	String pageContent4 = " ";
	output.println("<h2> Top Five Most Liked Product </h2>");
    while(cursor.count()>counter) {
		System.out.println("The counter count is::::"+counter);
        counter++;
					
					BasicDBObject obj = (BasicDBObject) cursor.next();
					String prodId=obj.getString("productID");
					if(!listUnique.contains(prodId)){
					listUnique.add(prodId);
					
				
				tableData4 = "<tr rowspan = \"3\"><td> Product Name: "+obj.getString("productName")+"</br>"
							+   "Rating: "+obj.getString("reviewRating").toString()+"</br>"
							+	"</td></tr>";
												
			pageContent4 = "<table class = \"query-table\">"+tableData4+"</table>";		
			output.println(pageContent4);
				
					}
					else{
						System.out.println("Item already exist in the list");
					}
   			 }
		
	}

		/** Handles the HTTP <code>GET</code> method.
		* @param request servlet request
		* @param response servlet response
		*/
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, java.io.IOException {
		    processRequest(request, response);
		} 

		/** Handles the HTTP <code>POST</code> method.
		* @param request servlet request
		* @param response servlet response
		*/
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, java.io.IOException {
		    processRequest(request, response);
		}
}