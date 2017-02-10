<%@ page import = "java.util.*,javax.servlet.*,java.io.*,org.xml.sax.*,javax.xml.parsers.*" %>

<%@page import="myAssignment3.*"%> 

<%              
            session=request.getSession();  
            session.invalidate();  
            out.print("Thank You, Visit Again..!!");  
            response.sendRedirect("HomeJsp.jsp"); 
%> 