package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //@Controller 애너테이션을 추가하면 웹에서 인식하는 스프링 컨트롤러가 된다.
public class SampleController {

	@RequestMapping("/doA") //GET OR POST로 접근하는 doA매핑주소를 웹주소창에서
	//실행하게 한다.
	public void doA() {//리턴타입이 없는 void형이면 매핑주소인 doA가 뷰페이지 파일명이 된다.
		
		System.out.println("doA매핑주소가 실행되었다.");
	}
	
	@GetMapping("/doB") //@GetMapping 애노테이션은 get으로 접근할 때 doB매핑주소를 처리
	public ModelAndView doB() {
		
		ModelAndView bm=new ModelAndView();
		bm.setViewName("doB");//뷰페이지 파일명을 doB로 설정
		return bm;
	}
}



