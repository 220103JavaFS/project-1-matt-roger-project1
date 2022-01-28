package com.revature.Service;

import com.revature.Models.Reimbursement;
import com.revature.DAO.ReimbursementDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbusrementServiceTest {

    private ReimbursementService testInstance;

    @Mock
    private ReimbursementDAO mockedDAO;

    private Reimbursement testReimbursement;


    @BeforeEach
    public void setReimbursement(){
        testReimbursement = new Reimbursement();
        testReimbursement.setAmount(300);
        testReimbursement.setTimeSubmitted(new Timestamp(System.currentTimeMillis()));
        testReimbursement.setStatusId(1);
        testReimbursement.setAuthorUserId(2);
        testReimbursement.setDescription("Test reimb");
        testReimbursement.setTypeId(1);
        MockitoAnnotations.openMocks(this);
        testInstance = new ReimbursementService(mockedDAO);

        Mockito.when(testInstance.getReimbursementById(1)).thenReturn(testReimbursement);
        Mockito.when(testInstance.addReimbursement(testReimbursement)).thenReturn(true);
        List<Reimbursement> list = new ArrayList<>();
        Mockito.when(testInstance.getAllReimbursements()).thenReturn(list);




    }

    @Test
    void getAllReimbursements() {
        assertFalse(testInstance.getAllReimbursements().isEmpty());
    }


}