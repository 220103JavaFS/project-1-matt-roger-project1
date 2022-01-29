package com.revature.Service;

import com.revature.DAO.UserDAO;
import com.revature.DAOImp.UserDaoImp;
import com.revature.Models.User;
import com.revature.Models.UserDTO;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDaoImp();

    public UserService() {
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public User findByUsername(String userName) {

        return userDAO.findByUsername(userName);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public boolean addUser(User user) {

        return userDAO.addUser(user);
    }


//
//    @Override
//    public UserDTO login(String username) {
//        return null;
//    }

    public boolean deleteUser(String username) {
        return userDAO.deleteUser(username);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }
}
