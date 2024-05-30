package net.daum.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity //엔티티빈 클래스
@Table(name="tbl_members7") //tbl_members7 테이블 생성
@EqualsAndHashCode(of="mem_id") //equal(), hashCode(), canEqual() 메서드 자동
//생성
public class MemberVO {//회원관리 엔티티빈 클래스

	@Id //유일키로 사용될 키본키 컬럼을 지정
	private String mem_id;//회원아이디
	
	private String mem_pwd;//비번
	private String mem_name;//회원이름
	
	@CreationTimestamp //하이버네이트로 등록시점 날짜값 생성, mybatis에서는 작동 안함.
	private Timestamp mem_date;//가입날짜
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	/* 일대다 연관관계, cascade=CascadeType.ALL은 JPA에서 영속성 전이중에서 모든 변경에 대
	 * 한 전이로 모든 엔티티빈 상태 변화에 대해서 같이 처리하는 옵션, FetchType.EAGER은 
	 * tbl_members7과 tbl_member_roles7 두 테이블을 조회해야 하기 때문에 트랜잭션을 처리
	 * 해 주거나,즉시 로딩을 이용해서 조인하는 방법으로 처리해야 한다. 권한 정보는 회원정보와 마찬
	 * 가지로 필요한 경우가 많기 때문에 fetch 모드를 즉시 로딩으로 설정한다.
	 */
	@JoinColumn(name="member") //이미 존재하는 tbl_member_roles7 테이블에 member
	//컬럼을 외래키(foreign key)로 추가
	private List<MemberRole> roles;
}







