<%@ page import ="java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

<%
      session = request.getSession(true);
      String productformid =request.getParameter("productUpdateId");

      MySqlDataStoreUtilities.cancelSalesProduct(productformid); 
%>
        <html>
        <head>
        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
        <title>Sales Delete : Best Deal</title>  <link rel='stylesheet' href='styles.css' type='text/css' />
        </head>
        <body>
        <div id='container'>
        <header>  <div class='header_logo'>  <img src='images/images_logo_new.jpg'/>  <h1><a href='#'>BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <h4>  <span style='width:310px;display:inline-block'></span>  Order Has Been Canceled Suuccesfully  </h4>
        <span style='width:310px;display:inline-block'></span><a href='SalesPageJsp.jsp'>Click here to redirect</a>
