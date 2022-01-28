package com.revature.DAOImp;

import com.revature.DAO.ReimbursementDAO;
import com.revature.Models.Reimbursement;
import com.revature.Models.Status;
import com.revature.Models.User;
import com.revature.utils.ConnectionUtil;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImp implements ReimbursementDAO {
    @Override
    public List<Reimbursement> getAllReimbursements() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> list = new ArrayList<Reimbursement>();
            Reimbursement reimbursement = new Reimbursement();

            while (result.next()){
                reimbursement.setId(result.getInt("reimb_id"));
                reimbursement.setAmount(result.getDouble("reimb_amount"));
                reimbursement.setTimeSubmitted(result.getTimestamp("reimb_submitted"));
                reimbursement.setTimeResolved(result.getTimestamp("reimb_resolved"));
                reimbursement.setDescription(result.getString("reimb_description"));
                reimbursement.setReceipt(result.getBytes("reimb_receipt"));
                reimbursement.setAuthorUserId(result.getInt("reimb_author"));
                reimbursement.setResolverUserId(result.getInt("reimb_resolver"));
                reimbursement.setStatusId(result.getInt("reimb_status_id"));
                reimbursement.setTypeId(result.getInt("reimb_type_id"));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Reimbursement>();
    }

    @Override
    public List<Reimbursement> getReimbursementsByAuthor(int authorUserId) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = " + authorUserId + ";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> list = new ArrayList<Reimbursement>();
            Reimbursement reimbursement = new Reimbursement();

            while (result.next()){
                reimbursement.setId(result.getInt("reimb_id"));
                reimbursement.setAmount(result.getDouble("reimb_amount"));
                reimbursement.setTimeSubmitted(result.getTimestamp("reimb_submitted"));
                reimbursement.setTimeResolved(result.getTimestamp("reimb_resolved"));
                reimbursement.setDescription(result.getString("reimb_description"));
                reimbursement.setReceipt(result.getBytes("reimb_receipt"));
                reimbursement.setAuthorUserId(result.getInt("reimb_author"));
                reimbursement.setResolverUserId(result.getInt("reimb_resolver"));
                reimbursement.setStatusId(result.getInt("reimb_status_id"));
                reimbursement.setTypeId(result.getInt("reimb_type_id"));
            }
            return list;
    }catch (SQLException e){
        e.printStackTrace();
    }
        return new ArrayList<Reimbursement>();
    }

    @Override
    public List<Reimbursement> getAllReimbursementsByStatus(int status) {
        return null;
    }

    @Override
    public Reimbursement getReimbursementById(int reimbId) {
        return null;
    }

    @Override
    public boolean updateReimbursement(Reimbursement reimbursement) {
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
