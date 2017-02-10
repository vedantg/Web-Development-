<%@ page import ="java.util.*,javax.Jsp.jsp.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*,java.text.*,com.mongodb.*,com.mongodb.BasicDBObject,com.mongodb.Mongo" %>

<%@page import="myAssignment3.*"%>

      
        <html>
        <head>
        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
        <title>Add Products : Best Deal</title>  <link rel='stylesheet' href='styles.css' type='text/css' />
        </head>
        <body>
        <div id='container'>
        <header>  <div class='header_logo'>  <img src='images/images_logo_new.jpg'/>  <h1><a href='AdminPageJsp.jsp'>BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  <span style='width:110px;display:inline-block'></span>  <h2 style='float:center','font-size:900%'>Welcome   !</h2>  </div>  </header>                                                    
        <form method='post' action='AddAdminProductJsp.jsp'><h3>Add Products</h3><table cellpadding='2' cellspacing='1'>
        <tr><td>Category</td><td><select name='productCategory'><option value='TV'>TV</option><option value='Laptop'>Laptop</option>
        <option value='Tablet'>Tablet</option><option value='SmartPhone'>SmartPhone</option></select></td></tr>
        <tr><td>Retailer</td><td><input type='TEXT' size='15' name='productRetailer'></input></td></tr>
        <tr><td>Product Id</td><td><input type='TEXT' size='15' name='productId' placeholder='Start with L/V/T/S###'></input></td></tr>
        <tr><td>Product Name</td><td><input type='text' size='15' name='productName'/></td></tr>
        <tr><td>Condition</td><td><input type='TEXT' size='15' name='productCondition'></input></td></tr>
        <tr><td>Price</td><td><input type='TEXT' size='15' name='productPrice'></input></td></tr>
        <tr><td>Accessories</td><td><input type='TEXT' size='15' name='productAcc'></input></td></tr>
        <tr><td>Set Image</td><td><input type='TEXT' size='20' name='productImg' placeholder='Set Path W/Single Quotes:images/Ur_image.jpg'></input></td></tr>
        <tr><td colspan='2'><center><input type='submit' value='Add Product' /></center></td></tr>
        </table></form>


