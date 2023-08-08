package dao;

import java.util.List;

import entities.Admin;
import entities.InsuranceClaim;
import entities.User;

public interface AdminDao {
	Admin findById(Long adminId);
    void save(Admin admin);
    void update(Admin admin);
    void delete(Admin admin);
    List<Admin> getAllAdmins();
    
    User findUserById(Long userId); // New method to find a user by ID
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(User user);
    
    List<InsuranceClaim> getAllClaims();
    InsuranceClaim findClaimById(Long claimId);
    void updateClaim(InsuranceClaim claim);
	
}
