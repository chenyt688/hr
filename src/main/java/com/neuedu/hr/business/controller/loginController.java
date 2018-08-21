package com.neuedu.hr.business.controller;


import com.neuedu.hr.business.dao.RoleDao;
import com.neuedu.hr.business.entity.Menu;
import com.neuedu.hr.business.entity.Role;
import com.neuedu.hr.business.entity.User;
import com.neuedu.hr.business.service.MenuService;
import com.neuedu.hr.business.service.RoleService;
import com.neuedu.hr.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class loginController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String login(Model model,HttpServletRequest request){
        List<Role> allRole = roleService.getAllRole();
        HttpSession session  =request.getSession(true);
        session.setAttribute("roleListInfo",allRole);
        //model.addAttribute("roleListInfo", allRole);
        return "login";
    }
    @RequestMapping("/login")
    public String logintoIndex(User user, HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {

        String role_code = request.getParameter("type"); //获取登录类型
        //System.out.println(role_code);
        //判断用户是否存在
        System.out.println(user.toString());
        List<User> userByCondition = userService.getUserByCondition(user.getUser_name(),user.getPassword(),role_code);
        HttpSession session = request.getSession(true);
        if (userByCondition.size() != 0){  //登录的用户账号密码存在
            model.addAttribute("firstMenu",userByCondition.get(0).getRoleList().get(0).getMenuList().get(0));
            session.setAttribute("principal", userByCondition);
            return "index";
        }
            return "login";

    }
}
