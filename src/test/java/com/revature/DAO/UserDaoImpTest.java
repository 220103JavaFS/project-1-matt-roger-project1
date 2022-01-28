package com.revature.DAO;
import com.revature.DAOImp.UserDaoImp;
import com.revature.Models.User;
import com.revature.Models.UserDTO;
import com.revature.Service.LoginService;
import com.revature.Service.UserService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoImpTest {

    private UserService testInstance;

    private List<User> list = new ArrayList<User>();

    @Mock
    private UserDAO mockedDAO;

    private static UserDAO userDAO = new UserDaoImp();


    private static User testUser = new User(
            "MattRoger" ,
            "1933" ,
            "Roger" ,
            "Gaulke" ,
            "Roger@gmail.com" ,
            1
    );

    @BeforeEach
    public void setUp(){

        List<User> newList = new ArrayList<User>();
        newList.add(testUser);
        list = newList;

        //testUser.setUserID(1);
        testUser.setUsername("MattRoger");
        testUser.setPassword("1933");
        MockitoAnnotations.openMocks(this);
        testInstance = new UserService(mockedDAO);
        Mockito.when(mockedDAO.getUsers()).thenReturn(list);
    }






    @Test
    @Order(1)
    void testCreateUser(){
        assertTrue(userDAO.addUser(testUser));
        assertNotNull(userDAO.findByUsername(testUser.getUsername()).getUsername());
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
        assertEquals(list, mockedDAO.getUsers());
    }
}
