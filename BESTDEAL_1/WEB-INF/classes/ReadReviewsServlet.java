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
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ReadReviewsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/*MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	} */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			
			 DBCollection myReviews = MongoDBDataStoreUtilities.createMongoDB();
			// if database doesn't exists, MongoDB will create it for you
			// DB db = mongo.getDB("bestdealmongodb"); 
			 HttpSession s=request.getSession();
        	 String username=(String)s.getAttribute("userid");
			
			//DBCollection myReviews = db.getCollection("myReviews");
			String productID= request.getParameter("productReadReviewId");
			// Find and display 
			/*BasicDBObject searchQuery1 = new BasicDBObject();
			searchQuery1.put("productID", productID);*/

			DBCursor cursor1 = MongoDBDataStoreUtilities.fetchReviewMongoDB(productID);


			//myReviews.find(searchQuery1);

			String productName=request.getParameter("productReadReviewName");
			PrintWriter out = response.getWriter();
			//out.println(cursor);
						
			
		out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment2_Test/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username +" !"+"<span style='width:110px;display:inline-block'><a href='#'></a></span>" +"<a href='/Assignment2_Test/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment2_Test/IndexPageServlet'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='#'>Smart Phones</a></li>" + "<li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li>"+ " <li><a href='#'></a></li>");
        out.println("<li><a href='/Assignment2_Test/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");
		out.println("<p>Reviews For:"+ productName+ "</p>");
		
		if(cursor1.count() == 0){
			out.println("There are no reviews for this product.");
		}else{				
				String productName1 = "";
				String userName = "";
				String category="";
				String price= "";
				String retailer= "";
				String retailerzip="";
				String retailercity="";
				String retailerstate= "";
				String sale= "";
				String mfname = "";
				String userid = "";
				String userage = "";
				String usergender = "";
				String reviewRating = "";
				String reviewDate =  "";
				String reviewText = "";
				
				int count=0;
				while (cursor1.count()>count) {
				
				
				count++;
					
					BasicDBObject obj = (BasicDBObject) cursor1.next();	


				out.println("<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Product<TH>Review(s)");

				out.print("<TR><TD> Product ID  \n</TD>");
				out.print("<TD>" + obj.getString("productID") + "\n</TD></TR>");
				

				out.print("<TR><TD> Retailer  \n</TD>");
				out.print("<TD>" + obj.getString("retailer") + "\n</TD></TR>");

				out.print("<TR><TD> Retailer Zip  \n</TD>");
				out.print("<TD>" + obj.getString("retailerzip") + "\n</TD></TR>");
				
				out.print("<TR><TD> Retailer City  \n</TD>");
				out.print("<TD>" + obj.getString("retailercity") + "\n</TD></TR>");

				out.print("<TR><TD> Sale  \n</TD>");
				out.print("<TD>" + obj.getString("sale") + "\n</TD></TR>");
				
				out.print("<TR><TD> Manufacturer Name  \n</TD>");
				out.print("<TD>" + obj.getString("mfname") + "\n</TD></TR>");

				out.print("<TR><TD> Review Rating  \n</TD>");
				out.print("<TD>" + obj.getString("reviewRating").toString() + "\n</TD></TR>");

				out.print("<TR><TD> Review Date  \n</TD>");
				out.print("<TD>" + obj.getString("reviewDate") + "\n</TD></TR>");

				out.print("<TR><TD> Review Text  \n</TD>");
				out.print("<TD>" + obj.getString("reviewText") + "\n</TD></TR>");

				out.println("</TABLE>\n");

				out.println
          ("</TABLE>\n" +
           "<FORM ACTION=/Assignment2_Test/IndexPageServlet  " +
		   " METHOD=\"get\">\n"+
           "<BIG><LEFT>\n" +
		   "<INPUT TYPE=\"SUBMIT\"\n" +
           "       VALUE=\"Back\">\n" +
		   
           "</CENTER></BIG></FORM>");			
			
			
			
		} 
		}

			out.println("</div>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul>");
            out.println("<li><a href='/Assignment2_Test/IndexPageServlet'>Home Page</a></li><li><a>Our Products</a><ul><li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment2_Test/LaptopDisplayServlet'>Laptops</a></li><li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li></ul></li>"+"<li><a href='/Assignment2_Test/FindReviewsServlet'>Trending</a></li></ul></li>");
            out.println("<li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you</li>");
            out.println("</ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");
                                           
        out.close();
		}catch (MongoException e) {
				e.printStackTrace();
		}  
	}

	
	public void destroy(){
      // do nothing.
	}
}