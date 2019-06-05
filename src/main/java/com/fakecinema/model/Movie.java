package com.fakecinema.model;

/**
 * Created by Vova on 08.04.2019.
 */
public class Movie {

    private int id;
    private String title;
    private String duration;
    private String description;

    public Movie (int id, String title, String duration, String description) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
    }

    public Movie (String title, String duration, String description) {
        this.title = title;
        this.duration = duration;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString () {
        return "id: " + this.id + "\n" +
                "title: " + this.title + "\n" +
                "duration: " + this.duration + "\n" +
                "description: " + this.description;
    }
}
