package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReplyAjaxController {//Rest API로 개발된 백엔드 서버 댓글 프로그램과 연동
	//되는 비동기식 jQuery 아작스로 댓글 뷰페이지 개발 스프링 컨트롤러 클래스이다.

	@GetMapping("/replyAjax")
	public ModelAndView replyAjax() {
		return new ModelAndView("reply_ajax");//생성자 인자값으로 뷰페이지 경로인
		//뷰리졸브중에서 뷰페이지 파일명 설정=>/WEB-INF/views/reply_ajax.jsp
	}
}
