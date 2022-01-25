package com.revature.Service;

import com.revature.DAO.UserDAO;
import com.revature.DAOImp.UserDaoImp;
import com.revature.Models.User;
import com.revature.Models.UserDTO;

import java.util.List;

public class UserService implements UserDAO {

    private UserDAO userDAO = new UserDaoImp();

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public User findByUsername(String userName) {

        return userDAO.findByUsername(userName);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public boolean addUser(User user) {

        return userDAO.addUser(user);
    }


//
//    @Override
//    public UserDTO login(String username) {
//        return null;
//    }

    @Override
    public boolean deleteUser(String username) {
        return userDAO.deleteUser(username);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }
}
