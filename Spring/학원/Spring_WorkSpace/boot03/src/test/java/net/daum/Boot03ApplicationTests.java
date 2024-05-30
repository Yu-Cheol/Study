package net.daum;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.inject.Inject;
import net.daum.dao.BoardRepository;
import net.daum.vo.BoardVO;

@SpringBootTest
class Boot03ApplicationTests {

	@Inject //자동의존성 주입=>@Autowired 와 기능이 같다.
	private BoardRepository boardRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testBoardInsert20() {
		
		for(int i=1;i<=20;i++) {
           BoardVO b=new BoardVO();
           
           b.setWriter("user0"+ (i%10));
           b.setTitle("게시판 제목...:"+i);
           b.setContent("내용..."+i);
           
           //this.boardRepo.save(b);
		}
	}//20개의 더미 데이터(샘플 데이터) 게시물 저장
	
	//쿼리 메서드중에서 제목으로 검색
	@Test
	public void testByTitle() {
      
		//자바 8 람다식 검색
		//this.boardRepo.findBoardVOByTitle("게시판 제목...:17")
		//.forEach(b->System.out.println(b));
		
		//자바 8 이전
	 /*	List<BoardVO> blist = 
				this.boardRepo.findBoardVOByTitle("게시판 제목...:17");
		
		if(blist != null && blist.size() > 0) {//size()메서드는 컬렉션 원소개수를
			//반환한다. 첫 원소개수는 1부터 카운터한다.
			for(int i=0;i<blist.size();i++) {
				System.out.println(blist.get(i));//get()메서드로 원소값을 가져옴.
			}
		}else {
		   System.out.println("검색된 게시글이 없습니다.");	
		}	*/	
	}//testByTitle()
	
	//글쓴이로 검색
	@Test
	public void testByWriter() {
		//Collection<BoardVO> blist =	this.boardRepo.findByWriter("user00");
		//blist.forEach(b -> System.out.println(b));
	}//testByWriter()	
	
	//글쓴이에 05가 포함된 게시물 검색 -> '%'+ '05' +'%' like 검색
	@Test
	public void testByWriterContaining() {
		
		//Collection<BoardVO> blist = 
			//	this.boardRepo.findByWriterContaining("05");
		//blist.forEach(b->System.out.println(b));
	}//testByWriterContaining()
	
	//제목에 2가 포함되거나 내용에 5가 포함된 경우
	@Test
	public void testByTitleOrContentContaining() {
		
		//Collection<BoardVO> blist = 
        //this.boardRepo.findByTitleContainingOrContentContaining("2","5");				
		
		//blist.forEach(board -> System.out.println(board));
	}//testByTitleOrContentContaining()
	
	//제목에 '5'가 포함되어 있고 게시물 번호가 5보다 큰 자료검색
	@Test
	public void testByTitleAndBno() {

		//Collection<BoardVO> blist = 
		 //this.boardRepo.findByTitleContainingAndBnoGreaterThan("5", 5);
		
		//blist.forEach(board -> System.out.println(board));
	}//testByTitleAndBno()
	
	//bno가 10보다 큰 게시물을 내림차순 정렬
	@Test
    public void testByBnoOrderBy() {
		
		//Collection<BoardVO> blist=
				//this.boardRepo.findByBnoGreaterThanOrderByBnoDesc(10);
		
		//blist.forEach(b->System.out.println(b));
	}//testByBnoOrderBy()
	
	//'제목'들어간 게시물 글제목을 검색
	@Test
	public void testByTitle2() {

		//this.boardRepo.findByTitle("제목")
		//.forEach(board->System.out.println(board));
	}//testByTitle2()
	
	//@Param("content")와 연결되는 :content에 의한 게시판내용 검색처리
	@Test
	public void testByContent2() {
		
		//this.boardRepo.findByContent("내용")
		//.forEach(board -> System.out.println(board));
	}//testByContent2()
	
	//원하는 컬럼만 검색
	@Test
	public void testByTitle17() {
		
		this.boardRepo.findByTitle2("제목")
		.forEach(arr -> System.out.println(Arrays.toString(arr)));
		//Arrays.toString(arr) 의 기능은 인자값으로 주어진 배열을 문자열로 반환해 준다.
	}//testByTitle17()
}










































