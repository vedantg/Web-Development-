import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Iterator;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nbuser
 */
public class AutoSearchServlet extends HttpServlet {

    private ServletContext context;
    public HashMap<String, List<Product>> composers = new HashMap<String, List<Product>>();
    public List<Product> composers_list = new ArrayList<Product>();
    public HashMap<String, List<Product>> ee ;


    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException 
    { 
                System.out.println("CALL GOT FROM JS:::::::");
                StringBuffer sb = new StringBuffer();
                String searchId = request.getParameter("searchId");
                System.out.println("CALL GOT FROM JS:::::::ID-->"+searchId);
                String action = request.getParameter("action");
                System.out.println("CALL GOT FROM JS:::::::ACTION-->"+action);
                //HashMap<String,Product> data = new HashMap<String,Product>();
                //data=MySqlDataStoreUtilities.selectAllProducts();

                AjaxUtility a=new AjaxUtility();

                boolean namesAdded = false;

                if (searchId != null) {
                    searchId = searchId.trim().toLowerCase();
                } else {
                    context.getRequestDispatcher("/error.jsp").forward(request, response);
                }
                
                if (action.equals("complete"))
                {
                        if (!searchId.equals(""))
                            { 
                                
                                sb=a.readdata(searchId);
                                    if(sb!=null || !sb.equals(""))
                                        {
                                        namesAdded=true;
                                        }
                                if (namesAdded)
                                {
                                System.out.println("Send UTILITYs Servlet:::-->"+sb);
                                response.setContentType("text/xml");
                                response.setHeader("Cache-Control", "no-cache");
                                response.getWriter().write("<products>" + sb.toString() + "</products>");

                                }
                                else {
                                    //nothing to show
                                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                                }
                            }
                }

                if (action.equals("lookup")) {

                    System.out.println("IN LOOKUP_1");

            // put the target composer in the request scope to display 
            if ((searchId != null)) {

                System.out.println("IN LOOKUP_2");
                response.sendRedirect("/Assignment5/ResultProdPage?prodid="+searchId);
            }
        /*composers = MySqlDataStoreUtilities.selectAllProducts();
            
            
        String action = request.getParameter("action");
        
        StringBuffer sb = new StringBuffer();

        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        boolean namesAdded = false;


        if (action.equals("complete")) {

            // check if user sent empty string
            if (!targetId.equals("")) 
            {


                       for (Map.Entry<String, List<Product>> ee : composers.entrySet()) 
                    {
                                        composers_list = ee.getValue();

                                        for (Product p : composers_list) 
                                {

                                            String prod_name = p.name;

                                        if (prod_name.toLowerCase().equals(targetId))
                                    {
                                        sb.append("<composer>");
                                        sb.append("<id>" + p.id + "</id>");
                                        sb.append("<ProductName>" + prod_name + "</ProductName>");                                      
                                        sb.append("</composer>");
                                        namesAdded = true;
                                    }

                                }
                    }
            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<composers>" + sb.toString() + "</composers>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }

        if (action.equals("lookup")) {

            // put the target composer in the request scope to display 
            if ((targetId != null) && composers.containsKey(targetId.trim())) {
                response.sendRedirect("/Assignment5/SearchProductServlet?prodid="+targetId);
            }
        }*/
    }
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
