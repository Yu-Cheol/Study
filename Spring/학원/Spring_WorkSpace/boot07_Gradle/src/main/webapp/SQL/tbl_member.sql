--tbl_member 테이블 생성
create table tbl_member(
  userid varchar2(50) primary key --회원아이디
  ,userpw varchar2(50) not null --비번
  ,username varchar2(50) not null --회원이름
  ,email varchar2(100) --전자우편
  ,regdate date --등록날짜
  ,updatedate date --수정날짜
);

select * from tbl_member;

--tbl_board 게시판 테이블 생성
create table tbl_board(
 bno number(38) primary key -- 번호
 ,writer varchar2(50) not null --글쓴이
 ,title varchar2(200) not null --글제목
 ,content varchar2(4000) not null --글내용
 ,viewcnt number(38) default 0 --default 0 제약조건을 설정해서 해당 컬럼에 굳이 레코드를
 --저장하지 않아도 정수숫자 기본값 0이 저장됨, 조회수
 ,regdate date default sysdate --등록날짜
);

select * from tbl_board order by bno desc;

--댓글수를 카운터해서 저장할 replycnt 컬럼 추가
alter table tbl_board add (replycnt number(38) default 0);

-- tbl_reply 댓글 테이블의 게시판번호에 해당하는 댓글수를 카운터해서 replycnt컬럼 레코드값으로
--수정되게 해본다.
update tbl_board set replycnt=(select count(rno) from tbl_reply
where bno=tbl_board.bno) where bno>0;

drop sequence bno_seq; --bno_seq 시퀀스 삭제

--bno_seq시퀀스 생성
create sequence bno_seq
start with 1
increment by 1
nocache
nocycle;

--bno_seq 시퀀스 다음 번호값 확인
select bno_seq.nextval as "bno_seq시퀀스 번호값" from dual;

--tbl_reply 댓글 테이블 생성
create table tbl_reply(
 rno number(38) primary key --댓글 번호
 ,bno number(38) default 0 --외래키로 추가 설정되어서 주인테이블인 tbl_board의 bno컬럼
 --번호값만 저장됨.
 ,replyer varchar2(50) not null --댓글 작성자
 ,replytext varchar2(4000) not null --댓글 내용
 ,regdate date --댓글 등록 날짜
 ,updatedate  date --댓글 수정 날짜
);

select * from tbl_reply order by rno desc;

--tbl_reply 테이블 bno컬럼에 외래키 추가 설정
alter table tbl_reply add constraint tbl_reply_bno_fk
foreign key(bno) references tbl_board(bno);

--rno_seq 시퀀스 생성
create sequence rno_seq
start with 1
increment by 1
nocache
nocycle;

--rno_seq 시퀀스 다음번호값 확인
select rno_seq.nextval as "rno_seq 시퀀스 번호값" from dual;


--스프링 AOP를 통한 트랜잭션 적용 실습을 위한 테이블 생성
create table tbl_user(
 uid2 varchar2(50) primary key --회원 아이디
 ,upw varchar2(50) not null --비번
 ,uname varchar2(50) not null --회원이름
 ,upoint number(38) default 0 --메시지가 보내지면 보내진 메시지 하나당 포인터 점수 10점 업 
);

--샘플 회원정보 더미 데이터 저장
insert into tbl_user (uid2,upw,uname) values('user00','user00','홍길동');
insert into tbl_user (uid2,upw,uname) values('user01','user01','이순신');

select * from tbl_user order by uid2 asc;

--보내진 메시지가 저장될 테이블 생성
create table tbl_message(
 mid number(38) primary key --번호
 ,targetid varchar2(50) not null --foreign key인 외래키로 설정되어서 tbl_user테이
 --블 uid2컬럼 회원아이디값만 저장됨.
 ,sender varchar2(50) not null --메시지를 보낸사람
 ,message varchar2(4000) not null --보낸 메시지
 ,senddate date --메시지를 보낸 날짜
 );

 select * from tbl_message order by mid desc;
 
 delete from tbl_message where mid=3;
 
--targetid 컬럼에 추가적으로 외래키 서정
alter table tbl_message add constraint tbl_message_targetid_fk
foreign key(targetid) references tbl_user(uid2);
 
--mid_no_seq라는 시퀀스를 생성
create sequence mid_no_seq
start with 1
increment by 1
nocache
nocycle;

--mid_no_seq 시퀀스 번호값 확인
select mid_no_seq.nextval as "시퀀스번호값" from dual;








