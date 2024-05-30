<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>
<h2>스프링 MVC 게시판 내용</h2>
<table border="1">
 <tr>
  <th>제목</th> <td>${bc.title}</td>
 </tr>
 <tR>
  <th>내용</th> <td>${bcont}</td>
 </tR>
 <tr>
  <th>조회수</th> <td>${bc.viewcnt}</td>
 </tr>
 <tr>
  <th colspan="2">
   <button type="button" onclick="location=
	   '/board/board_edit?bno=${bc.bno}&page=${page}';" >글수정</button>
	   <%-- board_edit?bno=번호&page=쪽번호 2개의 피라미터 값이 &기호로 구분해서 get방
	   식으로 전달된다. --%>

   <input type="button" value="글삭제" onclick=
"if(confirm('정말로 게시글을 삭제할까요?') == true) {
	location='/board/board_del?bno=${bc.bno}&page=${page}';}
	else{return;}" >	
	<%-- 자바스크립트 confirm()내장함수는 메시지를 담은 확인/취소 버튼을 가진 창을 만든다.
	확인을 클릭하면 true를 반환해서 삭제로 이동하고 취소를 클릭하면 false를 반환해서 현재창에 
	그래도 있게 한다. 여기서 return;은 값 반환기능이 아니고 종료 기능이다. 다시 한번더 삭제유무
	를 물어볼 때 많이 사용한다.--%>  
	
    <input type="button" value="목록" onclick="location=
    	'/board/board_list?page=${page}';" >	   
  </th>
 </tr>
</table>
</body>
</html>





