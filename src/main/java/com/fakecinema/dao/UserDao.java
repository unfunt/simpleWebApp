package com.fakecinema.dao;

import com.fakecinema.datasource.DataSource;
import com.fakecinema.helper.Hash;
import com.fakecinema.model.Role;
import com.fakecinema.model.Sex;
import com.fakecinema.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vova on 11.04.2019.
 */
public class UserDao implements CrudDao<User> {

    public UserDao () {}

    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        String getAllUsersQuery = "select * from users";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAllUsersQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("secondName"),
                        resultSet.getString("username"),
                        resultSet.getString("pass"),
                        resultSet.getDate("birthDay").toLocalDate(),
                        resultSet.getString("eMail"),
                        Sex.valueOf(resultSet.getString("sex")),
                        Role.valueOf(resultSet.getString("role"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return users;
    }

    public User getById(int id) throws SQLException {
        User user = null;
        String getUserByIdQuery = "select * from users where id = ?";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getUserByIdQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("secondName"),
                        resultSet.getString("username"),
                        resultSet.getString("pass"),
                        resultSet.getDate("birthDay").toLocalDate(),
                        resultSet.getString("eMail"),
                        Sex.valueOf(resultSet.getString("sex")),
                        Role.valueOf(resultSet.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return user;
    }

    public User getByUsername (String username) throws SQLException {
        User user = null;
        String getByUsername = "select * from users where username = ?";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getByUsername);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User (resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("secondName"),
                        resultSet.getString("username"),
                        resultSet.getString("pass"),
                        resultSet.getDate("birthDay").toLocalDate(),
                        resultSet.getString("eMail"),
                        Sex.valueOf(resultSet.getString("sex")),
                        Role.valueOf(resultSet.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return user;
    }

    public boolean create(User item) throws SQLException {
        boolean result = false;
        String createUserQuery = "insert into users (firstName,secondName,username,pass,birthDay,eMail,sex,role) values (?,?,?,?,?,?,?,?)";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createUserQuery);
            preparedStatement.setString(1, item.getFirstName());
            preparedStatement.setString(2, item.getSecondName());
            preparedStatement.setString(3, item.getUsername());
            preparedStatement.setString(4, Hash.hashPass(item.getPassword()));
            preparedStatement.setDate(5, Date.valueOf(item.getBirthDay()));
            preparedStatement.setString(6, item.geteMail());
            preparedStatement.setString(7, item.getSex().name());
            preparedStatement.setString(8, item.getRole().name());
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return  result;
    }

    public boolean update(int id, User item) throws SQLException {
        boolean result = false;
        String updateUserQuery = "update users set firstName = ?, secondName = ?, username = ?, pass = ?, birthDay = ?, eMail = ?, sex = ?, role = ? where id = ?";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateUserQuery);
            preparedStatement.setString(1, item.getFirstName());
            preparedStatement.setString(2, item.getSecondName());
            preparedStatement.setString(3, item.getUsername());
            preparedStatement.setString(4, item.getPassword());
            preparedStatement.setDate(5, Date.valueOf(item.getBirthDay()));
            preparedStatement.setString(6, item.geteMail());
            preparedStatement.setString(7, item.getSex().name());
            preparedStatement.setString(8, item.getRole().name());
            preparedStatement.setInt(9, id);
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return result;
    }

    public boolean delete(int id) throws SQLException {
        boolean result = false;
        String deleteUserQuery = "delete from users where id = ?";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUserQuery);
            preparedStatement.setInt(1, id);
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return result;
    }
}
