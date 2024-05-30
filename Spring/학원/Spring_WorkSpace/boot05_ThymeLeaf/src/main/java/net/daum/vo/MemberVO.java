package net.daum.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //기본생성자, canEqual(),equals(),setter(),getter(),hashCode(),toString
//() 메서드까지 자동생성
@AllArgsConstructor //해당빈클래스 모든속성(멤버변수)을 사용한 생성자 오버로딩=>전달인자 5개짜리
//생성자 오버로딩
public class MemberVO {

	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private Timestamp regdate;
}
