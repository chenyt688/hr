package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface UserDao {
    List<User> getAllUser();

    List<User> getUserByCondition(@Param("user_name") String username,@Param("password") String password,@Param("role_code") String role_code);
    void insertUser(User user);

    void deleteUser(String user_code);

    void updateUser(User user);

    List<User> queryUserByMulCondition(String user_code, String user_name, String role_code);
}
