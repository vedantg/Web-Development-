<%@ page import ="java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

<%
      session = request.getSession(true);
      HashMap<String,String> mapInFile = new HashMap<String,String>();
      String orderStatus = "InProgress..!!";
	  mapInFile = MySqlDataStoreUtilities.selectSalesOrder();  
	  String orderId;
	  String price;
%>

		<html>
        <head>
        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
        <title>SignIn : Best Deal</title>  <link rel='stylesheet' href='styles.css' type='text/css' />
        </head>
        <body>
        <div id='container'>
        <header>  <div class='header_logo'>  <img src='images/images_logo_new.jpg'/>  <h1><a href='IndexPageJsp.jsp'>BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  <span style='width:110px;display:inline-block'></span>  <h2 style='float:center','font-size:900%'>Welcome <span style='width:70px;display:inline-block;float:right'></span> !  <a href='SignOutJsp.jsp'>Sign <span>Out</span></a></h2>  </div>  </header>
                                            
        <form method='post' action='SalesDeleteJsp.jsp'><p>Enter the Order ID which you want to Cancel</p>
        <input type='text' name='productUpdateId'><input type='submit' name='submit'></form>
        <hr width='90%' size='2' align='center'>        
        <form method='post' action='SalesUpdateDesignJsp.jsp'><p>Enter the Order ID which you want to Update</p>
        <input type='text' name='productUpdateId'><input type='submit' name='submit'></form>
        <hr width='90%' size='2' align='center'>

<%        
        for (Map.Entry<String, String> ee : mapInFile.entrySet()) 
          {
           
            orderId = ee.getKey();
            price = ee.getValue();
%>
            <p align='left'>Order ID: <%=orderId %>
            <p align='left'>Price:  <%=price %>
            <p align='left'>Order Status: <%=orderStatus %>
            <hr width='90%' size='2' align='center'>
<%
         } 
%>       
      </body>
      </html>
