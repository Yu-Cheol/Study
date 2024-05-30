package net.daum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.vo.SampleVO;

@RestController
public class SampleController {

	@GetMapping("/jpa_start")
	public String jpa_start() {
		return "스프링 JPA 시작";//문자열 객체 반환
	}
	
	@RequestMapping("/sample")
	public SampleVO sample() {
		//반환타입이 SampleVO 이면 해당 빈클래스의 변수명이 json 데이터의 키이름이 된다.
		
		SampleVO vo=new SampleVO();
		
		vo.setVal01("val01 입니다.");
		vo.setVal02("val02 입니다.");
		vo.setVal03("val03 입니다.");
		
		System.out.println(vo.toString());
		
		return vo;
	}
}









