package com.revature.DAO;

import com.revature.Models.User;

public interface UserDAO {

    public User getUserByUsername(String userName);
    public User[] getUsers();
    public boolean addUser(User newUser);
}
