<%@ page import = "java.util.*,javax.servlet.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*" %>

<%@page import="myAssignment3.*"%>

<%

List<Product> laptop_list; 
List<Product> tab_list; 
List<Product> sm_list;
List<Product> tv_list; 
HashMap<String, List<Product>> mapInFile ;
String key;
int flag;

        String productformid =request.getParameter("productFormId");
        
        int productsInCart = MySqlDataStoreUtilities.productsInCart();


        response.setContentType("text/html");
        //out= response.getWriter();
        //HashMap<String,String> mapInFile = new HashMap<String,String>();
        ServletContext sc=request.getSession().getServletContext();
        String user=((String)session.getAttribute("userid"));
        String username_cap = user.substring(0, 1).toUpperCase() + user.substring(1);
        laptop_list = new ArrayList<Product>();
        tab_list = new ArrayList<Product>();
        sm_list= new ArrayList<Product>();
        tv_list = new ArrayList<Product>();
        mapInFile = new HashMap<String,List<Product>>();        
        mapInFile = MySqlDataStoreUtilities.selectProducts(productformid);
        //SaxParser4ProductXMLdataStore.loadProducts();
%>       

        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="IndexPageJsp.jsp">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  <span style="width:110px;display:inline-block"></span>  <h2 style="float:right">Welcome  <%=username_cap %>  !<span style="width:110px;display:inline-block"><a href="#">CART: <%=productsInCart %> </a></span>  </h2>  </div>  </header>
        <div class="menu-wrap">  <nav class="menu">  <ul class="clearfix">   <li><a href="IndexPageJsp.jsp">Home</a></li>  <li>
        <a href="#">Products</a>  <ul class="sub-menu">  <li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li>  <li><a href="TabletDisplayJsp.jsp">Tablets</a></li>
        <li><a href="LaptopDisplayJsp.jsp">Laptops</a></li>  <li><a href="TvDisplayJsp.jsp">TV</a></li>  </ul>  </li>  <li><a href="FindReviewsJsp.jsp">Trending</a></li></ul>
        </nav>  </div>  <img class="header-image" src="images/multiple_picture_wallpaper.jpg" alt="Buildings" />
        <p>  <p>
        <div id="content_product">
        <h4> Your Cart Items: </h4>

                         <%
                                                       
                            for (Map.Entry<String, List<Product>> ee : mapInFile.entrySet()) 
                                {                   
                                    key = ee.getKey();
                                    if(key.equals("Laptop"))
                                    {
                                        laptop_list = ee.getValue();
                                        //Key:"key);
                                        //Laptop_List::"laptop_list);
                                        //break;
                                        for (Product p : laptop_list) {
                                            
                                        %>
                                            <p align="left">ID:<%=p.id %><p align="left">Name:<%=p.name %></p>
                                            <p align="left">Retailer:<%=p.retailer %></p>
                                            <p align="left"><img src = <%=p.image %>  width = "200" height = "200" alt =  <%=p.name %> ></p>
                                            <form action="DeleteCartJsp.jsp" method="get" style="margin-bottom:20px;">
                        <input type="hidden" name="deleteFormId" value="<%=p.id %>" />
                        <input type="submit" value="Delete From Cart" class="submit-button" style="width:200px;"> 
                        </form>
                        <%
                                         } 
                                    } 

                                    if(key.equals("TV"))
                                    {
                                        tv_list = ee.getValue();
                                        //Key:"key);
                                        //Laptop_List::"laptop_list);
                                        //break;
                                        for (Product p : tv_list) {
                                        %>
                                            <p align="left">ID:<%=p.id %><p align="left">Name:<%=p.name %></p>
                                            <p align="left">Retailer:<%=p.retailer %></p>
                                            <p align="left"><img src = <%=p.image %>  width = "200" height = "200" alt =  <%=p.name %> ></p>
                                            <form action="DeleteCartJsp.jsp" method="get" style="margin-bottom:20px;">
                        <input type="hidden" name="deleteFormId" value="<%=p.id %>" /> <span style="width:110px;display:inline-block"></span>
                        <input type="submit" value="Delete From Cart" class="submit-button" style="width:200px;"> 
                        </form>
                                <%
                                         } 
                                    }       

                                    if(key.equals("SmartPhone"))
                                    {
                                        sm_list = ee.getValue();
                                        //Key:"key);
                                        //Laptop_List::"laptop_list);
                                        //break;
                                        for (Product p : sm_list) {
            %>
            <p align="left">ID:<%=p.id %><p align="left">Name:<%=p.name %></p>
                                            <p align="left">Retailer:<%=p.retailer %></p>
                                            <p align="left"><img src = <%=p.image %>  width = "200" height = "200" alt =  <%=p.name %> ></p>
                                            <form action="DeleteCartJsp.jsp" method="get" style="margin-bottom:20px;">
                        <input type="hidden" name="deleteFormId" value="<%=p.id %>" /> <span style="width:110px;display:inline-block"></span>
                        <input type="submit" value="Delete From Cart" class="submit-button" style="width:200px;"> 
                        </form>
            <hr width="90%" size="2" align="center">
            <%
         } 
                                    }       


                                    if(key.equals("Tablet"))
                                    {
                                        tab_list = ee.getValue();
                                        //Key:"key);
                                        //Laptop_List::"laptop_list);
                                        //break;
                                        for (Product p : tab_list) {
            %>
            <p align="left">ID:<%=p.id %><p align="left">Name:<%=p.name %></p>
                                            <p align="left">Retailer:<%=p.retailer %></p>
                                            <p align="left"><img src = <%=p.image %>  width = "200" height = "200" alt =  <%=p.name %> ></p>
                                            <form action="DeleteCartJsp.jsp" method="get" style="margin-bottom:20px;">
                        <input type="hidden" name="deleteFormId" value="<%=p.id %>" /> <span style="width:110px;display:inline-block"></span>
                        <input type="submit" value="Delete From Cart" class="submit-button" style="width:200px;"> 
                        </form>          
            <hr width="90%" size="2" align="center">
            <%
         } 
                                    }       

                                }

             int total_price=MySqlDataStoreUtilities.priceCalculate();
            
              %>  
            <form action="PlaceOrderJsp.jsp" method="get" style="margin-bottom:20px;">
                        <input type="hidden" name="totalprice" value="<%=total_price%>" /> 
                        <input style="float:center" type="submit" value="Place Order" class="submit-button" style="width:200px;"> 
                        </form>                  
            </div>
            <aside class="sidebar"><ul><li><h4>Categories</h4><ul><li><a href="IndexPageJsp.jsp">Home Page</a></li><li><a>Our Products</a><ul>
            <li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li><li><a href="TabletDisplayJsp.jsp">Tablets</a></li><li><a href="SmartPhoneDisplayJsp.jsp">Laptops</a></li>
            <li><a href="TvDisplayJsp.jsp">TV</a></li></ul></li><li><a href="FindReviewsJsp.jsp">Trending</a></li></ul></li><li><h4>About us</h4><ul><li class="text"><p style="margin: 0;">We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you
            </li></ul></li><li><h4>Search site</h4><ul><li class="text"><form method="get" class="searchform" action="#" ><p><input type="text" size="30" value="" name="s" class="s" /></p>
            </form></li></ul></li></ul></aside><div class="clear"> 
            </div>                     
            </div>
            
            <div id = "footer"><footer><div class="footer-bottom"><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>
                           
                           
