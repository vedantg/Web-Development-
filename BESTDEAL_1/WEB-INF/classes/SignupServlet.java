/*
 * RegisterServlet.java
 *
 */
 
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.File;

public class SignupServlet extends HttpServlet {

	public HashMap<String, List<SignUpDetails>> details = new HashMap<String, List<SignUpDetails>>();
    List<SignUpDetails> values = new ArrayList<SignUpDetails>();
    SignUpDetails s = new SignUpDetails();


protected void register(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");	

        s.setUserid(userid);
        s.setPassword(password);
        s.setEmail(email);
        s.setPhone(phone);

        //values.add(s);
		
		//details.put(userid, values);

        MySqlDataStoreUtilities.insertUser(userid,password,email,phone);


        
        
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<h4>" + "<span style='width:310px;display:inline-block'></span>" + "Thank you for registering with us" + "</h4>");
        out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment2_Test/HomeServlet'>Click here to login</a>");
}





/** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        register(request, response);
       // writeGameSpeedDataStore();
      //  showPageLogin(response);
} 

    /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        register(request, response);
        //writeGameSpeedDataStore();
      //  showPageLogin(response);
    }
}

        