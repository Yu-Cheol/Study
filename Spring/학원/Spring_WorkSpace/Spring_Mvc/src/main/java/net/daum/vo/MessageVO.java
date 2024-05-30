package net.daum.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageVO {//tbl_message 테이블 컬럼명과 일치하는 변수명을 가진 데이터 저장
	//빈 클래스

	private int mid;
	private String targetid;
	private String sender;
	private String message;
	private String senddate;
	
}
