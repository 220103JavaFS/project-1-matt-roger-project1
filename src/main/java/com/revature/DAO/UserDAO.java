package com.revature.DAO;

import com.revature.Models.User;
import com.revature.Models.UserDTO;

import java.util.List;

public interface UserDAO {

    public User findByUsername(String userName);
    public List<User> getUsers();
    public boolean addUser(User user);
    //UserDTO login(String username);

    boolean deleteUser(String username);
    public boolean updateUser(User user);
}
