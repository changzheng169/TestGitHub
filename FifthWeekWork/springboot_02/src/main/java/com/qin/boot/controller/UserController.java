package com.qin.boot.controller;

import com.qin.boot.entity.User;
import com.qin.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping ("/getUser")
    public Object examineUser(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException, JSONException {
        User user = userService.getUser(username, password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",user);
        String str=jsonObject.toString();
        String html="<h1 align='center'>"+str+"</h1>";
        if(user!=null){
            return html;
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
        requestDispatcher.forward(request,response);
        return null;
    }
}
