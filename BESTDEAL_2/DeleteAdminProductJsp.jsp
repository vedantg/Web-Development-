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


        String productid = request.getParameter("productDeleteId");
        
         MySqlDataStoreUtilities.deleteAdminProduct(productid);
                                                        
                                        
%>

        <html>
        <head>
        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
        <title>Product Deleted : Best Deal</title>  <link rel='stylesheet' href='styles.css' type='text/css' />
        </head>
        <body>
        <div id='container'>
        <header>  <div class='header_logo'>  <img src='images/images_logo_new.jpg'/>  <h1><a href='#'>BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <h4>  <span style='width:310px;display:inline-block'></span>  Your Product Has Been Deleted  </h4>
        <span style='width:310px;display:inline-block'></span><a href='AdminPageJsp.jsp'>Click here to redirect</a>                                      
        