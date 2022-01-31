package com.revature.Service;

import com.revature.DAO.UserDAO;
import com.revature.DAOImp.UserDaoImp;
import com.revature.Models.User;
import com.revature.Models.UserDTO;

public class LoginService {
    private UserDAO userDAO = new UserDaoImp();

    public LoginService(){}

    public LoginService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public User login(UserDTO userDTO){
        User userFromDb = userDAO.findByUsername(userDTO.username);

        if(userFromDb !=null){
            System.out.println("Not null");
            System.out.println(userDTO.password);
            System.out.print(userFromDb.getPassword());
            if(userDTO.password.equals(userFromDb.getPassword()))
            {
                System.out.println("Password equals");
                return userFromDb;
            }
        }else {
            System.out.println("Definitely null");
            return null;
        }
        return null;
    }
}
