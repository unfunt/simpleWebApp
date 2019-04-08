package com.fakecinema.model;

/**
 * Created by Vova on 08.04.2019.
 */
public class Movie {

    private String title;
    private String duration;
    private String description;
    public Movie (String title, String duration, String description) {
        setTitle(title);
        setDuration(duration);
        setDescription(description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
