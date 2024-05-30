<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 게시판 목록</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<h2>스프링 MVC 게시판 목록보기</h2>
<table border="1">
  <tr>
   <td colspan="5" align="right">
    <strong style="color:gold; font-size:18px;">${totalCount} 개</strong>
   </td>
  </tr>
  <tr>
   <th>번호</th> <th>제목</th> <th>글쓴이</th> <th>조회수</th> <th>등록날짜</th>
  </tr>
  
  <c:if test="${!empty blist}">
   <c:forEach var="b" items="${blist}">
   <tr>
    <th>${b.bno}</th>
    <td style="padding-left:10px; font-weight:bolder;">
    <a href="/board/board_cont?bno=${b.bno}&page=${page}">${b.title}</a>
    &nbsp;&nbsp;
    <c:if test="${b.replycnt != 0}"> <%--댓글이 있는 경우만 출력 --%>
    <span style="color:red;background:gold;font-size:14px;
      border-radius:15px; padding:2px; box-shadow:3px 3px 3px gray;">
       [댓글 개수 :${b.replycnt} 개]</span>
    </span>
    </c:if>        
    </td>
    <th>${b.writer}</th>
    <th>${b.viewcnt}</th>
    <th>${fn:substring(b.regdate,0,10)}</th> 
    <%-- 문제)fn 태그립 jstl과 EL을 사용해서 등록날짜에 년월일만 출력되게 해보자. 0이상 10미만
    사이 년월일만 반환--%>
   </tr>
   </c:forEach>
  </c:if>
  
  <c:if test="${empty blist}">
   <tr><th colspan="5">게시물 목록이 없습니다.</th>
  </c:if>
  
  <%--페이징(쪽나누기) --%>
  <tr>
   <th colspan="5">
   <c:if test="${page <= 1}">
    [이전]&nbsp;
   </c:if>
   <c:if test="${page > 1}">
    <a href="/board/board_list?page=${page-1}">[이전]</a>&nbsp;
   </c:if>
   
   <%--쪽번호(페이지번호) 출력 --%>
   <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
     <c:if test="${a == page}"> <%--현재 쪽번호가 선택된 경우 --%>
      <${a}>
     </c:if>
     <c:if test="${a != page}"> <%--현재 쪽번호가 선택 안된 경우 --%>
      <a href="/board/board_list?page=${a}">[${a}]</a>&nbsp;
     </c:if>
   </c:forEach>
   
   <c:if test="${page >= maxpage}">
    [다음]
   </c:if>
   <c:if test="${page < maxpage}">
    <a href="/board/board_list?page=${page+1}">[다음]</a>
   </c:if>
   </th>
  </tr>
  
  <tr>
   <td colspan="5" align="right">
   <button type="button" onclick=
   "location='/board/board_write?page=${page}';">글쓰기</button> 
   <%-- board_write?page=쪽번호가 get방식으로 전달되어 져서 내가 본 쪽번호로 이동한다.
   이것을 페이징에서 책갈피 기능이라고 한다. --%>
   </td>
  </tr>
</table>

<script>
 $result = "${msg}";//${msg} 는 jsp의 EL 표현언어이다.  
 
 if($result == "SUCCESS"){
	 alert("게시물 처리에 성공했습니다!");
 }
</script>
</body>
</html>










