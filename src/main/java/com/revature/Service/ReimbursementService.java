package com.revature.Service;

import com.revature.DAO.ReimbursementDAO;
import com.revature.DAOImp.ReimbursementDAOImp;
import com.revature.Models.Reimbursement;

import java.util.List;

public class ReimbursementService implements ReimbursementDAO {


    private ReimbursementDAO reimbursementDAO = new ReimbursementDAOImp();

    public ReimbursementService(ReimbursementDAO reimbursementDAO){
        this.reimbursementDAO = reimbursementDAO;
    }

    @Override
    public List<Reimbursement> getAllReimbursements() {
        return null;
    }

    @Override
    public List<Reimbursement> getReimbursementsByAuthor(int authorUserId) {
        return null;
    }

    @Override
    public List<Reimbursement> getAllReimbursementsByStatus(int status) {
        return null;
    }

    @Override
    public Reimbursement getReimbursementById(int reimbId) {
        return reimbursementDAO.getReimbursementById(reimbId);
    }

    @Override
    public boolean updateReimbursement(Reimbursement reimbursement) {
        return reimbursementDAO.updateReimbursement(reimbursement);
    }

    @Override
    public boolean addReimbursement(Reimbursement reimbursement) {
        return reimbursementDAO.addReimbursement(reimbursement);
    }

    @Override
    public boolean deleteReimbursement(int reimbId) {
        return reimbursementDAO.deleteReimbursement(reimbId);
    }
}
