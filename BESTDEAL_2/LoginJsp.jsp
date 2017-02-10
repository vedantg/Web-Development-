
<%@ page import = "java.util.*,javax.servlet.*,java.io.*" %>

<%@page import="myAssignment3.*"%>

    <%
    HashMap<String,String> mapInFile = new HashMap<String,String>();
    String key;
    int flag=2;
   
    %>

        <%
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        if(userid != null && userid.length() != 0) {
            userid = userid.trim();
        } %>

        <%
        if(password != null && password.length() != 0) {
            password = password.trim();
        } %>

        <%
        if(userid != null && password != null) {

                if(userid.equals("admin")) {
                    
                        session=request.getSession(); 
                        session.setAttribute("userid",userid);  
                        response.sendRedirect("AdminPageJsp.jsp"); 

                } else if(userid.equals("sales")) {

                        session=request.getSession(); 
                        session.setAttribute("userid",userid);  
                        response.sendRedirect("SalesPageJsp.jsp");  
                    
                } 

                else {

                                mapInFile= MySqlDataStoreUtilities.selectUser();
                                                    
                                System.out.println(mapInFile);
                                for (Map.Entry<String, String> ee : mapInFile.entrySet()) 
                                {
                                        key = ee.getKey();
                                        System.out.println("Key:"+key);
                                        String values = ee.getValue();
                                        System.out.println("Value::"+values);
                                        if((userid.equals(key)) && (password.equals(values)))
                                            {                
                                                System.out.println("In IFFF");
                                                System.out.println("userid::"+userid);
                                                System.out.println("password::"+password);
                                                flag=1;  
                                                break;                                                                   
                                            }
                                        else
                                            {          
                                                 System.out.println("In ELSEEE");
                                                 flag=0;
                                            }  

                                }

                                if(flag==1)
                                 {
                                    session=request.getSession(); 
                                    session.setAttribute("userid",userid);  
                                    response.sendRedirect("IndexPageJsp.jsp");
                                 }

                                 if(flag==0)
                                 {  %>
                                    
                                    <html>
                                    <head>
                                    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
                                    <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
                                    </head>
                                    <body>
                                    <div id="container">
                                    <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="index.html">BEST <span>DEAL</span></a></h1>
                                    <h2>Your One Stop Shop</h2>  </div>  </header>
                                    <div id="body">  <section id="content">  <article>  <form method="post" action="LoginJsp.jsp">
                                    <h4>  Login Failure!  You must supply correct username and password  </h4>
                                    <table cellpadding="2" cellspacing="1">  <tr>   <td>User ID</td>  <td><input type="TEXT" size="15" name="userid"></input></td>  </tr>
                                    <tr>  <td>Password</td>  <td><input type="PASSWORD" size="15" name="password"/></td>  </tr>  <tr>  <td colspan="2">
                                    <center><input type="submit" value="Login" style="margin-right:100px;"/></center>  </td>  </tr>  </table>  </form>  <h5>Don"t have an account click- <a href="SignupDesignJsp.jsp">Sign Up</a></h5>
                                    </div> 
                                    <div class="clear"></div>  </div>  <footer>  <div class="footer-bottom">  <p>MAKING TECHNOLOGY WORK FOR YOU..!!</p>  </div>  </footer>  </div>  </body>  </html>  
                                 <%
                                 }
                        
                }

        }  
        else { %>

                                    <html>
                                    <head>
                                    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
                                    <title>SignIn : Best Deal</title>  <link rel="stylesheet" href="styles.css" type="text/css" />
                                    </head>
                                    <body>
                                    <div id="container">
                                    <header>  <div class="header_logo">  <img src="images/images_logo_new.jpg"/>  <h1><a href="index.html">BEST <span>DEAL</span></a></h1>
                                    <h2>Your One Stop Shop</h2>  </div>  </header>
                                    <div id="body">  <section id="content">  <article>  <form method="post" action="LoginJsp.jsp">
                                    <h4>  Login Failure!  You must supply a username and password  </h4>
                                    <table cellpadding="2" cellspacing="1">  <tr>   <td>User ID</td>  <td><input type="TEXT" size="15" name="userid"></input></td>  </tr>
                                    <tr>  <td>Password</td>  <td><input type="PASSWORD" size="15" name="password"/></td>  </tr>  <tr>  <td colspan="2">
                                    <center><input type="submit" value="Login" style="margin-right:100px;"/></center>  </td>  </tr>  </table>  </form>  <h5>Don"t have an account click- <a href="SignupDesignJsp.jsp">Sign Up</a></h5>
                                    </div> 
                                    <div class="clear"></div>  </div>  <footer>  <div class="footer-bottom">  <p>MAKING TECHNOLOGY WORK FOR YOU..!!</p>  </div>  </footer>  </div>  </body>  </html>
            <%
        } %>
    
    

   
