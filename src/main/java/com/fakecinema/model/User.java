package com.fakecinema.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Vova on 10.04.2019.
 */
public class User {

    private int id;
    private String firstName;
    private String secondName;
    private String username;
    private String password;
    private LocalDate birthDay;
    private String eMail;
    private Sex sex;
    private Role role = Role.USER;

    public User (int id, String firstName, String secondName, String username,
                 String password, LocalDate birthDay, String eMail, Sex sex, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
        this.birthDay = birthDay;
        this.eMail = eMail;
        this.sex = sex;
        this.role = role;
    }

    public User (String firstName, String secondName, String username,
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

    public User (String firstName, String secondName, String username,
                 String password, LocalDate birthDay, String eMail, Sex sex) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
        this.birthDay = birthDay;
        this.eMail = eMail;
        this.sex = sex;
    }

    public int getId () {
        return this.id;
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

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "firstName: " + this.firstName + "\n" +
                "secondName: " + this.secondName + "\n" +
                "username: " + this.username + "\n" +
                "birthDay: " + this.birthDay.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n" +
                "eMail: " + this.eMail + "\n" +
                "sex: " + this.sex.name() + "\n" +
                "role: " + this.role.name();
    }
}
