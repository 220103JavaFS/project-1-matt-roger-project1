package com.revature.Service;

import com.revature.DAO.ReimbursementDAO;
import com.revature.DAOImp.ReimbursementDAOImp;
import com.revature.Models.Reimbursement;

import java.util.List;

public class ReimbursementService{


    private ReimbursementDAO reimbursementDAO = new ReimbursementDAOImp();

    public ReimbursementService(ReimbursementDAO reimbursementDAO){
        this.reimbursementDAO = reimbursementDAO;
    }

    public List<Reimbursement> getAllReimbursements() {
        return null;
    }

    public List<Reimbursement> getReimbursementsByAuthor(int authorUserId) {
        return null;
    }

    public List<Reimbursement> getAllReimbursementsByStatus(int status) {
        return null;
    }

    public Reimbursement getReimbursementById(int reimbId) {
        return reimbursementDAO.getReimbursementById(reimbId);
    }

    public boolean updateReimbursement(Reimbursement reimbursement) {
        return reimbursementDAO.updateReimbursement(reimbursement);
    }

    public boolean addReimbursement(Reimbursement reimbursement) {
        return reimbursementDAO.addReimbursement(reimbursement);
    }

    public boolean deleteReimbursement(int reimbId) {
        return reimbursementDAO.deleteReimbursement(reimbId);
    }
}
