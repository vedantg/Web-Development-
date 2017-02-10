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

public class AddToCartServlet extends HttpServlet implements Serializable{

transient List<String> cart_items = new ArrayList<String>();
/*transient List<Product> product_list1 = new ArrayList<Product>();
transient List<Product> product_list2 = new ArrayList<Product>();
transient List<Product> product_list3 = new ArrayList<Product>();*/
HashMap<String, List<Product>> mapInFile;
HashMap<String, List<String>> m;
transient List<Product> tv_list = new ArrayList<Product>();
transient List<Product> laptop_list = new ArrayList<Product>();
transient List<Product> sm_list = new ArrayList<Product>();
transient List<Product> tab_list = new ArrayList<Product>();

//List<Product> smart_list; */
transient HashMap<String, List<Product>> ee ;
String key_nm="";
int flag;
public ServletContext sc;
String firstLetter  = "";
    String productcategory= "" ;
        String productretailer= "" ;
        String productid = "";
        String productname= "" ;        
        String productcondition= "";
        int productprice = 0;
        String productacc= "";
        String strproductprice= "";
        String productimage= "";


protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException 
    {
        
        Product p;
        Map<String, List<Product>> product=new HashMap<String, List<Product>>();
        response.setContentType("text/html");
        //SaxParser4ProductXMLdataStore.loadProducts(); // loaded products
        PrintWriter out= response.getWriter();
        ServletContext sc=request.getSession().getServletContext();
        HttpSession session=request.getSession(); 
        String user=((String)session.getAttribute("userid"));

        //String productformid=request.getParameter("productFormId"); 

                                String productformid =request.getParameter("productFormId");
                                //System.out.println("Get The Required ID :"+ productformid);
                                firstLetter = String.valueOf(productformid.charAt(0));
                                //System.out.println("Get The Required ID First Letter :"+ firstLetter);

                                if(firstLetter.equals("L"))
                                {
                                    key_nm = "Laptop";
                                	laptop_list = MySqlDataStoreUtilities.selectLaptop(key_nm);

                                for(Product iter : laptop_list)
                                {

                                    if(iter.getId().equals(productformid))
                                    {
                                        productid = iter.getId();
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                        productimage = iter.getImage();
                                        MySqlDataStoreUtilities.insertProducts("Laptop",productid,productname,productretailer,productcondition,productprice,productimage);
                                     
                                    } 
                                }

                            }

                            else if(firstLetter.equals("V"))
                                {
                                    key_nm = "TV";
                                tv_list = MySqlDataStoreUtilities.selectTV(key_nm);  

                                for(Product iter : tv_list)
                                {

                                    if(iter.getId().equals(productformid))
                                    {
                                        productid = iter.getId();                                        
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                        productimage = iter.getImage();
                                        MySqlDataStoreUtilities.insertProducts("TV",productid,productname,productretailer,productcondition,productprice,productimage);
                                     
                                    } 
                                }

                            }

                            else if(firstLetter.equals("T"))
                                {
                                     key_nm = "Tablet";
                                tab_list =  MySqlDataStoreUtilities.selectTablet(key_nm); 

                                for(Product iter : tab_list)
                                {

                                    if(iter.getId().equals(productformid))
                                    {
                                        productid = iter.getId();                                        
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                        productimage = iter.getImage();
                                        MySqlDataStoreUtilities.insertProducts("Tablet",productid,productname,productretailer,productcondition,productprice,productimage);
                                     
                                    } 
                                }

                            }


                            else if(firstLetter.equals("S"))
                                {
                                    key_nm = "SmartPhone";
                                sm_list = MySqlDataStoreUtilities.selectSmartPhone(key_nm);

                                for(Product iter : sm_list)
                                {

                                    if(iter.getId().equals(productformid))
                                    {
                                        productid = iter.getId();                                       
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                        productimage = iter.getImage();
                                        MySqlDataStoreUtilities.insertProducts("SmartPhone",productid,productname,productretailer,productcondition,productprice,productimage);
                                     
                                    } 
                                }

                            }

        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Cart : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<h4>" + "<span style='width:310px;display:inline-block'></span>" + "Your Cart Has Been Updated" + "</h4>");
        //out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment4/CartProductDisplay'>Click here to redirect</a>");
        out.println("<form action='/Assignment4/CartProductDisplay' method='get' style='margin-bottom:20px;'>"+
                        "<input type='hidden' name='productFormId' value='"+productformid+"' />" +
                        "<input type='submit' value='click here to redirect' class='submit-button' style='width:200px;'>" +
                        "</form>");        
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