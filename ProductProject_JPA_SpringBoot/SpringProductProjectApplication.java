package com.telusko.SpringProductProject;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringProductProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringProductProjectApplication.class, args);
		
		ProductService service = context.getBean(ProductService.class);
		
		System.out.println();
        System.out.println("================================================================");
        System.out.println("ALL AVAILABLE PRODUCTS IN DATABASE FETCHING USING DATA JPA: ");
        System.out.println("================================================================");
		List<Product> products = service.getAllProducts();
        for(Product p : products) {
        	System.out.println(p);
        }
        
        
        //To get products with particular text
	  	System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH SPECIFIC TEXT AVAILABLE IN DATABASE FETCHING USING DATA JPA : ");
        System.out.println("================================================================");
        List<Product> prods = service.getProductWithText("black");
        for(Product product : prods){
            System.out.println(product);
        }
        
        
        
        //To get products , searched by place 
        System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH SPECIFIC PLACE FETCHING FROM DATABASE FETCHING USING DATA JPA: ");
        System.out.println("================================================================");
        for(Product p : service.getProductWithPlace("white table")) {
        	System.out.println(p);
        }
        
        
        //To get all products with less than 2023
        System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH EXPIRED WARRANTY FETCHING FROM DATABASE FETCHING USING DATA JPA: ");
        System.out.println("================================================================");
        List<Product> productsWithExpiredWarranty = service.getProductWithExpiredWarranty();
        for(Product p: productsWithExpiredWarranty) {
        	System.out.println(p);
        }
        
	}

}
