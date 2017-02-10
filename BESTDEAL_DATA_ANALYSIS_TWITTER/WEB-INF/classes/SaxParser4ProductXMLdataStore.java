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

public class SaxParser4ProductXMLdataStore extends DefaultHandler{
	
	public Product p;
	public List<Product> plist;
	public String consoleXmlFileName;
	public String elementValueRead;
	public static String key;
	public static transient Map<String, List<Product>> m;
	public static HashMap<String, List<Product>> ee ;
	public static List<Product> tv_list = new ArrayList<Product>();
	public static List<Product> tab_list = new ArrayList<Product>();
    public static List<Product> laptop_list = new ArrayList<Product>();
    public static List<Product> smart_list = new ArrayList<Product>();



	public SaxParser4ProductXMLdataStore(String consoleXmlFileName) {
		this.consoleXmlFileName = consoleXmlFileName;
		plist = new ArrayList<Product>();
		parseDocument();
}

	public List<Product> getProducts(){
		return plist;
	}



	public void parseDocument() {
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

		System.out.println("HI IN SAX PARSER::");
		
		m = new HashMap<String, List<Product>>();
		m.put("TV", new SaxParser4ProductXMLdataStore("C:\\apache-tomcat-7.0.34\\webapps\\Assignment5\\ProductTvCatalog.xml").getProducts());
		m.put("Laptop", new SaxParser4ProductXMLdataStore("C:\\apache-tomcat-7.0.34\\webapps\\Assignment5\\ProductLaptopCatalog.xml").getProducts());
		m.put("SmartPhone", new SaxParser4ProductXMLdataStore("C:\\apache-tomcat-7.0.34\\webapps\\Assignment5\\ProductSmartPhoneCatalog.xml").getProducts());
		m.put("Tablet", new SaxParser4ProductXMLdataStore("C:\\apache-tomcat-7.0.34\\webapps\\Assignment5\\ProductTabletCatalog.xml").getProducts());
		System.out.println("HI IN SAX PARSER_1::");
		writeDataStore();
	    
}


static void writeDataStore(){	

	System.out.println("HI IN SAX PARSER_3::");

	 for (Map.Entry<String, List<Product>> ee : m.entrySet()) 
	{                   
		    key = ee.getKey();
		    if(key.equals("TV"))
		    {		        
		        tv_list = ee.getValue();

		        for (Product p : tv_list) {                                        
		        MySqlDataStoreUtilities.insertProductsInTable(key,p.id,p.name,p.retailer,p.condition,p.price,p.image);                                       
		        }
		    } 

		    if(key.equals("Tablet"))
		    {		        
		        tab_list = ee.getValue();

		        for (Product p : tab_list) {                                        
		        MySqlDataStoreUtilities.insertProductsInTable(key,p.id,p.name,p.retailer,p.condition,p.price,p.image);                                        
		        }
		    }
		    if(key.equals("Laptop"))
		    {		        
		        laptop_list = ee.getValue();

		        for (Product p : laptop_list) {                                        
		        MySqlDataStoreUtilities.insertProductsInTable(key,p.id,p.name,p.retailer,p.condition,p.price,p.image);                                        
		        }
		    }
		    if(key.equals("SmartPhone"))
		    {		        
		        smart_list = ee.getValue();

		        for (Product p : smart_list) {                                        
		        MySqlDataStoreUtilities.insertProductsInTable(key,p.id,p.name,p.retailer,p.condition,p.price,p.image);                                       
		        }
		    }                                                
	} 				                                

     
}

	public static void main (String [] args){

		loadProducts();
	}

}