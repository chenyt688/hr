package com.neuedu.hr.business.entity;

import java.util.List;

public class User {
    private int user_id;
    private String user_name;
    private String user_code;
    private String password;
    private char user_sexual;
    private String user_phone;
    private char del_flag;
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_code='" + user_code + '\'' +
                ", password='" + password + '\'' +
                ", user_sexual=" + user_sexual +
                ", user_phone='" + user_phone + '\'' +
                ", del_flag=" + del_flag +
                ", roleList=" + roleList +
                '}';
    }

    public User(int user_id, String user_name, String user_code, String password, char user_sexual, String user_phone, char del_flag, List<Role> roleList) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_code = user_code; //员工编号
        this.password = password;
        this.user_sexual = user_sexual;
        this.user_phone = user_phone;
        this.del_flag = del_flag;
        this.roleList = roleList;
    }

    public String getUser_code() {

        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getUser_sexual() {
        return user_sexual;
    }

    public void setUser_sexual(char user_sexual) {
        this.user_sexual = user_sexual;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public char getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(char del_flag) {
        this.del_flag = del_flag;
    }
}
