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

public class CartProductDisplay extends HttpServlet implements Serializable {


transient HashMap<String, List<Product>> mapInFile;
List<Product> laptop_list ;
List<Product> tab_list ;
List<Product> sm_list;
List<Product> tv_list ;
transient HashMap<String, List<Product>> ee ;
String key;
int flag;
public ServletContext sc;
PrintWriter out ;

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

        out= response.getWriter();
        response.setContentType("text/html");
        
        String productformid =request.getParameter("productFormId");
        
        int productsInCart = MySqlDataStoreUtilities.productsInCart();


        response.setContentType("text/html");
        //out= response.getWriter();
        //HashMap<String,String> mapInFile = new HashMap<String,String>();
        HttpSession session=request.getSession(); 
        ServletContext sc=request.getSession().getServletContext();
        String user=((String)session.getAttribute("userid"));
        String username_cap = user.substring(0, 1).toUpperCase() + user.substring(1);
        laptop_list = new ArrayList<Product>();
        tab_list = new ArrayList<Product>();
        sm_list= new ArrayList<Product>();
        tv_list = new ArrayList<Product>();
        mapInFile = new HashMap<String,List<Product>>();        
        mapInFile = MySqlDataStoreUtilities.selectProducts(productformid);
        

        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment4/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username_cap +" !"+"<span style='width:110px;display:inline-block'><a href='#'>CART:"+ productsInCart +"</a></span>" + "</h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment4/IndexPageServlet'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='/Assignment4/SmartPhoneDisplayServlet'>Smart Phones</a></li>" + "<li><a href='/Assignment4/TabletDisplayServlet'>Tablets</a></li>");
        out.println("<li><a href='/Assignment4/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment4/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "<li><a href='/Assignment4/FindReviewsServlet'>Trending</a></li>"+"</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");
        out.println("<h4> Your Cart Items: </h4>");

                         
                                                       
                            for (Map.Entry<String, List<Product>> ee : mapInFile.entrySet()) 
                                {                   
                                    key = ee.getKey();
                                    if(key.equals("Laptop"))
                                    {
                                        laptop_list = ee.getValue();
                                        //out.println("Key:"+key);
                                        //out.println("Laptop_List::"+laptop_list);
                                        //break;
                                        for (Product p : laptop_list) {
                                            
                                        
                                            out.println("<p align='left'>ID:" + p.id + "<p align='left'>Name:" + p.name + "</p>");
                                            out.println("<p align='left'>Retailer:" + p.retailer + "</p>");
                                            out.println("<p align='left'><img src =" + p.image + "width = '200' height = '200' alt =" + p.name +"></p>");
                                            //out.println("<button onclick='WriteToCartFile()'>Add to Shopping Cart</button>");
                                            out.println("<form action='/Assignment4/DeleteCartServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='deleteFormId' value='"+p.id+"' />" +"<span style='width:110px;display:inline-block'></span>"+
                        "<input type='submit' value='Delete From Cart' class='submit-button' style='width:200px;'>" +
                        "</form>");
                                         } 
                                    } 

                                    if(key.equals("TV"))
                                    {
                                        tv_list = ee.getValue();
                                        //out.println("Key:"+key);
                                        //out.println("Laptop_List::"+laptop_list);
                                        //break;
                                        for (Product p : tv_list) {
            
                                            out.println("<p align='left'>ID:" + p.id + "<p align='left'>Name:" + p.name + "</p>");
                                            out.println("<p align='left'>Retailer:" + p.retailer + "</p>");
                                            out.println("<p align='left'><img src =" + p.image + "width = '200' height = '200' alt =" + p.name +"></p>");
                                            //out.println("<button onclick='WriteToCartFile()'>Add to Shopping Cart</button>");
                                            out.println("<form action='/Assignment4/DeleteCartServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='deleteFormId' value='"+p.id+"' />" +"<span style='width:110px;display:inline-block'></span>"+
                        "<input type='submit' value='Delete From Cart' class='submit-button' style='width:200px;'>" +
                        "</form>");
                                         } 
                                    }       

                                    if(key.equals("SmartPhone"))
                                    {
                                        sm_list = ee.getValue();
                                        //out.println("Key:"+key);
                                        //out.println("Laptop_List::"+laptop_list);
                                        //break;
                                        for (Product p : sm_list) {
            
            out.println("<p align='left'>ID:" + p.id + "<p align='left'>Name:" + p.name + "</p>");
            out.println("<p align='left'>Retailer:" + p.retailer + "</p>");
            out.println("<p align='left'><img src =" + p.image + "width = '200' height = '200' alt =" + p.name +"></p>");
            //out.println("<button onclick='WriteToCartFile()'>Add to Shopping Cart</button>");
            out.println("<form action='/Assignment4/DeleteCartServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='deleteFormId' value='"+p.id+"' />" +"<span style='width:110px;display:inline-block'></span>"+
                        "<input type='submit' value='Delete From Cart' class='submit-button' style='width:200px;'>" +
                        "</form>");           
            out.println("<hr width='90%' size='2' align='center'>");
         } 
                                    }       


                                    if(key.equals("Tablet"))
                                    {
                                        tab_list = ee.getValue();
                                        //out.println("Key:"+key);
                                        //out.println("Laptop_List::"+laptop_list);
                                        //break;
                                        for (Product p : tab_list) {
            
            out.println("<p align='left'>ID:" + p.id + "<p align='left'>Name:" + p.name + "</p>");
            out.println("<p align='left'>Retailer:" + p.retailer + "</p>");
            out.println("<p align='left'><img src =" + p.image + "width = '200' height = '200' alt =" + p.name +"></p>");
            //out.println("<button onclick='WriteToCartFile()'>Add to Shopping Cart</button>");
            out.println("<form action='/Assignment4/DeleteCartServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='deleteFormId' value='"+p.id+"' />" +"<span style='width:110px;display:inline-block'></span>"+
                        "<input type='submit' value='Delete From Cart' class='submit-button' style='width:200px;'>" +
                        "</form>");
                    out.println("<hr width='90%' size='2' align='center'>");          
            out.println("<hr width='90%' size='2' align='center'>");
         } 
                                    }       

                                }

             int total_price=MySqlDataStoreUtilities.priceCalculate();
             System.out.println("Sum is: "+total_price);


            out.println("<form action='/Assignment4/PlaceOrderServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='totalprice' value='"+total_price+"' />" +
                        "<input style='float:center' type='submit' value='Place Order' class='submit-button' style='width:200px;'>" +
                        "</form>");                    
            out.println("</div>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul><li><a href='/Assignment4/IndexPageServlet'>Home Page</a></li><li><a>Our Products</a><ul>");
            out.println("<li><a href='/Assignment4/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment4/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment4/SmartPhoneDisplayServlet'>Laptops</a></li>");
            out.println("<li><a href='/Assignment4/TvDisplayServlet'>TV</a></li></ul></li>"+"<li><a href='/Assignment4/FindReviewsServlet'>Trending</a></li></ul></li><li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you");
            out.println("</li></ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div>");             
            out.println("<div id = 'footer'><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");
                                 
            }

    
    protected void showPage(HttpServletResponse response, String s)
    throws ServletException, java.io.IOException {
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       pw.println(s);      
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