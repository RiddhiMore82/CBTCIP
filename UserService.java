package exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
	
	public void registerUser(String userName, String password) {
		String passwordHash = SecurityUtils.hashPassword(password);
		try(Connection connection = Database.getConnection()){
			String query = "INSERT INTO users (user_name, password_hash) VALUES (?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, userName);
			statement.setString(2, passwordHash);
			statement.executeUpdate();
			System.out.println("User registered successfully for " + userName);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User authenticateUser(String userName, String password) {
		try(Connection connection = Database.getConnection()){
			String query = "SELECT * FROM users WHERE user_name = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, userName);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				String storedHash = resultSet.getString("password_hash");
				if(SecurityUtils.verifyPassword(password, storedHash)) {
					return new User(resultSet.getInt("user_id"), userName, storedHash, resultSet.getString("profile"));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateProfile(User user, String newProfile) {
		try(Connection connection = Database.getConnection()){
			String query = "UPDATE users SET profile = ? WHERE user_id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newProfile);
			statement.setInt(2, user.getUserId());
			statement.executeUpdate();
			user.setProfile(newProfile);
			System.out.println("Profile updated successfully.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePassword(User user, String newPassword) {
		String newPasswordHash = SecurityUtils.hashPassword(newPassword);
		try(Connection connection = Database.getConnection()){
			String query = "UPDATE users SET password_hash = ? WHERE user_id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newPasswordHash);
			statement.setInt(2, user.getUserId());
			statement.executeUpdate();
			user = new User(user.getUserId(), user.getUserName(), newPasswordHash, user.getProfile());
			System.out.println("Password updated successfully.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
