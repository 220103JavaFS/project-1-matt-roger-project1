package com.revature.Service;

import com.revature.DAO.UserDAO;
import com.revature.Models.User;
import com.revature.Models.UserDTO;

public class LoginService {
    private UserDAO userDAO;

    public LoginService(){}

    public LoginService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public boolean login(UserDTO userDTO){
        User userFromDb = userDAO.findByUsername(userDTO.username);

        if(userFromDb !=null&&userDTO.password.equals(userFromDb.getPassword())){
            return true;
        }else {
            return false;
        }
    }
}
