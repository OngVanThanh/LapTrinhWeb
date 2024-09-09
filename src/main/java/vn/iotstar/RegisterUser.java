package vn.iotstar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUser {
	public boolean register(String username, String password, String email) {
		String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
		try (
				Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)
			){
			stmt.setString(1, username);
			stmt.setString(2,  password);
			stmt.setString(3, email);
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
