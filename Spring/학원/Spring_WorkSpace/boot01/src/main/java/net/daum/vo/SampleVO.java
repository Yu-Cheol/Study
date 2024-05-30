package net.daum.vo;

import lombok.Data;
import lombok.ToString;

@Data //setter(),getter(),기본생성자,canEqual(),equals(),hashCode()메서드 자동생성
@ToString(exclude= {"val03"}) //toString()메서드 자동생성, exclude 속성을 사용해서
//STS콘솔모드에 val03 변수를 제외하고 출력
public class SampleVO {

	private String val01;
	private String val02;
	private String val03;
	
}
