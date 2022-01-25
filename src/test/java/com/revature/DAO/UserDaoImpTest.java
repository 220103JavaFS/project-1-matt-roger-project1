package com.revature.DAO;
import com.revature.DAOImp.UserDaoImp;
import com.revature.Models.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoImpTest {
    private static UserDAO userDAO = new UserDaoImp();
    private static User testUser = new User(
            1 ,
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
        assertEquals(testUser , userDAO.findByUsername(testUser.getUserName()));
    }

    @Test
    @Order(7)
    void testDelete(){
        assertTrue(testUser.deleteUser(userDAO.getUserName()));
        assertNull(userDAO.findByUsername(userDAO.getUserName()).getUserName());
    }


}
