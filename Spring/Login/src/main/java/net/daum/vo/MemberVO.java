package net.daum.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {

    private String member_id; // 아이디
    private String member_pwd; // 비밀번호
    private String member_name; // 이름
    private String member_year; // 생년월일
    private String member_month;
    private String member_day;
    private String member_sex; // 성별
    private String member_email; // 이메일
    private String member_domain; // 이메일 도메인
    private String member_phone01; // 전화번호
    private String member_phone02;
    private String member_phone03;
    private int member_date; // 가입날짜

}
