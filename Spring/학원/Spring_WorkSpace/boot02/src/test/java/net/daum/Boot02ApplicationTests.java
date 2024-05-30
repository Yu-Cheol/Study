package net.daum;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.daum.dao.BoardRepository;
import net.daum.vo.BoardVO;

@SpringBootTest
class Boot02ApplicationTests {//JUnti 연습용 테스트 클래스

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testBoardInsert() {
		BoardVO b=new BoardVO();
		
		b.setWriter("글쓴이");
		b.setTitle("게시판 글제목입니다.");
		b.setContent("게시판 글내용입니다.");
		
		//this.boardRepo.save(b);//게시판 저장
	}//저장
	
	@Test
	public void testBoardRead() {
		//Optional<BoardVO> board = this.boardRepo.findById(2);//2번 검색
		//System.out.println(board);
	}//게시판 읽기(검색)
	
	@Test
	public void testBoardUpdate() {
		/*Optional<BoardVO> board = this.boardRepo.findById(2);
		
		board.ifPresent(board2->{//해당 레코드가 존재하면 실행
			System.out.println(board2.getWriter());
			board2.setWriter("수정 글쓴이");
			board2.setTitle("게시판 글제목을 수정합니다.");
			board2.setContent("게시판 내용을 수정합니다.");
			
			System.out.println("update board ------------->");
			this.boardRepo.save(board2);//2번 레코드를 수정
		});*/
	}//수정
	
	@Test
	public void testeBoardDel() {
		System.out.println("엔티티빈 JPA에 의한 게시물 삭제");
		this.boardRepo.deleteById(1);//1번 레코드 삭제
	}//삭제
}













