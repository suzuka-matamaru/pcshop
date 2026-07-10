/*package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class PaymentDaoDB implements PaymentDao {
	
	private String userId;
	private String userName;
	private String productId;
	private String productName;
	private String amount;
	private String purchaseDate;
	
	
	public void insert(
			String userId,
			String userName, 
			String productId,
			String productName,
			String amount,
			String purchaseDate) {
		
		this.userId =userId;
		this.userName =userName;
		this.productId =productId;
		this.amount =amount;
		this.purchaseDate =purchaseDate;
	};
	
		try (Connection connection = getConnection()) {
			String sql = "INSERT INTO Payment"
			+"(user_id,user_name,product_id,product_name,amount,purchase_date)"
			+"VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1,userId);
			statement.setString(2,userName);
			statement.setString(3,productId);
			statement.setString(4,productName);
			statement.setString(5,amount);
			statement.setString(6,purchaseDate);
			int updateCount = statement.executeUpdate(sql);
	
				}
}
		catch (Exception e) {
			e.printStackTrace();
			
		
	}
		return productList;

*/
