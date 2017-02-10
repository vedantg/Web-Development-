import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class UpdateAdminDesignProductServlet extends HttpServlet{

transient List<Product> product_list = new ArrayList<Product>();
transient List<Product> product_list1 = new ArrayList<Product>();
transient List<Product> product_list2 = new ArrayList<Product>();
transient List<Product> product_list3 = new ArrayList<Product>();
HashMap<String, List<Product>> mapInFile;
transient List<Product> tv_list = new ArrayList<Product>();
transient List<Product> laptop_list = new ArrayList<Product>();
transient List<Product> sm_list = new ArrayList<Product>();
transient List<Product> tab_list = new ArrayList<Product>();

String productcategory;
String productretailer;
String productid;
String productname;
String productcondition;
int productprice;
String firstLetter  = "";
//String productcategory;


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

                        
                                /*sc=request.getSession().getServletContext();    
                                File gameSpeedDataStore=new File(sc.getRealPath("MainDatabaseFile"));
                                //File tvDataStore=new File("C:\\apache-tomcat-7.0.34\\webapps\\Assignment2_Test\\MainDataStorage");
                                //out.println(gameSpeedDataStore);
                                FileInputStream fis=new FileInputStream(gameSpeedDataStore);
                                //out.println(fis);
                                ObjectInputStream ois=new ObjectInputStream(fis);
                                //out.println(ois);
                                mapInFile=(HashMap<String,List<Product>>)ois.readObject();*/
                                //System.out.println("In Update Servlet After Read");
                                String productupdateId =request.getParameter("productUpdateId");
                                System.out.println("Get The Required ID :"+ productupdateId);
                                firstLetter = String.valueOf(productupdateId.charAt(0));
                                System.out.println("Get The Required ID First Letter :"+ firstLetter);
                                

                                if(firstLetter.equals("L")){
                                    productcategory = "Laptop";
                                laptop_list = SaxParser4ProductXMLdataStore.m.get("Laptop");

                                for(Product iter : laptop_list)
                                {

                                    if(iter.getId().equals(productupdateId))
                                    {
                                        productid = iter.getId();
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                     
                                    } 
                                }

                                }

                                else if(firstLetter.equals("V")){
                                        productcategory = "TV";
                                    tv_list = SaxParser4ProductXMLdataStore.m.get("TV");

                                for(Product iter : tv_list)
                                {

                                    if(iter.getId().equals(productupdateId))
                                    {
                                        productid = iter.getId();
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                     
                                    } 
                                }

                                }

                                else if(firstLetter.equals("T")){
                                        productcategory = "Tablet";
                                    tab_list = SaxParser4ProductXMLdataStore.m.get("Tablet");

                                for(Product iter : tab_list)
                                {

                                    if(iter.getId().equals(productupdateId))
                                    {
                                        productid = iter.getId();
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                     
                                    } 
                                }

                                }

                                else if(firstLetter.equals("S")){
                                        productcategory = "SmartPhone";
                                    sm_list = SaxParser4ProductXMLdataStore.m.get("SmartPhone");

                                for(Product iter : sm_list)
                                {

                                    if(iter.getId().equals(productupdateId))
                                    {
                                        productid = iter.getId();
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                     
                                    } 
                                }
                                }

                                

                                


        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>Add Products : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='/Assignment2_Test/IndexPageServlet'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "<span style='width:110px;display:inline-block'></span>" + "<h2 style='float:center','font-size:900%'>Welcome "+ " !<a href='/Assignment2_Test/SignOutServlet'>Sign <span>Out</span></a></h2>" + "</div>" + "</header>");                                                    
        out.println("<form method='post' action='/Assignment2_Test/UpdateAdminProductServlet'><h3>Edit Products</h3><table cellpadding='2' cellspacing='1'>");
        //out.println("<tr><td>Category</td><td><select name='productCategory'><option value='"+productcategory+"'>TV</option><option value='Laptop'>Laptop</option></select></td></tr>");
        out.println("<tr><td>Category</td><td><input type='TEXT' readonly='true' size='15' value='"+productcategory+"' name='productCategory'></input></td></tr>");        
        //out.println("<option value='Tablet'>Tablet</option><option value='SmartPhone'>SmartPhone</option></select></td></tr>");
        out.println("<tr><td>Retailer</td><td><input type='TEXT' size='15' value='"+productretailer+"' name='productRetailer'></input></td></tr>");
        out.println("<tr><td>Product Id</td><td><input type='TEXT' readonly='true' size='15' value='"+productid+"' name='productId'></input></td></tr>");
        out.println("<tr><td>Product Name</td><td><input type='text' size='15' value='"+productname+"' name='productName'/></td></tr>");
        out.println("<tr><td>Condition</td><td><input type='TEXT' size='15' value='"+productcondition+"' name='productCondition'></input></td></tr>");
        out.println("<tr><td>Price</td><td><input type='TEXT' size='15' value='"+productprice+"' name='productPrice'></input></td></tr>");
        //out.println("<tr><td>Accessories</td><td><input type='TEXT' size='15' name='productAcc'></input></td></tr>");
        out.println("<tr><td colspan='2'><center><input type='submit' value='Edit Product' /></center></td></tr>");
        out.println("</table></form>");
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