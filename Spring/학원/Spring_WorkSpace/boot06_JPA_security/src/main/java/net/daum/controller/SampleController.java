package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@Log
public class SampleController {

	@GetMapping("/")
	public String index() {
		
		log.info("index.jsp로 이동");
		return "index"; //뷰리졸브 경로는 /WEB-INF/views/index.jsp
	}//index()
	
	@RequestMapping("/guest")
    public void guest() {//리턴타입이 없는 void형이면 매핑주소가 뷰페이지 파일명이 된다.
		
		log.info("guest.jsp로 이동");
	}//guest
	
	@RequestMapping("/manager")
	public void forManager() {
		
		log.info("manager.jsp로 이동");
	}//manager
	
	@RequestMapping("/admin")
	public void forAdmin() {
		
		log.info("admin.jsp로 이동");
	}//admin	
}





