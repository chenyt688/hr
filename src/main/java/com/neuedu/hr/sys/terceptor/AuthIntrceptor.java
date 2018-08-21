package com.neuedu.hr.sys.terceptor;

import com.neuedu.hr.business.entity.Menu;
import com.neuedu.hr.business.entity.User;
import com.neuedu.hr.sys.annotation.RequirePremission;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

public class AuthIntrceptor extends HandlerInterceptorAdapter {
    /**
     * 权限控制拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //RequirePremission annotation = method.getAnnotation(RequirePremission.class);

        HttpSession session = request.getSession(false);
        //判断session是否为空，如果是空，代表肯定没登录，直接冲重定向到login界面
        if (session != null){
            User user = (User) session.getAttribute("principal");
            if (user != null){
                System.out.println("Sfdf;skfo;sdf;sd");
                for (Menu m:user.getRoleList().get(0).getMenuList()){
                    System.out.println("拦截器中"+m.getMenu_name());
                }
                return true;
            }else {
                session.invalidate();
            }
        }
        response.sendRedirect(request.getContextPath()+"/views/login.html");
        return false;
    }



}






















