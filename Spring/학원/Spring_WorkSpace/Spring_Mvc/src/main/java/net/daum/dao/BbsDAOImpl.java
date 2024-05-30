package net.daum.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.BbsVO;
import net.daum.vo.PageVO;

@Repository //@Repository 애노테이션을 설정해야 스프링에서 모델 DAO로 인식한다.
public class BbsDAOImpl implements BbsDAO {//사용자 자료실 DAO

	@Autowired //자동 의존성 주입
	private SqlSession sqlSession;//mybatis 쿼리문 수행 sqlSession

	@Override
	public void insertBbs(BbsVO bbs) {
	   this.sqlSession.insert("bbs_in", bbs);//mybatis에서 bbs_in은 bbs.xml
	   //에서 설정할 유일아이디명, 
	}//자료실 저장

	@Override
	public int getTotalCount(PageVO p) {
		return this.sqlSession.selectOne("bbs_count",p);//mybatis에서 
		//bbs_count는 bbs.xml에서 설정할 유일한 select아이디명이다. selectOne()메서드는
		//단 한개의 레코드값만 반환한다.
	}//레코드 개수

	@Override
	public List<BbsVO> getBbsList(PageVO p) {
		return this.sqlSession.selectList("bbs_list", p);//mybatis에서 sele
		//ctList()메서드는 하나이상의 레코드를 검색해서 컬렉션 List로 반환
	}// 페이지 목록

	@Override
	public void updateHit(int bbs_no) {
		this.sqlSession.update("bbs_hi", bbs_no);		
	}//조회수 증가

	@Override
	public BbsVO getBbsCont(int bbs_no) {
		return this.sqlSession.selectOne("bbs_co", bbs_no);
	}//내용보기

	@Override
	public void updateLevel(BbsVO rb) {
		this.sqlSession.update("levelUp", rb);		
	}//답변 레벨 증가

	@Override
	public void replyBbs(BbsVO rb) {
		this.sqlSession.insert("reply_in2", rb);//mybatis에서 insert()메서드는
		//레코드를 저장시킨다. reply_in2는 bbs.xml에서 설정할 유일 아이디명이다.
	}//답변 저장

	@Override
	public void editBbs(BbsVO bbs) {
		this.sqlSession.update("bbs_edit", bbs);		
	}//수정

	@Override
	public void delBbs(int bbs_no) {
		this.sqlSession.delete("bbs_del", bbs_no);		
	}//자료실 삭제
}





