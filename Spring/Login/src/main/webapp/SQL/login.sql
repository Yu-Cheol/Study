-- 회원가입 테이블 (테스트용)
create table JoinTest01(
    j_id varchar2(50) primary key, -- 아이디
    j_pwd varchar2(500) not null, -- 비밀번호
    j_name varchar2(50) not null, -- 회원이름
    j_phone01 varchar2(10) not null, -- 전화번호
    j_phone02 varchar2(10) not null,
    j_phone03 varchar2(10) not null
);

select * from JoinTest01;

commit;