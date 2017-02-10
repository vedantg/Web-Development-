import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
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
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.AggregationOutput;
import com.mongodb.client.AggregateIterable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class MongoDBDataStoreUtilities {
	
	private static final long serialVersionUID = 1L;
	
	public static MongoClient mongo;
	public static DB db;
	public static DBCollection myReviews ;
	public static DBCursor cursor;
	public static AggregationOutput aggregate;
	public static DBObject match = null;
	public static DBObject groupFields = null;
	public static DBObject group = null;
	public static DBObject projectFields = null;
	public static DBObject project = null;
	public static DBObject sort=null;


	public static DBCollection createMongoDB(){

		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("bestdealmongodb");
		myReviews = db.getCollection("myReviews");
		return myReviews;
	}
	

	public static DBCursor fetchReviewMongoDB(String productID){

		DBObject searchQuery = new BasicDBObject();
		System.out.println("ID:::"+productID);
		searchQuery.put("productID", productID);
		DBCursor cursor = myReviews.find(searchQuery);
		//curs = coll.find(query, fields);
		

		System.out.println("IN fetchReviewMongoDB::");
		System.out.println("IN fetchReviewMongoDB cursor::"+cursor.count());
		return cursor;
	}


	public static DBCursor topMostLiked(DBCollection collection){
	 //List<String> listUnique=new ArrayList<String>();
    BasicDBObject getQuery = new BasicDBObject();
    getQuery.put("reviewRating", new BasicDBObject("$gt", 4).append("$lt", 6));
    DBCursor cursor = collection.find(getQuery);

	return cursor;
	}
	


	public static HashMap<String, Integer> topZipCodes()
	{
		HashMap<String, Integer> reviewHashmap1=new HashMap<String, Integer>();
		
		
		DBObject groupFields1 = new BasicDBObject("_id", 0);
		groupFields1.put("_id", "$retailerzip");
		groupFields1.put("count", new BasicDBObject("$sum", 1));
		DBObject group1 = new BasicDBObject("$group", groupFields1);

		DBObject projectFields1 = new BasicDBObject("_id", 0);
		projectFields1.put("retailerZip", "$_id");
		projectFields1.put("reviewCount", "$count");
		DBObject project1 = new BasicDBObject("$project", projectFields1);

		

		DBObject limit1=new BasicDBObject();
		DBObject orderby1=new BasicDBObject();
		
		DBObject sort1 = new BasicDBObject();
		// Specify the field that you want to sort on, and the direction of the sort
		sort1.put("reviewCount",-1);
		
		
		//Adding sort object in DbObject
		orderby1=new BasicDBObject("$sort",sort1);
		limit1=new BasicDBObject("$limit",5);
		
		AggregationOutput aggregate1 = myReviews.aggregate(group1, project1, orderby1, limit1);
		
		String reviewCount1= null;
		int reviewCountCount1;
		for (DBObject result1 : aggregate1.results()) {
			BasicDBObject bobj1 = (BasicDBObject) result1;
			System.out.println("*****************************");
			System.out.println(bobj1.getString("retailerZip"));
			reviewCount1 = bobj1.getString("reviewCount");
			if(reviewCount1 == null || reviewCount1.isEmpty()) {
				reviewCountCount1=0;
			} else {
				reviewCountCount1=Integer.parseInt(reviewCount1);
			}
			System.out.println(reviewCountCount1);
			//System.out.println(reviewCountCount1);
			reviewHashmap1.put(bobj1.getString("retailerZip"), reviewCountCount1);

		}
		
		return sortingZipCodes(reviewHashmap1);
	}	





	public static HashMap<String, Integer> topReviewed()
	{
		HashMap<String, Integer> reviewHashmap2=new HashMap<String, Integer>();
		
		

		DBObject groupFields2 = new BasicDBObject("_id", 0);
		groupFields2.put("_id", "$productName");
		groupFields2.put("count", new BasicDBObject("$sum", 1));
		DBObject group2 = new BasicDBObject("$group", groupFields2);


		DBObject projectFields2 = new BasicDBObject("_id", 0);
		projectFields2.put("productModelName", "$_id");
		projectFields2.put("reviewCount", "$count");
		DBObject project2 = new BasicDBObject("$project", projectFields2);


		DBObject limit2=new BasicDBObject();
		DBObject orderby2=new BasicDBObject();
		
		DBObject sort2 = new BasicDBObject();
		// Specify the field that you want to sort on, and the direction of the sort
		sort2.put("reviewCount",-1);
		
		
		//Adding sort object in DbObject
		orderby2=new BasicDBObject("$sort",sort2);
		limit2=new BasicDBObject("$limit",5);
		
		AggregationOutput aggregate2 = myReviews.aggregate(group2, project2, orderby2, limit2);
		
		String reviewCount2 = null;
		int reviewCountCount2;
		for (DBObject result2 : aggregate2.results()) {
			BasicDBObject bobj2 = (BasicDBObject) result2;
			System.out.println(bobj2.getString("productModelName"));
			reviewCount2 = bobj2.getString("reviewCount");
			if(reviewCount2 == null || reviewCount2.isEmpty()) {
				reviewCountCount2=0;
			} else {
				reviewCountCount2=Integer.parseInt(reviewCount2);
			}
			System.out.println(reviewCountCount2);
			reviewHashmap2.put(bobj2.getString("productModelName"), reviewCountCount2);

		}
		
		return sortingZipCodes(reviewHashmap2);
	}


	public static HashMap<String, Integer> sortingZipCodes(HashMap<String, Integer> reviewHashmap_return1){

		 List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(reviewHashmap_return1.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                if (false)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
	}	

}

