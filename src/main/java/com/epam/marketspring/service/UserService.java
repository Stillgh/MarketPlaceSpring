package com.epam.marketspring.service;

import com.epam.marketspring.domain.User;

public interface UserService {
    void addUser(User user);

    User getUserByUserName(String userName);

    boolean ifUserExists(String username);
}
