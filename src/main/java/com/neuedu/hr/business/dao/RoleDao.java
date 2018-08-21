package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RoleDao {
   List<Role> getAllRole();

    List<Role> getRoleMenuByMulCondition(String role_code, String role_name);

    void deleteRoleByRoleCode(String role_code);
}
