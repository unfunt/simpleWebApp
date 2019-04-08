package com.fakecinema.dao;

import com.fakecinema.datasource.DataSource;
import com.fakecinema.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vova on 02.04.2019.
 */
public class MovieDao {

    private String addMovieQuery = "insert into movies (title, duration, description) values (?, ?, ?)";
    private String getAllMoviesQuery = "select * from movies";

    public MovieDao () {}

    public void addMovie (Movie movie) throws SQLException {
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addMovieQuery);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDuration());
            preparedStatement.setString(3, movie.getDescription());
            boolean result = preparedStatement.execute();
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public List<Movie> getAllMovies () throws SQLException {
        List<Movie> movies = new ArrayList<Movie>();
        DataSource dataSource = DataSource.getInstance();
        Connection connection = dataSource.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllMoviesQuery);
            while (resultSet.next()) {
                Movie movie = new Movie(resultSet.getString("title"),
                        resultSet.getString("duration"),
                        resultSet.getString("description"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return movies;
    }
}
