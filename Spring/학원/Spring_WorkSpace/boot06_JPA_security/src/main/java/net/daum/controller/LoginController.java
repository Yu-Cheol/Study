package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping("/login") //사용자 로그인 페이지
	public ModelAndView login() {
		
		return new ModelAndView("login");//뷰페이지 경로가 /WEB-INF/views/
		//login.jsp
	}//login()
	
	@RequestMapping("/accessDenied") //403접근금지 에러가 났을때
	public void accessDenied() {
		
	}//accessDenied()
	
    @GetMapping("/logout") //로그아웃 페이지
    public void logout() {
    	
    }
}








