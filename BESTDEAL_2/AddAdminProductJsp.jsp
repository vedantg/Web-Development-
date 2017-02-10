<%@ page import ="java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

<%

List<Product> product_list = new ArrayList<Product>();
List<Product> product_list1 = new ArrayList<Product>();
List<Product> product_list2 = new ArrayList<Product>();
List<Product> product_list3 = new ArrayList<Product>();
HashMap<String, List<Product>> mapInFile;
List<Product> tv_list = new ArrayList<Product>();
List<Product> laptop_list = new ArrayList<Product>();
List<Product> sm_list = new ArrayList<Product>();
List<Product> tab_list = new ArrayList<Product>();
int flag;
String key="";

        Product p;
        Map<String, List<Product>> product=new HashMap<String, List<Product>>();
        session=request.getSession(); 
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
                                        
%>                                         


        <html>
        <head>
        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
        <title>Product Added : Best Deal</title>  <link rel='stylesheet' href='styles.css' type='text/css' />
        </head>
        <body>
        <div id='container'>
        <header>  <div class='header_logo'>  <img src='images/images_logo_new.jpg'/>  <h1><a href='#'>BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <h4>  <span style='width:310px;display:inline-block'></span>  Your Product Has Been Added  </h4>
        <span style='width:310px;display:inline-block'></span><a href='AdminPageJsp.jsp'>Click here to redirect</a>
        </head>
        </html>
                                              
