--연습용 자료실 테이블 설계
create table tbl_bbs( -- tbl_bbs 테이블생성
 bbs_no number(38) primary key --자료실 번호
 ,bbs_name varchar2(50) not null --글쓴이
 ,bbs_title varchar2(200) not null --글제목
 ,bbs_pwd varchar2(50) not null --비번
 ,bbs_cont varchar2(4000) not null --글내용
 ,bbs_file varchar2(200) --첨부된 이진파일 경로와 파일명
 ,bbs_hit number(38) default 0 --조회수
 ,bbs_ref number(38) --원본글과 답변글을 묶어주는 글그룹번호 역할
 ,bbs_step number(38) --원본글과 답변글을 구분하는 번호값, 몇번째 답변글인가를 알려줌.즉 첫번째
 --답변글이면 1,두번째 답변글이면 2
 ,bbs_level int --답변글 정렬순서
 ,bbs_date date --등록날짜
);--bbs_ref,bbs_step,bbs_level 관리자 답변글과 관련된 컬럼명이다.=>계단형 계층형 게시판
--관리자 답변글 기능이 없는 게시판을 그냥 일반자료실 또는 일반 게시판이라고 한다.

select * from tbl_bbs order by bbs_no desc;

--bbs2_no_seq 시퀀스 생성
create sequence bbs2_no_seq
start with 1 --1부터 시작
increment by 1 --1씩 증가
nocache --임시 메모리 사용하지 않겠다
nocycle; --시퀀스 최대/최소값 생성시 생성 중지

--bbs2_no_seq 다음시퀀스 번호값 확인
select bbs2_no_seq.nextval as "시퀀스 번호값" from dual;










