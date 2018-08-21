package com.neuedu.hr.business.entity;

public class Menu {
    private int menu_id;
    private String menu_code;
    private String menu_name;
    private String menu_url;
    private char del_flag;

    public Menu() {
    }

    public Menu(int menu_id, String menu_code, String menu_name, String menu_url, char del_flag) {
        this.menu_id = menu_id;
        this.menu_code = menu_code;
        this.menu_name = menu_name;
        this.menu_url = menu_url;
        this.del_flag = del_flag;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_code() {
        return menu_code;
    }

    public void setMenu_code(String menu_code) {
        this.menu_code = menu_code;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public char getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(char del_flag) {
        this.del_flag = del_flag;
    }
}
