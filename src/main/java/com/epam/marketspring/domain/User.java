package com.epam.marketspring.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;


public class User implements UserDetails, Serializable {


    private int id;

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String address;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,12}$")
    private String password;


    private Set<RoleEnum> roles;

    public User() {
    }

    public User(String name, String address, String email, String username,
                String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", login='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
