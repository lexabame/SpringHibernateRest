package com.alex.login.dao.model;

/**
 * Created by alejandro on 8/20/16.
 */

public class UserEntity {

    private Integer id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String role;

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }
}
