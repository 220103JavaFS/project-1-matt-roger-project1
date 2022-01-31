
//NOT TESTED



package com.revature.DAOImp;

import com.revature.DAO.ReimbTypeDAO;
import com.revature.Models.ReimbType;
import com.revature.Models.Reimbursement;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbTypeDAOImpl implements ReimbTypeDAO {
    @Override
    public List<ReimbType> getAllTypes() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement_type;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<ReimbType> list = new ArrayList<ReimbType>();
            ReimbType type = new ReimbType();

            while (result.next()){
                type.setId(result.getInt("reimb_type_id"));
                type.setType(Type.values()[result.getInt("reimb_type")]);
                list.add(type);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<ReimbType>();
    }

    @Override
    public ReimbType getTypeByID(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement_type WHERE reimb_type_id = + " + id + ";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<ReimbType> list = new ArrayList<ReimbType>();
            ReimbType type = new ReimbType();

            while (result.next()){
                type.setId(result.getInt("reimb_type_id"));
                type.setType(Type.values()[result.getInt("reimb_type")]);
                list.add(type);
            }
            return type;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ReimbType();
    }

    @Override
    public boolean addType(ReimbType newType) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)" +
                    "VALUES (?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, newType.getId());
            statement.setInt(2, newType.getType().ordinal());

            statement.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteType(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM ers_reimbursement_type WHERE reimb_type_id = ?;";
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
