import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.http.*;

public class IndexPageServlet extends HttpServlet {
	
 File file;
 long size;

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		HttpSession s=request.getSession();
    	String username=(String)s.getAttribute("userid");
        String username_cap = username.substring(0, 1).toUpperCase() + username.substring(1);
	
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
            out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
            out.println("<script type='text/javascript' src='javascript.js'></script>");
            // JavaScript Included Here...!!
            
            out.println("</head>");
            out.println("<body onload='init()''>");
            out.println("<div id='container'>");
            out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
            out.println("<h2>Your One Stop Shop" + "</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username_cap +" !"+"<a href='/Assignment4/SignOutServlet'>Sign <span>Out</span></a></h2>" +  "</div>" + "</header>");
            out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='#'>Home</a></li>" + "<li>");
            out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='/Assignment4/SmartPhoneDisplayServlet'>Smart Phones</a></li>" + "<li><a href='/Assignment4/TabletDisplayServlet'>Tablets</a></li>");
            out.println("<li><a href='/Assignment4/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment4/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "<li><a href='/Assignment4/FindReviewsServlet'>Trending</a></li>");
            out.println("</ul>");       
            out.println("</nav>");
            out.println("</div>");


           /* 
            out.println("<script type='text/javascript' src='javascript.js'></script>");
            out.println("<input type='text' name='searchId' value='' class='input' id='searchId' onkeyup='doCompletion()' style='padding: 5px; font-size: 16px;' placeholder='search here..'/>");
            out.println("<div id='auto-row'> <table id='complete-table' class='gridtable' style='position: absolute; width:315px;'></table>");
            out.println("</div> </body>");*/

            out.println("<div id='search_body'>");
            out.println("<form name='autofillform' action='autocomplete'><table><tbody>");
            out.println("<input type='text' size='30'  name='searchId' id='searchId' onkeyup='doCompletion()' style='font-size: 16px;' placeholder='Search Here...!!' />");
            out.println("<img src='images/Search.png' style='margin-top:10px;margin-left: 5px;'/>");    
            out.println("</td></tr><tr><td id='auto-row' colspan='2'><table id='complete-table' class='popupBox' /></td></tr></tbody></table></form>"); 
            out.println("<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
            out.println("</div>");

            
        	out.println("<div id='body'>");            
            out.println("<section id='content'><article><h2>Welcome To <span1>Best</span1> <span2>Deal" + "</span2>" + "<span style='width:10px;display:inline-block'></span>" + username_cap + "</h2>");
            out.println("<p><span>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you. Come along to experience how technology integrates into your life at <span1>Best</span1> <span2>Deal</span2> with extraordinary offers in every department.</span></p>");
            out.println("<p><span>Our Built-for-work, ready-for-life Products:</span></p>");
            out.println("<ul class='styledlist'><li><span1>Smart Phones</span1></li><li><span2>Tablets</span2></li><li><span1>Laptops</span1></li><li><span2>TV</span2></li>");
            out.println("</ul></article></section>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul>");
            out.println("<li><a href='#'>Home Page</a></li><li><a>Our Products</a><ul><li><a href='/Assignment4/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment4/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment4/LaptopDisplayServlet'>Laptops</a></li><li><a href='/Assignment4/TvDisplayServlet'>TV</a></li></ul></li>"+"<li><a href='/Assignment4/FindReviewsServlet'>Trending</a></li></ul></li>");
            out.println("<li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you</li>");
            out.println("</ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");

    	}
    }