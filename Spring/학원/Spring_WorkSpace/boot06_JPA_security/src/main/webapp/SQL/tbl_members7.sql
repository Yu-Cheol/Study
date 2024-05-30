select * from TBL_MEMBERS7;
select * from TBL_MEMBER_ROLES7;

alter sequence member7_no_seq nocache; --nocache로 설정
alter sequence member7_no_seq nocycle; --nocycle로 설정

--스프링 시큐리티 자동로그인 정보를 저장 유지하는 테이블
create table persistent_logins(
  username varchar2(64) not null --아이디
  ,series varchar2(64) not null --비번
  ,token varchar2(64) not null --토큰정보
  ,last_used timestamp not null --로그인한 날짜 시간
);

select * from PERSISTENT_LOGINS;