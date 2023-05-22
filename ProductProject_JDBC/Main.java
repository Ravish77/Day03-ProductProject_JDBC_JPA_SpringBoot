import java.util.List;


public class Main {

	public static void main(String[] args) {
	
		ProductService service = new ProductService();
		
		
		//Pushing all Products to Database.
		service.addProduct(new Product("Type C", "Cable", "Black Drawer", 2024));
        service.addProduct(new Product("Mac Studio", "Computer", "White Table", 2025));
        service.addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
        service.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
        service.addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
        service.addProduct(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
        service.addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
        service.addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
        service.addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
        service.addProduct(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
        service.addProduct(new Product("Java Black Book", "Cable", "Shelf", 2024));
        service.addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
        service.addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
        service.addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
        service.addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));
        
        
        //A list contains all products
        System.out.println();
        System.out.println("================================================================");
        System.out.println("ALL AVAILABLE PRODUCTS IN DATABASE: ");
        System.out.println("================================================================");
        List<Product> products = service.getAllProducts();
        for(Product p : products) {
        	System.out.println(p);
        }
        
        
        //To get products with particular text
	  	System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH SPECIFIC TEXT AVAILABLE IN DATABASE: ");
        System.out.println("================================================================");
        List<Product> prods = service.getProductWithText("black");
        for(Product product : prods){
            System.out.println(product);
        }
        
        
        
        //To get products , searched by place 
        System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH SPECIFIC PLACE FETCHING FROM DATABASE: ");
        System.out.println("================================================================");
        for(Product p : service.getProductWithPlace("white table")) {
        	System.out.println(p);
        }
        
        
        //To get all products with less than 2023
        System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH EXPIRED WARRANTY FETCHING FROM DATABASE: ");
        System.out.println("================================================================");
        List<Product> productsWithExpiredWarranty = service.getProductWithExpiredWarranty();
        for(Product p: productsWithExpiredWarranty) {
        	System.out.println(p);
        }
        
        

		
	}

}