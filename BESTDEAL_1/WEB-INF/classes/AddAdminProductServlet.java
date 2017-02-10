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
            //System.out.println("InTvList");
            p = new TV();

            p.setRetailer(productretailer);
            p.setId(productid);
            p.setName(productname);
            p.setCondition(productcondition);
            p.setPrice(Integer.parseInt(productprice));
            p.setImage(productimg);
            product_list.add(p);
        }


        else if(productcategory.equals("Laptop"))
        {   
            //System.out.println("InLapList");
            p = new Laptop();

            p.setRetailer(productretailer);
            p.setId(productid);
            p.setName(productname);
            p.setCondition(productcondition);
            p.setPrice(Integer.parseInt(productprice));
            p.setImage(productimg);
            product_list1.add(p);
        }



        else if(productcategory.equals("Tablet"))
        {
            //System.out.println("InTabList");
            p = new Tablet();

            p.setRetailer(productretailer);
            p.setId(productid);
            p.setName(productname);
            p.setCondition(productcondition);
            p.setPrice(Integer.parseInt(productprice));
            p.setImage(productimg);
            product_list2.add(p);
        }



        else if(productcategory.equals("SmartPhone"))
        {
           //System.out.println("InSmList");
            p = new SmartPhone();

            p.setRetailer(productretailer);
            p.setId(productid);
            p.setName(productname);
            p.setCondition(productcondition);
            p.setPrice(Integer.parseInt(productprice));
            p.setImage(productimg);
            product_list3.add(p);
        } 

                            /*try{
                                sc=request.getSession().getServletContext();    
                                File gameSpeedDataStore=new File(sc.getRealPath("MainDatabaseFile"));
                                //File tvDataStore=new File("C:\\apache-tomcat-7.0.34\\webapps\\Assignment2_Test\\MainDataStorage");
                                //out.println(gameSpeedDataStore);
                                FileInputStream fis=new FileInputStream(gameSpeedDataStore);
                                //out.println(fis);
                                ObjectInputStream ois=new ObjectInputStream(fis);
                                //out.println(ois);
                                mapInFile=(HashMap<String,List<Product>>)ois.readObject();
                                //out.println(mapInFile);
                                ois.close();
                                fis.close();*/

                                for (Map.Entry<String, List<Product>> ee : SaxParser4ProductXMLdataStore.m.entrySet()) 
                                {                   
                                                    
                                                    key = ee.getKey();
                                                    //System.out.println("Key:"+key);

                                                    if(key.equals("TV")){
                                                    //System.out.println("InTv");
                                                    tv_list = ee.getValue();                                                    
                                                    tv_list.addAll(product_list);
                                                    //System.out.println("OutTv");
                                                    
                                                    }
                                                    else if(key.equals("Laptop")){
                                                    //System.out.println("InLaptop");
                                                    laptop_list = ee.getValue();                                                    
                                                    laptop_list.addAll(product_list1);
                                                    //System.out.println("OutLap"); 
                                                    }

                                                    else if(key.equals("SmartPhone")){
                                                    //System.out.println("InSmartPhone");
                                                    sm_list = ee.getValue();                                                    
                                                    sm_list.addAll(product_list3);  
                                                   // System.out.println("OutSm");

                                                    }

                                                    else if(key.equals("Tablet")){
                                                   // System.out.println("InTablet");
                                                    tab_list = ee.getValue();                                                    
                                                    tab_list.addAll(product_list2);  
                                                   // System.out.println("OutTab");

                                                    }

                                            }
                                        


                                        /*try{
        //System.out.println("here");
        File tvDataStore=new File("C:\\apache-tomcat-7.0.34\\webapps\\Assignment2_Test\\MainDatabaseFile");
        //tvDataStore.createNewFile();
        //System.out.println("here1");
        FileOutputStream tvfos=new FileOutputStream(tvDataStore);
        //System.out.println("here2");
        ObjectOutputStream tvoos=new ObjectOutputStream(tvfos);    
        tvoos.writeObject(mapInFile);
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
        out.println("<title>Product Added : Best Deal</title>" + "<link rel='stylesheet' href='styles.css' type='text/css' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='container'>");
        out.println("<header>" + "<div class='header_logo'>" + "<img src='images/images_logo_new.jpg'/>" + "<h1><a href='#'>BEST <span>DEAL</span></a></h1>");
        out.println("<h2>Your One Stop Shop</h2>" + "</div>" + "</header>");
        out.println("<h4>" + "<span style='width:310px;display:inline-block'></span>" + "Your Product Has Been Added" + "</h4>");
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