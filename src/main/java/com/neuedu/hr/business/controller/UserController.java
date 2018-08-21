package com.neuedu.hr.business.controller;

import com.neuedu.hr.business.entity.Role;
import com.neuedu.hr.business.entity.User;
import com.neuedu.hr.business.entity.UserAndRole;
import com.neuedu.hr.business.service.RoleService;
import com.neuedu.hr.business.service.UserAndRoleService;
import com.neuedu.hr.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserAndRoleService userAndRoleService;
    @RequestMapping("/insertUser")
    public String insertUser(User user, HttpServletRequest request,String judgelable){
        System.out.println("judgelable"   +  "         "  +judgelable);
        if(judgelable.equals("insert")){
            String roles[] = request.getParameterValues("rolevalue");
            //System.out.println(roles.length+ "    " + user.toString());
            userService.insertUser(user);
            for (int i=0; i<roles.length;i++){
                UserAndRole userAndRole = new UserAndRole();
                userAndRole.setUser_code(user.getUser_code());
                userAndRole.setRole_code(roles[i]);
                userAndRoleService.insertUserandRole(userAndRole);
            }
            return "redirect:/user/queryUser";
        }
        return "redirect:/user/updateUser";
    }

    @RequestMapping("/queryUser")
    public String queryUser(Model model,HttpServletRequest request){
        String user_code = request.getParameter("usercode");
        String username = request.getParameter("username");
        String role_code = request.getParameter("rolecode");

        List<User> allUser = new ArrayList<User>();
        List<Role> allRole = roleService.getAllRole();      //将中文匹配角色对应的标识
        for (Role r:allRole){
            if (r.getRole_name().equals(role_code)){
                role_code = r.getRole_code();
                break;
            }
        }
        allUser = userService.queryUserByMulCondition(user_code,username,role_code);
        model.addAttribute("userList",allUser);
        return "userManage";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(String lable){   //lable为员工编号
        userService.deleteUser(lable);
        return "redirect:/user/queryUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/user/queryUser";
    }
}
