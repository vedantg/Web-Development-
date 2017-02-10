<%@ page import ="java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

<%

List<Product> tv_list = new ArrayList<Product>();
List<Product> laptop_list = new ArrayList<Product>();
List<Product> sm_list = new ArrayList<Product>();
List<Product> tab_list = new ArrayList<Product>();
String key;

        session=request.getSession(); 
        String user=((String)session.getAttribute("userid")); 


        String productcategory = request.getParameter("productCategory");
        String productretailer = request.getParameter("productRetailer");
        String productid = request.getParameter("productId");
        String productname = request.getParameter("productName");        
        String productcondition= request.getParameter("productCondition");
        String productprice = request.getParameter("productPrice");
        String productacc = request.getParameter("productAcc");

        MySqlDataStoreUtilities.updateAdminProduct(productid,productname,productretailer,productcondition,Integer.parseInt(productprice));


                                /*for (Map.Entry<String, List<Product>> ee : SaxParser4ProductXMLdataStore.m.entrySet()) 
                                {                   
                                                    
                                                    key = ee.getKey();     

                                                    if(key.equals("TV") && productcategory.equals("TV"))
                                                {
                                                    tv_list = ee.getValue(); 

                                                    for(Product iter : tv_list)
                                                    {

                                                        if(iter.getId().equals(productid))
                                                                {
                                                                    iter.setRetailer(productretailer);
                                                                    iter.setId(productid);
                                                                    iter.setName(productname);
                                                                    iter.setCondition(productcondition);
                                                                    iter.setPrice(Integer.parseInt(productprice));
                                                                    break;
                                                                } 
                                                      
                                                    }   

                                                }


                                                if(key.equals("Laptop") && productcategory.equals("Laptop"))
                                                {
                                                    laptop_list = ee.getValue(); 

                                                    for(Product iter : laptop_list)
                                                    {

                                                        if(iter.getId().equals(productid))
                                                                {
                                                                    iter.setRetailer(productretailer);
                                                                    iter.setId(productid);
                                                                    iter.setName(productname);
                                                                    iter.setCondition(productcondition);
                                                                    iter.setPrice(Integer.parseInt(productprice));
                                                                    break;
                                                                } 
                                                      
                                                    }   

                                                }

                                                


                                                if(key.equals("Tablet") && productcategory.equals("Tablet"))
                                                {
                                                    tab_list = ee.getValue(); 

                                                    for(Product iter : tab_list)
                                                    {

                                                        if(iter.getId().equals(productid))
                                                                {
                                                                    iter.setRetailer(productretailer);
                                                                    iter.setId(productid);
                                                                    iter.setName(productname);
                                                                    iter.setCondition(productcondition);
                                                                    iter.setPrice(Integer.parseInt(productprice));
                                                                    break;
                                                                } 
                                                      
                                                    }   


                                                }


                                                if(key.equals("SmartPhone") && productcategory.equals("SmartPhone"))
                                                {
                                                    sm_list = ee.getValue(); 

                                                    for(Product iter : sm_list)
                                                    {

                                                        if(iter.getId().equals(productid))
                                                                {
                                                                    iter.setRetailer(productretailer);
                                                                    iter.setId(productid);
                                                                    iter.setName(productname);
                                                                    iter.setCondition(productcondition);
                                                                    iter.setPrice(Integer.parseInt(productprice));
                                                                    break;
                                                                } 
                                                      
                                                    }   

                                                }
                                                    
                                            }*/
                                     
%>

                                        


        <html>
        <head>
        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
        <title>Product Update : Best Deal</title>  <link rel='stylesheet' href='styles.css' type='text/css' />
        </head>
        <body>
        <div id='container'>
        <header>  <div class='header_logo'>  <img src='images/images_logo_new.jpg'/>  <h1><a href='#'>BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <h4>  <span style='width:310px;display:inline-block'></span>  Your Product Has Been Updated  </h4>
        <span style='width:310px;display:inline-block'></span><a href='AdminPageJsp.jsp'>Click here to redirect</a>
        </head> 
        </html>
                                          
 