package net.daum.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.BoardVO;

@Repository //@Repository 애노테이션을 추가해야 스프링에서 모델 DAO로 인식
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession; //mybatis 쿼리문 수행 sqlSession에 자동 의존
	//성 주입=>DI

	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("board_in", b);
		/* mybatis에서 insert() 메서드는 레코드를 저장한다. board_in은 board.xml에서
		 * 설정할 유일한 insert 아이디명이다.
		 */
	}//게시판 저장	

	@Override
	public int getTotalCount() {
		return this.sqlSession.selectOne("b_count");//mybatis에서 selectOne
		//()메서드는 단 한개의 레코드값만 반환, b_count는 board.xml에서 설정할 유일아이디명
	}//총레코드 개수

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return sqlSession.selectList("b_list", b);//mybatis 에서 selectList
		//()메서드는 한개 이상 레코드를 검색해서 컬렉션 List로 반환한다. b_list는 board.xm
		//ㅣ에서 설정할 유일 아이디명
	}//페이징 목록

	@Override
	public void updateHit(int bno) {
		this.sqlSession.update("b_hit", bno);//mybatis에서 update()메서드는 레
        //코드를 수정한다. b_hit는 board.xml에서 설정할 유일한 update 아이디명이다.		
	}//조회수 증가

	@Override
	public BoardVO getBoardCont(int bno) {
		return this.sqlSession.selectOne("b_cont", bno);//b_cont는 board.xm
		//l에서 설정할 유일한 아이디명이다.
	}//번호에 해당하는 레코드값 가져오기

	@Override
	public void editBoard(BoardVO eb) {
		/* 문제)board.xml에서 설정하는 유일아이디명 b_edit로 해서 번호를 기준으로 글쓴이,글제
		 * 		목,글내용을 수정되게 해보자.
		 */
		this.sqlSession.update("b_edit", eb);
	}//게시판 수정

	@Override
	public void delBoard(int bno) {
		this.sqlSession.delete("b_del", bno);//mybatis에서 delete()메서드는
		//레코드를 삭제한다.
	}//삭제

	//@Override
	//public void updateReplyCnt(int bno, int count) {
	//	Map<String,Object> cm=new HashMap<>();
		
		//cm.put("bno", bno);//board.xml에서 bno키이름을 참조해서 게시판 번호값을 가져옴
		//cm.put("count", count);
		
		//this.sqlSession.update("updateReplyCnt", cm);
	//}//새로운 댓글이 추가되었을 때 댓글수 1증가
}





