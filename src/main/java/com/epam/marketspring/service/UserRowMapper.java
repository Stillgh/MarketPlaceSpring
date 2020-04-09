package com.epam.marketspring.service;

import com.epam.marketspring.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setAddress(resultSet.getString("address"));
        user.setEmail(resultSet.getString("email"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setUsername(resultSet.getString("username"));
        return user;
    }
}
