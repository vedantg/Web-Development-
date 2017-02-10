<%@ page import = "java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

<%
List<Product> product_list = new ArrayList<Product>();
HashMap<String,List<Product>> mapInFile = new HashMap<String,List<Product>>();
mapInFile = MySqlDataStoreUtilities.selectAdminProducts();
String key;
int flag;

%>

<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
<title>SignIn : Best Deal</title>  <link rel='stylesheet' href='styles.css' type='text/css' />
</head>
<body>
<div id='container'>
<header>  <div class='header_logo'>  <img src='images/images_logo_new.jpg'/>  <h1><a href='#'>BEST <span>DEAL</span></a></h1>
<h2>Your One Stop Shop</h2>  <span style='width:110px;display:inline-block'></span>  <h2 style='float:center','font-size:900%'>Welcome <span style='width:70px;display:inline-block;float:right'></span> !  <a href='SignOutJsp.jsp'>Sign <span>Out</span></a></h2>  </div>  </header>
<table><tr><th>Product Id</th><th>Product Name</th><th>Product Retailer</th><th>Product Condition</th>
<th>Price</th></tr>

<%                                                   

                                for (Map.Entry<String, List<Product>> ee : mapInFile.entrySet()) 
                                {
                                                    product_list = ee.getValue();

                                                    for (Product p : product_list) {
                                                    out.println("<tr>");
                                                    out.println("<td>"+p.id+"</td>");
                                                    out.println("<td>"+p.name+"</td>");
                                                    out.println("<td>"+p.retailer+"</td>");
                                                    out.println("<td>"+p.condition+"</td>");
                                                    out.println("<td>"+p.price+"</td>");
                                                    out.println("</tr>");
                                                }
                                            }
%>
                                        
         <td><a href='AddAdminProductDesignJsp.jsp'><b>Add Product </b></a></td>
         </tr>
         <a href='DataAnalyticsDesignJsp.jsp'>Data<span>Analytics</span></a>
         <form method='post' action='UpdateAdminDesignProductJsp.jsp'><p>Enter the Product ID which you want to update</p>
         <input type='text' name='productUpdateId'><input type='submit' name='submit'></form>
         <form method='post' action='DeleteAdminProductJsp.jsp'><p>Enter the Product ID which you want to delete</p>
         <input type='text' name='productDeleteId'><input type='submit' name='submit'></form> 
         </body>
         </head>
         </html>
              
 