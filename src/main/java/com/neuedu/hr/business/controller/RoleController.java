package com.neuedu.hr.business.controller;

import com.neuedu.hr.business.entity.Menu;
import com.neuedu.hr.business.entity.Role;
import com.neuedu.hr.business.service.MenuService;
import com.neuedu.hr.business.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;


    @RequestMapping("/queryRole")
    public String queryRole(Model model, HttpServletRequest request){
        String role_code = request.getParameter("rolecode");
        String role_name = request.getParameter("rolename");

        //System.out.println("-------->" + role_code + role_name);
        List<Role> allRole = roleService.getRoleMenuByMulCondition(role_code,role_name);   //角色信息和菜单权限信息
        //获取数据库中所有的菜单数据
        List<Menu> menuList = menuService.getAllMenu();
        model.addAttribute("roleList",allRole);
        model.addAttribute("menuList",menuList);
        return "roleManage";
    }
    @RequestMapping("/insertRole")
    public String insertRole(Model model,HttpServletRequest request){
        String menus[] = request.getParameterValues("menuvalue");
        for (int i=0;i<menus.length;i++){
            System.out.println(menus[i]);
        }
        List<Menu> allMenu = menuService.getAllMenu();
        return "redirect:/role/queryRole";
    }
    @RequestMapping("/updateRole")
    public String updateRole(Model model,HttpServletRequest request){

        return "redirect:/role/queryRole";
    }

    @RequestMapping("/deleteRole")
    public String deleteRole(String lable){
        roleService.deleteRoleByRoleCode(lable);
        return "redirect:/role/queryRole";
    }

}
