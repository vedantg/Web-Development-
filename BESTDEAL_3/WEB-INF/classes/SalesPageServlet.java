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

public class SalesPageServlet extends HttpServlet {
  
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    
      HttpSession session = request.getSession(true);
      HashMap<String,String> mapInFile = new HashMap<String,String>();
      String orderStatus = "InProgress..!!";
      //String orderStatus1 = "..!!";
              
      PrintWriter out = response.getWriter();     
    
        mapInFile = MySqlDataStoreUtilities.selectSalesOrder();  

        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment4/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:center','font-size:900%'>Welcome"+ "<span style='width:70px;display:inline-block;float:right'></span>"+" !  <a href='/Assignment4/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");
                                            
        out.println("<form method='post' action='/Assignment4/SalesDeleteServlet'>"+"<p>Enter the Order ID which you want to Cancel</p>");
        out.println("<input type='text' name='productUpdateId'>"+"<input type='submit' name='submit'>"+"</form>");
        out.println("<hr width='90%' size='2' align='center'>");        
        out.println("<form method='post' action='/Assignment4/SalesUpdateDesignServlet'>"+"<p>Enter the Order ID which you want to Update</p>");
        out.println("<input type='text' name='productUpdateId'>"+"<input type='submit' name='submit'>"+"</form>");
        out.println("<hr width='90%' size='2' align='center'>");        
        for (Map.Entry<String, String> ee : mapInFile.entrySet()) 
          {
           
            String orderId = ee.getKey();
            String price = ee.getValue();
            out.println("<p align='left'>Order ID:" + orderId ); 
            out.println("<p align='left'>Price:" + price ); 
            out.println("<p align='left'>Order Status:" + orderStatus); 
            out.println("<hr width='90%' size='2' align='center'>");
         } 
        
      out.println("</body>");
      out.println("</html>");


      
      
     
  }
  
  public void destroy() {

  }
  
}