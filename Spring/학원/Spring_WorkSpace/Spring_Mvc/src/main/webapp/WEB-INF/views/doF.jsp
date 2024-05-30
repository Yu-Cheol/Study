<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="name2" value="${name}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<script type="text/javascript">
 
 //$msg= "${name2}";//jsp의 EL문법이다.
 $msg = '<c:out value="${name2}" />';
 window.alert($msg);//$msg는 jQuery변수이다. 
 /*
  백엔드 서버언어인 jsp의 문법중 JSTL,EL을 클라이언트(사용자) 스크립트 언어인 javascript에서
  사용할 수 있다.
 */
</script>
</body>
</html>