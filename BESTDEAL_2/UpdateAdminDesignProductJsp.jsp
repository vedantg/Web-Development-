<%@ page import ="java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

<%

List<Product> tv_list = new ArrayList<Product>();
List<Product> prod_list = new ArrayList<Product>();
List<Product> sm_list = new ArrayList<Product>();
List<Product> tab_list = new ArrayList<Product>();

String productcategory= "";
String productretailer= "";
String productid= "";
String productname= "";
String productcondition= "";
int productprice= 0;
String firstLetter = "";
String productupdateId = "";

        session=request.getSession(); 
        String user=((String)session.getAttribute("userid"));

                                System.out.println("Before Update::");
                                productupdateId =request.getParameter("productUpdateId");
                                System.out.println("Before Update::Product"+productupdateId);
                                firstLetter = String.valueOf(productupdateId.charAt(0));

                                prod_list = MySqlDataStoreUtilities.adminUpdateProduct(productupdateId);

                                System.out.println("Before Update::Product_List"+prod_list);

                                for(Product iter : prod_list)
                                {

                                    if(firstLetter.equals("L")){
                                        productcategory = "Laptop";
                                    }

                                    else if(firstLetter.equals("V")){
                                        productcategory = "TV";
                                    }

                                    else if(firstLetter.equals("T")){
                                        productcategory = "Tablet";
                                    }

                                    else if(firstLetter.equals("S")){
                                        productcategory = "SmartPhone";
                                    }

                                        productid = iter.getId();
                                        productname = iter.getName();
                                        productretailer = iter.getRetailer();
                                        productcondition = iter.getCondition();        
                                        productprice= iter.getPrice();
                                }

                                

 %>                               

                                


        <html>
        <head>
        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
        <title>Add Products : Best Deal</title>  <link rel='stylesheet' href='styles.css' type='text/css' />
        </head>
        <body>
        <div id='container'>
        <header>  <div class='header_logo'>  <img src='images/images_logo_new.jpg'/>  <h1><a href='IndexPageJsp.jsp'>BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  <span style='width:110px;display:inline-block'></span>  <h2 style='float:center','font-size:900%'>Welcome   !<a href='SignOutJsp.jsp'>Sign <span>Out</span></a></h2>  </div>  </header>                                                    
        <form method='post' action='UpdateAdminProductJsp.jsp'><h3>Edit Products</h3><table cellpadding='2' cellspacing='1'>
        <tr><td>Category</td><td><input type='TEXT' readonly='true' size='15' value='<%=productcategory%>' name='productCategory'></input></td></tr>        
        
        <tr><td>Retailer</td><td><input type='TEXT' size='15' value='<%=productretailer%>' name='productRetailer'></input></td></tr>
        <tr><td>Product Id</td><td><input type='TEXT' readonly='true' size='15' value='<%=productid%>' name='productId'></input></td></tr>
        <tr><td>Product Name</td><td><input type='text' size='15' value='<%=productname%>' name='productName'/></td></tr>
        <tr><td>Condition</td><td><input type='TEXT' size='15' value='<%=productcondition%>' name='productCondition'></input></td></tr>
        <tr><td>Price</td><td><input type='TEXT' size='15' value='<%=productprice%>' name='productPrice'></input></td></tr>
        
        <tr><td colspan='2'><center><input type='submit' value='Edit Product' /></center></td></tr>
        </table></form>
        </head>
        </html>
        
        