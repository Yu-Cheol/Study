package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {

    /* Index Page */
    @GetMapping("/Index")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");
        return mv;
    }

    /* Login Page */
    @GetMapping("/Login")
    public String login(){



        return "join/login";
    }

    @PostMapping("/Join")
    public String join(Model m) {

        String[] phone = {"010", "011"};
        String[] email = {"naver.com", "daum.net", "google.com", "직접입력"};

        m.addAttribute("phone", phone);
        m.addAttribute("email", email);


        return "join/CreateID";
    }
}
