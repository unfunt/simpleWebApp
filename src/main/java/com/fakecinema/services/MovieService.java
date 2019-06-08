package com.fakecinema.services;

import com.fakecinema.dao.MovieDao;
import com.fakecinema.dto.MovieDto;
import com.fakecinema.dto.UserDto;
import com.fakecinema.model.Movie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vova on 06.06.2019.
 */
public class MovieService {

    private static MovieService movieService = null;

    private MovieService () {

    }

    public static MovieService getInstance () {
        if (movieService == null) {
            movieService = new MovieService();
        }
        return movieService;
    }

    public List<MovieDto> getAll () {
        List<MovieDto> listMovies = new ArrayList<MovieDto>();
        MovieDao movieDao = new MovieDao();
        try {
            for (Movie movie: movieDao.getAll()) {
                listMovies.add(new MovieDto(movie));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMovies;
    }

    public MovieDto getById (int id) {
        MovieDto movieDto = null;
        MovieDao movieDao = new MovieDao();
        try {
            movieDto = new MovieDto(movieDao.getById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieDto;
    }

    public  void addMovie (MovieDto movieDto) {
        MovieDao movieDao = new MovieDao();
        try {
            movieDao.create(new Movie(movieDto.getTitle(), movieDto.getDuration(), movieDto.getDescription()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMovie (int id) {
        MovieDao movieDao = new MovieDao();
        try {
            movieDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMovie (int id, MovieDto movieDto) {
        MovieDao movieDao = new MovieDao();
        try {
            movieDao.update(id, new Movie(movieDto.getTitle(),
                    movieDto.getDuration(),
                    movieDto.getDescription()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
