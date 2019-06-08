package com.fakecinema.dto;

import com.fakecinema.model.Role;
import com.fakecinema.model.Sex;
import com.fakecinema.model.User;

import java.time.LocalDate;

/**
 * Created by Vova on 07.06.2019.
 */
public class UserDto {

    private int id;
    private String firstName;
    private String secondName;
    private String username;
    private String password;
    private LocalDate birthDay;
    private String eMail;
    private Sex sex;
    private Role role;

    public UserDto (String firstName, String secondName, String username,
                    String password, LocalDate birthDay, String eMail, Sex sex, Role role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
        this.birthDay = birthDay;
        this.eMail = eMail;
        this.sex = sex;
        this.role = role;
    }

    public UserDto (String firstName, String secondName, String username,
                    LocalDate birthDay, Sex sex, Role role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = null;
        this.birthDay = birthDay;
        this.eMail = null;
        this.sex = sex;
        this.role = role;
    }

    public UserDto (User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.username = user.getUsername();
        this.birthDay = user.getBirthDay();
        this.eMail = user.geteMail();
        this.sex = user.getSex();
        this.role = user.getRole();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String geteMail() {
        return eMail;
    }

    public Sex getSex() {
        return sex;
    }

    public Role getRole() {
        return role;
    }

    public int getId() {
        return id;
    }
}
