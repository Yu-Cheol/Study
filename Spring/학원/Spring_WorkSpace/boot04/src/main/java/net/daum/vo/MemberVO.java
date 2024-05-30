package net.daum.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity //엔티티 빈 정의
@Table(name="tbl_members6") //@Table 애노테이션을 지정하지 않으면 엔티티빈 클래스명이
//테이블명이 된다. name 속성에 지정한 tbl_members6 테이블명이 생성된다.
@EqualsAndHashCode(of="uid2") //equals(), hashCode(), canEqual()메서드 자동생성
public class MemberVO {//회원정보 저장하는 엔티티빈 클래스

	@Id //각 엔티티 빈을 식별할 수 있도록 해주는 기본키 지정
	private String uid2; //회원 아이디
	private String upw;//회원 비번
	private String uname;//회원 이름
}
