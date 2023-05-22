import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class ProductDB {
	
	Connection connection = null;
	
	public ProductDB() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/telusko", "postgres", "root123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save(Product p) {
		String sqlQuery = "insert into product(name, type, place, warranty) values(?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getType());
			pstmt.setString(3, p.getPlace());
			pstmt.setInt(4, p.getWarranty());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//Returns all products in DB
	public List<Product> getAll() {
		List<Product> products = new ArrayList<>();
		String sqlQuery = "select name,type,place,warranty from product";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				Product p = new Product();
				p.setName(resultSet.getString(1));
				p.setType(resultSet.getString(2));
				p.setPlace(resultSet.getString(3));
				p.setWarranty(resultSet.getInt(4));
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	//Returns  products in DB with Specific text 
	public List<Product> getProductWithSpecificText(String text) {
		ProductDB d = new ProductDB();
		List<Product> allProducts = d.getAll();
		String str = text.toLowerCase();
		List<Product> prods = new ArrayList<>();

		for(Product p : allProducts){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str))
                prods.add(p);
        }
        return prods;
		
	}

	//returns products based on place
	public List<Product> getProductWithSpecificPlace(String text) {
		ProductDB d = new ProductDB();
		List<Product> allProducts = d.getAll();
		
		String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : allProducts){
            String place = p.getPlace().toLowerCase();
            if( place.contains(str))
                prods.add(p);
        }
        return prods;
	}

	
	//returns prodct based on expired warranty
	public List<Product> getExpiredProducts() {
		List<Product> products = new ArrayList<>();
		String sqlQuery = "select name,type,place,warranty from product where warranty<2023";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				Product p = new Product();
				p.setName(resultSet.getString(1));
				p.setType(resultSet.getString(2));
				p.setPlace(resultSet.getString(3));
				p.setWarranty(resultSet.getInt(4));
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

}
