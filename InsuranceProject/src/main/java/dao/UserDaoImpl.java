package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.User;

public class UserDaoImpl implements UserDao {
    private Connection connection;

    public UserDaoImpl() {

    	try {
			//1. Load the Driver
			System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded....");
			
			//2. Acquire the connection
			System.out.println("Trying to connect....");
			connection = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected : "+ connection);
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractUserFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (Userid,username, password, PhoneNumber,Emailid) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setLong(1, user.getId());
        	statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPhoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to create a User object from a ResultSet
    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("Userid"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("Emailid"));
        user.setPhoneNumber(resultSet.getString("PhoneNumber"));
        return user;
    }
}
