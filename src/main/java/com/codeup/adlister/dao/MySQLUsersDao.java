package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import models.Config;

import java.sql.*;

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

        return null;
    }


    public Long insert(Ad ad) {
        long id = -1;
        try {
            PreparedStatement stmt = connection.prepareStatement(getInsertQueay(), Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
        return id;
    }
    private String getInsertQueay() {
        return null;
    }

    @Override
    public Long insert(User user) {
        return null;
    }
}
