package net.daum.controller;

import net.daum.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/MemberJoin")
    public String member_join(Model m){

        String[] phone = {"010","011"};

        m.addAttribute("phone",phone);

        return "/join/CreateID";
    }
}
