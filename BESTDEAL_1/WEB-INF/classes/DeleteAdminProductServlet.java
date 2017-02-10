import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DeleteAdminProductServlet extends HttpServlet implements Serializable{

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

public List<Product> getProducts(){
        return product_list;
    }

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


        String productid = request.getParameter("productDeleteId");
        

                                for (Map.Entry<String, List<Product>> ee : SaxParser4ProductXMLdataStore.m.entrySet()) 
                                {                   
                                                    
                                                    key = ee.getKey();     

                                                    if(key.equals("TV"))
                                                {
                                                    tv_list = ee.getValue(); 

                                                    for(Product iter : tv_list)
                                                    {

                                                        if(iter.getId().equals(productid))
                                                                {
                                                                   tv_list.remove(iter);
                                                                    break;
                                                                } 
                                                      
                                                    }   

                                                }


                                                if(key.equals("Laptop"))
                                                {
                                                    laptop_list = ee.getValue(); 

                                                    for(Product iter : laptop_list)
                                                    {

                                                        if(iter.getId().equals(productid))
                                                                {
                                                                    laptop_list.remove(iter);
                                                                    break;
                                                                } 
                                                      
                                                    }   

                                                }


                                                if(key.equals("Tablet"))
                                                {
                                                    tab_list = ee.getValue(); 

                                                    for(Product iter : tab_list)
                                                    {

                                                        if(iter.getId().equals(productid))
                                                                {
                                                                    tab_list.remove(iter);
                                                                    break;
                                                                } 
                                                      
                                                    }   


                                                }


                                                if(key.equals("SmartPhone"))
                                                {
                                                    sm_list = ee.getValue(); 

                                                    for(Product iter : sm_list)
                                                    {

                                                        if(iter.getId().equals(productid))
                                                                {
                                                                   sm_list.remove(iter);
                                                                    break;
                                                                } 
                                                      
                                                    }   

                                                }
                                                   
                                            }                                 
                                        


        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Product Deleted : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<h4>" + "<span style='width:310px;display:inline-block'></span>" + "Your Product Has Been Deleted" + "</h4>");
        out.println("<span style='width:310px;display:inline-block'></span>"+"<a href='/Assignment2_Test/AdminPageServlet'>Click here to redirect</a>");                                      
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