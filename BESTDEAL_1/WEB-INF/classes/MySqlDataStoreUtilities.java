import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;



public class MySqlDataStoreUtilities
{
		public static Connection conn = null;
		public static HashMap<String, String> fetchdetails_signup = new HashMap<String,String>();
		public static HashMap<String, List<Product>> fetchdetails_review_prefetch = new HashMap<String,List<Product>>();
		public static HashMap<String, String> fetchdetails_history;
		public static HashMap<String, String> fetchdetails_sales; 
		public static List<OrderHistoryModel> salesProductDisplayList;
		public static HashMap<String, List<OrderHistoryModel>> fetchdetails_selectUpdatedOrderHistory = new HashMap<String, List<OrderHistoryModel>>();
		public static HashMap<String, List<OrderHistoryModel>> fetchdetails_selectUpdatedOrderSales = new HashMap<String, List<OrderHistoryModel>>();
		public static Product p = new Product();
		public static List<Product> review_list = new ArrayList<Product>();
		public static OrderHistoryModel o = new OrderHistoryModel();
		public static OrderHistoryModel o1 = new OrderHistoryModel();
		public static int sum;
		public static HashMap<String, List<Product>> fetchdetails_products = new HashMap<String,List<Product>>();
		public static HashMap<String, List<Product>> fetchdetails_products1 = new HashMap<String,List<Product>>();
		public static List<OrderHistoryModel> selectUpdatedOrderHistory_list;
		public static List<OrderHistoryModel> selectUpdatedOrderSales_list;
		public static List<Product> main_list = new ArrayList<Product>();
	    public static List<Product> tv_list = new ArrayList<Product>();
		public static List<Product> laptop_list = new ArrayList<Product>();
		public static List<Product> sm_list = new ArrayList<Product>();
		public static List<Product> tab_list = new ArrayList<Product>();

		/*public static List<Product> tv_list1 = new ArrayList<Product>();
		public static List<Product> laptop_list1= new ArrayList<Product>();
		public static List<Product> sm_list1= new ArrayList<Product>();
		public static List<Product> tab_list1= new ArrayList<Product>();*/
		public static List<Product> laptop_list1;
		public static int totalRow;

