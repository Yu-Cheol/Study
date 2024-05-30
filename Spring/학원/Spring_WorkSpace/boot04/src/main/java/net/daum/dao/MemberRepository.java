package net.daum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO,String>{

	@Query(value="select m.uid2, count(fname) from tbl_members6 m "
+" left outer join tbl_profile3 p on m.uid2=p.member_uid2 where m.uid2=?1 "
+" group by m.uid2", nativeQuery=true)
/* nativeQuery=true로 설정하면 데이터베이스에 종속적인 SQL문을 그대로 사용하겠다는 의미이다.
 * 	복잡한 쿼리문 작성에 유리하다.다만, 이 경우는 데이터베이스에 독립적이라는 JPA장점은 어느 정도
 * 포기해야 한다. 엔티티빈 클래스명 대신 실제 테이블명을 사용하고, 엔티티 빈 클래스 속성대신 실제 테이
 * 블 컬럼명을 사용한다. tbl_members6테이블에는 레코드가 있어나 tbl_profile3테이블에는 레코드
 * 가 없는 경우 left outer join을 한다. =>단방향 Fetch Join이라고 한다.
 */
	public List<Object[]> getMemberVOWithProfileCount(String id);
	//회원아이디와 프로필 사진 개수
	
	@Query(value="select m.uid2,m.upw,m.uname,p.current2,p.fname from "
+" tbl_members6 m left outer join tbl_profile3 p on m.uid2=p.member_uid2 "			
+" where m.uid2 = ?1 and p.current2=1", nativeQuery = true)
	public List<Object[]> getMemberVOWithProfile(String id);
	//회원아이디에 대한 회원정보와 현재 사용중인 프로필 사진 정보
}





