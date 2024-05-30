package net.daum.controller;

import java.text.DecimalFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.daum.vo.ProductVO;

@Controller
public class Sample3Controller {
	//ProductVO 빈클래스를 뷰페이지에서 EL로 사용하는 법에 관한 컨트롤러

	@GetMapping("/note_price") //get으로 접근하는 note_price매핑주소를 처리	
	public String namePrice(Model m) {
		/* 문제)자바 언어로 상품가격을 세자리수 콤마로 표기해서 저장한 다음 출력해 본다. 
		 */
		DecimalFormat decFormat = new DecimalFormat("###,###");
		//세자리 콤마로 표현할려면 생성자 인자값으로 ###,###으로 표현
		String price = decFormat.format(2500000L);
		
		ProductVO pv=new ProductVO("노트북",price);
		m.addAttribute("pv", pv);//pv키이름에 pv객체를 저장
		return "shop/note_view"; //뷰페이지 경로(뷰리졸브 경로)는 /WEB-INF/views/
		//shop/note_view.jsp
	}
}
