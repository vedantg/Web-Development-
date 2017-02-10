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

public class UpdateOrderHistoryServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException 
    {
        
    
      //List<OrderHistoryModel> updatedOrderHistory_list = new ArrayList<OrderHistoryModel>();
      HttpSession session = request.getSession(true);
      HashMap<String,List<OrderHistoryModel>> mapInFile = new HashMap<String,List<OrderHistoryModel>>();
      HashMap<String, List<OrderHistoryModel>> ee ;
      //public List<OrderHistoryModel> updatedOrderHistory_list = new ArrayList<OrderHistoryModel>();
              
      PrintWriter out = response.getWriter(); 
      String productformid =request.getParameter("productUpdateId");

      

       String orderId1 = request.getParameter("orderId1");
        String firstName1 = request.getParameter("firstName1");
        String lastName1 = request.getParameter("lastName1");
        String price1 = request.getParameter("price1");        
        String address1= request.getParameter("address1");
        String phone1 = request.getParameter("phone1");
        String creditCard1 = request.getParameter("creditCard1");

        
        MySqlDataStoreUtilities.updateSelectedOrderHistory(orderId1,firstName1,lastName1,price1,address1,phone1,creditCard1);

        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Cart Delete : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<h4>" + "<span style='width:310px;display:inline-block'></span>" + "Your Order Has Been Updated Successfully" + "</h4>");
        out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment2_Test/OrderHistoryServlet'>Click here to redirect</a>");
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