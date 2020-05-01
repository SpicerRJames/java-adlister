package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import models.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLUsersDao implements Users {

    private Connection connection;


    public MySQLUsersDao(Config config) throws SQLException{
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    public User findByUsername(String username) {
//        String sql = "SELECT * FROM users";
//        String userSearchTerm = "%" + findByUsername(sql) + "%";
//
//        PreparedStatement stmt =
        return null;
    }

    @Override
    public Long insert(User user) {
        return null;
    }
}
