<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
 <h2>화면전환이 있는 동기식 방법의 파일첨부(이진파일(binary mode file))</h2>
 <form method="post" action="uploadForm_OK" enctype="multipart/form-data">
  <%--
     파일첨부 기능인 자료실 만들때 필요한 사항)
      1.먼저 form태그의 메서드 전송방식이 post로 해야한다.get은 안된다. form태그의 method
      속성을 생략하면 기본값이 get방식이다. 그러므로 생략하면 안된다.
      
      2.다음으로 필요한것은 form태그내에서 enctype="multipart/form-data"속성을 지정해야
      한다.
   --%>
   <input type="file" name="uploadFile" multiple >
   <%--multiple 속성을 사용하면 다중 첨부파일을 동시에 서버에 업로드 가능하다. 이 속성은
   IE10 이후에서만 사용가능하다. --%>
   <input type="submit" value="파일 업로드" > 
 </form>
</body>
</html>


