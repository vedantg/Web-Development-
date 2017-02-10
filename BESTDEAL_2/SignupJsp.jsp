<%@ page import = "java.util.*,javax.servlet.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*" %>

<%@page import="myAssignment3.*"%>

<%
	HashMap<String, List<SignUpDetails>> details = new HashMap<String, List<SignUpDetails>>();
    List<SignUpDetails> values = new ArrayList<SignUpDetails>();
    SignUpDetails s = new SignUpDetails();

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");	

        s.setUserid(userid);
        s.setPassword(password);
        s.setEmail(email);
        s.setPhone(phone);
        MySqlDataStoreUtilities.insertUser(userid,password,email,phone);
%>        
        
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
        </head>
        <body>
        <div id="container">
        <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="#">BEST <span>DEAL</span></a></h1>
        <h2>Your One Stop Shop</h2>  </div>  </header>
        <h4>  <span style="width:310px;display:inline-block"></span>  Thank you for registering with us  </h4>
        <span style="width:310px;display:inline-block"></span><a href="HomeJsp.jsp">Click here to login</a>







        