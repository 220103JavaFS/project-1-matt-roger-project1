package com.revature.DAO;

import com.revature.Models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {
    List<Reimbursement> getAllReimbursements();

    List<Reimbursement> getReimbursementsByAuthor(int authorUserId);

    List<Reimbursement> getAllReimbursementsByStatus(int status);

    Reimbursement getReimbursementById(int reimbId);

    boolean updateReimbursement(Reimbursement reimbursement);

    boolean addReimbursement(Reimbursement reimbursement);

    boolean deleteReimbursement(int reimbId);
}
