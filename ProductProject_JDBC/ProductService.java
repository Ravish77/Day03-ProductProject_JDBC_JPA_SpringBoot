import java.util.ArrayList;
import java.util.List;

public class ProductService {
	
	List<Product> products = new ArrayList<>();
	ProductDB db = new ProductDB();

	public void addProduct(Product p) {
		db.save(p);
	}
	
	public List<Product> getAllProducts(){
		return db.getAll();
	}
	
	public List<Product> getProductWithText(String text) {
        return db.getProductWithSpecificText(text);

    }
	
	
	//Return Products searched by place 
	public List<Product> getProductWithPlace(String text) {
        return db.getProductWithSpecificPlace(text);

    }	
	
	
	//Returns List of all Products with expired Warranty 
	public List<Product> getProductWithExpiredWarranty() {
		 return db.getExpiredProducts();
    }
	
}
   