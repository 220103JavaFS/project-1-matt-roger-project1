package com.revature.Service;

import com.revature.DAO.UserDAO;
import com.revature.Models.User;

public class UserService implements UserDAO {


    
    @Override
    public User findByUsername(String userName) {
        return null;
    }

    @Override
    public User[] getUsers() {
        return new User[0];
    }

    @Override
    public boolean addUser(User newUser) {
        return false;
    }
}
