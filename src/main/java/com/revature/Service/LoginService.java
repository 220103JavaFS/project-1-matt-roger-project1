package com.revature.Service;

import com.revature.DAO.UserDAO;
import com.revature.Models.UserDTO;

public class LoginService {
    private UserDAO userDAO;

    public LoginService(){

    }
    public LoginService(UserDAO userDAO){
        this.userDAO = userDAO;

    }
    public boolean login(String username, String password){
        UserDTO userFromDb = userDAO.login(username);
        if(userFromDb !=null&&password.equals(userFromDb.password)){
            return true;
        }else {
            return false;
        }
    }



}
