package com.fakecinema.dto;

import com.fakecinema.dao.UserDao;
import com.fakecinema.model.User;

import java.sql.SQLException;

/**
 * Created by Vova on 05.06.2019.
 */
public class LoginDto {

    private String username;
    private String password;

    public LoginDto () {}

    public LoginDto (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginDto getByUsername (String username) {
        LoginDto loginDto = null;
        UserDao userDao = new UserDao();
        try {
            User user = userDao.getByUsername(username);
            loginDto = new LoginDto(user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginDto;
    }

    public String getPassword() {
        return password;
    }
}
