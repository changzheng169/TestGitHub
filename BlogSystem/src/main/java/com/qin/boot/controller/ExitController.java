package com.qin.boot.controller;

import com.qin.boot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * 退出登录
 */
@Controller
public class ExitController {
    @GetMapping("/exit")
    public String exitSystem(HttpSession session){
        //手动注销session中的值
        session.invalidate();
        return "redirect:/login";
    }
}
