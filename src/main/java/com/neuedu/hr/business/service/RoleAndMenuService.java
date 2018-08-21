package com.neuedu.hr.business.service;

import com.neuedu.hr.business.dao.RoleAndMenuDao;
import com.neuedu.hr.business.entity.RoleAndMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleAndMenuService {
    @Autowired
    private RoleAndMenuDao roleAndMenuDao;

    /**
     * 插入角色对应的权限信息
     * @param roleAndMenu
     */
    public void insertRoleAndMenu(RoleAndMenu roleAndMenu){
        roleAndMenuDao.insertRoleAndMenu(roleAndMenu);
    }
}
