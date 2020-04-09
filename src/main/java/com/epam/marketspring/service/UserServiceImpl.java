package com.epam.marketspring.service;

import com.epam.marketspring.domain.RoleEnum;
import com.epam.marketspring.domain.User;
import com.epam.marketspring.dao.QueryUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private QueryUserInterface queryUserInterface;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void addUser(User user) {
        Set<RoleEnum> myRoles = new HashSet<RoleEnum>();
        myRoles.add(RoleEnum.USER);
        user.setRoles(myRoles);
        queryUserInterface.saveUser(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        return queryUserInterface.getUserByUsername(userName);
    }

    @Override
    public boolean ifUserExists(String username) {
        return queryUserInterface.ifUserExists(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (ifUserExists(username)) {
            User user = getUserByUserName(username);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return user;
        } else {
            return new User();
        }
    }
}
