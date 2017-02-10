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

public class DealMatches extends HttpServlet {

public List<Product> product_list_lap = new ArrayList<Product>();
public String key_nm = "Laptop";

	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        ServletContext sc=request.getSession().getServletContext();

        HttpSession s=request.getSession();
        String username=(String)s.getAttribute("userid");
        String username_cap = username.substring(0, 1).toUpperCase() + username.substring(1);

        HashMap<String,Product> productmap = new  HashMap<String,Product>();

        HashMap<String,Product> selectedproducts=new HashMap<String,Product>();

        String line=null;

        productmap=MySqlDataStoreUtilities.getAllProducts();

                               
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
            out.println("<title>SignIn : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
            out.println("<script type='text/javascript' src='javascript.js'></script>");
            // JavaScript Included Here...!!
            
            out.println("</head>");
            out.println("<body onload='init()''>");
            out.println("<div id='container'>");
            out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
            out.println("<h2>Your One Stop Shop" + "</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:right'>Welcome "+ username_cap +" !"+"<a href='/Assignment5/SignOutServlet'>Sign <span>Out</span></a></h2>" +  "</div>" + "</header>");
            out.println("<div class='menu-wrap'>" + "<nav class='menu'>" + "<ul class='clearfix'>" + " <li><a href='#'>Home</a></li>" + "<li>");
            out.println("<a href='#'>Products</a>" + "<ul class='sub-menu'>" + "<li><a href='/Assignment5/SmartPhoneDisplayServlet'>Smart Phones</a></li>" + "<li><a href='/Assignment5/TabletDisplayServlet'>Tablets</a></li>");
            out.println("<li><a href='/Assignment5/LaptopDisplayServlet'>Laptops</a></li>" + "<li><a href='/Assignment5/TvDisplayServlet'>TV</a></li>" + "</ul>" + "</li>" + "<li><a href='/Assignment5/FindReviewsServlet'>Trending</a></li>");
            out.println("</ul>");       
            out.println("</nav>");
            out.println("</div>");
            out.println("<div id='search_body'>");
            out.println("<form name='autofillform' action='autocomplete'><table><tbody>");
            out.println("<input type='text' size='30'  name='searchId' id='searchId' onkeyup='doCompletion()' style='font-size: 16px;' placeholder='Search Here...!!' />");
            out.println("<img src='images/Search.png' style='margin-top:10px;margin-left: 5px;'/>");    
            out.println("</td></tr><tr><td id='auto-row' colspan='2'><table id='complete-table' class='popupBox' /></td></tr></tbody></table></form>"); 
            out.println("</div>");
            out.println("<img class='header-image' src='images/multiple_picture_wallpaper.jpg' alt='Buildings' />");
            out.println("<p>" + "<p>");
            out.println("<div id='content_product'>");
            
            out.println("<h2>Welcome To <span>Best</span> <span>Deal" + "</span>" + "<span style='width:10px;display:inline-block'></span>" + username_cap + "</h2>");
            out.println("<p><span>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you. Come along to experience how technology integrates into your life at <span1>Best</span1> <span2>Deal</span2> with extraordinary offers in every department.</span></p>");
            out.println("<br>");
            out.println("<hr width='100%' size='2' align='center'>");
            out.println("<br>");
            out.println("<span><h3>Best Deals of the day...!!! We Gurantee Price Match</h3></span>");
            out.println("<hr width='100%' size='2' align='center'>");
               
                       
          

        for(Map.Entry<String, Product> entry : productmap.entrySet())
        {
            if(selectedproducts.size()<2 && !selectedproducts.containsKey(entry.getKey()))
            {
                BufferedReader reader = new BufferedReader(new FileReader (new File("C:\\apache-tomcat-7.0.34\\webapps\\Assignment5\\DealMatches.txt")));
                line=reader.readLine();
                if(line==null)
                { 
                    out.println("<h3 <span1>No Offers Found....!!!!</span1></h3>");       
                    break;
                }
                else
                { 
                    do {
                            if(line.contains(entry.getKey()))
                            {
                                //String[] details = line.split("(?=[:])");
                                /*String[] details = line.split("#");
                                String url = details[1];
                                String [] url1 = url.split("\\s+");
                                String orig = url1[1];
                               // String site = new String(orig);
                               // response.setStatus(response.SC_MOVED_TEMPORARILY);*/

                                out.println("<p><span>"+line+"</span></p>"); 
                                out.println("<br>");         
                                out.println("<br>");                      
                                System.out.println("SELECTED PRODUCTS_KEY::"+entry.getKey());
                                System.out.println("SELECTED PRODUCTS_VALUE::"+entry.getValue());
                                selectedproducts.put(entry.getKey(),entry.getValue());
                                break;
                            }
                        }while((line = reader.readLine()) != null);
                }
            }
       }

       out.println("<hr width='100%' size='2' align='center'>");
       for(Map.Entry<String, Product> entry : selectedproducts.entrySet())
        {
            Product p = entry.getValue();

		    out.println("<p align='left'>ID:" + p.id + "<p align='left'>Name:" + p.name + "</p>");
            out.println("<p align='left'>Retailer:" + p.retailer + "</p>");
            out.println("<p align='left'>Price:" + p.price + "</p>");
            out.println("<p align='left'><img src =" + p.image + "width = '200' height = '200' alt =" + p.name +"></p>");
            out.println("<form action='/Assignment5/AddToCartServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='productFormId' value='"+p.id+"' />" +
                        "<input type='submit' value='Add to Shopping Cart' class='submit-button' style='width:200px;'>" +
                        "</form>");  
            out.println("<form action='/Assignment5/WriteReviewsServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='productReviewId' value='"+p.id+"' />" +
                        "<input type='hidden' name='productReviewName' value='"+p.name+"' />" +
                        "<input type='hidden' name='productReviewRetailer' value='"+p.retailer+"' />" +
                        "<input type='hidden' name='productReviewCondition' value='"+p.condition+"' />" +
                        "<input type='hidden' name='productReviewPrice' value='"+p.price+"' />" +
                        "<input type='hidden' name='productReviewImage' value='"+p.image+"' />" +   
                        "<input type='submit' value='Write Reviews' class='submit-button' style='width:200px;'>" +
                        "</form>");
            out.println("<form action='/Assignment5/ReadReviewsServlet' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='productFormId' value='"+p.id+"' />" +
                        "<input type='hidden' name='productReadReviewName' value='"+p.name+"' />" +
                        "<input type='submit' value='Read Reviews' class='submit-button' style='width:200px;'>" +
                        "</form>");            
            out.println("<hr width='100%' size='2' align='center'>");
         

    } 
            out.println("</div>");
            out.println("<aside class='sidebar'><ul><li><h4>Categories</h4><ul>");
            out.println("<li><a href='#'>Home Page</a></li><li><a>Our Products</a><ul><li><a href='/Assignment5/SmartPhoneDisplayServlet'>Smart Phones</a></li><li><a href='/Assignment5/TabletDisplayServlet'>Tablets</a></li><li><a href='#'>Laptops</a></li><li><a href='/Assignment5/TvDisplayServlet'>TV</a></li></ul></li>"+"<li><a href='/Assignment5/FindReviewsServlet'>Trending</a></li></ul></li>");
            out.println("<li><h4>About us</h4><ul><li class='text'><p style='margin: 0;'>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you</li>");
            out.println("</ul></li><li><h4>Search site</h4><ul><li class='text'><form method='get' class='searchform' action='#' ><p><input type='text' size='30' value='' name='s' class='s' /></p>");
            out.println("</form></li></ul></li></ul></aside><div class='clear'></div></div><footer><div class='footer-bottom'><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>");
                                         
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