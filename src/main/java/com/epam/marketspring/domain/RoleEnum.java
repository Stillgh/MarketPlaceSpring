package com.epam.marketspring.domain;

        import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    USER,
    GUEST;

    @Override
    public String getAuthority() {
        return name();
    }
}
