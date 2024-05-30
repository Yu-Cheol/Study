--nocache 로 수정
alter sequence bno_seq8
nocache;

--nocycle 로 수정
alter sequence bno_seq8
nocycle;

select * from tbl_boards3 order by bno desc;