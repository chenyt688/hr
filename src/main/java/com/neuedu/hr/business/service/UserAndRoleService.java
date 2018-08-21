package com.neuedu.hr.business.service;

import com.neuedu.hr.business.dao.UserAndRoleDao;
import com.neuedu.hr.business.entity.UserAndRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAndRoleService {
    @Autowired
    private UserAndRoleDao userAndMenuDao;
    public void insertUserandRole(UserAndRole userAndRole){
        userAndMenuDao.insertUserandRole(userAndRole);
    }

}
