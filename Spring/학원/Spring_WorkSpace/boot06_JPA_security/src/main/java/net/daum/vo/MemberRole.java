package net.daum.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@SequenceGenerator(//시퀀스 생성기
		  name = "member7_no_seq_gename",//시퀀스 제너레이터 이름
		  sequenceName = "member7_no_seq", //시퀀스 이름
		  initialValue = 1,//시퀀스 시작값
		  allocationSize = 1 //1씩 증가
		)
@Table(name="tbl_member_roles7")
@EqualsAndHashCode(of="fno")
public class MemberRole {

	@Id
	@GeneratedValue(
			 strategy = GenerationType.SEQUENCE,//사용할 전략을 시퀀스로 선택
			 generator = "member7_no_seq_gename"//시퀀스 생성기에 설정해 놓은
			 //시퀀스 제너레이터 이름으로 지정
			)
	private int fno;
	
	private String roleName;//권한이름
}












