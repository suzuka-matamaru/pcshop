package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDaoDB implements UserDao {

	private String database;
	private String host;
	private String port;
	private String id;
	private String password;


public UserDaoDB
(String database,String host,String port,String id,String password) 
{this.database =database;
	this.host =host;
	this.port =port;
	this.id =id;
	this.password =password;
	
};

	@Override
	public User getUser(String userId) {
		//データベース接続
		try (Connection connection = getConnection()) {
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);

			System.out.println(sql);
			
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new User(resultSet.getString("id"),
							resultSet.getString("password"),
							resultSet.getString("name"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		// MySQL JDBCドライバを読み込む	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = String.format("jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false", host, port,
				database);
		return DriverManager.getConnection(url, id, password);
	}

}
