package com.fakecinema.dao;

import com.fakecinema.datasource.DataSource;
import com.fakecinema.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vova on 02.04.2019.
 */
public class MovieDao implements CrudDao<Movie> {

    public MovieDao () {}

    public List<Movie> getAll() throws SQLException {
        String getAllMoviesQuery = "select * from movies";
        List<Movie> movies = new ArrayList<Movie>();
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAllMoviesQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movies.add(new Movie(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("duration"),
                        resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return movies;
    }

    public Movie getById (int id) throws SQLException {
        Movie movie = null;
        String getByIdQuery = "select * from movies where id = ?";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getByIdQuery);
            preparedStatement.setString(1, Integer.toString(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movie = new Movie(id,
                        resultSet.getString("title"),
                        resultSet.getString("duration"),
                        resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return movie;
    }

    public boolean create (Movie movie) throws SQLException {
        boolean result = false;
        String createQuery = "insert into movies (title,duration,description) values (?,?,?)";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDuration());
            preparedStatement.setString(3,movie.getDescription());
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return result;
    }

    public boolean update (int id, Movie movie) throws SQLException {
        boolean result = false;
        String updateQuery = "update movies set title = ?, duration = ?, description = ? where id = ?";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDuration());
            preparedStatement.setString(3, movie.getDescription());
            preparedStatement.setInt(4, id);
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return result;
    }

    public boolean delete (int id) throws SQLException {
        boolean result = false;
        String deleteQuery = "delete from movies where id = ?";
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, Integer.toString(id));
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return result;
    }
}
