package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.daum.vo.ProductVO;

@Controller //@Controller 애노테이션을 추가하면 해당 클래스는 인터넷 웹에서 인식하는 스프링
//컨트롤러 클래스가 된다.
public class Sample5Controller {

	
	@GetMapping(value="/doJSON") //브라우저 주소창에서 직접 실행하는 get방식으로 접근하는
	//매핑주소 doJSON을 처리. 매핑주소란 url-pattern이라고도 하는대 브라우저 주소창에서 실행되는
	//주소값을 말한다.
	public @ResponseBody ProductVO doJSON() {
		/* 메서드명 리턴타입 앞에 @ResponseBody 애노테이션을 사용하면 브라우저에 키,값 쌍의
		 * JSON데이터를 만들 수 있다. 반환타입이 ProductVO 빈클래스이면 해당 클래스의 변수명이
		 * json데이터의 키이름이 된다.
		 */
		ProductVO p=new ProductVO("자동차","55000000");
		return p;
	}
}




