package net.daum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import net.daum.service.BoardService;
import net.daum.vo.BoardVO;

@Controller //@Controller 애노테이션을 추가함으로써 스프링에서 컨트롤러로 인식하게 한다.
@RequestMapping("/board/*") //컨트롤러 자체 매핑주소 등록
public class BoardController {//스프링 MVC게시판 컨트롤러

	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/test")
	public void test() {
		
	}
	
	//스프링 MVC 게시판 글쓰기
	@RequestMapping(value="/board_write",method=RequestMethod.GET) //get
	//으로 접근하는 board_write 매핑주소 처리
	public void board_write(HttpServletRequest request) {
		//리턴타입이 없는 void형이면 매핑주소인 board_write가 뷰페이지 파일명이 된다.
		//뷰리졸브 경로(뷰페이지 경로)는 /WEB-INF/views/board/board_write.jsp
		
		/* 책갈피기능 구현 코드*/
		int page=1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		request.setAttribute("page", page);//page키이름에 쪽번호 저장
	}//board_write()
	
	//게시판 저장
	@RequestMapping(value="/board_write",method=RequestMethod.POST) //post
	//로 접근하는 매핑주소를 처리.
	public ModelAndView board_write(BoardVO b,RedirectAttributes rttr) {
		/* BoardVO b는 네임피라미터 이름과 빈클래스 변수명이 같으면 b객체에 글쓴이,글제목,글내용
		 * 이 저장되어 있다. 
		 */
		this.boardService.insertBoard(b);//게시물 저장
		rttr.addFlashAttribute("msg", "SUCCESS");
		//백엔드 서버단 다른 매핑주소로 이동시 msg키이름에 'SUCCESS'문자를 담아서 전달한다. 주
		//소창에 노출 안되어서 보안상 좋다.
		
		ModelAndView wm=new ModelAndView();
		wm.setViewName("redirect:/board/board_list");//메서드 인자값으로 뷰페이지
		//경로나 매핑주소가 들어갈 수 있다.여기서는 게시물 저장후 변경된 레코드값을 다시 제대로 확인
		//하과 redirect:/매핑주소로 목록보기 새로운 매핑주소로 이동.
		return wm;
	}//board_write()
	
	//게시판 목록
	@RequestMapping("/board_list") //get or post로 접근하는 board_list매핑주소 
	//처리, redirect:/에 의해서 이동하는 방식은 get방식이다.
	public String board_list(BoardVO b,HttpServletRequest request,
			Model listM) {
		
		int page=1;//현재 페이지 번호
		int limit=7;//한페이지에 보여지는 목록개수
		if(request.getParameter("page") != null) {
			//get으로 전달된 쪽번호가 있는경우
			page = Integer.parseInt(request.getParameter("page"));
			//쪽번호를 정수 숫자로 변경해서 저장
		}
		b.setStartrow((page-1)*7+1);//시작행 번호
		b.setEndrow(b.getStartrow()+limit-1);//끝행 번호
		
		int totalCount = this.boardService.getTotalCount();//총레코드 개수
		List<BoardVO> blist = boardService.getBoardList(b);
		//페이징(쪽나누기) 목록
		
		/* 페이지 연산 */
		int maxpage=(int)((double)totalCount/limit+0.95);//총 페이지 수
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		//현재 페이지에 보여질 시작 페이지
		int endpage=maxpage;//현재 페이지에 보여질 마지막 페이지
		
		if(endpage > startpage+10-1) endpage=startpage+10-1;
		
		listM.addAttribute("totalCount", totalCount);//totalCount키이름에
		//총레코드 개수를 저장
		listM.addAttribute("blist", blist);//blist키이름에 목록 저장
		listM.addAttribute("startpage", startpage);
		listM.addAttribute("endpage", endpage);
		listM.addAttribute("maxpage", maxpage);
		listM.addAttribute("page", page);//page키이름에 현재 쪽번호 저장
		
		return "board/board_list";//뷰리졸브(뷰페이지) 경로는 /WEB-INF/
		// views/board/board_list.jsp
	}
	
	//내용보기+조회수 증가
	@GetMapping(value="/board_cont") //get으로 접근하는 board_cont매핑주소 처리
	public ModelAndView board_cont(@RequestParam("bno") int bno,int page){
		/* @RequestParam("bno")를 서블릿 코드로 변환하면 request.getParameter("
		 * bno")와 같은 기능을 한다.
		 */
		BoardVO cb=this.boardService.getBoardCont(bno);//오라클로 부터 번호에
		//해당하는 레코드값을 가져오면서 동시에 조회수 증가
		String bcont=cb.getContent().replace("\n", "<br>");//textarea 게시판
		//내용 입력필드에서 엔터키를 친부분을 줄바꿈해준다.
		
		ModelAndView cm=new ModelAndView("board/board_cont");//생성자 인자값
		//으로 뷰페이지 경로 설정=> /WEB-INF/views/board/board_cont.jsp
		cm.addObject("bc", cb);
		cm.addObject("bcont", bcont);
		cm.addObject("page", page);
		return cm;		
	}//board_cont()
	
	//게시판 수정폼
	@GetMapping("/board_edit")
	public ModelAndView board_edit(int bno,int page) {
		BoardVO eb=this.boardService.getBoardCont2(bno);//조회수가 증가되지 않는
		//번호에 해당하는 레코드 가져오기
		
		ModelAndView em=new ModelAndView();
		em.setViewName("board/board_edit");//뷰페이지 경로 설정
		em.addObject("eb", eb);
		em.addObject("page", page);//페이징에서 책갈피 기능을 적용하기 위해서 page
		//키이름에 쪽번호 저장
		return em;
	}//board_edit()
	
	//수정완료
	@PostMapping("/board_edit_ok") //post방식으로 접근하는 board_edit_ok 매핑주소
	//를 처리
	public String board_edit_ok(BoardVO eb, int page) {
		
		this.boardService.editBoard(eb);//게시물 수정
		
		return "redirect:/board/board_cont?bno="+eb.getBno()+"&page="+page;
		//board_cont?bno=번호&page=쪽번호 2개의 피라미터값이 get방식으로 전달된다.
	}//board_edit_ok()
	
	//삭제완료
	@RequestMapping("/board_del")
	public ModelAndView board_del(int bno,int page,RedirectAttributes rttr) {
		this.boardService.delBoard(bno);//번호를 기준으로 삭제
		/* 문제) board.xml에서 설정할 delete 매퍼태그 유일아이디명을 b_del로 해서
		 * 번호를 기준으로 삭제되게 해보자. 삭제메서드는 delete()메서드를 사용한다.
		 */
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		ModelAndView dm=new ModelAndView();
		dm.setViewName("redirect:/board/board_list");//메서드 인자값으로 매핑주소
		//경로가 들어감.
		dm.addObject("page", page);
		return dm;//board_list?page=쪽번호가 주소창에 노출되는 get방식으로 전달된다.
	}//board_del()
}





















