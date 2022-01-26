package com.revature.DAO;

import com.revature.Models.Reimbursement;
import com.revature.Models.Status;

import java.util.ArrayList;

public interface ReimbursementDAO {
    ArrayList<Reimbursement> getAllReimbursements();

    ArrayList<Reimbursement> getReimbursementsByAuthor(int authorUserId);

    ArrayList<Reimbursement> getAllReimbursementsByStatus(Status status);

    Reimbursement getReimbursementById(int reimbId);

    boolean updateReimbursement(Reimbursement reimbursement, int reimbId);

    boolean addReimbursement(Reimbursement reimbursement);

    boolean deleteReimbursement(int reimbId);
}
