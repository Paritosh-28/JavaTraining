package services;
import java.util.List;

import dao.AdminDao;
import entities.Admin;
import entities.InsuranceClaim;
import entities.User;

public class AdminService {

	private AdminDao adminDao;

    public AdminService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
    
    public Admin getAdminById(Long adminId) {
        return adminDao.findById(adminId);
    }

    public List<Admin> getAllAdmins() {
        return adminDao.getAllAdmins();
    }

    public void createAdmin(Admin admin) {
        adminDao.save(admin);
    }
    
    public void updateAdmin(Admin admin) {
        adminDao.update(admin);
    }

    public void deleteAdmin(Admin admin) {
        adminDao.delete(admin);
    }
    
    public User getUserById(Long userId) {
        return adminDao.findUserById(userId);
    }

    public List<User> getAllUsers() {
        return adminDao.getAllUsers();
    }

    public void updateUser(User user) {
        adminDao.updateUser(user);
    }

    public void deleteUser(User user) {
        adminDao.deleteUser(user);
    }
    
    public List<InsuranceClaim> getAllClaims() {
        return adminDao.getAllClaims();
    }

    public InsuranceClaim getClaimById(Long claimId) {
        return adminDao.findClaimById(claimId);
    }

    public void updateClaim(InsuranceClaim claim) {
        adminDao.updateClaim(claim);
    }
    
}
