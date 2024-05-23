<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="https://kit.fontawesome.com/064567d6a5.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="./js/LoginCheck.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/login.css" />
    <link rel="stylesheet" type="text/css" href="./css/header.css"/>
    <title>망고: 로그인</title>
</head>
<body>
<%-- header 부분 --%>
<header>
    <div class="logo">
        <%-- 로고 --%>
        <a onclick="location='Index';"><img src="./images/main/logo.png" alt="로고"/></a>
    </div>
</header>
<%-- 로그인 페이지 --%>
<c:if test="${empty id}">
    <div class="LoginContainer">
        <div class="LoginMain">
            <div class="Login"><h2>로그인</h2></div>
            <%-- 로그인 창 --%>
            <form action="LoginOK" method="POST" onsubmit="return login_check();">
                <div class="LoginGroup">
                    <label for="user_id"><b>아이디</b></label>
                    <input type="text" id="user_id" name="user_id" tabindex="1" />
                </div>
                <div class="LoginGroup">
                    <label for="user_pwd"><b>비밀번호</b></label>
                    <input type="password" id="user_pwd" name="user_pwd" tabindex="2" />
                </div>
                <input type="submit" class="LoginBtn" value="로그인"/>
                <div class="LoginOption">
                    <a href="#">아이디 찾기</a>
                    <a href="#">비밀번호 찾기</a>
                    <a onclick="location='Join';">회원가입</a>
                </div>
                <div class="APILogin">
                    <input type="submit" class="LoginBtn" id="Naver_Btn" value="네이버 로그인" />
                    <input type="submit" class="LoginBtn" id="Kakao_Btn" value="카카오톡 로그인" />
                </div>
            </form>
            <p>Copyright © MANGO Corp. All Rights Reserved.</p>
        </div>
    </div>
</c:if>
<c:if test="${!empty id}">
    <div>${id} 님으로 로그인 하셨습니다</div>
</c:if>