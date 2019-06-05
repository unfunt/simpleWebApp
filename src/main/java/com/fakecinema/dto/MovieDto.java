package com.fakecinema.dto;

import com.fakecinema.dao.MovieDao;
import com.fakecinema.model.Movie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vova on 13.05.2019.
 */
public class MovieDto {

    private int id;
    private String title;
    private String duration;
    private String description;

    public MovieDto (Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.duration = movie.getDuration();
        this.description = movie.getDescription();
    }

    public MovieDto () {

    }

    public List<MovieDto> getAll () {
        List<MovieDto> listMovies = new ArrayList<MovieDto>();
        MovieDao movieDao = new MovieDao();
        try {
            List<Movie> movies = movieDao.getAll();
            for (Movie movie: movies) {
                listMovies.add(new MovieDto(movie));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMovies;
    }

    public MovieDto getById (int id) {
        MovieDto movie = null;
        MovieDao movieDao = new MovieDao();
        try {
            movie = new MovieDto(movieDao.getById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}
