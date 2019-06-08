package com.fakecinema.dto;

import com.fakecinema.dao.UserDao;
import com.fakecinema.model.Role;
import com.fakecinema.model.User;

import java.sql.SQLException;

/**
 * Created by Vova on 05.06.2019.
 */
public class LoginDto {

    private String username;
    private String password;
    private Role role;

    public LoginDto (String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }
}
