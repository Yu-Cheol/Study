<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="../css/login.css" />
<%-- 로그인 페이지 --%>
<div class="login-container">
	<div class="login-main">
		<!-- <h2>로그인</h2> -->
		<div class="guest-order">
			<div>
				<a href="#">회원 로그인</a>
			</div>
			<div>
				<a href="#">비회원 조회하기</a>
			</div>
		</div>
		<%-- 로그인 창 --%>
		<form action="#" method="POST">
			<div class="input-group">
				<label for="username">아이디:</label> <input type="text" id="username" name="username" required />
			</div>
			<div class="input-group">
				<label for="password">비밀번호:</label> <input type="password" id="password" name="password" required />
			</div>
			<input type="submit" class="login_btn" value="로그인" />
		</form>
		<div class="options">
			<a href="#">아이디 찾기</a> 
			<a href="#">비밀번호 찾기</a> 
			<a href="CreateID.jsp">회원가입</a>
		</div>
		<div class="social-login">
			<input type="submit" class="login_btn" id="login_btn" value="네이버 로그인" />
			<input type="submit" class="login_btn" id="login_btn" value="카카오톡 로그인" />
		</div>
	</div>
</div>
<jsp:include page="../include/footer.jsp" />