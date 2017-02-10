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



public class DataAnalyticsDesignServlet extends HttpServlet {

		public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		HttpSession s=request.getSession();
        String username=(String)s.getAttribute("userid");
		
		PrintWriter out= response.getWriter();
		out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment2_Test/AdminPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username +" !"+"<span style='width:110px;display:inline-block'><a href='#'></a></span>" +"<a href='/Assignment2_Test/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment2_Test/AdminPageServlet'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='#'>Smart Phones</a></li>" + "<li><a href='#'>Tablets</a></li>"+ " <li><a href='#'></a></li>");
        out.println("<li><a href='#'>Laptops</a></li>" + "<li><a href='#'>TV</a></li>" + "</ul>" + "</li>" + "</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");
        out.println("<section id='review-content'>"+
					"<article>"+
                    "<h3> Data Analytics  </h3>"+
                    "<form method='post' class='searchform' action='SearchDataServlet'>"+
                    "<table class = 'query-table'>"+
					"<tr>"+
					"<td colspan = '4'> <b> Regular Search </b> </td>"+
					"</tr>"+
					
           			"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='productName' > Select </td>"+
                    "<td> Product Name: </td>"+
					"<td>"+
                    "<select name='productName'>"+
					"<option value='ALL_PRODUCTS'>All Products</option>"+
					"<option value='MotoG2'>MotoG2</option>"+
					"<option value='Sony001'>Sony001</option>"+
					"<option value='Dell360'>Dell360</option>"+ 
					"<option value='SonyHawkEye'>SonyHawkEye</option>"+  					
                    "</td>"+
					"<td> </td>"+
                    "</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='productPrice'> Select </td>"+
                    "<td> Product Price: </td>"+
                    "<td>"+
                    "<input type='number' name='productPrice' value = '0' size=10 class='s' /> </td>"+
					"<td>"+
					"<input type='radio' name='comparePrice' value='EQUALS_TO' > Equals <br>"+
					"<input type='radio' name='comparePrice' value='GREATER_THAN'> Greater Than <br>"+
					"<input type='radio' name='comparePrice' value='LESS_THAN'> Less Than</td>"+
                    "</tr>"+

					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='productCategory'> Select </td>"+
                    "<td> Product Category: </td>"+
                    "<td>"+
                    "<input type='text' name='productCategory' value = '' size=10 class='s' /> </td>"+
                    "</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='retailerName'> Select </td>"+
                    "<td> Retailer Name: </td>"+
                    "<td>"+
                    "<input type='text' name='retailerName' value = '' size=15 class='s' /> </td>"+
                    "</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='retailerState'> Select </td>"+
                    "<td> Retailer State: </td>"+
                    "<td>"+
                    "<input type='text' name='retailerState' value = '' size=15 class='s' /> </td>"+
                    "</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='productonSale' > Select </td>"+
                    "<td> Product on Sale: </td>"+
					"<td>"+
                    "<select name='productonSale'>"+
					"<option value='Yes'>Yes</option>"+
					"<option value='No'>No</option>"+                                  
                    "</td>"+
					"<td> </td>"+
                    "</tr>"+
					
                    "<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='retailerZipcode'> Select </td>"+
                    "<td> Retailer Zip code: </td>"+
                    "<td>"+
                    "<input type='number' name='retailerZipcode' value = '0' size=10/> </td>"+
					"<td> </td>"+
                    "</tr>"+
					"<tr>"+
					"<td><input type='checkbox' name='queryCheckBox' value='retailerCity'> Select </td>"+
					"<td> Retailer City: </td>"+
					"<td>"+
					"<input type='text' name='retailerCity' value = 'All' class='s' /> </td>"+
					"<td> </td>"+
					"</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='manufacturerName'> Select </td>"+
                    "<td> Manufacturer Name: </td>"+
                    "<td>"+
                    "<input type='text' name='manufacturerName' value = '' size=15 class='s' /> </td>"+
                    "</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='manufacturerRebate' > Select </td>"+
                    "<td> Manufacturer Rebate: </td>"+
					"<td>"+
                    "<select name='manufacturerRebate'>"+
					"<option value='Yes'>Yes</option>"+
					"<option value='No'>No</option>"+                                  
                    "</td>"+
					"<td> </td>"+
                    "</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='userID'> Select </td>"+
                    "<td> User ID: </td>"+
                    "<td>"+
                    "<input type='number' name='userID' value = '' size=15 class='s' /> </td>"+
                    "</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='userAge'> Select </td>"+
                    "<td> User Age: </td>"+
                    "<td>"+
                    "<input type='number' name='userAge' value = '' size=15 class='s' /> </td>"+
                    "</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='userGender'> Select </td>"+
                    "<td> User Gender: </td>"+
                    "<td>"+
                    "<input type='text' name='userGender' value = '' size=15 class='s' /> </td>"+
                    "</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='userOccupation'> Select </td>"+
                    "<td> User Occupation: </td>"+
                    "<td>"+
                    "<input type='text' name='userOccupation' value = '' size=15 class='s' /> </td>"+
                    "</tr>"+
					
					
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='reviewRating'> Select </td>"+
					"<td> Review Rating: </td>"+
					"<td>"+
					"<select name='reviewRating'>"+
					"<option value='1' selected>1</option>"+
					"<option value='2'>2</option>"+
					"<option value='3'>3</option>"+
					"<option value='4'>4</option>"+
					"<option value='5'>5</option>"+
					"</td>"+
					"<td>"+
					"<input type='radio' name='compareRating' value='EQUALS_TO' checked> Equals <br>"+
					"<input type='radio' name='compareRating' value='GREATER_THAN'> Greater Than</td>"+
					"</tr>"+
					
					"<tr>"+
					"<td> <input type='checkbox' name='queryCheckBox' value='reviewText'> Select </td>"+
                    "<td> Review Text: </td>"+
                    "<td>"+
                    "<input type='textarea' name='reviewText' value = '' size=15 class='s' /> </td>"+
					"<td>(PATTERN MATCHING) </td>"+
                    "</tr>"+
					
					
					
					"<tr>"+
					"<td>Return:"+
					"</td>"+
					"<td colspan = '4'>"+
					"<select name='returnValue'>"+
					"<option value='ALL' selected>All</option>"+
					"<option value='TOP_5'>Top 5 </option>"+
					"<option value='TOP_10'>Top 10 </option>"+
					"<option value='LATEST_5'>Latest 5 </option>"+
					"<option value='LATEST_10'>Latest 10 </option>"+
					"</td>"+
					"</tr>"+
					
					"<tr>"+
					"<td colspan = '4'> <b> Grouping </b> </td>"+
					"</tr>"+
					"<tr>"+
					"<td>"+
					"<input type='checkbox' name='extraSettings' value='GROUP_BY'> Group By</td>"+
					"<td colspan = '3'>"+
					"<select name='groupByDropdown'>"+
					"<option value='GROUP_BY_CITY' selected>City</option>"+
					"<option value='GROUP_BY_PRODUCT'>Product Name</option>"+
					"<option value='GROUP_BY_RETAILER_NAME'>Retailer Name</option>"+
					"<option value='GROUP_BY_RETAILER_ZIP'>Retailer Zip</option>"+
					"</td>"+
					"</tr>"+
					
					"<tr>"+
					"<td>Return:"+
					"</td>"+
					"<td colspan = '4'>"+
					"<select name='returnData'>"+
					"<option value='ALL' selected>All</option>"+
					"<option value='HIGHEST_PRICE_PRODUCT'>Highest Price Product </option>"+
					"<option value='MEDIAN'>Median Price</option>"+
					"<option value='TOP_5_LIKED_PRODUCT'>Top 5 Liked Product </option>"+
					
					"</td>"+
					"</tr>"+
					
					
					"<tr>"+
					"<td colspan = '4'> <input type='submit' value='Perform Data Analysis' class='formbutton' /> </td>"+
					"</form>"+
					"</table>"+
					"</form>"+
					
					"</article>"+
					"</section>");

			out.println("</div>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul><li><a href='/Assignment2_Test/AdminPageServlet'>Home Page</a></li><li><a>Our Products</a><ul>");
            out.println("<li><a href='#'>Smart Phones</a></li><li><a href='#'>Tablets</a></li><li><a href='#'>Laptops</a></li>");
            out.println("<li><a href='#'>TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you");
            out.println("</li></ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div>");
            out.println("<div id = 'footer'><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");

					

		}
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




