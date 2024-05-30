package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Sample4Controller {

	@RequestMapping("/doE") //doE 매핑주소 등록
	public String doE(RedirectAttributes rttr) {
		rttr.addFlashAttribute("msg","다른 매핑주소로 이동 성공~");
		/* 백엔드 서버단에서 다른 매핑주소로 이동시 msg키이름에 값을 담아서 전달한다. 서버상에서
		 * 실행되기 때문에 웹주소창에 전달되어지는 값이 노출 안된다. 보안상 좋다.
		 */
		return "redirect:/doF";//레코드 저장,수정,삭제후 변경된 값을 정확히 확인하고자 다른
		//매핑주소로 이동시 사용한다. 이런경우 스프링에서는 "redirect:/매핑주소" 형식을 사용한다.
		//그리고 redirect:/매핑주소로 이동하는 방식도 get방식이다.
	}
	
	@GetMapping("/doF") //GET으로 접근하는 doF매핑주소를 처리
	public void doF(@ModelAttribute("msg") String name,Model m) {
		//리턴타입이 없는 void형이면 doF매핑주소가 뷰페이지 파일명이 된다. msg키이름 값을 가져
		//와서 name매개변수에 저장
		System.out.println("msg피라미터값:"+name);
		m.addAttribute("name", name);//name키이름에 값 저장
	}
}
