package com.neuedu.hr.business.service;

import com.neuedu.hr.business.dao.MenuDao;
import com.neuedu.hr.business.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuDao menuDao;
    public List<Menu> getAllMenu(){
        return menuDao.getAllMenu();
    }
}
