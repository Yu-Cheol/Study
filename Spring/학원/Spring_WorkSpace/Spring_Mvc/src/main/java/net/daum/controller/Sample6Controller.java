package net.daum.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.vo.SampleVO;

@RestController //스프링 4.0 이후 부터는 @RestController 애너테이션이 추가되어져서
//jsp같은 뷰페이지를 만들지 않고도 REST API 방식의 데이터를 처리할 수 있는 프로그램을 만들 수
//있다. 만들어지는 데이터 객체는 문자열(String),xml, JSON(키,값 쌍의 영어 사전적인 자료구조)이다.
public class Sample6Controller {

	@GetMapping(value="/rest_start") //get으로 접근하는 rest_start 매핑주소 처리
	public String rest_Start() {
		return "Rest Api 프로그램 시작";//문자열 객체 반환
	}//rest_Start()
	
	@RequestMapping("/sendVO") //GET OR POST 방식으로 접근하는 sendVO 매핑주소 처리
	public SampleVO sendVO() {
		//메서드 리턴타입이 SampleVO 타입이면 빈클래스 변수명이 json데이터의 키이름이 된다.
		
		SampleVO vo=new SampleVO();
		vo.setMno(10);
		vo.setFirstName("홍");
		vo.setLastName("길동");
		
		return vo;
	}//sendVO()
	
	@GetMapping("/sendList")
	public List<SampleVO> sendList(){
		List<SampleVO> list=new ArrayList<>();
		
		for(int i=1;i<=3;i++) {
			SampleVO vo=new SampleVO();
			
			vo.setMno(i);
			vo.setFirstName("홍");
			vo.setLastName("길동");
			
			list.add(vo);//컬렉션에 추가
		}
		
		return list;
	}//sendList()
	
	//키,값 쌍의 Map 타입 JSON
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap(){
         Map<Integer, SampleVO> map=new HashMap<>();	
         
         for(int i=3;i>=1;i--) {
        	 SampleVO vo=new SampleVO();
        	 
        	 vo.setMno(i);
        	 vo.setFirstName("홍");
        	 vo.setLastName("길동");
        	 
        	 map.put(i, vo);//키,값 쌍으로 저장
         }
         
         return map;
	}//sendMap()
	
	@GetMapping("/sendError")
	public ResponseEntity<Void> sendListAuth(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		/* @RestController 애노테이션을 사용한 REST API 프로그램 개발에서는 별도의 jsp
		 * 와 같은 뷰페이지를 만들지 않고도 원하는 json데이터가 만들어지기 때문에 예외적인 오류
		 * 상황에서 스프링에서 제공하는 api인 ResponseEntity타입을 사용하면 에러가 발생했을때
		 * 나쁜상태 코드 400,500등이 브라우저로 전송되기 때문에 좀더 세밀한 에러 제어가 가능하
		 * 다.
		 * 여기서는 BAD_REQUEST인 400 나쁜상태코드가 브라우저로 전송된다.
		 */
	}//sendListAuth()
	
	//정상적인 JSON 데이터와 404(해당경로에서 파일 찾을수 없음 에러) 나쁜 상태코드가 동시에
	//브라우저로 전송
	@GetMapping(value="/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot(){
       List<SampleVO> list=new ArrayList<>();
       
       for(int i=1;i<=3;i++) {
    	   SampleVO vo=new SampleVO();
    	   
    	   vo.setMno(i);
    	   vo.setFirstName("이");
    	   vo.setLastName("순신");
    	   
    	   list.add(vo);//컬렉션에 추가
       }
       return new ResponseEntity<List<SampleVO>>(list,
    		   HttpStatus.NOT_FOUND);//NOT_FOUND는 404 나쁜상태코드
	}//sendListNot()
}

























































