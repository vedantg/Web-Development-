import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AdminPageServlet extends HttpServlet {

List<Product> product_list = new ArrayList<Product>();
HashMap<String,List<Product>> mapInFile = new HashMap<String,List<Product>>();
String key;
int flag;
HashMap<String, List<Product>> ee ;
public ServletContext sc;

 


protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException 
    {
        PrintWriter out= response.getWriter(); 
        response.setContentType("text/html");
        mapInFile = MySqlDataStoreUtilities.selectAdminProducts();
                                                                  

         
out.println("<html>");
out.println("<head>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
out.println("</head>");
out.println("<body>");
out.println("<div id='container'>");
out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:center','font-size:900%'>Welcome"+ "<span style='width:70px;display:inline-block;float:right'></span>"+" !  <a href='/Assignment4/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
out.println("<table>"+"<tr>"+"<th>Product Id</th>"+"<th>Product Name</th>"+"<th>Product Retailer</th>"+"<th>Product Condition</th>");
out.println("<th>Price</th>"+"</tr>");
                                                    

                                for (Map.Entry<String, List<Product>> ee : mapInFile.entrySet()) 
                                {
                                                    product_list = ee.getValue();

                                                    for (Product p : product_list) {
                                                    out.println("<tr>");
                                                    out.println("<td>"+p.id+"</td>");
                                                    out.println("<td>"+p.name+"</td>");
                                                    out.println("<td>"+p.retailer+"</td>");
                                                    out.println("<td>"+p.condition+"</td>");
                                                    out.println("<td>"+p.price+"</td>");
                                                    out.println("</tr>");
                                                }
                                            }
                                        
         out.println("<td>"+"<a href='/Assignment4/AddAdminProductDesignServlet'><b>Add Product </b></a>"+"</td>");
         out.println("</tr>");
         out.println("<a href='/Assignment4/DataAnalyticsDesignServlet'>Data<span>Analytics</span></a>");
         out.println("<form method='post' action='/Assignment4/UpdateAdminDesignProductServlet'>"+"<p>Enter the Product ID which you want to update</p>");
         out.println("<input type='text' name='productUpdateId'>"+"<input type='submit' name='submit'>"+"</form>");
         out.println("<form method='post' action='/Assignment4/DeleteAdminProductServlet'>"+"<p>Enter the Product ID which you want to delete</p>");
         out.println("<input type='text' name='productDeleteId'>"+"<input type='submit' name='submit'>"+"</form>");               
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