<%@ page import = "java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*" %>

<%@page import="myAssignment3.*"%>

<%
        session = request.getSession(true);
        String productformid =request.getParameter("productUpdateId");
        String orderId1 = request.getParameter("orderId1");
        String firstName1 = request.getParameter("firstName1");
        String lastName1 = request.getParameter("lastName1");
        String price1 = request.getParameter("price1");        
        String address1= request.getParameter("address1");
        String phone1 = request.getParameter("phone1");
        String creditCard1 = request.getParameter("creditCard1");

        
        MySqlDataStoreUtilities.updateSelectedOrderHistory(orderId1,firstName1,lastName1,price1,address1,phone1,creditCard1);
%>
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Update Order History : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="#">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <h4>  <span style="width:310px;display:inline-block"></span>  Your Order Has Been Updated Successfully  </h4>
        <span style="width:310px;display:inline-block"></span><a href="OrderHistoryJsp.jsp">Click here to redirect</a>
        </head>
        </html>
        
 