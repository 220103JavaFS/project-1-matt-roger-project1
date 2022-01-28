//Not tested
package com.revature.DAOImp;

import com.revature.DAO.ReimbStatusDAO;
import com.revature.Models.ReimbStatus;
import com.revature.Models.ReimbType;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.Status;
import com.revature.utils.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbStatusDAOImpl implements ReimbStatusDAO {


    @Override
    public List<ReimbStatus> getAllStatus() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement_status;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<ReimbStatus> list = new ArrayList<ReimbStatus>();
            ReimbStatus status = new ReimbStatus();



            while (result.next()){
                status.setReimbStatusID(result.getInt("reimb_status_id"));
                status.setStatus(Status.values()[result.getInt("reimb_status")]);
                list.add(status);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<ReimbStatus>();
    }

    @Override
    public ReimbStatus getStatisByID(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status_id = + " + id + ";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<ReimbStatus> list = new ArrayList<ReimbStatus>();
            ReimbStatus status = new ReimbStatus();



            while (result.next()){
                status.setReimbStatusID(result.getInt("reimb_status_id"));
                status.setStatus(Status.values()[result.getInt("reimb_status")]);
                list.add(status);
            }
            return status;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ReimbStatus();
    }

    @Override
    public boolean addStatus(ReimbStatus newStatus) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO ers_reimbursement_status (reimb_status_id, reimb_status)" +
                    "VALUES (?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, newStatus.getReimbStatusID());
            statement.setInt(2, newStatus.getStatus().ordinal());

            statement.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStatus(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM ers_reimbursement_status WHERE reimb_status_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            statement.execute();

            return true;
        }catch (SQLException e){
            e.printStackTrace();

        }
        return false;
    }
}
