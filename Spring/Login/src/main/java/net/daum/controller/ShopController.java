package net.daum.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.daum.pwdconv.PwdChange;
import net.daum.service.ShopService;
import net.daum.vo.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;

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
    }// index

    /* 로그인 페이지 */
    @GetMapping("/Login")
    public ModelAndView login() {

        ModelAndView m = new ModelAndView();
        m.setViewName("/join/shoplogin");

        return m;
    }// login

    /* 회원가입 페이지 */
    @GetMapping("/Join")
    public ModelAndView join() {

        ModelAndView m = new ModelAndView();
        m.setViewName("/join/shopjoin");

        return m;
    }// join

    /* 회원가입 저장 */
    @PostMapping("/JoinOK")
    public ModelAndView joinOK(ShopVO s) {

        s.setM_pwd(PwdChange.getPassWordToXEMD5String(s.getM_pwd()));
        s.setM_pwdC(PwdChange.getPassWordToXEMD5String(s.getM_pwdC()));
        this.shopService.insertMember(s);

        ModelAndView m = new ModelAndView();
        m.setViewName("redirect:/Login");

        return m;
    }// joinOK

    /* 로그인 인증 */
    @PostMapping("/LoginOK")
    public String loginOK(String user_id, String user_pwd, HttpSession session, HttpServletResponse response) throws Exception{

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        /* 아이디와 m_state=1 인 경우만 로그인 인증 처리 */
        ShopVO s = this.shopService.loginCheck(user_id);

        if(s == null){
            out.println("<script>");
            out.println("alert('등록이 안된 아이디 입니다');");
            out.println("history.back();");
            out.println("</script>");
        }else{
            if(!s.getM_pwd().equals(PwdChange.getPassWordToXEMD5String(user_pwd))){
                out.println("<script>");
                out.println("alert('비밀번호가 다릅니다');");
                out.println("history.back();");
                out.println("</script>");
            }else{
                session.setAttribute("id", user_id);
                return "redirect:/Login";
            }// if ~ else
        }// if ~ else
        return null;
    }// LoginOK

}
