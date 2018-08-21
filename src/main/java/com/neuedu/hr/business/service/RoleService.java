package com.neuedu.hr.business.service;

import com.neuedu.hr.business.dao.RoleDao;
import com.neuedu.hr.business.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public List<Role> getAllRole(){
        return roleDao.getAllRole();
    }

    /*public List<Role> getRoleMenu(){
        return roleDao.getRoleMenu();
    }*/

    public List<Role> getRoleMenuByMulCondition(String role_code, String role_name) {
        return roleDao.getRoleMenuByMulCondition(role_code,role_name);
    }

    public void deleteRoleByRoleCode(String role_code){
        roleDao.deleteRoleByRoleCode(role_code);
    }
}
