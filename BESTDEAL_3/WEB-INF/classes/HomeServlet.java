
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class HomeServlet extends HttpServlet {


    
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
        out.println("<div id='body'>" + "<section id='content'>" + "<article>" + "<form method='post' action='/Assignment4/LoginServlet'>");
        out.println("<h4>" + "Please Provide Your Login Credentials" + "</h4>");
        out.println("<table cellpadding='2' cellspacing='1'>" + "<tr>" + " <td>User ID</td>" + "<td><input type='TEXT' size='15' name='userid'></input></td>" + "</tr>");
        out.println("<tr>" + "<td>Password</td>" + "<td><input type='PASSWORD' size='15' name='password'/></td>" + "</tr>" + "<tr>" + "<td colspan='2'>");
        out.println("<center><input type='submit' value='Login' style='margin-right:100px;'/></center>" + "</td>" + "</tr>" + "</table>" + "</form>" + "<h5>Don't have an account click- <a href='/Assignment4/SignupDesignServlet'>Sign Up</a></h5>");
        out.println("</div>" );
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
