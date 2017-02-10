import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Product implements Serializable{
    public String retailer;
    public String name;
    public String id;
    public String image;
    public String condition;
	public List<String> accessories;
    public int price;



    public Product (String id, String name,String retailer,String condition,int price,String image) {
        this.id = id;
        this.name = name;
        this.retailer = retailer;
        this.condition = condition;
        this.price = price;       
        this.image = image;
	}

	 public Product (String id, String name) {
        this.id = id;
        this.name = name;       
	}
	
public Product(){
	accessories=new ArrayList<String>();
}

public void setId(String id) {
	this.id = id;
}

public String getId() {
    	return id;
    }

public void setRetailer(String retailer) {
	this.retailer = retailer;
}

public String getRetailer() {
		return retailer;
	}


public void setImage(String image) {
	this.image = image;
}

public String getImage() {
		return image;
	}

public void setCondition(String condition) {
	this.condition = condition;
}

public String getCondition() {
		return condition;
	}
	
public int getPrice() {
		return price;
	}
	
public void setPrice(int price) {
	this.price = price;
}

	public String getName() {
		return name;
	}

public void setName(String name) {
	this.name = name;
}

public List<String> getAccessories() {
	return accessories;
}


}
