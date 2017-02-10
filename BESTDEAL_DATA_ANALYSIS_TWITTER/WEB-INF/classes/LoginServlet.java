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


public class LoginServlet extends HttpServlet {
   
    protected Map users = new HashMap();
    HashMap<String,String> ee ;
    HashMap<String,String> mapInFile = new HashMap<String,String>();
    String[] temp_key = new String[100];
    String[] temp_value_pass = new String[100];;
    String key;
    int flag;

    public void init() {

                users.put("sales", "sales");
                users.put("admin","admin");
    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    	response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        if(userid != null && userid.length() != 0) {
            userid = userid.trim();
        }
        if(password != null && password.length() != 0) {
            password = password.trim();
        }
        if(userid != null && password != null) {
                String realpassword = (String)users.get(userid);
                if(realpassword != null &&
                    realpassword.equals(password) && userid.equals("admin")) {
                	
                        HttpSession session=request.getSession(); 
                        session.setAttribute("userid",userid);  
                        response.sendRedirect("/Assignment5/AdminPageServlet"); 

                } else if(userid.equals("sales")) {

                        HttpSession session=request.getSession(); 
                        session.setAttribute("userid",userid);  
                        response.sendRedirect("/Assignment5/SalesPageServlet");  
                    
                } 

                else {

                                HashMap<String,String> mapInFile= MySqlDataStoreUtilities.selectUser();
                                                    
                                System.out.println(mapInFile);
                                for (Map.Entry<String, String> ee : mapInFile.entrySet()) 
                                {
                                        key = ee.getKey();
                                        //System.out.println("Key:"+key);
                                        String values = ee.getValue();
                                        //System.out.println("Value::"+values);
                                        if((userid.equals(key)) && (password.equals(values)))
                                            {                
                                                //System.out.println("In IFFF");
                                                //System.out.println("userid::"+userid);
                                                //System.out.println("password::"+password);
                                                flag=1;  
                                                break;                                                                   
                                            }
                                        else
                                            {          
                                                 //System.out.println("In ELSEEE");
                                                 flag=0;
                                            }  

                                }

                                if(flag==1)
                                 {
                                    HttpSession session=request.getSession(); 
                                    session.setAttribute("userid",userid);  
                                    response.sendRedirect("/Assignment5/DealMatches");
                                 }

                                 if(flag==0)
                                 {
                                    showPageLogin(response, "Login Failure!  You must supply correct username and password");
                                 }
                        
                }

        }  
        else {
            showPageLogin(response, "Login Failure!  You must supply a username and password");
        }
    } 
    

    protected void showPageLogin(HttpServletResponse response, String message)
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
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='index.html'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<div id='body'>" + "<section id='content'>" + "<article>" + "<form method='post' action='/Assignment5/LoginServlet'>");
        out.println("<h4>" + message + "</h4>");
        out.println("<table cellpadding='2' cellspacing='1'>" + "<tr>" + " <td>User ID</td>" + "<td><input type='TEXT' size='15' name='userid'></input></td>" + "</tr>");
        out.println("<tr>" + "<td>Password</td>" + "<td><input type='PASSWORD' size='15' name='password'/></td>" + "</tr>" + "<tr>" + "<td colspan='2'>");
        out.println("<center><input type='submit' value='Login' style='margin-right:100px;'/></center>" + "</td>" + "</tr>" + "</table>" + "</form>" + "<h5>Don't have an account click- <a href='/Assignment1/SignupDesignServlet'>Sign Up</a></h5>");
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
