package com.revature.DAOImp;

import com.revature.DAO.ReimbursementDAO;
import com.revature.Models.Reimbursement;
import com.revature.Models.Status;

import java.util.ArrayList;

public class ReimbursementDAOImp implements ReimbursementDAO {
    @Override
    public ArrayList<Reimbursement> getAllReimbursements() {
        return null;
    }

    @Override
    public ArrayList<Reimbursement> getReimbursementsByAuthor(int authorUserId) {
        return null;
    }

    @Override
    public ArrayList<Reimbursement> getAllReimbursementsByStatus(Status status) {
        return null;
    }

    @Override
    public Reimbursement getReimbursementById(int reimbId) {
        return null;
    }

    @Override
    public boolean updateReimbursement(Reimbursement reimbursement, int reimbId) {
        return false;
    }

    @Override
    public boolean addReimbursement(Reimbursement reimbursement) {
        return false;
    }

    @Override
    public boolean deleteReimbursement(int reimbId) {
        return false;
    }
}
