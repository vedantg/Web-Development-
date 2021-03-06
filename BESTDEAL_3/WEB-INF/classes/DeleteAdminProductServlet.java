import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DeleteAdminProductServlet extends HttpServlet implements Serializable{


        List<Product> tv_list = new ArrayList<Product>();
        List<Product> laptop_list = new ArrayList<Product>();
        List<Product> sm_list = new ArrayList<Product>();
        List<Product> tab_list = new ArrayList<Product>();
        String key;

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException 
    {
        Product p;
        Map<String, List<Product>> product=new HashMap<String, List<Product>>();
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        ServletContext sc=request.getSession().getServletContext();
        HttpSession session=request.getSession(); 
        String user=((String)session.getAttribute("userid")); 


        String productid = request.getParameter("productDeleteId");
        
        MySqlDataStoreUtilities.deleteAdminProduct(productid);


        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Product Deleted : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<h4>" + "<span style='width:310px;display:inline-block'></span>" + "Your Product Has Been Deleted" + "</h4>");
        out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment4/AdminPageServlet'>Click here to redirect</a>");                                      
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