<%@ page import = "java.util.*,javax.servlet.*,java.io.*" %>

<%@page import="myAssignment3.*"%>
        
        <%
        HttpSession s=request.getSession();
    	String username=(String)s.getAttribute("userid");
        String username_cap = username.substring(0, 1).toUpperCase() + username.substring(1);

	    %>
            <html>
            <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
            </head>
            <body>
            <div id="container">
            <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="#">BEST <span>DEAL</span></a></h1>
            <h2>Your One Stop Shop  </h2>  <span style="width:110px;display:inline-block"></span>  <h2 style="float:right">Welcome  

            <%=username_cap %>!<a href="SignOutJsp.jsp">Sign <span>Out</span></a></h2>   </div>  </header>
            <div class="menu-wrap">  <nav class="menu">  <ul class="clearfix">   <li><a href="#">Home</a></li>  <li>
            <a href="#">Products</a>  <ul class="sub-menu">  <li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li>  <li><a href="TabletDisplayJsp.jsp">Tablets</a></li>
            <li><a href="LaptopDisplayJsp.jsp">Laptops</a></li>  <li><a href="TvDisplayJsp.jsp">TV</a></li>  </ul>  </li>  <li><a href="FindReviewsJsp.jsp">Trending</a></li>  </ul>
            </nav>  </div>  <img class="header-image" src="images/multiple_picture_wallpaper.jpg" alt="Buildings" />
        	<div id="body">  <section id="content"><article><h2>Welcome To <span1>Best</span1> <span2>Deal  </span2>  <span style="width:10px;display:inline-block"></span> <%=username_cap %> </h2>
            <p><span>We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you. Come along to experience how technology integrates into your life at <span1>Best</span1> <span2>Deal</span2> with extraordinary offers in every department.</span></p>
            <p><span>Our Built-for-work, ready-for-life Products:</span></p>
            <ul class="styledlist"><li><span1>Smart Phones</span1></li><li><span2>Tablets</span2></li><li><span1>Laptops</span1></li><li><span2>TV</span2></li>
            </ul></article></section>
            <aside class="sidebar"><ul><li><h4>Categories</h4><ul>
            <li><a href="#">Home Page</a></li><li><a>Our Products</a><ul><li><a href="SmartPhoneDisplayJsp.jsp">Smart Phones</a></li><li><a href="TabletDisplayJsp.jsp">Tablets</a></li><li><a href="LaptopDisplayJsp.jsp">Laptops</a></li><li><a href="TvDisplayJsp.jsp">TV</a></li></ul></li><li><a href="FindReviewsJsp.jsp">Trending</a></li></ul></li>
            <li><h4>About us</h4><ul><li class="text"><p style="margin: 0;">We are retailers of consumer electronics and entertainment software. Keeping you plugged into the world of technology, Expert Service and Unbeatable Price. We always strive for making technology work for you</li>
            </ul></li><li><h4>Search site</h4><ul><li class="text"><form method="get" class="searchform" action="#" ><p><input type="text" size="30" value="" name="s" class="s" /></p>
            </form></li></ul></li></ul></aside><div class="clear"></div></div><footer><div class="footer-bottom"><p>MAKING TECHNOLOGY WORK FOR YOU..!!</p></div></footer></div></body></html>
    	}
    }