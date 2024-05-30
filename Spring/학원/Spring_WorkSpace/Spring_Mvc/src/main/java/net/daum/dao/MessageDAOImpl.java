package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {//MessageDAOImpl에서
	//message.xml을 통한 tbl_message테이블에 보낸 메시지가 저장된다.

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addM(MessageVO vo) {
	   this.sqlSession.insert("message_in",vo);
	   /* mybatis에서 쿼리문 실행메서드 종류)
	    *  1.레코드 저장 : insert()
	    *  2.레코드 수정 : update()
	    *  3.레코드 삭제 : delete()
	    *  4.단 한개의 레코드값만 반환 : selectOne()
	    *  5.하나이상의 레코드를 검색해서 컬렉션 List로 반환 : selectList()
	    *  
	    * ibatis는 mybatis의 부모로서 2010년에 온라인 기술지원이 중단됨.
	    *  ibatis에서 단 한개의 레코드값만 반환하는 메서드는 queryForObject()이고,
	    *  하나이상의 레코드를 검색해서 컬렉션 List로 반환하는 메서드는 queryForList이다. 
	    */
	}//메시지 추가
}
