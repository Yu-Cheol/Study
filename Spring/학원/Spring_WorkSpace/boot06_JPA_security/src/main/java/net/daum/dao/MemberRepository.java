package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO, String>{

	@Query("select m from MemberVO m where m.mem_id=?1 and m.mem_name=?2")
	/* JPQL(JPA에서 사용하는 쿼리언어이다. Java Persistence Query Language의 약어)이다.
	 * JPQL문은 실제 테이블명 대신 엔티빈 클래스명을 사용하고,실제 컬럼명 대신 엔티티빈 속성명을 사용한다. ?1은 첫번째로 전달되
	 * 어지는 인자값, ?2는 두번째로 전달되어지는 인자값
	 */
	public MemberVO pwdFind(String id,String name);//아이디외 회원이름을 기준으로 DB로 부터 회원정보 검색
	
	@Modifying //@Query는 select문만 가능하지만, @Modifying을 사용하면 insert,delete,update문도 가능하다
	@Query("update MemberVO m set m.mem_pwd=?1 where m.mem_id=?2")
	public void updatePwd(String pwd,String id);
}
