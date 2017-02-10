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


transient HashMap<String, List<Product>> mapInFile = new HashMap<String,List<Product>>();
List<Product> laptop_list = new ArrayList<Product>();
List<Product> tab_list = new ArrayList<Product>();
List<Product> sm_list = new ArrayList<Product>();
List<Product> tv_list = new ArrayList<Product>();
transient HashMap<String, List<Product>> ee ;
String key;
int flag;
public ServletContext sc;
PrintWriter out ;

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

        out= response.getWriter();

        String productformid =request.getParameter("productFormId");
        System.out.println("id recieved is: "+productformid);
        int productsInCart = MySqlDataStoreUtilities.productsInCart();


        response.setContentType("text/html");
        //out= response.getWriter();
        //HashMap<String,String> mapInFile = new HashMap<String,String>();
        ServletContext sc=request.getSession().getServletContext();
        HttpSession session=request.getSession(); 
        String user=((String)session.getAttribute("userid"));
        String username_cap = user.substring(0, 1).toUpperCase() + user.substring(1);
        //SaxParser4ProductXMLdataStore.loadProducts();
        

        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment2_Test/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username_cap +" !"+"<span style='width:110px;display:inline-block'><a href='#'>CART:"+ productsInCart +"</a></span>" + "</h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment2_Test/IndexPageServlet'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Smart Phones</a></li>" + "<li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li>");
        out.println("<li><a href='/Assignment2_Test/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "<li><a href='/Assignment2_Test/FindReviewsServlet'>Trending</a></li>"+"</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");
        out.println("<h4> Your Cart Items: </h4>");

                         
                            mapInFile = MySqlDataStoreUtilities.selectProducts(productformid);

                            
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
                                            out.println("<form action='/Assignment2_Test/DeleteCartServlet' method='get' style='margin-bottom:20px;'>"+
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
                                            out.println("<form action='/Assignment2_Test/DeleteCartServlet' method='get' style='margin-bottom:20px;'>"+
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
            out.println("<form action='/Assignment2_Test/DeleteCartServlet' method='get' style='margin-bottom:20px;'>"+
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
            out.println("<form action='/Assignment2_Test/DeleteCartServlet' method='get' style='margin-bottom:20px;'>"+
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
                                
            out.println("</div>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul><li><a href='/Assignment2_Test/IndexPageServlet'>Home Page</a></li><li><a>Our Products</a><ul>");
            out.println("<li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Laptops</a></li>");
            out.println("<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li></ul></li>"+"<li><a href='/Assignment2_Test/FindReviewsServlet'>Trending</a></li></ul></li><li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you");
            out.println("</li></ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div>");
            out.println("<form action='/Assignment2_Test/PlaceOrderServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='totalprice' value='"+total_price+"' />" +
                        "<input style='float:center' type='submit' value='Place Order' class='submit-button' style='width:200px;'>" +
                        "</form>"); 
            out.println("<div id = 'footer'><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");
                           
                           
       /* out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment2_Test/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username_cap +" !"+"<span style='width:110px;display:inline-block'><a href='#'>CART:"+count+"</a></span>" + "</h2>" + "</div>" + "</header>");
        out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='/Assignment2_Test/IndexPageServlet'>Home</a></li>" + "<li>");
        out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Smart Phones</a></li>" + "<li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li>");
        out.println("<li><a href='/Assignment2_Test/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "</ul>");
        out.println("</nav>" + "</div>" + "<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
        out.println("<p>" + "<p>");
        out.println("<div id='content_product'>");
        out.println("<h4> Your Cart Items: </h4>");*/

       /* System.out.println("Before FOR Loop");
        for (int i = 0; i < cart_list.size(); i++) {
                //System.out.println(i);
                String var = cart_list.get(i);
                //System.out.println(var);

                if(!var.equals("%")){
                    
                    uniqlist.add(var);
                    //System.out.println(uniqlist);

                }

                else if(var.equals("%")){

                    for ( int j = 0; j < uniqlist.size(); j++) {
                        //System.out.println(j);
                   if(j ==0)
                   {
                    out.println("<p align='left'>Name:" + uniqlist.get(j));
                    out.println("<br/><br/>");
                   }
                   if(j ==1)
                   {
                    out.println("<p align='left'>Retailer:" + uniqlist.get(j) + "</p>");
                    out.println("<br/><br/>");
                   }
                   if(j ==2)
                   {
                    out.println("<p align='left'>Condittion:" + uniqlist.get(j)+ "</p>");
                    out.println("<br/><br/>");
                   }
                   if(j ==3)
                   {
                    out.println("<p align='left'>Price:" + uniqlist.get(j)+ "</p>");
                    temp_price = Integer.parseInt(uniqlist.get(j));
                    priceArray[j]=temp_price;
                    /*System.out.println("tempPrice"+temp_price);
                    System.out.println("totalPrice1st:"+total_price);
                    total_price = total_price + temp_price;
                    System.out.println("totalPrice2nd:"+total_price);
                    //price_list.add(uniqlist.get(j));
                    out.println("<br/><br/>");
                    
                   }
                   if(j ==4)
                   {
                    out.println("<p align='left'>ID:" + uniqlist.get(j)+ "</p>");
                    out.println("<br/><br/>");
                    out.println("<form action='/Assignment2_Test/DeleteCartServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='deleteFormId' value='"+uniqlist.get(j)+"' />" +"<span style='width:110px;display:inline-block'></span>"+
                        "<input type='submit' value='Delete From Cart' class='submit-button' style='width:200px;'>" +
                        "</form>");
                    out.println("<hr width='90%' size='2' align='center'>");
                   }

                }
                    uniqlist.clear();

                }

             
            }

            for (int i : priceArray)
            total_price += i;
            System.out.println("Total Price::"+total_price);

            
            out.println("</div>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul><li><a href='/Assignment2_Test/IndexPageServlet'>Home Page</a></li><li><a>Our Products</a><ul>");
            out.println("<li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment2_Test/TabletDisplayServlet'>Tablets</a></li><li><a href='/Assignment2_Test/SmartPhoneDisplayServlet'>Laptops</a></li>");
            out.println("<li><a href='/Assignment2_Test/TvDisplayServlet'>TV</a></li></ul></li></ul></li><li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you");
            out.println("</li></ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div>");
            out.println("<form action='/Assignment2_Test/PlaceOrderServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='totalprice' value='"+total_price+"' />" +
                        "<input style='float:center' type='submit' value='Place Order' class='submit-button' style='width:200px;'>" +
                        "</form>"); 
            out.println("<div id = 'footer'><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");
*/

                        
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