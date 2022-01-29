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

    public ReimbursementService() {

    }


    public List<Reimbursement> getAllReimbursements() {
        return reimbursementDAO.getAllReimbursements();
    }

    public List<Reimbursement> getReimbursementsByAuthor(int authorUserId) {
        return reimbursementDAO.getReimbursementsByAuthor(authorUserId);
    }

    public List<Reimbursement> getAllReimbursementsByStatus(int status) {
        return reimbursementDAO.getAllReimbursementsByStatus(status);
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
