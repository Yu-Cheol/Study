<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그아웃 페이지</title>
</head>
<body>
 <h2>Custom LogOut Page</h2>
 <form method="post">
   <h3>LogOut</h3>
   <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token }" >
   <button type="submit" class="btn">로그아웃</button>
 </form>
</body>
</html>