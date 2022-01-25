package com.revature.DAO;
import com.revature.DAOImp.UserDaoImp;
import com.revature.Models.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoImpTest {
    private static UserDAO userDAO = new UserDaoImp();
    private static User testUser = new User(
            0 ,
            "MattRoger" ,
            "1933" ,
            "Roger" ,
            "Gaulke" ,
            "Roger@gmail.com" ,
            1
    );
    @Test
    @Order(1)
    void testCreateUser(){
        assertTrue(userDAO.addUser(testUser));
    }

    @Test
    @Order(3)
    void testGetUser(){
        assertEquals(testUser , userDAO.findByUsername(testUser.getUsername()));
    }

    @Test
    @Order(7)
    void testDelete(){
        assertTrue(userDAO.deleteUser(testUser.getUsername()));
        assertNull(userDAO.findByUsername(testUser.getUsername()).getUsername());
    }

    @Test
    @Order(8)
    void testUpdate(){
        assertTrue((userDAO.updateUser(testUser)));
    }

    @Test
    @Order(9)
    void testGetUsers(){
        List list = new ArrayList<User>() ;
        list.add(testUser);
        assertEquals(list, userDAO.getUsers());
    }
}