		public void getConnection()
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			}
			catch(Exception e)
			{}
		}


		public static void insertUser(String userid,String password,String email,String phone){

				try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
				String insertIntoCustomerRegisterQuery = "INSERT INTO SignUp(userid,password,email,phone) "+ "VALUES (?,?,?,?);";
				PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
				pst.setString(1,userid);
				pst.setString(2,password);
				pst.setString(3,email);
				pst.setString(4,phone);
				pst.execute();
				}
				catch(Exception e){}
		}


		public static void insertOrderHistory(String orderNumber,String firstName,String lastName,String productPrice,String address,String phoneNumber,String creditcard){

				try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
				System.out.println("IN order1::");
				String insertIntoCustomerRegisterQuery = "INSERT INTO orderhistory(orderId,firstName,lastName,price,address,phone,creditCard) "+ "VALUES (?,?,?,?,?,?,?);";
				System.out.println("IN order2::");
				PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
				System.out.println("IN order3::");
				pst.setString(1,orderNumber);
				pst.setString(2,firstName);
				pst.setString(3,lastName);
				pst.setString(4,productPrice);
				pst.setString(5,address);
				pst.setString(6,phoneNumber);
				pst.setString(7,creditcard);
				pst.execute();
				System.out.println("IN order4::");
				}
				catch(Exception e){}
		}



		public static HashMap<String, String> selectOrderHistory(){

			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			String selectIntoCustomerRegisterQuery = "SELECT orderId,price FROM orderhistory;";
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);

			fetchdetails_history = new HashMap<String,String>();
			while (rs.next()) {
			    // Get data at cursor

			    fetchdetails_history.put(rs.getString(1),rs.getString(2));
			}

			}
			catch(Exception e){}
			return fetchdetails_history;
		}




		public static HashMap<String, String> selectUser(){

			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			String selectIntoCustomerRegisterQuery = "SELECT userid,password FROM SignUp;";
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);

			while (rs.next()) {
			    // Get data at cursor
			    fetchdetails_signup.put(rs.getString(1),rs.getString(2));
			}

			}
			catch(Exception e){}
			return fetchdetails_signup;
		}


		public static void deleteProduct(String productId){

			try{
				System.out.println("The product id to be deleted is: "+productId);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			System.out.println("Here1");
			String selectIntoCustomerRegisterQuery = "DELETE FROM CartProducts WHERE p_id='"+productId+"';";
			System.out.println("Here2");
			Statement stmt = conn.createStatement();
			System.out.println("Here3"+stmt);
			int rs;
			rs = stmt.executeUpdate(selectIntoCustomerRegisterQuery);
			System.out.println("Here4"+rs);

		}
		catch(Exception e){}
		}

		public static void cancelProduct(String productId){

			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			System.out.println("Here1");
			String selectIntoCustomerRegisterQuery = "DELETE FROM orderhistory WHERE orderId='"+productId+"';";
			System.out.println("Here2");
			Statement stmt = conn.createStatement();
			System.out.println("Here3"+stmt);
			int rs;
			rs = stmt.executeUpdate(selectIntoCustomerRegisterQuery);
			System.out.println("Here4"+rs);

		}
		catch(Exception e){}
		}


		public static void updateOrder(String productId){

			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			System.out.println("Here1");
			String selectIntoCustomerRegisterQuery = "DELETE FROM orderhistory WHERE orderId='"+productId+"';";
			System.out.println("Here2");
			Statement stmt = conn.createStatement();
			System.out.println("Here3"+stmt);
			int rs;
			rs = stmt.executeUpdate(selectIntoCustomerRegisterQuery);
			System.out.println("Here4"+rs);

		}
		catch(Exception e){}
		}



		public static HashMap<String, List<OrderHistoryModel>> selectUpdatedOrderHistory(String productId){

			try{
				
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			String selectIntoCustomerRegisterQuery = "SELECT * FROM orderhistory WHERE orderId ='"+productId+"';";
			System.out.println(" selectUpdatedOrderHistory incoming data:"+selectIntoCustomerRegisterQuery);
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);
			
			selectUpdatedOrderHistory_list = new ArrayList<OrderHistoryModel>();
			while (rs.next()) {
			    // Get data at cursor
				//if(rs.getString(1).equals("Laptop")){
				
					o = new OrderHistoryModel();
					o.setOrderId(rs.getString(1));
					o.setFirstName(rs.getString(2));
					o.setLastName(rs.getString(3));
					o.setPrice(rs.getString(4));
					o.setAddress(rs.getString(5));
					o.setPhone(rs.getString(6));
					o.setCreditCard(rs.getString(7));
					
					selectUpdatedOrderHistory_list.add(o);
					fetchdetails_selectUpdatedOrderHistory.put(rs.getString(1),selectUpdatedOrderHistory_list);
				
			}
		}catch(Exception e){}
			return fetchdetails_selectUpdatedOrderHistory;
		

	}


	public static void updateSelectedOrderHistory(String orderId1,String firstName1,String lastName1,String price1,String address1,String phone1,String creditCard1){

			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			System.out.println(" updateSelectedOrderHistory Here1");
			String selectIntoCustomerRegisterQuery = "UPDATE orderhistory SET orderId='"+orderId1+"', firstName='"+firstName1+"', lastName='"+lastName1+"', price='"+price1+"',address='"+address1+"',phone='"+phone1+"',creditCard='"+creditCard1+"' WHERE orderId='"+orderId1+"';";
			System.out.println("updateSelectedOrderHistory Here2");
			Statement stmt = conn.createStatement();
			System.out.println("updateSelectedOrderHistory Here3"+stmt);
			int rs;
			rs = stmt.executeUpdate(selectIntoCustomerRegisterQuery);
			System.out.println("updateSelectedOrderHistory Here4"+rs);

		}
		catch(Exception e){}
		}


	/*update orderhistory set
orderId = '12324',
firstName = 'vedantg',
lastName = 'godg',
price = '321',
address = 'Chicago B',
phone = '1233',
creditCard = '1221312'
Where orderId = '12324';*/


		public static int priceCalculate(){

			try{
				
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			System.out.println("Here1");
			String selectIntoCustomerRegisterQuery = "SELECT SUM(p_price) FROM CartProducts;";
			System.out.println("Here2");
			Statement stmt = conn.createStatement();
			System.out.println("Here3"+stmt);
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);
			System.out.println("Here4"+rs);
			rs.next();
			sum=rs.getInt(1);
			System.out.println("The sum is: "+sum);


		}
		catch(Exception e){}
		return sum;
		}


	   public static void insertProducts(String key,String id,String name,String retailer,String condition,int price,String image){

				try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
				String insertIntoCustomerRegisterQuery = "INSERT INTO CartProducts(key_name,p_id,p_name,p_retailer,p_condition,p_price,p_image) "+ "VALUES (?,?,?,?,?,?,?);";
				PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
				pst.setString(1,key);
				pst.setString(2,id);
				pst.setString(3,name);
				pst.setString(4,retailer);
				pst.setString(5,condition);
				pst.setInt(6,price);
				pst.setString(7,image);
				pst.execute();
				}
				catch(Exception e){}
		}


		public static HashMap<String, List<Product>> selectProducts(String productId){

			try{
				System.out.println("id in database: "+productId);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			String selectIntoCustomerRegisterQuery = "SELECT * FROM CartProducts WHERE p_id='"+productId+"';";
			System.out.println("incoming data:"+selectIntoCustomerRegisterQuery);
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);
			System.out.println("ResultSet::"+rs);

			while (rs.next()) {
			    // Get data at cursor
				if(rs.getString(1).equals("Laptop")){
					p = new Laptop();
					p.setId(rs.getString(2));
					p.setName(rs.getString(3));
					p.setRetailer(rs.getString(4));
					p.setCondition(rs.getString(5));
					p.setPrice(rs.getInt(6));
					p.setImage(rs.getString(7));
					
					if(laptop_list.isEmpty())
					{
						laptop_list.add(p);
					}

					else{
					for(Product p1 : laptop_list)
					{
						if(!(p1.id).equals(rs.getString(2)))
						{
							laptop_list.add(p);
						}
						else{
							System.out.println("In ELSE Loop::"+rs.getString(2));
							break;
						}
					}
				}
					
					fetchdetails_products.put(rs.getString(1),laptop_list);
				}

				if(rs.getString(1).equals("Tablet")){
					p = new Tablet();
					p.setId(rs.getString(2));
					p.setName(rs.getString(3));
					p.setRetailer(rs.getString(4));
					p.setCondition(rs.getString(5));
					p.setPrice(rs.getInt(6));
					p.setImage(rs.getString(7));
					if(tab_list.isEmpty())
					{
						tab_list.add(p);
					}

					else{
					for(Product p1 : tab_list)
					{		
						if(!(p1.id).equals(rs.getString(2)))
						{
							tab_list.add(p);
						}
						else{
							System.out.println("In ELSE Loop::"+rs.getString(2));
							break;
						}
					}
				}

					fetchdetails_products.put(rs.getString(1),tab_list);
				}
				if(rs.getString(1).equals("SmartPhone")){
					p = new SmartPhone();
					p.setId(rs.getString(2));
					p.setName(rs.getString(3));
					p.setRetailer(rs.getString(4));
					p.setCondition(rs.getString(5));
					p.setPrice(rs.getInt(6));
					p.setImage(rs.getString(7));
					if(sm_list.isEmpty())
					{
						sm_list.add(p);

					}

					/*for (Product p : sm_list) {
					System.out.println(p.id);
					System.out.println(p.name);
					System.out.println(p.retailer);
					System.out.println(p.condition);
					System.out.println(p.price);
					System.out.println(p.image);


}*/
					else{
					for(Product p1 : sm_list)
					{
						System.out.println("In For Loop::");
						if(!(p1.id).equals(rs.getString(2)))
						{
							System.out.println("In IF Loop::");
							sm_list.add(p);
							break;
						}
						else{
							System.out.println("In ELSE Loop::"+rs.getString(2));
							break;
						}
					}
				}

					fetchdetails_products.put(rs.getString(1),sm_list);
				}
				if(rs.getString(1).equals("TV")){
					p = new TV();
					p.setId(rs.getString(2));
					p.setName(rs.getString(3));
					p.setRetailer(rs.getString(4));
					p.setCondition(rs.getString(5));
					p.setPrice(rs.getInt(6));
					p.setImage(rs.getString(7));
					if(tv_list.isEmpty())
					{
						tv_list.add(p);
					}

					else{
					for(Product p1 : tv_list)
					{
						if(!(p1.id).equals(rs.getString(2)))
						{
							tv_list.add(p);
						}
						else{
							System.out.println("In ELSE Loop::"+rs.getString(2));
							break;
						}
					}
				}
					fetchdetails_products.put(rs.getString(1),tv_list);
			    //fetchdetails_signup.put(rs.getString(1),rs.getString(2));
			}
		}

		}
			catch(Exception e){}
			return fetchdetails_products;
		

	}


	public static HashMap<String, List<Product>> selectUpdatedProducts(){

			try{
				
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			String selectIntoCustomerRegisterQuery = "SELECT * FROM CartProducts;";
			System.out.println("incoming data:"+selectIntoCustomerRegisterQuery);
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);
			
			laptop_list1 = new ArrayList<Product>();
			while (rs.next()) {
			    // Get data at cursor
				//if(rs.getString(1).equals("Laptop")){
				String keey="temp";
					p = new Product();
					p.setId(rs.getString(2));
					p.setName(rs.getString(3));
					p.setRetailer(rs.getString(4));
					p.setCondition(rs.getString(5));
					p.setPrice(rs.getInt(6));
					p.setImage(rs.getString(7));
					
					laptop_list1.add(p);
					fetchdetails_products1.put(keey,laptop_list1);
				
			}
		}catch(Exception e){}
			return fetchdetails_products1;
		

	}



	public static HashMap<String, List<Product>> selectReviewProduct(String productId){

			try{
				
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			String selectIntoCustomerRegisterQuery = "SELECT * FROM reviewtable WHERE p_id='"+productId+"';";
			System.out.println("incoming data:"+selectIntoCustomerRegisterQuery);
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);
			
			review_list = new ArrayList<Product>();
			while (rs.next()) {
			    // Get data at cursor
				//if(rs.getString(1).equals("Laptop")){
				String keey="temp";
					p = new Product();
					p.setId(rs.getString(2));
					p.setName(rs.getString(3));
					p.setRetailer(rs.getString(4));
					p.setCondition(rs.getString(5));
					p.setPrice(rs.getInt(6));
					p.setImage(rs.getString(7));
					
					review_list.add(p);
					fetchdetails_review_prefetch.put(keey,review_list);
				
			}
		}catch(Exception e){}
			return fetchdetails_review_prefetch;
		

	}

	public static int productsInCart(){

			try{
				
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("********");
			System.out.println("Im in cart1");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			System.out.println("Im in cart2");
			String selectIntoCountProductsInCart = "SELECT COUNT(*) FROM CartProducts;";
			System.out.println("Im in cart3");
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCountProductsInCart);
			System.out.println("Im in cart4");
			rs.next();
			totalRow=rs.getInt(1);
			System.out.println("Im in cart5");
			System.out.println("The total row are: "+totalRow);
			System.out.println("********");


		}
		catch(Exception e){}
		return totalRow;
		}


		public static HashMap<String, String> selectSalesOrder(){

			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			String selectIntoCustomerRegisterQuery = "SELECT orderId,price FROM orderhistory;";
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);

			fetchdetails_sales = new HashMap<String,String>();
			while (rs.next()) {
			    // Get data at cursor

			    fetchdetails_sales.put(rs.getString(1),rs.getString(2));
			}

			}
			catch(Exception e){}
			return fetchdetails_sales;
		}


		public static void cancelSalesProduct(String productId){

			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			System.out.println("Here1");
			String selectIntoCustomerRegisterQuery = "DELETE FROM orderhistory WHERE orderId='"+productId+"';";
			System.out.println("Here2");
			Statement stmt = conn.createStatement();
			System.out.println("Here3"+stmt);
			int rs;
			rs = stmt.executeUpdate(selectIntoCustomerRegisterQuery);
			System.out.println("Here4"+rs);

		}
		catch(Exception e){}
		}


		public static HashMap<String, List<OrderHistoryModel>> selectUpdatedOrderSales(String productId){

			try{
				
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			String selectIntoCustomerRegisterQuery = "SELECT * FROM orderhistory WHERE orderId ='"+productId+"';";
			System.out.println(" selectUpdatedOrderHistory incoming data:"+selectIntoCustomerRegisterQuery);
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(selectIntoCustomerRegisterQuery);
			
			selectUpdatedOrderSales_list = new ArrayList<OrderHistoryModel>();
			while (rs.next()) {
			    // Get data at cursor
				//if(rs.getString(1).equals("Laptop")){
				
					o1 = new OrderHistoryModel();
					o1.setOrderId(rs.getString(1));
					o1.setFirstName(rs.getString(2));
					o1.setLastName(rs.getString(3));
					o1.setPrice(rs.getString(4));
					o1.setAddress(rs.getString(5));
					o1.setPhone(rs.getString(6));
					o1.setCreditCard(rs.getString(7));
					
					selectUpdatedOrderSales_list.add(o1);
					fetchdetails_selectUpdatedOrderSales.put(rs.getString(1),selectUpdatedOrderSales_list);
				
			}
		}catch(Exception e){}
			return fetchdetails_selectUpdatedOrderSales;
		

	}


	public static void updateSelectedOrderSales(String orderId1,String firstName1,String lastName1,String price1,String address1,String phone1,String creditCard1){

			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
			System.out.println(" updateSelectedOrderHistory Here1");
			String selectIntoCustomerRegisterQuery = "UPDATE orderhistory SET orderId='"+orderId1+"', firstName='"+firstName1+"', lastName='"+lastName1+"', price='"+price1+"',address='"+address1+"',phone='"+phone1+"',creditCard='"+creditCard1+"' WHERE orderId='"+orderId1+"';";
			System.out.println("updateSelectedOrderHistory Here2");
			Statement stmt = conn.createStatement();
			System.out.println("updateSelectedOrderHistory Here3"+stmt);
			int rs;
			rs = stmt.executeUpdate(selectIntoCustomerRegisterQuery);
			System.out.println("updateSelectedOrderHistory Here4"+rs);

		}
		catch(Exception e){}
		}

}

