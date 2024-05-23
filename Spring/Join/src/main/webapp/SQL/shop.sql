create table mjoin(
    m_id varchar2(50) primary key, -- 회원 아이디
    m_pwd varchar2(500) not null, -- 비밀번호
    m_pwdC varchar2(500) not null, -- 비밀번호 확인
    m_email varchar2(500) not null, -- 이메일
    m_name varchar2(50) not null, -- 이름
    m_day varchar2(50) not null, -- 생년월일
    m_phone varchar2(100) not null -- 전화번호 
);