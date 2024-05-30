package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Sample2Controller {

	@RequestMapping(value="/doC",method=RequestMethod.GET) //GET으로 접근하는
	//doC매핑주소(url-pattern)를 처리
	public String doC(@ModelAttribute("msg2") String mag) {
		/* doC?msg2=값을 담아서 주소창에 노출되는 get방식으로 전달한다. msg2네임피라미터 이름
		 * 에 값을 담아서 전달하는 get방식인대 뷰페이지에서 EL로 ${피라미터이름}로 참조해서 값을
		 * 가져온다.
		 */
		return "result";//뷰리졸브 경로(뷰페이지 경로)는 /WEB-INF/views/result.jsp
	}
}
