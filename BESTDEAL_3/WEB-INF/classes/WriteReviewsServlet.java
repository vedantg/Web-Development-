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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.*;

public class WriteReviewsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	String productName = "";
	String productReviewCategory = " ";
	String firstLetter = " ";
	int productPrice = 0;
	String category;
	String retailer;
	HashMap<String,List<Product>> mapInFile = new HashMap<String,List<Product>>();
	List<OrderHistoryModel> updatedOrderHistory_list = new ArrayList<OrderHistoryModel>();
	public void init(){
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html");
			
		PrintWriter out = response.getWriter();
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
		

        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment4/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username +" !"+"<span style='width:110px;display:inline-block'><a href='#'></a></span>" +"<a href='/Assignment4/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment4/IndexPageServlet'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='#'>Smart Phones</a></li>" + "<li><a href='/Assignment4/TabletDisplayServlet'>Tablets</a></li>"+ " <li><a href='#'></a></li>");
        out.println("<li><a href='/Assignment4/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment4/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");

			out.println(" <h3>" +productReviewName+ "</h3> ");
			out.println("<form method=\"get\" action=\"/Assignment4/SubmitReviewServlet\">");
			out.println("<fieldset>");
			out.println("<legend>Product information:</legend>");
			
			out.println("<table>");

			out.println("<tr>");
			out.println("<td style='width:30%'> Product Name: </td>");
			out.println("<td>"+productReviewName+"</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td style='width:30%'> Product Price: </td>");
			out.println("<td>"+productReviewPrice+" </td>");
			out.println("</table>");
			out.println("</fieldset>");
			out.println("<fieldset>");
			out.println("<legend>Reviews:</legend>");	

			out.println("<table>");
			out.println("<tr>");
			out.println("<td> Product Model Name: </td>");
			out.println("<td> <input type='text' name= 'productName' readonly value = \""+productReviewName+"\">  </td>");
			out.println("</tr>");

			out.println("<td> <input type='hidden' name= 'productID' readonly value = \""+productReviewId+"\">  </td>");	

			out.println("<tr>");
			out.println("<td> Product Category: </td>");
			out.println("<td> <input type='text' name= 'category' readonly value = \""+productReviewCategory+"\">  </td>");
			out.println("</tr>");	

			out.println("<tr>");
			out.println("<td> Price </td>");
			out.println("<td> <input type='text' name= 'price' readonly value = \""+productReviewPrice+"\">  </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td> Retailer Name</td>");
			out.println("<td> <input type='text' name='retailer' readonly value = \""+productReviewRetailer+"\" >  </td>");
			out.println("</tr>");				

			out.println("<tr>");
			out.println("<td> Retailer Zip</td>");
			out.println("<td> <input type='number' name= 'retailerzip' >  </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td> Retailer City</td>");
			out.println("<td> <input type='text' name='retailercity' >  </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td> Retailer State</td>");
			out.println("<td> <input type='text' name= 'retailerstate' >  </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td> Product on Sale </td>");
			out.println("<td>");
			out.println("<select name='sale'>");
			out.println("<option value='Yes' selected>Yes</option>");
			out.println("<option value='No'>No</option>");
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> Manufacturer Name </td>");
			out.println("<td>");
			out.println("<select name=\"mfname\">");
			out.println("<option value=\"LG\" selected>LG</option>");
			out.println("<option value=\"Dell\">Dell</option>");
			out.println("<option value=\"Sony\">Sony</option>");
			out.println("<option value=\"OnePlus\" selected>OnePlus</option>");
			out.println("<option value=\"Moto\">Moto</option>");
			out.println("<option value=\"Toshiba\">Toshiba</option>");
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> Manufacturer Rebate </td>");
			out.println("<td>");
			out.println("<select name=\"rebate\">");
			out.println("<option value=\"Yes\" selected>Yes</option>");
			out.println("<option value=\"No\">No</option>");
			out.println("</td>");
			out.println("</tr>");
			
			
			out.println("<tr>");
			out.println("<td> User ID </td>");
			out.println("<td> <input type=\"text\" name= \"userid\" readonly value = \""+username+"\">  </td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> User Age: </td>");
			out.println("<td> <input type=\"text\" name=\"userAge\"> </td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> User Gender: </td>");
			out.println("<td> <input type=\"text\" name=\"userGender\"> </td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> User Occupation: </td>");
			out.println("<td> <input type=\"text\" name=\"userOccupation\"> </td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> Review Rating: </td>");
			out.println("<td>");
			out.println("<select name=\"reviewRating\">");
			out.println("<option value=\"1\" selected>1</option>");
			out.println("<option value=\"2\">2</option>");
			out.println("<option value=\"3\">3</option>");
			out.println("<option value=\"4\">4</option>");
			out.println("<option value=\"5\">5</option>");
			out.println("</td>");
			out.println("</tr>");
			
			
			
			
			out.println("<tr>");
			out.println("<td> Review Date: </td>");
			out.println("<td> <input type=\"text\" name=\"reviewDate\"> </td>");
			out.println("</tr>");
			out.println("<tr>");
			
			out.println("<td> Review Text: </td>");
			out.println("<td><textarea name=\"reviewText\" rows=\"4\" cols=\"50\"> </textarea></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<br><br>");
			out.println("<input type=\"submit\" value=\"Submit Review\">");
			out.println("</fieldset>");
			out.println("</form>");
      
    		out.println("</div>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul><li><a href='/Assignment2_Test/IndexPageServlet'>Home Page</a></li><li><a>Our Products</a><ul>");
            out.println("<li><a href='#'>Smart Phones</a></li><li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Laptops</a></li>");
            out.println("<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you");
            out.println("</li></ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div>");
            out.println("<div id = 'footer'><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");
                                             
        out.close();
			
						
	    } catch (MongoException e) {
		e.printStackTrace();
	    }

	}
}