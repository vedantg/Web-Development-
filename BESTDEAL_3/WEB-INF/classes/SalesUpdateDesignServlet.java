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

public class SalesUpdateDesignServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException 
    {
        
    
      HttpSession session = request.getSession(true);
      HashMap<String,List<OrderHistoryModel>> mapInFile = new HashMap<String,List<OrderHistoryModel>>();
      //HashMap<String, List<OrderHistoryModel>> ee ;
      String key;
      //public List<OrderHistoryModel> updatedOrderHistory_list = new ArrayList<OrderHistoryModel>();
      List<OrderHistoryModel> updatedOrderHistory_list = new ArrayList<OrderHistoryModel>();
              
      PrintWriter out = response.getWriter(); 
      String productformid =request.getParameter("productUpdateId");

      
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Add Products : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment4/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>");

      mapInFile = MySqlDataStoreUtilities.selectUpdatedOrderSales(productformid); 
                            
                            for (Map.Entry<String, List<OrderHistoryModel>> ee : mapInFile.entrySet()) 
                                {                   
                                      key = ee.getKey();
                                      if(key.equals(productformid))
                                    {
                                        updatedOrderHistory_list = ee.getValue();
                                        //out.println("Key:"+key);
                                        //out.println("updatedOrderHistory_list::"+updatedOrderHistory_list);
                                        //break;
                                        for (OrderHistoryModel o : updatedOrderHistory_list) {
                                                                          
        out.println("<form method='post' action='/Assignment4/SalesUpdateProduct'><h3>Edit Order</h3><table cellpadding='2' cellspacing='1'>");
        //out.println("<tr><td>Category</td><td><select name='productCategory'><option value='"+productcategory+"'>TV</option><option value='Laptop'>Laptop</option></select></td></tr>");
        out.println("<tr><td>OrderID</td><td><input type='TEXT' readonly='true' size='15' value='"+o.orderId+"' name='orderId1'></input></td></tr>");        
        out.println("<tr><td>First Name</td><td><input type='TEXT' size='15' value='"+o.firstName+"' name='firstName1'></input></td></tr>");
        out.println("<tr><td>Last Name</td><td><input type='TEXT' size='15' value='"+o.lastName+"' name='lastName1'></input></td></tr>");
        out.println("<tr><td>price</td><td><input type='text' size='15' value='"+o.price+"' name='price1'/></td></tr>");
        out.println("<tr><td>Address</td><td><input type='TEXT' size='15' value='"+o.address+"' name='address1'></input></td></tr>");
        out.println("<tr><td>Phone</td><td><input type='TEXT' size='15' value='"+o.phone+"' name='phone1'></input></td></tr>");
        out.println("<tr><td>Credit Card</td><td><input type='TEXT' size='15' value='"+o.creditCard+"' name='creditCard1'></input></td></tr>");
        //out.println("<tr><td>Accessories</td><td><input type='TEXT' size='15' name='productAcc'></input></td></tr>");
        out.println("<tr><td colspan='2'><center><input type='submit' value='Edit Order' /></center></td></tr>");
        out.println("</table></form>");
                                         } 
                                    }

                                  }

        
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