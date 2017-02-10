import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Product implements Serializable{
    String retailer;
    String name;
    String id;
    String image;
    String condition;
	List<String> accessories;
    int price;
	
    public Product(){
		accessories=new ArrayList<String>();
    }

    public void setId(String id) {
    	this.id = id;
    }

public String getId() {
    	return id;
    }

void setRetailer(String retailer) {
	this.retailer = retailer;
}

public String getRetailer() {
		return retailer;
	}


void setImage(String image) {
	this.image = image;
}

public String getImage() {
		return image;
	}

void setCondition(String condition) {
	this.condition = condition;
}

public String getCondition() {
		return condition;
	}
	
public int getPrice() {
		return price;
	}
	
void setPrice(int price) {
	this.price = price;
}

	public String getName() {
		return name;
	}

void setName(String name) {
	this.name = name;
}

List<String> getAccessories() {
	return accessories;
}

/*List<String> setAccessories() {
	this.accessories = accessories;
}*/

}
