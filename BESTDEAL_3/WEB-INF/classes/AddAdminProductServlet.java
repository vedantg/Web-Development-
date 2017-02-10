import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AddAdminProductServlet extends HttpServlet implements Serializable{

transient List<Product> product_list = new ArrayList<Product>();
transient List<Product> product_list1 = new ArrayList<Product>();
transient List<Product> product_list2 = new ArrayList<Product>();
transient List<Product> product_list3 = new ArrayList<Product>();
HashMap<String, List<Product>> mapInFile;
transient List<Product> tv_list = new ArrayList<Product>();
transient List<Product> laptop_list = new ArrayList<Product>();
transient List<Product> sm_list = new ArrayList<Product>();
transient List<Product> tab_list = new ArrayList<Product>();

//List<Product> smart_list; */
transient HashMap<String, List<Product>> ee ;
String key;
int flag;
public ServletContext sc;


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


        String productcategory = request.getParameter("productCategory");
        String productretailer = request.getParameter("productRetailer");
        String productid = request.getParameter("productId");
        String productname = request.getParameter("productName");        
        String productcondition= request.getParameter("productCondition");
        String productprice = request.getParameter("productPrice");
        String productacc = request.getParameter("productAcc");
        String productimg = request.getParameter("productImg");

        if(productcategory.equals("TV"))
        {
            //System.InTvList");
            String key1 = "TV";
            p = new TV();

            p.setRetailer(productretailer);
            p.setId(productid);
            p.setName(productname);
            p.setCondition(productcondition);
            p.setPrice(Integer.parseInt(productprice));
            p.setImage(productimg);
            product_list.add(p);
            MySqlDataStoreUtilities.insertProductsInTable(key1,p.id,p.name,p.retailer,p.condition,p.price,p.image);
        }


        else if(productcategory.equals("Laptop"))
        {   
            String key2 = "Laptop";
            p = new Laptop();

            p.setRetailer(productretailer);
            p.setId(productid);
            p.setName(productname);
            p.setCondition(productcondition);
            p.setPrice(Integer.parseInt(productprice));
            p.setImage(productimg);
            product_list1.add(p);
            MySqlDataStoreUtilities.insertProductsInTable(key2,p.id,p.name,p.retailer,p.condition,p.price,p.image);
        }



        else if(productcategory.equals("Tablet"))
        {
            String key3 = "Tablet";
            p = new Tablet();

            p.setRetailer(productretailer);
            p.setId(productid);
            p.setName(productname);
            p.setCondition(productcondition);
            p.setPrice(Integer.parseInt(productprice));
            p.setImage(productimg);
            product_list2.add(p);
            MySqlDataStoreUtilities.insertProductsInTable(key3,p.id,p.name,p.retailer,p.condition,p.price,p.image);
        }



        else if(productcategory.equals("SmartPhone"))
        {
            String key4 = "SmartPhone";
            p = new SmartPhone();

            p.setRetailer(productretailer);
            p.setId(productid);
            p.setName(productname);
            p.setCondition(productcondition);
            p.setPrice(Integer.parseInt(productprice));
            p.setImage(productimg);
            product_list3.add(p);
            MySqlDataStoreUtilities.insertProductsInTable(key4,p.id,p.name,p.retailer,p.condition,p.price,p.image);
        } 



                                for (Map.Entry<String, List<Product>> ee : SaxParser4ProductXMLdataStore.m.entrySet()) 
                                {                   
                                                    
                                                    key = ee.getKey();
                                                    //System.Key:"+key);

                                                    if(key.equals("TV")){
                                                    //System.InTv");
                                                    tv_list = ee.getValue();                                                    
                                                    tv_list.addAll(product_list);
                                                    //System.OutTv");
                                                    
                                                    }
                                                    else if(key.equals("Laptop")){
                                                    //System.InLaptop");
                                                    laptop_list = ee.getValue();                                                    
                                                    laptop_list.addAll(product_list1);
                                                    //System.OutLap"); 
                                                    }

                                                    else if(key.equals("SmartPhone")){
                                                    //System.InSmartPhone");
                                                    sm_list = ee.getValue();                                                    
                                                    sm_list.addAll(product_list3);  
                                                   // System.OutSm");

                                                    }

                                                    else if(key.equals("Tablet")){
                                                   // System.InTablet");
                                                    tab_list = ee.getValue();                                                    
                                                    tab_list.addAll(product_list2);  
                                                   // System.OutTab");

                                                    }

                                            } 
                                      


        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Product Added : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<h4>" + "<span style='width:310px;display:inline-block'></span>" + "Your Product Has Been Added" + "</h4>");
        out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment4/AdminPageServlet'>Click here to redirect</a>");                                      
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