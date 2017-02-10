<%@ page import ="java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

<%
      session = request.getSession(true);
      HashMap<String,List<OrderHistoryModel>> mapInFile = new HashMap<String,List<OrderHistoryModel>>();
      String key;
      List<OrderHistoryModel> updatedOrderHistory_list = new ArrayList<OrderHistoryModel>();
 
      String productformid =request.getParameter("productUpdateId");
%>
      
        <html>
        <head>
        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
        <title>Add Products : Best Deal</title>  <link rel='stylesheet' href='styles.css' type='text/css' />
        </head>
        <body>
        <div id='container'>
        <header>  <div class='header_logo'>  <img src='images/images_logo_new.jpg'/>  <h1><a href='IndexPageJsp.jsp'>BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>
<%
      mapInFile = MySqlDataStoreUtilities.selectUpdatedOrderSales(productformid); 
                            
                            for (Map.Entry<String, List<OrderHistoryModel>> ee : mapInFile.entrySet()) 
                                {                   
                                      key = ee.getKey();
                                      if(key.equals(productformid))
                                    {
                                        updatedOrderHistory_list = ee.getValue();

                                        for (OrderHistoryModel o : updatedOrderHistory_list) {
%>
                                                                          
        <form method='post' action='SalesUpdateProduct.jsp'><h3>Edit Order</h3><table cellpadding='2' cellspacing='1'>
        <tr><td>OrderID</td><td><input type='TEXT' readonly='true' size='15' value='<%=o.orderId %>' name='orderId1'></input></td></tr>        
        <tr><td>First Name</td><td><input type='TEXT' size='15' value='<%=o.firstName%>' name='firstName1'></input></td></tr>
        <tr><td>Last Name</td><td><input type='TEXT' size='15' value='<%=o.lastName %>' name='lastName1'></input></td></tr>
        <tr><td>price</td><td><input type='text' size='15' value='<%=o.price %>' name='price1'/></td></tr>
        <tr><td>Address</td><td><input type='TEXT' size='15' value='<%=o.address %>' name='address1'></input></td></tr>
        <tr><td>Phone</td><td><input type='TEXT' size='15' value='<%=o.phone %>' name='phone1'></input></td></tr>
        <tr><td>Credit Card</td><td><input type='TEXT' size='15' value='<%=o.creditCard%>' name='creditCard1'></input></td></tr>
        <tr><td colspan='2'><center><input type='submit' value='Edit Order' /></center></td></tr>
        </table></form>
        <%
                                         } 
                                    }

                                  }
                            %>