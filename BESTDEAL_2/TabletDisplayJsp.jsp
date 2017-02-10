<%@ page import = "java.util.*,javax.servlet.*,java.io.*" %>

<%@page import="myAssignment3.*"%>

<%
List<Product> product_list_tab = new ArrayList<Product>();

HttpSession s=request.getSession();
String username=(String)s.getAttribute("userid");
String username_cap = username.substring(0, 1).toUpperCase() + username.substring(1);
String key;
int flag;
String key_nm = "Tablet";
product_list_tab = MySqlDataStoreUtilities.selectTablet(key_nm);
//product_list_tab = SaxParser4ProductXMLdataStore.m.get("Tablet");

%>
        
        
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="IndexPageJsp.jsp">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  <span style="width:110px;display:inline-block"></span>  <h2 style="float:right">Welcome  <%=username_cap %>  !<span style="width:110px;display:inline-block"><a href="#"></a></span> <a href="SignOutJsp.jsp">Sign <span>Out</span></a></h2>  </div>  </header>
        <div class="menu-wrap">  <nav class="menu">  <ul class="clearfix">   <li><a href="IndexPageJsp.jsp">Home</a></li>  <li>
        <a href="#">Products</a>  <ul class="sub-menu">  <li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li>  <li><a href="#">Tablets</a></li>  <li><a href="#"></a></li>
        <li><a href="LaptopDisplayJsp.jsp">Laptops</a></li>  <li><a href="TvDisplayJsp.jsp">TV</a></li>  </ul>  </li>  <li><a href="FindReviewsJsp.jsp">Trending</a></li> </ul>
        </nav>  </div>  <img class="header-image" src="images/multiple_picture_wallpaper.jpg" alt="Buildings" />
        <p>  <p>
        <div id="content_product">

        <%
        for (Product p : product_list_tab) {
        %>   
            <p align="left">ID:<%=p.id %><p align="left">Name:<%=p.name %></p>
            <p align="left">Retailer:<%=p.retailer %></p>
            <p align="left">Price:<%=p.price %></p>
            <p align="left"><img src =  <%=p.image %>  width = "200" height = "200" alt =  <%=p.name %> ></p>
            <form action="AddToCartJsp.jsp" method="get" style="margin-bottom:20px;">
                        <input type="hidden" name="productFormId" value="<%=p.id%>" /> 
                        <input type="submit" value="Add to Shopping Cart" class="submit-button" style="width:200px;"> 
                        </form>
            <form action="WriteReviewsJsp.jsp" method="get" style="margin-bottom:20px;">
                        <input type="hidden" name="productReviewId" value="<%=p.id%>" /> 
                        <input type="hidden" name="productReviewName" value="<%=p.name%>" /> 
                        <input type="hidden" name="productReviewRetailer" value="<%=p.retailer %>" /> 
                        <input type="hidden" name="productReviewCondition" value="<%=p.condition %>" /> 
                        <input type="hidden" name="productReviewPrice" value="<%=p.price %>" /> 
                        <input type="hidden" name="productReviewImage" value="<%=p.image %>" />     
                        <input type="submit" value="Write Reviews" class="submit-button" style="width:200px;"> 
                        </form>
            <form action="ReadReviewsJsp.jsp" method="get" style="margin-bottom:20px;">
                        <input type="hidden" name="productReadReviewId" value="<%=p.id%>" /> 
                        <input type="hidden" name="productReadReviewName" value="<%=p.name%>" /> 
                        <input type="submit" value="Read Reviews" class="submit-button" style="width:200px;"> 
                        </form>            
            <hr width="90%" size="2" align="center">
         <%   
         } 
         %>
         </div>
            <aside class="sidebar"><ul><li><h4>Categories</h4><ul>
            <li><a href="#">Home Page</a></li><li><a>Our Products</a><ul><li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li><li><a href="#">Tablets</a></li><li><a href="LaptopDisplayJsp.jsp">Laptops</a></li><li><a href="TvDisplayJsp.jsp">TV</a></li></ul></li><li><a href="FindReviewsJsp.jsp">Trending</a></li></ul></li>
            <li><h4>About us</h4><ul><li class="text"><p style="margin: 0;">We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you</li>
            </ul></li><li><h4>Search site</h4><ul><li class="text"><form method="get" class="searchform" action="#" ><p><input type="text" size="30" value="" name="s" class="s" /></p>
            </form></li></ul></li></ul></aside><div class="clear"></div></div><footer><div class="footer-bottom"><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>

