package net.daum.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginVO {

    private String j_id; // 아이디
    private String j_pwd; // 비밀번호
    private String j_name; // 이름
    private String j_phone01; // 전화번호
    private String j_phone02;
    private String j_phone03;

}
