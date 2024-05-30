package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.daum.service.MessageService;
import net.daum.vo.MessageVO;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	//메시지 추가
	@RequestMapping(value="/add_message",method=RequestMethod.POST) //POST
	//로 접근하는 매핑주소를 처리, add_message 매핑주소 등록
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
		
		ResponseEntity<String> entity=null;
		
		try {
			this.messageService.addM(vo);//메시지 추가
			entity=new ResponseEntity<>("success",HttpStatus.OK);//메시지 추가
			//가 성공하면 'success'문자와 200 정상상태코드가 반환
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}



