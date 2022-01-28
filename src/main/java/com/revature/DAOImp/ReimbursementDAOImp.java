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


            while (result.next()){
                Reimbursement reimbursement = new Reimbursement();
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
                list.add(reimbursement);
            }
            return list;
    }catch (SQLException e){
        e.printStackTrace();
    }
        System.out.println("return default");
        return new ArrayList<Reimbursement>();
    }

    @Override
    public List<Reimbursement> getAllReimbursementsByStatus(int status) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = " + status + ";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> list = new ArrayList<Reimbursement>();


            while (result.next()){
                Reimbursement reimbursement = new Reimbursement();
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
                list.add(reimbursement);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("return default");
        return new ArrayList<Reimbursement>();
    }

    @Override
    public Reimbursement getReimbursementById(int reimbId) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = " + reimbId + ";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> list = new ArrayList<Reimbursement>();
            System.out.println(reimbId);

            while (result.next()){
                Reimbursement reimbursement = new Reimbursement();
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
                return reimbursement;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("return default");
        return new Reimbursement();
    }

    @Override
    public boolean updateReimbursement(Reimbursement reimbursement) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE ers_reimbursement SET reimb_amount = ?, reimb_submitted = ?, " +
                    "reimb_resolved = ?, reimb_description = ?, reimb_receipt = ?," +
                    " reimb_author = ?, reimb_resolver = ?, reimb_status_id = ?, reimb_type_id = ?" +
                    "WHERE reimb_id = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1, reimbursement.getAmount());
            statement.setTimestamp(2, reimbursement.getTimeSubmitted());
            statement.setTimestamp(3, reimbursement.getTimeResolved());
            statement.setString(4, reimbursement.getDescription());
            statement.setBytes(5, reimbursement.getReceipt());
            statement.setInt(6, reimbursement.getAuthorUserId());
            statement.setInt(7, reimbursement.getResolverUserId());
            statement.setInt(8, reimbursement.getStatusId());
            statement.setInt(9, reimbursement.getTypeId());
            statement.setInt(10, reimbursement.getId());
            statement .execute();
            return true;



        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addReimbursement(Reimbursement reimbursement) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted," +
                    "reimb_description, reimb_author, reimb_status_id, reimb_type_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1, reimbursement.getAmount());
            statement.setTimestamp(2, reimbursement.getTimeSubmitted());
            statement.setString(3, reimbursement.getDescription());
            statement.setInt(4, reimbursement.getAuthorUserId());
            statement.setInt(5, reimbursement.getStatusId());
            statement.setInt(6, reimbursement.getTypeId());

            statement.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        //return false;
    }

    @Override
    public boolean deleteReimbursement(int reimbId) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, reimbId);
            statement.execute();

            return true;


        }catch (SQLException e){
            e.printStackTrace();

        }
        return false;



    }
}
