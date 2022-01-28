package com.revature.DAO;

import com.revature.DAOImp.ReimbursementDAOImp;
import com.revature.Models.Reimbursement;
import com.revature.Models.Status;
import com.revature.Models.User;
import com.revature.Service.ReimbursementService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import com.revature.Service.UserService;
import org.junit.jupiter.api.*;

import java.sql.Time;
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


    @Test
    @Order(1)
    void testGetAllReimbursements() {
        assertEquals(list, reimbursementDAO.getAllReimbursements());
    }
    @Test
    @Order(3)
    void testGetReimbursementsByAuthor() {
        assertEquals(list,reimbursementDAO.getReimbursementsByAuthor(testReimbursement.getAuthorUserId()));
    }

    @Test
    @Order(5)
    void testGetAllReimbursementsByStatus() {
        assertEquals(testReimbursement,reimbursementDAO.getAllReimbursementsByStatus(testReimbursement.getStatusId()));
    }

    @Test
    @Order(7)
    void testGetReimbursementById() {
        assertEquals(testReimbursement,reimbursementDAO.getReimbursementById(testReimbursement.getId()));
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
        assertNull(reimbursementDAO.getReimbursementById(testReimbursement.getId()));
    }








}
