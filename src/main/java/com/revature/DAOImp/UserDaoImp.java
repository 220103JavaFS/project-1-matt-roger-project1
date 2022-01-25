package com.revature.DAOImp;

import com.revature.DAO.UserDAO;
import com.revature.Models.User;
import com.revature.Models.UserDTO;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ConcurrentModificationException;

public class UserDaoImp implements UserDAO {
    @Override
    public User findByUsername(String userName) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users WHERE username = "+ userName +";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            User user = new User();

            while (result.next()){
                user.setUserID(result.getInt("user_id"));
                user.setFirstName(result.getString("user_first_name"));
                user.setLastName(result.getString("user_last_name"));
                user.setEmail(result.getString("user_email"));
                user.setUserRoleId(result.getInt("user_role_id"));
            }
            return user;


        }catch (SQLException e){
            e.printStackTrace();
        }
        return new User();

    }

    @Override
    public User[] getUsers() {
        return new User[0];





    }

    @Override
    public boolean addUser(User newUser) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO user ( ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(count++, newUser.getUsername());
            statement.setString(count++, newUser.getPassword());
            statement.setString(count++, newUser.getFirstName());
            statement.setString(count++, newUser.getLastName());
            statement.setString(count++, newUser.getEmail());
            statement.setInt(count++, newUser.getUserRoleId());

            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

//    @Override
//    public UserDTO login(String username) {
//
//
//
//
//
//
//        return null;
//    }

    @Override
    public boolean deleteUser(String username){
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE * FROM users WHERE ers_username = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, username);
            statement.execute();

            return true;


        }catch (SQLException e){
            e.printStackTrace();
        }



        return false;}

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
