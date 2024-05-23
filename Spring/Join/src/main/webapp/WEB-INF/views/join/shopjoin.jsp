<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="https://kit.fontawesome.com/064567d6a5.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/join.css">
    <link rel="stylesheet" type="text/css" href="./css/header.css"/>
    <title>망고: 회원가입</title>
</head>
<body>
<%-- header 부분 --%>
<header>
    <div class="logo">
        <%-- 로고 --%>
        <a onclick="location='Index';"><img src="../images/main/logo.png" alt="로고"/></a>
    </div>
</header>
<form name="s" method="post" action="JoinOK" onsubmit="return join_check();">
    <div class="JoinContainer">
        <div class="MemberJoin">
            <%-- 필드 --%>
            <%-- 아이디 --%>
            <div class="JoinField">
                <b>아이디</b>
                <span class="UserID"><input placeholder="아이디" name="m_id" id="m_id"></span>
            </div>
            <%-- 비밀번호 --%>
            <div class="JoinField">
                <b>비밀번호</b>
                <input class="UserPwd" type="password" placeholder="비밀번호" name="m_pwd" id="m_pwd">
            </div>
            <div class="JoinField">
                <b>비밀번호 확인</b>
                <input class="UserPwdCheck" type="password" placeholder="비밀번호 확인" name="m_pwdC" id="_pwdC">
            </div>
            <%-- 이메일 --%>
            <div class="JoinField">
                <b>본인 확인 이메일<small>(선택)</small></b>
                <input type="email" name="m_email" id="m_email" placeholder="선택입력">
            </div>
            <%-- 이름 --%>
            <div class="JoinField">
                <b>이름</b>
                <input type="text" placeholder="이름" name="m_name" id="m_name">
            </div>
            <%-- 생년월일 --%>
            <div class="FieldBirth">
                <b>생년월일</b>
                <div><input type="text" placeholder="생년월일 8자리" name="m_day" id="m_day"></div>
            </div>
            <%-- 전화번호 --%>
            <div class="FieldTel">
                <b>휴대전화</b>
                <div><input type="tel" name="m_phone" id="m_phone" placeholder="휴대전화 번호"></div>
            </div>
            <%-- 가입하기 --%>
            <input type="submit" class="JoinCheck" value="가입하기">
        </div>
    </div>
</form>