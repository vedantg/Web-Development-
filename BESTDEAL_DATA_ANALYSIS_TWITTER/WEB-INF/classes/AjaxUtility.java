import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;



public class AjaxUtility implements Serializable{


	public  Connection conn = null;
		public  PreparedStatement pst;
		public  ResultSet rs;
		public  Statement stmt;
	HashMap<String,Product> data;
	HashMap<String,Product> selectAllProducts_hash;
	StringBuffer sb = new StringBuffer();




public HashMap<String,Product> getData(){

			try{
				
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			String selectIntoCustomerRegisterQuery = "SELECT * FROM ProductsTab;";
			System.out.println(" selectUpdatedOrderHistory incoming data:"+selectIntoCustomerRegisterQuery);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);

			//System.out.println("RESULT:::"+rs);
			
			selectAllProducts_hash = new HashMap<String,Product>();
			//selectAllProducts_list = new ArrayList<Product>();
			
			while (rs.next()) {

					//System.out.println("ID:::"+rs.getString(2));
					//System.out.println("NAME:::"+rs.getString(3));

					Product p = new Product(rs.getString(2), rs.getString(3));
					
					/*p = new Product();
					p.setId(rs.getString(2));
					p.setName(rs.getString(3));
							
					selectAllProducts_list.add(p);*/
					selectAllProducts_hash.put(rs.getString(2),p);
						
			}
		}catch(Exception e){}

		finally {
			try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { stmt.close(); } catch (Exception e) { /* ignored */ }
		    try { conn.close(); } catch (Exception e) { /* ignored */ }
			}

			return selectAllProducts_hash;
		

	}


public StringBuffer readdata(String searchId)
{

 data = new HashMap<String,Product>();

data=getData();

 /*for (Map.Entry<String,Product> ee : data.entrySet()) {

 	System.out.println("KEY::"+ee.getKey());
 	System.out.println("Value::"+ee.getValue());
 }*/

Iterator it = data.entrySet().iterator();
while (it.hasNext())
{
Map.Entry pi = (Map.Entry)it.next();
Product p=(Product)pi.getValue();

//System.out.println("Product p::"+p);
//System.out.println("p.getName()::"+p.getName());
//System.out.println("searchId::"+searchId);

if (p.getName().toLowerCase().contains(searchId))
{
System.out.println("IN IFF::");
System.out.println("p.getName()::"+p.getName());
System.out.println(" p.getId()::"+ p.getId());
sb.append("<product>");
sb.append("<id>" + p.getId() + "</id>");
sb.append("<productName>" + p.getName() + "</productName>");
sb.append("</product>");
}
}
//System.out.println("Send To Servlet:::-->"+sb);
return sb;
}
}
