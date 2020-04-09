package com.epam.marketspring.dao;

import com.epam.marketspring.domain.User;

public interface QueryUserInterface {
    void saveUser(User user);

    boolean ifUserExists(String username);

    User getUserByUsername(String username);
}
