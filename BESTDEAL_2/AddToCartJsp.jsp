<%@ page import = "java.util.*,javax.servlet.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*" %>

<%@page import="myAssignment3.*"%>

<%
List<String> cart_items = new ArrayList<String>();
HashMap<String, List<Product>> mapInFile;
HashMap<String, List<String>> m;
List<Product> tv_list = new ArrayList<Product>();
List<Product> laptop_list = new ArrayList<Product>();
List<Product> sm_list = new ArrayList<Product>();
List<Product> tab_list = new ArrayList<Product>();

HashMap<String, List<Product>> ee ;
String key;
int flag;
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

Map<String, List<Product>> product=new HashMap<String, List<Product>>();
ServletContext sc=request.getSession().getServletContext();
HttpSession s=request.getSession();
String username=(String)s.getAttribute("userid");


                                String productformid =request.getParameter("productFormId");
                                //System.Get The Required ID :"+ productformid);
                                firstLetter = String.valueOf(productformid.charAt(0));
                                //System.Get The Required ID First Letter :"+ firstLetter);

                                if(firstLetter.equals("L"))
                                {
                                    //productcategory = "Laptop";
                                laptop_list = SaxParser4ProductXMLdataStore.m.get("Laptop");

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
                                    //productcategory = "Laptop";
                                tv_list = SaxParser4ProductXMLdataStore.m.get("TV");

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
                                    //productcategory = "Laptop";
                                tab_list = SaxParser4ProductXMLdataStore.m.get("Tablet");

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
                                    //productcategory = "Laptop";
                                sm_list = SaxParser4ProductXMLdataStore.m.get("SmartPhone");

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
                        %>
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Cart : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="#">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <h4>  <span style="width:310px;display:inline-block"></span>  Your Cart Has Been Updated  </h4>
        <form action="CartProductDisplay.jsp" method="get" style="margin-bottom:20px;">
                        <input type="hidden" name="productFormId" value="<%=productformid %>" /> 
                        <input type="submit" value="click here to redirect" class="submit-button" style="width:200px;"> 
                        </form></body></html>      
            
            
    

