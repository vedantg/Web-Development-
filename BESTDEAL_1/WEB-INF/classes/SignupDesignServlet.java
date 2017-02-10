/*
 * LoginServlet.java
 *
 */
 

import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class SignupDesignServlet extends HttpServlet {
   
    
    protected void showPage(HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<div id='body'>" + "<section id='content'>" + "<article>" + "<form method='post' action='/Assignment2_Test/SignupServlet'>");
        out.println("<h4>" + "Please Provide Your Login Details" + "</h4>");
        out.println("<table cellpadding='2' cellspacing='1'>" + "<tr>" + " <td>User ID</td>" + "<td><input type='TEXT' size='15' name='userid'></input></td>" + "</tr>");
        out.println("<tr>" + "<td>Password</td>" + "<td><input type='PASSWORD' size='15' name='password'/></td>" + "</tr>");
        out.println("<tr><td>Email ID</td><td><input type='TEXT' size='15' name='email'></input></td></tr>");
        out.println("<tr><td>Phone Number</td><td><input type='TEXT' size='15' name='phone'></input></td></tr>");
        out.println("<tr>" + "<td colspan='2'>");
        out.println("<center><input type='submit' value='Register' style='margin-right:100px;'/></center>" + "</td>" + "</tr>" + "</table>" + "</form>");
        out.println("</div>" );
        //out.println("<li><a>Our Products</a>" + "<ul>" + "<li><a href='index.html'>Smart Phones</a></li>" + "<li><a href='index.html'>Tablets</a></li>" + "<li><a href='index.html'>Laptops</a></li>" + "<li><a href='index.html'>TV</a></li>");
        //out.println("</ul>" + "</li>" + "</ul>" + "</li>");
        //out.println("<li>" + "<h4>About us</h4>" + "<ul>" + "<li class='text'>" + "<p style='margin: 0;''>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you" + "</p>" + "</li>" + "</ul>" + "</li>");
        //out.println("<li>" + "<h4>Search site</h4>" + "<ul>" + "<li class='text'>" + "<form method='get' class='searchform' action='#' >" + "<p>" + "<input type='text' size='30' value='' name='s' class='s' />" + "</p>" + "</form>" );
        //out.println("</li>" + "</ul>" + "</li>" + "</ul>");    
        out.println("<div class='clear'></div>" + "</div>" + "<footer>" + "<div class='footer-bottom'>" + "<p>MAKING TECHNOLOGY WORK FOR YOU..!!</p>" + "</div>" + "</footer>" + "</div>" + "</body>" + "</html>");                        
        out.close();
 
    }

   
    /** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    	showPage(response);
    } 

    /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    	showPage(response);
    }
}
