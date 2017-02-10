import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
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

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;

public class PlaceOrderServlet extends HttpServlet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String productName = "Multiple ";
	String imageLocation = " ";
	int productPrice = 0;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		String user=((String)session.getAttribute("userid")); 
		response.setContentType("text/html");
		
		String price=request.getParameter("totalprice");
		
		
		
		PrintWriter out = response.getWriter();
						
		
			//Get the values from the form
			
			
		out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment4/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome"+"<span style='width:110px;display:inline-block'><a href='#'></a></span>" + "<a href='/Assignment4/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment4/IndexPageServlet'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='/Assignment4/SmartPhoneDisplayServlet'>Smart Phones</a></li>" + "<li><a href='/Assignment4/TabletDisplayServlet'>Tablets</a></li>");
        out.println("<li><a href='/Assignment4/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment4/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");
							
		
			out.println(" <form method=\"get\" action=\"SubmitOrderServlet\">");
			out.println("<fieldset>");
			out.println("<legend>Order information:</legend>");
			
			out.println("<table>");
			
			
							
			out.println("<tr>");
			out.println("<td>Product Price: </td>");
			out.println("<td> <input type=\"text\" name=\"productPrice\" value= "+price+" readonly style='margin-left: 245px;'> </td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</fieldset>");
		
			out.println("<fieldset>");
			out.println("<legend>Personal information:</legend>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td> First name: </td>");
			out.println("<td> <input type=\"text\" name=\"firstName\"> </td>");
			out.println("</tr>");				
			out.println("<tr>");
			out.println("<td> Last name: </td>");
			out.println("<td> <input type=\"text\" name=\"lastName\"> </td>");
			out.println("</tr>");				
			out.println("<tr>");
			out.println("<td> Address: </td>");
			out.println("<td> <input type=\"text\" name=\"address\"> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<tr>");
			out.println("<td> Phone: </td>");
			out.println("<td> <input type=\"text\" name=\"phoneNumber\"> </td>");
			out.println("</tr>");
			out.println("<td> Credit Card Information: </td>");
			out.println("<td> <input type=\"text\" name=\"creditcard\"> </td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<br><br>");
			out.println("<input type=\"submit\" value=\"Place Order\">");			
			out.println("</fieldset>");		
			out.println("</form>");
			out.println("</div>");
			out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul><li><a href='/Assignment4/IndexPageServlet'>Home Page</a></li><li><a>Our Products</a><ul>");
            out.println("<li><a href='/Assignment4/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment4/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment4/SmartPhoneDisplayServlet'>Laptops</a></li>");
            out.println("<li><a href='/Assignment4/TvDisplayServlet'>TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you");
            out.println("</li></ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div>");
			out.println("<div id = 'footer'><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");		
			out.println("</body>");
			out.println("</html>");
						
	   

	}
}