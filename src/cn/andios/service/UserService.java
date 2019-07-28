package cn.andios.service;

import cn.andios.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    public String getUserPwdByUsername(String username){
        Connection connection = UserDao.getConn();
        String password = null;
        String sql = "select * from user where  username = ?";
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                password = resultSet.getString("password");
            }
            return password;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
