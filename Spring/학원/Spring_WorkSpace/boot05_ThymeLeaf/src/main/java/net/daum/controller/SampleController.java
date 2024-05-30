package net.daum.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import net.daum.vo.MemberVO;

@Controller
public class SampleController {

	@GetMapping(value="/thymeLeaf_begin")
	public ModelAndView thymeLeaf_begin() {
		
		ModelAndView tm=new ModelAndView();
		tm.addObject("greeting", "방갑습니다.타임리프");
		tm.setViewName("./thymeLeaf/thymeLeaf_begin");
		//타임리프 뷰페이지 경로 /src/main/resources/templates/thymeLeaf/
		//thymeLeaf_begin.html
		
		return tm;
	}//thymeLeaf_begin()
	
	@RequestMapping("/listTest") //get or post로 접근하는 매핑주소를 처리
	//listTest 매핑주소 등록
	public void listTest(Model model) {
		//리턴타입이 없는 void형이면 매핑주소가 뷰페이지 파일명이 된다.
		
		List<String> list=new ArrayList<>();
		
		for(int i=1;i<=10;i++) {
			list.add("Data : "+i);//컬렉션에 문자열 원소값 추가			
		}//for
		
		model.addAttribute("name", "타임리프 연습");
		model.addAttribute("list", list);
	}//listTest()
	
	@GetMapping("/sample02")
	public void sample02(Model m) {
		MemberVO vo = new MemberVO(123,"u00","p00","홍길동",
				new Timestamp(System.currentTimeMillis()));
		
		m.addAttribute("vo", vo);
	}//sample02()
	
	@GetMapping("/sample03")
	public void sample03(HttpServletRequest request) {
		
		List<MemberVO> list = new ArrayList<>();
		
		for(int i=0;i<10;i++) {
			list.add(new MemberVO(123+1,"u0"+i, "p0"+i,"홍길동"+i,
					new Timestamp(System.currentTimeMillis())));
		}//for
		
        request.setAttribute("list", list);		
	}//sample03()
	
	
	@GetMapping("/sample04")
	public void sample04(Model model) {
       
		List<MemberVO> list = new ArrayList<>();
		
		for(int i=0;i<10;i++) {
			list.add(new MemberVO(i+1, "u000"+ i%3, "p0000"+i%3,
				"홍길동"+ (i+1),new Timestamp(System.currentTimeMillis())));
		}//for
		
		model.addAttribute("list", list);
	}//sample04()
	
	@GetMapping("/sample05")
	public void sample05(Model model) {
		
		String result = "SUCCESS";
		model.addAttribute("result", result);
	}//sample05()
	
	@GetMapping("/sample06")
	public ModelAndView sample06() {
		
		List<MemberVO> list=new ArrayList<>();
		
		for(int i=1;i<=7;i++) {
			list.add(new MemberVO(i,"u0"+i,"pw0"+i, "홍길동"+i,
					new Timestamp(System.currentTimeMillis())));
		}//for
		
		ModelAndView model=new ModelAndView("sample06");//생성자 인자값으로
		//타임리프 뷰페이지 파일명을 지정. sample06.html
		model.addObject("list", list);//list키이름에 list컬렉션 저장
		
		String result="success";
		model.addObject("result", result);
		return model;
	}//sample06()
	
	@RequestMapping(value="/sample07" ,method=RequestMethod.GET)
	//GET으로 접근하는 sample07 매핑주소를 처리
	public String sample07(HttpServletRequest request) {
		
		request.setAttribute("now", new Date());//now키이름에 날짜 객체 저장
		request.setAttribute("price", 123456789);
		request.setAttribute("title", "This is a just sample.");
		request.setAttribute("options", 
				Arrays.asList("AAA","BBB","CCC"));//Arrays.asList()는 배열을
		//컬렉션 List로 변환
		
		return "result07";//타임리트 뷰페이지 파일명이 result07.html 이 된다.
	}
}





















































