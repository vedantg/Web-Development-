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

public class LaptopDisplayServlet extends HttpServlet {

public List<Product> product_list_lap = new ArrayList<Product>();
public String key_nm = "Laptop";

	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        ServletContext sc=request.getSession().getServletContext();

        HttpSession s=request.getSession();
        String username=(String)s.getAttribute("userid");
        String username_cap = username.substring(0, 1).toUpperCase() + username.substring(1);

        product_list_lap = MySqlDataStoreUtilities.selectLaptop(key_nm);
                       
		out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment5/DealMatches'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username_cap +" !"+"<a href='/Assignment5/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment5/DealMatches'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='/Assignment5/SmartPhoneDisplayServlet'>Smart Phones</a></li>" + "<li><a href='/Assignment5/TabletDisplayServlet'>Tablets</a></li>" + " <li><a href='#'></a></li>");
        out.println("<li><a href='#'>Laptops</a></li>" + "<li><a href='/Assignment5/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "<li><a href='/Assignment5/FindReviewsServlet'>Trending</a></li>"+"</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");

		for (Product p : product_list_lap) {
            
            out.println("<p align='left'>ID:" + p.id + "<p align='left'>Name:" + p.name + "</p>");
            out.println("<p align='left'>Retailer:" + p.retailer + "</p>");
            out.println("<p align='left'>Price:" + p.price + "</p>");
            out.println("<p align='left'><img src =" + p.image + "width = '200' height = '200' alt =" + p.name +"></p>");
            out.println("<form action='/Assignment5/AddToCartServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='productFormId' value='"+p.id+"' />" +
                        "<input type='submit' value='Add to Shopping Cart' class='submit-button' style='width:200px;'>" +
                        "</form>");  
            out.println("<form action='/Assignment5/WriteReviewsServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='productReviewId' value='"+p.id+"' />" +
                        "<input type='hidden' name='productReviewName' value='"+p.name+"' />" +
                        "<input type='hidden' name='productReviewRetailer' value='"+p.retailer+"' />" +
                        "<input type='hidden' name='productReviewCondition' value='"+p.condition+"' />" +
                        "<input type='hidden' name='productReviewPrice' value='"+p.price+"' />" +
                        "<input type='hidden' name='productReviewImage' value='"+p.image+"' />" +   
                        "<input type='submit' value='Write Reviews' class='submit-button' style='width:200px;'>" +
                        "</form>");
            out.println("<form action='/Assignment5/ReadReviewsServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='productFormId' value='"+p.id+"' />" +
                        "<input type='hidden' name='productReadReviewName' value='"+p.name+"' />" +
                        "<input type='submit' value='Read Reviews' class='submit-button' style='width:200px;'>" +
                        "</form>");            
            out.println("<hr width='90%' size='2' align='center'>");
         } 
         out.println("</div>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul>");
            out.println("<li><a href='#'>Home Page</a></li><li><a>Our Products</a><ul><li><a href='/Assignment5/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment5/TabletDisplayServlet'>Tablets</a></li><li><a href='#'>Laptops</a></li><li><a href='/Assignment5/TvDisplayServlet'>TV</a></li></ul></li>"+"<li><a href='/Assignment5/FindReviewsServlet'>Trending</a></li></ul></li>");
            out.println("<li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you</li>");
            out.println("</ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");
                                         
		out.close();
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}