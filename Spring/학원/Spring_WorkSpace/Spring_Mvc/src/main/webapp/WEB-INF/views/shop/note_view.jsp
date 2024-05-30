<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>
상품이름 : ${pv.productName}<hr>
<%-- 위의 표현언어(EL)를 자바코드로 표현하면 pv.getProductName();과 기능이 같다. --%>
상품가격 : \ <strong>${pv.productPrice}</strong> 원<hr>
</body>
</html>