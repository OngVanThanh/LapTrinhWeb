package vn.iotstar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser {
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, username);
            stmt.setString(2, password); // Phải kiểm tra với mật khẩu đã mã hóa
            ResultSet rs = stmt.executeQuery();
            
            return rs.next(); // Đăng nhập thành công nếu tìm thấy người dùng
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

