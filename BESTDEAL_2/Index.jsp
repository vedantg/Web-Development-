
<%@ page import = "java.util.*,javax.servlet.*, java.util.HashMap,java.io.*" %>

<%@page import="myAssignment3.*"%>


        <% 
        MySqlDataStoreUtilities.truncateProducts();
        SaxParser4ProductXMLdataStore.loadProducts(); 
        response.sendRedirect("HomeJsp.jsp");
        %>