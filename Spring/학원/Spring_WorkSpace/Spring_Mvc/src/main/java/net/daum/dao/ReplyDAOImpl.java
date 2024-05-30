package net.daum.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.ReplyVO;

@Repository //@Repository 애노테이션을 설정해야 스프링에서 모델 dao로 인식한다.
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired //자동의존성 주입(DI:Dependency Injection)
	private SqlSession sqlSession;//mybatis 쿼리문 수행 sqlSession

	@Override
	public void insertReply(ReplyVO vo) {
		this.sqlSession.insert("reply_in", vo);//reply_in은 reply.xml에서 설
		//정할 유일 아이디명
	}//댓글 저장	

	@Override
	public List<ReplyVO> replyList(int bno) {
		return this.sqlSession.selectList("reply_list", bno);
		/* mybatis 에서 selectList()메서드는 하나이상의 레코드를 검색해서 컬렉션 List로
		 * 반환한다. reply_list는 reply.xml에서 설정할 유일한 select 아이디명이다.
		 */
	}//게시판 번호에 해당하는 댓글 목록

	@Override
	public void editReply(ReplyVO vo) {
		this.sqlSession.update("reply_edit", vo);		
	}//댓글 수정

	@Override
	public void deleteReply(int rno) {
	    this.sqlSession.delete("reply_del", rno);			
	}//댓글 삭제

	@Override
	public int getBno(int rno) {
		return this.sqlSession.selectOne("reply_bno",rno);
		//mybatis 에서 selectOne()메서드는 단 하나의 레코드값만 반환, reply_bno는 repl
		//y.xml에서 설정할 유일한 select 아이디명
	}//댓글번호를 기준으로 게시판 번호를 구함
}



