package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.MemberVO;

@Repository //@Repository애노테이션을 추가함으로써 스프링에서 모델 DAO로 인식하게 한다.
public class MemberDAOImpl implements MemberDAO {

	@Autowired //DI(Dependency injection의 준말로 '의존성 주입' 이라는 뜻=>내 스스로
	//100% 할수 있는게 없다라는 의미.즉 스프링 프레임웍 구조 틀에 의존해야 한다.
	//@Autowired  자동의존성 주입
	private SqlSession sqlSession;//mybatis 쿼리문 수행 sqlSession 의존성 주입

	@Override
	public void insertMember(MemberVO m) {
		this.sqlSession.insert("m_in", m);
		/* mybatis 에서 insert() 메서드는 레코드를 저장시킨다. m_in은 member.xml 에서
		 * 설정할 유일한 insert 아이디명이다.
		 */
	}//회원 저장	
}
