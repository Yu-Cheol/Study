<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--ajax 통신 시 403 forbidden 에러 발생 해결법 => 
csrf(Cross-site request forgery)의 token이 누락으로 발생하기 때문에 
아래 코드 2개 추가 --%>
<meta name="_csrf_header" content="${_csrf.headerName}">
<meta name="_csrf" content="${_csrf.token}">
<title>회원가입 폼</title>
<link rel="stylesheet" type="text/css" href="./css/member.css" />
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="./js/member.js"></script>
</head>
<body>
   <div id="mJoin_wrap">
      <h2 class="mJoin_title">회원가입</h2>
      <form name="m" method="post" action="member_join_ok"
         onsubmit="return join_check();">
         <table id="mJoin_t">
            <tr>
               <th>회원아이디</th>
               <td><input name="mem_id" id="mem_id" size="14"
                  class="input_box" /> <input type="button" value="아이디중복체크"
                  class="input_b" onclick="id_check();"> <br /> <span
                  id="idcheck"></span></td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td><input type="password" name="mem_pwd" id="mem_pwd"
                  size="14" class="input_box" /></td>
            </tr>
            <tr>
               <th>비밀번호확인</th>
               <td><input type="password" name="mem_pwd2" id="mem_pwd2"
                  size="14" class="input_box" /></td>
            </tr>
            <tr>
               <th>회원이름</th>
               <td><input name="mem_name" id="mem_name" size="14"
                  class="input_box" /></td>
            </tr>
            
            <tr>
               <th>회원 권한</th>
               <td>
                 <input type="checkbox" name="roles[0].roleName" value="BASIC" checked>BASIC
                 <input type="checkbox" name="roles[1].roleName" value="MANAGER" checked>MANAGER
                 <input type="checkbox" name="roles[2].roleName" value="ADMIN" checked>ADMIN
                 <!--  MemberVO 엔티티빈 클래스에서 List<MemberRole>로 
                 처리되기 때문에 [0] 컬렉션 주소 인덱스 번호로 처리한다. -->
                </td> 
            </tr>
            
            
            </table>
         <div id="mJoin_menu">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
               <%--post방식으로 데이터를 전송할 때에는 스프링 시큐리티에서는 CSRF 토큰을 같이 보내야 한다. --%>
            <input type="submit" value="가입" class="input_b" /> <input
               type="reset" value="취소" class="input_b"
               onclick="$('#mem_id').focus();" />
         </div>
      </form>
   </div>
   </body>
</html>