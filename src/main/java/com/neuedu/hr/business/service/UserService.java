package com.neuedu.hr.business.service;

import com.neuedu.hr.business.dao.UserDao;
import com.neuedu.hr.business.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

    /**
     * 根据用户数据(用户名，密码)，登录类型，判断该用户的账号是否存在
     * @return
     */
    public List<User> getUserByCondition(String username,String password,String role_code){
        return userDao.getUserByCondition(username,password,role_code);
    }

    /**
     * 插入用户数据
     * @param user
     */
    public void insertUser(User user){
        userDao.insertUser(user);
    }

    /**
     * 通过用户编号逻辑删除用户数据
     * @param user_code
     */
    public void deleteUser(String user_code){
        userDao.deleteUser(user_code);
    }


    /**
     * 修改用户数据
     * @param user
     */
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    /**
     * 多条件查询用户数据
     * @param user_code
     * @param user_name
     * @param role_code
     * @return
     */
    public List<User> queryUserByMulCondition(String user_code,String user_name,String role_code){
        return userDao.queryUserByMulCondition(user_code,user_name,role_code);
    }

}
