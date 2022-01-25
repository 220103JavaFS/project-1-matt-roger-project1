package com.revature.DAOImp;

import com.revature.DAO.UserDAO;
import com.revature.Models.User;
import com.revature.Models.UserDTO;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDAO {
    @Override
    public User findByUsername(String userName) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_users WHERE ers_username = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userName);

            ResultSet result = statement.executeQuery();

            User user = new User();

            if(result.next()){
                user.setUserID(result.getInt("ers_user_id"));
                user.setPassword(result.getString("ers_password"));
                user.setUsername(result.getString("ers_username"));
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
    public List<User> getUsers() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_users;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<User> list = new ArrayList<User>();
            User user = new User();

            while (result.next()){

                user.setUserID(result.getInt("ers_user_id"));
                user.setPassword(result.getString("ers_password"));
                user.setUsername(result.getString("ers_username"));
                user.setFirstName(result.getString("user_first_name"));
                user.setLastName(result.getString("user_last_name"));
                user.setEmail(result.getString("user_email"));
                user.setUserRoleId(result.getInt("user_role_id"));
                list.add(user);
            }
            return list;


        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<User>();

    }

    @Override
    public boolean addUser(User user) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);

//            int count = 0;
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getEmail());
            statement.setInt(6, user.getUserRoleId());

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
            String sql = "DELETE FROM ers_users WHERE ers_username = ?;";
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
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE ers_users SET ers_username = ?, ers_password = ?, user_first_name = ?, user_last_name = ?, user_email = ?, user_role_id = ? WHERE ers_username = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 1;
            statement.setString(count++, user.getUsername());
            statement.setString(count++, user.getPassword());
            statement.setString(count++, user.getFirstName());
            statement.setString(count++, user.getLastName());
            statement.setString(count++, user.getEmail());
            statement.setInt(count++, user.getUserRoleId());
            statement.setString(count++, user.getUsername());

            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
