package net.daum.vo;

import lombok.Getter;
import lombok.Setter;

@Setter //setter()메서드 자동제공
@Getter //getter()메서드 자동제공
public class ReplyVO {//댓글 테이블인 TBL_reply의 컬럼명과 일치하는 변수명을 가진
	//데이터 저장빈 클래스를 정의

	private int rno;//댓글 번호
	private int bno;//게시판 번호=>외래키로 설정됨.
	private String replyer;//댓글 작성자
	private String replytext;//댓글 내용
	private String regdate;//댓글등록 날짜
	private String updatedate;//댓글수정 날짜
}
