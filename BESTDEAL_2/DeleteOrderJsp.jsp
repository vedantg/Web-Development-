<%@ page import = "java.util.*,javax.servlet.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*" %>

<%@page import="myAssignment3.*"%>

<%
      session = request.getSession(true);
      HashMap<String,String> mapInFile = new HashMap<String,String>();

      String productformid =request.getParameter("productUpdateId");

      MySqlDataStoreUtilities.cancelProduct(productformid); 
%>
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Cart Delete : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="#">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <h4>  <span style="width:310px;display:inline-block"></span>  Your Order Has Been Canceled Suuccesfully  </h4>
        <span style="width:310px;display:inline-block"></span><a href="OrderHistoryJsp.jsp">Click here to redirect</a>
     