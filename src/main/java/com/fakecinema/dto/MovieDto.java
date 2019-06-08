package com.fakecinema.dto;

import com.fakecinema.model.Movie;

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

    public MovieDto (String title, String duration, String description) {
        this.title = title;
        this.duration = duration;
        this.description = description;
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
