package services;

import dao.UserDao;
import entities.User;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
    	
        this.userDao = userDao;
    }

    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void registerUser(User user) {
        userDao.save(user);
    }

    // Other methods as needed
}
