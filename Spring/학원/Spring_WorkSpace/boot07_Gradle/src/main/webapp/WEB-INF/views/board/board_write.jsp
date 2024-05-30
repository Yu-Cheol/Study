<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 스프링 MVC 게시판 글쓰기</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="../js/board.js"></script>
<%-- ../는 한단계 상위경로로 이동, ../../는 두단계 상위경로로 이동 --%>
</head>
<body>
<h2>스프링 부트 MVC 게시판 입력폼</h2>
<form method="post" onsubmit="return write_check();">
<%--
  action 속성을 생략하면 이전 매핑주소인 board_write가 action속성값이 된다. 그러면 동일 매핑주
  소를 구분하는 요건은 get or post등 메서드 방식으로 처리한다.
 --%>
 글쓴이 : <input type="text" name="writer" id="writer" size="14" 
        placeholder="글쓴이 입력">
        <br><span id="error_writer"></span> <%--여기에 유효성 검증 메시지가 출력 --%>
 <br><br>
 글제목 : <input type="text" name="title" id="title" size="36" 
        placeholder="글제목 입력">
        <br><span id="error_title"></span>
 <br><br>
 글내용 : <textarea rows="10" cols="36" name="content" 
 id="content" placeholder="글내용 입력"></textarea>
        <br><span id="error_content"></span>
 <hr>
 <button type="submit">글쓰기</button>
 <button type="reset" onclick="$('#writer').focus();">취소</button>
 <button type="button" onclick="location=
	 '/board/board_list?page=${page}';">목록</button>
 <%--
   문제)board.js 자바스크립트와 jQuery 추가 코드를 해서 유효성 검증메시지를 띄워보자.
  --%>
</form>
</body>
</html>


