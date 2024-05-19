create table member_join(
    member_id varchar2(50) primary key, -- 아이디
    member_pwd varchar2(500) not null, -- 비밀번호
    member_name varchar2(50) not null, -- 이름
    member_year varchar2(50) not null, -- 생년월일
    member_month varchar2(50) not null,
    member_day varchar2(50) not null,
    member_sex varchar2(30) not null, -- 성별
    member_email varchar2(100) not null, -- 이메일
    member_domain varchar2(100) not null, -- 이메일 도메인
    member_phone01 varchar2(10) not null, -- 전화번호 
    member_phone02 varchar2(10) not null,
    member_phone03 varchar2(10) not null,
    member_date date -- 가입날짜 
);

select * from member_join;

commit;