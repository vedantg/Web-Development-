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

public class DeleteCartServlet extends HttpServlet implements Serializable{

transient List<String> delete_cart_items = new ArrayList<String>();
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
String key;
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

/*public List<Product> getProducts(){
        return product_list;
    }*/

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
        String productformid =request.getParameter("deleteFormId");

                                
                                MySqlDataStoreUtilities.deleteProduct(productformid);

                                /*firstLetter = String.valueOf(productformid.charAt(0));
                                //System.out.println("Get The Required ID First Letter :"+ firstLetter);
                                

                                if(firstLetter.equals("L"))
                                {
                                    //productcategory = "Laptop";
                                laptop_list = mapInFile.get("Laptop");

                                for(Product iter : laptop_list)
                                {

                                    if(iter.getId().equals(productformid))
                                    {
                                        productid = iter.getId();
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                        //strproductprice = 

                                        
                                        delete_cart_items.add(productname);
                                        delete_cart_items.add(productretailer);
                                        delete_cart_items.add(productcondition);
                                        delete_cart_items.add(Integer.toString(productprice));
                                        delete_cart_items.add(productid);
                                        //delete_cart_items.add("%");
                                     
                                    } 
                                }

                            }

                            else if(firstLetter.equals("V"))
                                {
                                    //productcategory = "Laptop";
                                tv_list = mapInFile.get("TV");

                                for(Product iter : tv_list)
                                {

                                    if(iter.getId().equals(productformid))
                                    {
                                        productid = iter.getId();                                        
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                        
                                        
                                        delete_cart_items.add(productname);
                                        delete_cart_items.add(productretailer);
                                        delete_cart_items.add(productcondition);
                                        delete_cart_items.add(Integer.toString(productprice));
                                        delete_cart_items.add(productid);
                                        //delete_cart_items.add("%");
                                     
                                    } 
                                }

                            }

                            else if(firstLetter.equals("T"))
                                {
                                    //productcategory = "Laptop";
                                tab_list = mapInFile.get("Tablet");

                                for(Product iter : tab_list)
                                {

                                    if(iter.getId().equals(productformid))
                                    {
                                        productid = iter.getId();                                        
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                        
                                        delete_cart_items.add(productname);
                                        delete_cart_items.add(productretailer);
                                        delete_cart_items.add(productcondition);
                                        delete_cart_items.add(Integer.toString(productprice));
                                        delete_cart_items.add(productid);
                                        //delete_cart_items.add("%");
                                     
                                    } 
                                }

                            }


                            else if(firstLetter.equals("S"))
                                {
                                    //productcategory = "Laptop";
                                sm_list = mapInFile.get("SmartPhone");

                                for(Product iter : sm_list)
                                {

                                    if(iter.getId().equals(productformid))
                                    {
                                        productid = iter.getId();                                       
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                        
                                        
                                        delete_cart_items.add(productname);
                                        delete_cart_items.add(productretailer);
                                        delete_cart_items.add(productcondition);
                                        delete_cart_items.add(Integer.toString(productprice));
                                        delete_cart_items.add(productid);
                                        //delete_cart_items.add("%");
                                     
                                    } 
                                }

                            }

                    }catch(Exception e){  } */

                   /* m = new HashMap<String, List<String>>();
                    m.put(user,delete_cart_items);
                    //out.println("HashMap::"m);

                    /*for (int i = 0; i < delete_cart_items.size(); i++) {
                            String value = delete_cart_items.get(i);
                    System.out.println("Elements: " + value);*/
    

    /*try{
        //System.out.println("here");
        File tvDataStore=new File("C:\\apache-tomcat-7.0.34\\webapps\\Assignment2_Test\\DeleteCartProductsFile");
        //tvDataStore.createNewFile();
        //System.out.println("here1");
        FileOutputStream tvfos=new FileOutputStream(tvDataStore);
        //System.out.println("here2");
        ObjectOutputStream tvoos=new ObjectOutputStream(tvfos);    
        tvoos.writeObject(m);
        //System.out.println("here3");
        tvoos.flush();
        tvoos.close();
        tvfos.close();
    
    }catch(Exception e){
        System.out.println("Could NOT Write microsoft to writeTvDataStore ...");
        e.printStackTrace();
    }*/

        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Cart Delete : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<h4>" + "<span style='width:310px;display:inline-block'></span>" + "Your Cart Has Been Updated" + "</h4>");
        out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment2_Test/UpdatedCartProduct'>Click here to redirect</a>");
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