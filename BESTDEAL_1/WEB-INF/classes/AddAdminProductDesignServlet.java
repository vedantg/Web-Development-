import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AddAdminProductDesignServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException 
    {
        PrintWriter out= response.getWriter(); 
        response.setContentType("text/html");
        
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Add Products : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment2_Test/AdminPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:center','font-size:900%'>Welcome "+ " !</h2>" + "</div>" + "</header>");                                                    
        out.println("<form method='post' action='/Assignment2_Test/AddAdminProductServlet'><h3>Add Products</h3><table cellpadding='2' cellspacing='1'>");
        out.println("<tr><td>Category</td><td><select name='productCategory'><option value='TV'>TV</option><option value='Laptop'>Laptop</option>");
        out.println("<option value='Tablet'>Tablet</option><option value='SmartPhone'>SmartPhone</option></select></td></tr>");
        out.println("<tr><td>Retailer</td><td><input type='TEXT' size='15' name='productRetailer'></input></td></tr>");
        out.println("<tr><td>Product Id</td><td><input type='TEXT' size='15' name='productId' placeholder='Start with L/V/T/S###'></input></td></tr>");
        out.println("<tr><td>Product Name</td><td><input type='text' size='15' name='productName'/></td></tr>");
        out.println("<tr><td>Condition</td><td><input type='TEXT' size='15' name='productCondition'></input></td></tr>");
        out.println("<tr><td>Price</td><td><input type='TEXT' size='15' name='productPrice'></input></td></tr>");
        out.println("<tr><td>Accessories</td><td><input type='TEXT' size='15' name='productAcc'></input></td></tr>");
        out.println("<tr><td>Set Image</td><td><input type='TEXT' size='20' name='productImg' placeholder='Set Path W/Single Quotes:images/Ur_image.jpg'></input></td></tr>");
        out.println("<tr><td colspan='2'><center><input type='submit' value='Add Product' /></center></td></tr>");
        out.println("</table></form>");
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

