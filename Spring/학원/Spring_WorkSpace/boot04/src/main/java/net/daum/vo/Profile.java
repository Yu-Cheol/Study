package net.daum.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="member") //toString()메서드에서 member변수 제외를 하여 호출안되게함
@Entity
@SequenceGenerator(//시퀀스 생성기
		  name="fno_seq_gename",//시퀀스 제너레이터 이름
		  sequenceName = "fno_seq",//시퀀스 이름
		  initialValue = 1,//시퀀스 번호 시작값
		  allocationSize = 1 //시퀀스 증가값, 1씩 증가,기본값은 50
		)
@Table(name="tbl_profile3") //tbl_profile3이라는 테이블이 생성
@EqualsAndHashCode(of="fname") 
public class Profile {

	@Id //기본키 컬럼
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
			generator = "fno_seq_gename" //시퀀스 생성기에서 설정해 놓은 시퀀스 제너레
			//이터 이름으로 설정
			)
	private int fno;
	
	private String fname;//회원 프로필 사진명
	
	private boolean current2;
	
	@ManyToOne //다대일 연관 관계
	private MemberVO member;//추가적으로 외래키로 설정
}



