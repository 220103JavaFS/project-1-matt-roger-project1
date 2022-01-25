package com.revature.DAO;

import com.revature.Models.User;
import com.revature.Models.UserDTO;

public interface UserDAO {

    public User findByUsername(String userName);
    public User[] getUsers();
    public boolean addUser(User newUser);
    UserDTO login(String username);

    boolean deleteUser(String username);
}
