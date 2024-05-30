<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 스프링 MVC 게시판 글수정</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="../js/board.js"></script>
<%-- ../는 한단계 상위경로로 이동, ../../는 두단계 상위경로로 이동 --%>
</head>
<body>
<h2>스프링 부트 MVC 게시판 수정폼</h2>
<form method="post" action="board_edit_ok" 
onsubmit="return write_check();">
<input type="hidden" name="bno" value="${eb.bno}" >
<input type="hidden" name="page" value="${page}" >

 글쓴이 : <input type="text" name="writer" id="writer" size="14" 
        placeholder="글쓴이 입력" value="${eb.writer}" >
        <br><span id="error_writer"></span> <%--여기에 유효성 검증 메시지가 출력 --%>
 <br><br>
 글제목 : <input type="text" name="title" id="title" size="36" 
        placeholder="글제목 입력" value="${eb.title}">
        <br><span id="error_title"></span>
 <br><br>
 글내용 : <textarea rows="10" cols="36" name="content" 
 id="content" placeholder="글내용 입력" >${eb.content}</textarea>
        <br><span id="error_content"></span>
 <hr>
 <button type="submit">글수정</button>
 <button type="reset" onclick="$('#writer').focus();">취소</button>
 <button type="button" onclick="location=
	 '/board/board_list?page=${page}';">목록</button>
</form>
</body>
</html>

