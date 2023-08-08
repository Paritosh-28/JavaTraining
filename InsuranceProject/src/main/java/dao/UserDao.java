package dao;

import java.util.List;

import entities.User;

public interface UserDao {
    User findByUsername(String username);
    void save(User user);
    // Other methods as needed
}
