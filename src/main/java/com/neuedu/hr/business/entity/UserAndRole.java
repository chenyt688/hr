package com.neuedu.hr.business.entity;

public class UserAndRole {
    private String user_code;
    private String role_code;
    private char own;

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public char getOwn() {
        return own;
    }

    public void setOwn(char own) {
        this.own = own;
    }

    public UserAndRole() {

    }

    public UserAndRole(String user_code, String role_code, char own) {

        this.user_code = user_code;
        this.role_code = role_code;
        this.own = own;
    }
}
