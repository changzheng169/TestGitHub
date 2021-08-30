package com.qin.boot.controller;

import com.qin.boot.entity.User;
import com.qin.boot.service.UserService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * 修改密码
 */
@Controller
public class UpdatePwdController {
    @Autowired
    UserService userService;

    /**
     * @return 跳转到修改页面
     */
    @GetMapping("/updatepwd")
    public String updatePage(){
        return "/updatepwd";
    }

    /**
     * 修改密码
     * @param user
     * @param session
     * @param model
     * @return 返回页面
     */
    @PostMapping("/updatepwd")
    public String updatePwd(User user, HttpSession session,Model model){
            User loginUser = (User) session.getAttribute("loginUser");
            if(loginUser.getUserId()==user.getUserId()){
                userService.updateUser(user);
                session.invalidate();
                return "redirect:/login";
            }
            model.addAttribute("msg","登录与要修改密码的不是同一账号！");
            return "/updatepwd";
    }
}
