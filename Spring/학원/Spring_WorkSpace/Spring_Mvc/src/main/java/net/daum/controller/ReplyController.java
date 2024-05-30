package net.daum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.service.ReplyService;
import net.daum.vo.ReplyVO;

@RestController //이 애노테이션을 추가하면 해당 컨트롤러는 Rest API 서비스 
//프로그램을 개발가능
@RequestMapping("/replies") //컨트롤러 자체 매핑주소 replies 등록
public class ReplyController {
	
	@Autowired //자동 의존성 주입
	private ReplyService replyService;

	//댓글 등록
	@PostMapping("/addReply") //post방식으로 접근하는 addReply 매핑주소 처리
	public ResponseEntity<String> addReply(@RequestBody ReplyVO vo){
		/* @RequestBody 애노테이션을 사용하면 전송된 키,값 쌍의 JSON데이터가 
		 * ReplyVO 객체타입으로 변환한다.
		 */
		ResponseEntity<String> entity=null;
		
		try {
			this.replyService.insertReply(vo);//댓글 저장
			entity=new ResponseEntity<String>("success",HttpStatus.OK);
			//댓글 저장 성공시 'success'문자열이 반환되고 정상상태 코드 200이 전송된다.
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
			/* 예외 에러가 발생하면 에러 메시지와 나쁜 상태코드가 전송 
			 */
		}
		return entity;
	}//addReply()
	
	//게시판 번호에 해당하는 댓글 목록
    @GetMapping("/all/{bno}") //get으로 접근하는 매핑주소 처리
    public ResponseEntity<List<ReplyVO>> getReplyList(
    		@PathVariable("bno") int bno){
    	/* @PathVariable("bno") 은 매핑주소의 게시판 번호값을 추출용도로 {bno}와
    	 * 연결됨.
    	 */
    	ResponseEntity<List<ReplyVO>> entity=null;
    	
    	try {
    		entity=new ResponseEntity<>(this.replyService.replyList(bno),
    				HttpStatus.OK);
    	}catch(Exception e) {
    		e.printStackTrace();
    		entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	return entity;
    }//getReplyList()
    
    //댓글 수정
    @PutMapping(value="{rno}") //@PutMapping은 RestAPI에서 수정할 때 사용한다.
    public ResponseEntity<String> updateReply(@PathVariable("rno") int rno,
    		@RequestBody ReplyVO vo){
    	
    	ResponseEntity<String> entity=null;
    	
    	try {
    		vo.setRno(rno);//댓글 번호를 저장
    		this.replyService.editReply(vo);//댓글 수정
    		entity=new ResponseEntity<>("success",HttpStatus.OK);
    	}catch(Exception e) {
    		e.printStackTrace();
    		entity=new ResponseEntity<>(e.getMessage(),
    				HttpStatus.BAD_REQUEST);
    	}
    	
    	return entity;
    }//updateReply()
    
    //댓글 번호를 기준으로 댓글 삭제
    @DeleteMapping("/{rno}") //REST API에서 삭제할 때는 @DeleteMapping을 사용
    public ResponseEntity<String> delReply(@PathVariable("rno") int rno){
    	
    	ResponseEntity<String> entity=null;
    	
    	try {
    		this.replyService.deleteReply(rno);
    		/* 문제)reply.xml에서 설정할 유일한 delete 아이디명을 reply_del로 해서
    		 * 댓글 번호를 기준으로 삭제되게 만들어 보자.
    		 */
    		entity=new ResponseEntity<>("success",HttpStatus.OK);
    	}catch(Exception e) {
    		e.printStackTrace();
    		entity=new ResponseEntity<>(e.getMessage(),
    				HttpStatus.BAD_REQUEST);
    	}
    	return entity;
    }//delReply()
}





















