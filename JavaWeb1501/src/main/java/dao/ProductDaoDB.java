package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDaoDB implements ProductDao {
	
	private String database;
	private String host;
	private String port;
	private String id;
	private String password;

	
	public ProductDaoDB
	(String database,String host,String port,String productid,String password) 
	{this.database =database;
		this.host =host;
		this.port =port;
		this.id =productid;
		this.password =password;

	};
	
	@Override
	public List<Product> getProductList() {
		List<Product> productList =new ArrayList<>();
		//データベース接続
		try (Connection connection = getConnection()) {
			String sql = "SELECT*FROM Product";
			PreparedStatement statement = connection.prepareStatement(sql);
				
			try (ResultSet resultSet = statement.executeQuery()) {
				while(resultSet.next()) {
					productList.add(new Product(resultSet.getString("id"),
							resultSet.getString("name"),
							resultSet.getInt("price")));
	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		
	}
		return productList;

}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		// MySQL JDBCドライバを読み込む	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = String.format("jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false", host, port,
				database);
		return DriverManager.getConnection(url, id, password);
	}
	
	
		

}
