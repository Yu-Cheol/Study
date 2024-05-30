package net.daum.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BbsVO {//TBL_BBS테이블 컬럼명과 일치하는 변수명을 가진 자료실 데이터 저장빈 클래
	//스

	private int bbs_no;
	private String bbs_name;
	private String bbs_title;
	private String bbs_pwd;
	private String bbs_cont;
	private String bbs_file;
	private int bbs_hit;
	private int bbs_ref;//원본글과 답변글을 묶어주는 글 그룹번호 역할
	private int bbs_step;//원본글이면 0,첫번째 답변글이면 1,두번째 답변글이면 2 =>원본글과
	//답변글을 구분하는 번호값이면서 몇번째 답변글인가를 알려준다.
	private int bbs_level;//답변글 정렬순서
	private String bbs_date;
}
