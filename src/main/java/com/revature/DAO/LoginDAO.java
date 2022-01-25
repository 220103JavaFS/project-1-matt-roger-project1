package com.revature.DAO;


import com.revature.Models.UserDTO;

public interface LoginDAO  {
    UserDTO login(String username);
}
