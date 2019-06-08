package com.fakecinema.services;

import com.fakecinema.dao.MovieDao;
import com.fakecinema.dao.UserDao;
import com.fakecinema.dto.DeleteUserDto;
import com.fakecinema.dto.LoginDto;
import com.fakecinema.dto.UserDto;
import com.fakecinema.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vova on 06.06.2019.
 */
public class UserService {

    private static UserService userService = null;

    private UserService () {

    }

    public static UserService getInstance () {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public LoginDto getByUsername (String username) {
        LoginDto loginDto = null;
        UserDao userDao = new UserDao();
        try {
            User user = userDao.getByUsername(username);
            loginDto = new LoginDto(user.getUsername(), user.getPassword(), user.getRole());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginDto;
    }

    public void addUser (UserDto userDto) {
        UserDao userDao = new UserDao();
        User user = new User(userDto.getFirstName(),
                userDto.getSecondName(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getBirthDay(),
                userDto.geteMail(),
                userDto.getSex(),
                userDto.getRole());
        try {
            userDao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DeleteUserDto> getAllUsersToDelete () {
        List<DeleteUserDto> listUsers = new ArrayList<>();
        UserDao userDao = new UserDao();
        try {
            for (User user: userDao.getAll()) {
                listUsers.add(new DeleteUserDto(user.getId(),
                        user.getUsername()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }

    public void deleteUser (int id) {
        UserDao userDao = new UserDao();
        try {
            userDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserDto> getAll () {
        List<UserDto> listUsers = new ArrayList<>();
        UserDao userDao = new UserDao();
        try {
            for (User user: userDao.getAll()) {
                listUsers.add(new UserDto(user));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }

    public UserDto getById (int id) {
        UserDto userDto = null;
        UserDao userDao = new UserDao();
        try {
            userDto = new UserDto(userDao.getById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDto;
    }

    public void updateUser (int id, UserDto userDto) {
        UserDao userDao = new UserDao();
        try {
            userDao.update(id, new User(userDto.getFirstName(),
                    userDto.getSecondName(),
                    userDto.getUsername(),
                    userDto.getPassword(),
                    userDto.getBirthDay(),
                    userDto.geteMail(),
                    userDto.getSex(),
                    userDto.getRole()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
