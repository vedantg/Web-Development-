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

public class SubmitReviewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
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
			DB db = mongo.getDB("bestdealmongodb");
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myReviews = db.getCollection("myReviews");
			System.out.println("Collection myReviews selected successfully");
				
			BasicDBObject doc = new BasicDBObject("title", "myReviews").
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
									
			myReviews.insert(doc);
				
			System.out.println("Document inserted successfully");
			
			//Send the response back to the JSP
			PrintWriter out = response.getWriter();
			
		out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Cart : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<h4>" + "<span style='width:310px;display:inline-block'></span>" + "Your Review has been Saved Successfully For: "+ productName + "</h4>");

        if(category.equals("Laptop")){
        	out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment2_Test/LaptopDisplayServlet'>Click here to redirect</a>");
        }

        else if(category.equals("TV")){
        	out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment2_Test/TvDisplayServlet'>Click here to redirect</a>");
        }

        else if(category.equals("Tablet")){
        	out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment2_Test/TabletDisplayServlet'>Click here to redirect</a>");
        }

        else if(category.equals("SmartPhone")){
        	out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Click here to redirect</a>");
        }				
			
			out.println("</body>");
			out.println("</html>");               
        	out.close();  
		
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy()	{
      // do nothing.
	}
	
}