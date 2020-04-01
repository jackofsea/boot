package com.huanhai.bootmain.controllers;

import com.huanhai.bootmain.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/login")
     public String login(String username, String pwd){
        System.out.println(username+" "+pwd+(redisUtil.get("name")));

         return "index";
     }
    @RequestMapping(value = "/logOut",produces = "text/html;charset=utf-8")
    public @ResponseBody String logOut(){
        return "退出成果";
    }
}
