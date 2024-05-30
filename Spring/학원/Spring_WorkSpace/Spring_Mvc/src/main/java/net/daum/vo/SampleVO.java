package net.daum.vo;

import lombok.Data;

@Data //기본생성자, canEqual(), equals(), hashCode(), toString(),setter(),
//getter()메서드 자동제공
public class SampleVO {//데이터 저장빈 클래스. 해당 빈 클래스 변수명이 json데이터의 키이름이
	//된다.

	private int mno;//번호
	private String firstName;//성
	private String lastName;//이름
}
