package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test2")
	public void test2() {
		
		System.out.println("test입니다.");		
	}
}
