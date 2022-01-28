package com.revature.DAO;

import com.revature.DAOImp.ReimbursementDAOImp;
import com.revature.Models.Reimbursement;
import com.revature.Service.ReimbursementService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReimbursementDAOImpTest {

    private ReimbursementService testInstance;

    private List<Reimbursement> list = new ArrayList<Reimbursement>();

    private ReimbursementDAO reimbursementDAO = new ReimbursementDAOImp();

    private static Reimbursement testReimbursement = new Reimbursement(
            1,
            100.00,
            new Timestamp(2022, 1, 3, 10, 0, 0, 0),
            new Timestamp(2023, 1, 3, 10, 0, 0, 0),
            "Test reimbursement",
            hexStringToByteArray("e04fd020ea3a6910a2d808002b30309d"),
            2,
            2,
            0,
            2
    );

    @Mock
    private ReimbursementService mockedDAO;

    @BeforeEach
    public void setUp(){

        List<Reimbursement> newList = new ArrayList<Reimbursement>();
        newList.add(testReimbursement);
        list = newList;

       // testReimbursement.setUserID(1);
        testReimbursement.setAmount(100.00);
        testReimbursement.setDescription("Test reimbursement");
        testReimbursement.setReceipt(hexStringToByteArray("e04fd020ea3a6910a2d808002b30309d"));
        MockitoAnnotations.openMocks(this);
        testInstance = new ReimbursementService(mockedDAO);
        Mockito.when(mockedDAO.getAllReimbursements()).thenReturn(list);
        Mockito.when(mockedDAO.getReimbursementsByAuthor(testReimbursement.getAuthorUserId())).thenReturn(list);
        Mockito.when(mockedDAO.getAllReimbursementsByStatus(testReimbursement.getStatusId())).thenReturn(list);
        Mockito.when(mockedDAO.getReimbursementById(testReimbursement.getId())).thenReturn(testReimbursement);
    }


    @Test
    @Order(1)
    void testGetAllReimbursements() {
        assertEquals(list, mockedDAO.getAllReimbursements());
    }
    @Test
    @Order(3)
    void testGetReimbursementsByAuthor() {
        assertEquals(list,mockedDAO.getReimbursementsByAuthor(testReimbursement.getAuthorUserId()));
    }

    @Test
    @Order(5)
    void testGetAllReimbursementsByStatus() {
        assertEquals(list,mockedDAO.getAllReimbursementsByStatus(testReimbursement.getStatusId()));
    }

    @Test
    @Order(7)
    void testGetReimbursementById() {
        System.out.println(testReimbursement.getId());
        assertEquals(testReimbursement,mockedDAO.getReimbursementById(testReimbursement.getId()));
    }

    @Test
    @Order(9)
    void testUpdateReimbursement() {
        assertTrue(reimbursementDAO.updateReimbursement(testReimbursement));
    }

    @Test
    @Order(11)
    void testAddReimbursement() {
        assertTrue(reimbursementDAO.addReimbursement(testReimbursement));
    }


    @Test
    @Order(13)
    void testDeleteReimbursement() {
        assertTrue(reimbursementDAO.deleteReimbursement(testReimbursement.getId()));
        assertNull(reimbursementDAO.getReimbursementById(testReimbursement.getId()).getReceipt());
    }








}
