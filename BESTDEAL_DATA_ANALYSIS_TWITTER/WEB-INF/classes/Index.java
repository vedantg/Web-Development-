import java.io.PrintWriter;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Index extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    	System.out.println("HI IN INDEX::");
      	response.setContentType("text/html");
      	System.out.println("HI IN INDEX_1::");  
        MySqlDataStoreUtilities.truncateProducts();
        System.out.println("HI IN INDEX_2::");
        SaxParser4ProductXMLdataStore.loadProducts(); 
        System.out.println("HI IN INDEX_3::");
        response.sendRedirect("/Assignment5/HomeServlet");
      }  


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
} 
