import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class SaxParser4ProductXMLdataStore extends DefaultHandler implements Serializable{
	
	Product p;
	transient List<Product> plist;
	String consoleXmlFileName;
	String elementValueRead;
	static String key;
	static transient Map<String, List<Product>> m;
	static HashMap<String, List<Product>> ee ;
	static List<Product> tv_list = new ArrayList<Product>();
	static List<Product> tab_list = new ArrayList<Product>();
    static List<Product> laptop_list = new ArrayList<Product>();
    static List<Product> smart_list = new ArrayList<Product>();



	public SaxParser4ProductXMLdataStore(String consoleXmlFileName) {
		this.consoleXmlFileName = consoleXmlFileName;
		plist = new ArrayList<Product>();
		parseDocument();
}

	public List<Product> getProducts(){
		return plist;
	}



	private void parseDocument() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(consoleXmlFileName, this);
		} catch (ParserConfigurationException e) {
			System.out.println("ParserConfig error");
		} catch (SAXException e) {
			System.out.println("SAXException : xml not well formed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void startElement(String str1, String str2, String elementName,
			Attributes attributes) throws SAXException {
		if (elementName.equalsIgnoreCase("TV")) {
			p = new TV();
			p.setId(attributes.getValue(0));
			p.setRetailer(attributes.getValue(1));
		}
		if (elementName.equalsIgnoreCase("Laptop")) {
			p = new Laptop();
			p.setId(attributes.getValue(0));
			p.setRetailer(attributes.getValue(1));
		}
		if (elementName.equalsIgnoreCase("SmartPhone")) {
			p = new SmartPhone();
			p.setId(attributes.getValue(0));
			p.setRetailer(attributes.getValue(1));
		} 
		if (elementName.equalsIgnoreCase("Tablet")) {
			p = new Tablet();
			p.setId(attributes.getValue(0));
			p.setRetailer(attributes.getValue(1));
		}

	}

	@Override
	public void endElement(String str1, String str2, String element)
			throws SAXException {

		if (element.equalsIgnoreCase("image")) {
			p.setImage(elementValueRead);
		}
		if (element.equalsIgnoreCase("name")) {
			p.setName(elementValueRead);
		}		
		if (element.equalsIgnoreCase("condition")) {
			p.setCondition(elementValueRead);
		}
		if (element.equalsIgnoreCase("price")) {
			p.setPrice(Integer.parseInt(elementValueRead));
		}
		if(element.equalsIgnoreCase("accessory")){
           p.getAccessories().add(elementValueRead);
        }
        if (element.equals("TV") || element.equals("Laptop")
				|| element.equals("SmartPhone") || element.equals("Tablet")) {
			plist.add(p);
		}


	}

	@Override
	public void characters(char[] content, int begin, int end)
			throws SAXException {
		elementValueRead = new String(content, begin, end);
	}

	public static void loadProducts() {
		
		m = new HashMap<String, List<Product>>();
		m.put("TV", new SaxParser4ProductXMLdataStore("C:\\apache-tomcat-7.0.34\\webapps\\Assignment2_Test\\ProductTvCatalog.xml").getProducts());
		m.put("Laptop", new SaxParser4ProductXMLdataStore("C:\\apache-tomcat-7.0.34\\webapps\\Assignment2_Test\\ProductLaptopCatalog.xml").getProducts());
		m.put("SmartPhone", new SaxParser4ProductXMLdataStore("C:\\apache-tomcat-7.0.34\\webapps\\Assignment2_Test\\ProductSmartPhoneCatalog.xml").getProducts());
		m.put("Tablet", new SaxParser4ProductXMLdataStore("C:\\apache-tomcat-7.0.34\\webapps\\Assignment2_Test\\ProductTabletCatalog.xml").getProducts());
		//writeDataStore();
	    
}

/*for (List<Object> lo : list) {
    for (Object o : lo) {
        // etc etc
    }
}*/


/*static void writeDataStore(){	

	 /*for (Map.Entry<String, List<Product>> ee : m.entrySet()) 
	{                   
		    key = ee.getKey();
		    if(key.equals("TV"))
		    {		        
		        tv_list = ee.getValue();

		        for (Product p : tv_list) {                                        
		        MySqlDataStoreUtilities.insertProducts(key,p.id,p.retailer,p.image,p.name,p.condition,p.price);                                        
		        }
		    } 

		    if(key.equals("Tablet"))
		    {		        
		        tab_list = ee.getValue();

		        for (Product p : tab_list) {                                        
		        MySqlDataStoreUtilities.insertProducts(key,p.id,p.retailer,p.image,p.name,p.condition,p.price);                                        
		        }
		    }
		    if(key.equals("Laptop"))
		    {		        
		        laptop_list = ee.getValue();

		        for (Product p : laptop_list) {                                        
		        MySqlDataStoreUtilities.insertProducts(key,p.id,p.retailer,p.image,p.name,p.condition,p.price);                                        
		        }
		    }
		    if(key.equals("SmartPhone"))
		    {		        
		        smart_list = ee.getValue();

		        for (Product p : smart_list) {                                        
		        MySqlDataStoreUtilities.insertProducts(key,p.id,p.retailer,p.image,p.name,p.condition,p.price);                                        
		        }
		    }                                                
	} 				                                

     try{
		//System.out.println("here");
        File tvDataStore=new File("C:\\apache-tomcat-7.0.34\\webapps\\Assignment2_Test\\MainDatabaseFile");
        //tvDataStore.createNewFile();
        //System.out.println("here1");
        FileOutputStream tvfos=new FileOutputStream(tvDataStore);
		//System.out.println("here2");
        ObjectOutputStream tvoos=new ObjectOutputStream(tvfos);    
        tvoos.writeObject(m);
        //System.out.println("here3");
        tvoos.flush();
        tvoos.close();
        tvfos.close();
    
    }catch(Exception e){
        System.out.println("Could NOT Write microsoft to writeTvDataStore ...");
        e.printStackTrace();
    }
}*/

	public static void main (String [] args){

		loadProducts();
	}

}