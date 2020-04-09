package com.epam.marketspring.dao;

import com.epam.marketspring.domain.User;
import com.epam.marketspring.service.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class QueryUserDAO extends JdbcDaoSupport implements QueryUserInterface {


    @Autowired
    public QueryUserDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public void saveUser(User user) {

        String query = "INSERT INTO forspringdb.user(id, name, address, email, username, password) "
                + "VALUES(?,?,?,?,?,?)";

        this.getJdbcTemplate().update(query, preparedStatement -> {
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getUsername());
            preparedStatement.setString(6, user.getPassword());
        });

    }

    public boolean ifUserExists(String username) {
        String query = "select count(*) from forspringdb.user where username = ?";

        boolean exists;

        int count = this.getJdbcTemplate().queryForObject(query, new Object[]{username}, Integer.class);
        exists = count > 0;
        return exists;
    }

    public User getUserByUsername(String username) {
        String query = "select * from forspringdb.user where username = ?";
        User userFromDB = this.getJdbcTemplate().queryForObject(query, new Object[]{username}, new UserRowMapper());
        return userFromDB;
    }

}


