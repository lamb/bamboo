package com.yonyou.bamboo.model;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

    private long id;
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private String salt;

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}