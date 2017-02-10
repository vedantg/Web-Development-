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
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
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

public class TrendServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	String username;

			
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession s=request.getSession();
        username=(String)s.getAttribute("userid");
		
		PrintWriter output = response.getWriter();
					
		DB db = mongo.getDB("bestdealmongodb");
		
		// If the collection does not exists, MongoDB will create it for you
		DBCollection myReviews = db.getCollection("myReviews");
		
		BasicDBObject query = new BasicDBObject();
		boolean groupBy	= false;
		boolean countOnly	= false;
		try {
			
			DBCursor dbCursor = null;
			AggregationOutput aggregateData = null;

			DBObject match = null;
			DBObject groupFields = null;
			DBObject group = null;
			DBObject projectFields = null;
			DBObject projectField2 = null;
			DBObject project = null;
			DBObject project2 = null;
			DBObject newGroupFields = null;
			DBObject group2 = null;
			AggregationOutput aggregate = null;



			//Construct the top of the page
			constructPageTop(output);
			
			DBObject fields = new BasicDBObject( "City", "$retailercity" );
			fields.put( "ProductName", "$productName" );
			
			groupFields = new BasicDBObject( "_id", fields );
			groupFields.put( "count", new BasicDBObject( "$sum", 1 ) );
			groupFields.put("product", new BasicDBObject("$first", "$productName"));
			//groupFields.put("product", new BasicDBObject("$push","));
			group = new BasicDBObject( "$group", groupFields );


			match = new BasicDBObject("$match", new BasicDBObject("reviewRating",new BasicDBObject("$eq", 5)));
			
			projectFields = new BasicDBObject("_id", 0);
			projectFields.put("IDS", "$_id");
			projectFields.put("Review Count", "$count");
			projectFields.put("Product", "$product");
			project = new BasicDBObject("$project", projectFields);

			DBObject sortFields = new BasicDBObject("Review Count", -1);
			DBObject sort1 = new BasicDBObject("$sort", sortFields );
			
			
    		aggregate = myReviews.aggregate(match,group,project,sort1);
    		constructGroupByCityContent(aggregate, output, countOnly);

    		constructPageBottom(output);
			
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
	
	public void constructPageTop(PrintWriter out){
		String pageHeading = "Query Result";
		out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment2_Test/DealMatches'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username +" !"+"<span style='width:110px;display:inline-block'><a href='#'></a></span>" +"<a href='/Assignment2_Test/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment2_Test/DealMatches'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='#'>Smart Phones</a></li>" + "<li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li>"+ " <li><a href='/Assignment2_Test/CartProductDisplay'>Cart</a></li>");
        out.println("<li><a href='/Assignment2_Test/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");
		out.println("<h2 style=\"color:#DE2D3A;font-weight:700;\">" +pageHeading + "</h2>");
	
	}
	
	public void constructPageBottom(PrintWriter out){
			out.println("</div>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul><li><a href='/Assignment2_Test/DealMatches'>Home Page</a></li><li><a>Our Products</a><ul>");
            out.println("<li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Laptops</a></li>");
            out.println("<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you");
            out.println("</li></ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div>");
            out.println("<div id = 'footer'><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");

			
	}
	
	
	
	public void constructGroupByCityContent(AggregationOutput aggregate, PrintWriter output, boolean countOnly){
		int rowCount = 0;
		int productCount = 0;
		String tableData = " ";
		String pageContent = " ";
		
		output.println("<h1>Trending Product Group By City </h1>");	
		//output.println(aggregate.results());
		for (DBObject result : aggregate.results()) {
				BasicDBObject bobj = (BasicDBObject) result;
			
			
			
			
		//	BasicDBList productList = (BasicDBList) bobj.get("Product");
			//BasicDBList review = (BasicDBList) bobj.get("Review Count");
			//BasicDBList details = (BasicDBList) bobj.get("IDS");
				
			//output.println(productList);
			//output.println(review);
			//output.println(details);
				
				
						
				tableData = "<tr><td><b>City and Product Name: "+bobj.get("IDS")+"</td>&nbsp"
						+	"<td><b>Number of Times Product has got Rating 5:  "+bobj.get("Review Count")+" </b></td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
			    output.println(pageContent);		
						break;
				
		}	
		
		
		
	}
}