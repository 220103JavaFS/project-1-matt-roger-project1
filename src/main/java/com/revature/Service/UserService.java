package com.revature.Service;

import com.revature.DAO.UserDAO;
import com.revature.Models.User;
import com.revature.Models.UserDTO;

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


//
//    @Override
//    public UserDTO login(String username) {
//        return null;
//    }

    @Override
    public boolean deleteUser(String username) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
