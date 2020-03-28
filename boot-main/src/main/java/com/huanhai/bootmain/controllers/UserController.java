package com.huanhai.bootmain.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
     public String login(String username, String say){
        System.out.println(username+" "+say);
         return "index";
     }
    @RequestMapping(value = "/logOut",produces = "text/html;charset=utf-8")
    public @ResponseBody String logOut(){
        return "退出成果";
    }
}
