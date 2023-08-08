package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Admin;
import entities.InsuranceClaim;
import entities.User;

public class AdminDaoImpl implements AdminDao{

    private Connection connection;

    public AdminDaoImpl() {

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
    public Admin findById(Long adminId) {
        // Implementation to find an admin by ID
    	
    	 String sql = "SELECT * FROM admins WHERE id = ?";
         try (PreparedStatement statement = connection.prepareStatement(sql)) {
             statement.setLong(1, adminId);
             try (ResultSet resultSet = statement.executeQuery()) {
                 if (resultSet.next()) {
                     return extractAdminFromResultSet(resultSet);
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return null;
    }

    private Admin extractAdminFromResultSet(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void save(Admin admin) {
        // Implementation to save an admin
    	String sql = "INSERT INTO admins (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Admin admin) {
        // Implementation to update an admin
    	
    	String sql = "UPDATE admins SET username = ?, password = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());
            statement.setLong(3, admin.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }

    @Override
    public void delete(Admin admin) {
        // Implementation to delete an admin
    	
    	 String sql = "DELETE FROM admins WHERE id = ?";
         try (PreparedStatement statement = connection.prepareStatement(sql)) {
             statement.setLong(1, admin.getId());
             statement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }

    @Override
    public List<Admin> getAllAdmins() {
        // Implementation to get all admins
    	
    	List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM admins";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Admin admin = extractAdminFromResultSet(resultSet);
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    	
    }

    @Override
    public User findUserById(Long userId) {
        // Implementation to find a user by ID
    	String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, userId);
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

    private User extractUserFromResultSet(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public List<InsuranceClaim> getAllClaims() {
        // Implementation to get all insurance claims
		
		 List<InsuranceClaim> claims = new ArrayList<>();
	        String sql = "SELECT * FROM insurance_claims";
	        try (PreparedStatement statement = connection.prepareStatement(sql);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                InsuranceClaim claim = extractClaimFromResultSet(resultSet);
	                claims.add(claim);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return claims;
		
    }

    private InsuranceClaim extractClaimFromResultSet(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public InsuranceClaim findClaimById(Long claimId) {
        // Implementation to find an insurance claim by ID
		
		String sql = "SELECT * FROM insurance_claims WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, claimId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractClaimFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
		
    }

    @Override
    public void updateClaim(InsuranceClaim claim) {
        // Implementation to update an insurance claim
    	
    	String sql = "UPDATE insurance_claims SET user_id = ?, claim_details = ?, approved = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, claim.getUserId());
            statement.setString(2, claim.getClaimDetails());
            statement.setBoolean(3, claim.isApproved());
            statement.setLong(4, claim.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = extractUserFromResultSet(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		 String sql = "UPDATE users SET username = ?, password = ?, email = ?, phone_number = ? WHERE id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, user.getUsername());
	            statement.setString(2, user.getPassword());
	            statement.setString(3, user.getEmail());
	            statement.setString(4, user.getPhoneNumber());
	            statement.setLong(5, user.getId());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
}
