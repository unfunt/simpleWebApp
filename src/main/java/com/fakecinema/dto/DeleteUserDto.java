package com.fakecinema.dto;

/**
 * Created by Vova on 07.06.2019.
 */
public class DeleteUserDto {

    private int id;
    private String username;

    public DeleteUserDto (int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
