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
import java.text.DateFormat;
import java.util.*;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SubmitOrderServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
			HttpSession session = request.getSession(true);
			String productName = request.getParameter("productName");
			String productPrice = request.getParameter("productPrice");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String creditcard = request.getParameter("creditcard");			
			String status="Active";
			//HttpSession session=request.getSession(true); 
			String user=((String)session.getAttribute("userid"));
			String title = "Your Order Placed Successfully";
			
			Random r = new Random( System.currentTimeMillis() );
			int rand= 10000 + r.nextInt(20000);
			String randString=Integer.toString(rand);			

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 14); // Adding 14 days
		String output = sdf.format(c.getTime());

			
			//productPrice=productPrice.substring(0, productPrice.length()-1);	
				
			PrintWriter out = response.getWriter();	

			System.out.println("IN submit1::");		
		
		MySqlDataStoreUtilities.insertOrderHistory(randString,firstName,lastName,productPrice,address,phoneNumber,creditcard);	
		System.out.println("IN submit2::");		

		out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment2_Test/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome"+"<span style='width:110px;display:inline-block'><a href='#'></a></span>" + "<a href='/Assignment2_Test/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment2_Test/IndexPageServlet'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Smart Phones</a></li>" + "<li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li>");
        out.println("<li><a href='/Assignment2_Test/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");
                
        out.println("<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
				"<H3 ALIGN=CENTER>Your Order Number :" + randString + "</H3>\n" +
                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Parameter Name<TH>Parameter Value(s)");
				
				out.print("<TR><TD> First Name  \n</TD>");
				out.print("<TD>" + request.getParameter("firstName") + "\n</TD></TR>");
				
				
				out.print("<TR><TD> Last Name  \n</TD>");
				out.print("<TD>" + request.getParameter("lastName") + "\n</TD></TR>");
				
				
				out.print("<TR><TD> Phone Number \n</TD>");
				out.print("<TD>" + request.getParameter("phoneNumber") + "\n</TD></TR>");
				
				out.print("<TR><TD> Address  \n</TD>");
				out.print("<TD>" + request.getParameter("address") + "\n</TD></TR>");
				
				
					
					out.print("<TR><TD> Delivery Date  \n</TD>");
					out.print("<TD>" + output + "\n</TD></TR>");
					out.println("</TABLE>\n");

					out.println
          ("</TABLE>\n" +
           "<FORM ACTION=/Assignment2_Test/OrderHistoryServlet  " +
		   " METHOD=\"get\">\n"+
           "<BIG><CENTER>\n" +
		   "<p>Thank you for shopping with us...</p>"+
           "<INPUT TYPE=\"SUBMIT\"\n" +
           "       VALUE=\"Order History\">\n" +
		   
           "</CENTER></BIG></FORM>");
					out.println("</div>");
			out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul><li><a href='/Assignment2_Test/IndexPageServlet'>Home Page</a></li><li><a>Our Products</a><ul>");
            out.println("<li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Laptops</a></li>");
            out.println("<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you");
            out.println("</li></ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div>");
			out.println("<div id = 'footer'><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");		
			out.println("</body>");
			out.println("</html>");


			
			
		 
	}
	
	public void destroy()	{

	}
	
}