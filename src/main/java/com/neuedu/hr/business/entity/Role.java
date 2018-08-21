package com.neuedu.hr.business.entity;

import java.util.List;

public class Role {
    private int role_id;
    private String role_name;
    private String role_code;
    private char del_flag;
    private List<Menu> menuList;

    public Role(int role_id, String role_name, String role_code, char del_flag, List<Menu> menuList) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_code = role_code;
        this.del_flag = del_flag;
        this.menuList = menuList;
    }

    public List<Menu> getMenuList() {
    
        return menuList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_code='" + role_code + '\'' +
                ", del_flag=" + del_flag +
                ", menuList=" + menuList +
                '}';
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Role() {
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public char getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(char del_flag) {
        this.del_flag = del_flag;
    }
}
