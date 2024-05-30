package net.daum.controller;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.MemberService;
import net.daum.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private  PasswordEncoder passwordEncoder;
	
	//회원가입 폼
	@GetMapping("/member_join")
	public String member_join() {
		return "member/mem_join";//뷰페이지 경로가 /WEB-INF/views/member/mem_join.jsp
	}//member_join()
	
	//아이디중복 검색
	@PostMapping("/member_idcheck")
	public ModelAndView member_idcheck(String id,HttpServletResponse response) 
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		MemberVO db_id  = this.memberService.idCheck(id);//아이디에 해당하는 회원정보를 db로 부터 검색
		
		int re=-1;//중복 아이디가 없을 경우 반환값
		
		if(db_id != null) {//중복아이디가 있는 경우
			re=1;
		}
		
		out.println(re);//비동기식에서 값 반환기능
		
		return null;
	}//member_idcheck()
	
	//회원 저장
	@RequestMapping("/member_join_ok")
	public ModelAndView member_join_ok(MemberVO m) {
		/* MemberVO빈클래스의 변수명과 네임피라미터 이름이 같으면 m 객체에 입력한 회원정보가 저장되어 있다. 
		 */
		m.setMem_pwd(passwordEncoder.encode(m.getMem_pwd()));//비번 암호화		
		this.memberService.insertMember(m);//회원저장
		
		return new ModelAndView("redirect:/login");//로그인 매핑주소로 이동
	}//member_join_ok()
	
	//비번찾기 공지창
	@GetMapping("/pwd_find")
	public ModelAndView pwd_find() {
		ModelAndView pm=new ModelAndView();
		pm.setViewName("member/pwd_find");//메서드 인자값으로 뷰페이지 경로 저장 =>/WEB-INF/views/member/
		//pwd_find.jsp
		return pm;
	}//pwd_find()
	
	@RequestMapping(value="/pwd_find_ok",method=RequestMethod.POST)
	public ModelAndView pwd_find_ok(String pwd_id,String pwd_name,HttpServletResponse 
			response,MemberVO m) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		m.setMem_id(pwd_id); m.setMem_name(pwd_name);
		MemberVO pm=this.memberService.pwdMember(m);//아이디와 회원이름을 기준으로 DB로부터 회원정보 검색
		
		if(pm == null) {
			out.println("<script>");
			out.println("alert('회원으로 검색되지 않습니다!\\n 올바른 회원정보를 입력하세요!');");
			out.println("history.back();");
			out.println("</script>");
		}else {
		    Random r=new Random();
		    int pwd_random = r.nextInt(100000);//0이상 십만 미만 사이의 정수숫자  난수 발생
		    String ran_pwd = Integer.toString(pwd_random);//정수숫자 비번을 문자열로 변경
		    m.setMem_pwd(passwordEncoder.encode(ran_pwd));//임시 비번 암호화
		    
		    this.memberService.updatePwd(m);//암호화된 임시비번으로 수정
		    
		    ModelAndView fm=new ModelAndView("member/pwd_find_ok");//생성자 인자값으로 뷰페이지 경로와
		    //파일명 설정
		    fm.addObject("pwd_ran", ran_pwd);
		    return fm;
		}//if else		
		return null;
	}//pwd_find_ok()
}

















