package net.daum.controller;

import net.daum.pwdconv.PwdChange;
import net.daum.service.ShopService;
import net.daum.vo.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;

    /* 메인 페이지 */
    @GetMapping("/Index")
    public ModelAndView index() {

        ModelAndView m = new ModelAndView();
        m.setViewName("index");

        return m;
    }

    /* 로그인 페이지 */
    @GetMapping("/Login")
    public ModelAndView login() {

        ModelAndView m = new ModelAndView();
        m.setViewName("/join/shoplogin");

        return m;
    }

    /* 회원가입 페이지 */
    @GetMapping("/Join")
    public ModelAndView join() {

        ModelAndView m = new ModelAndView();
        m.setViewName("/join/shopjoin");

        return m;
    }

    /* 회원가입 저장 */
    @PostMapping("/JoinOK")
    public ModelAndView joinOK(ShopVO s) {

        s.setM_pwd(PwdChange.getPassWordToXEMD5String(s.getM_pwd()));
        this.shopService.insertMember(s);

        ModelAndView m = new ModelAndView();
        m.setViewName("redirect:/Login");

        return m;
    }

}
