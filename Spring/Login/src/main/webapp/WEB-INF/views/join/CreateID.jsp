<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="../css/CreateID.css">
	<div class="create_container">
		<div class="member">
			<%-- 필드 --%>
			<div class="field">
				<b>아이디</b> <span class="placehold-text"><input type="text"></span>
			</div>
			<div class="field">
				<b>비밀번호</b> <input class="userpw" type="password">
			</div>
			<div class="field">
				<b>비밀번호 재확인</b> <input class="userpw-confirm" type="password">
			</div>
			<div class="field">
				<b>이름</b> <input type="text">
			</div>
			<%-- 필드 (생년월일) --%>
			<div class="field birth">
				<b>생년월일</b>
				<div>
					<input type="number" placeholder="년(4자)"> 
					<select>
						<option value="">월</option>
						<option value="">1월</option>
						<option value="">2월</option>
						<option value="">3월</option>
						<option value="">4월</option>
						<option value="">5월</option>
						<option value="">6월</option>
						<option value="">7월</option>
						<option value="">8월</option>
						<option value="">9월</option>
						<option value="">10월</option>
						<option value="">11월</option>
						<option value="">12월</option>
					</select> 
					<input type="number" placeholder="일">
				</div>
			</div>
			<%-- 필드(성별) --%>
			<div class="field gender">
				<b>성별</b>
				<div>
					<label><input type="radio" name="gender">남자</label> <label><input
						type="radio" name="gender">여자</label>
				</div>
			</div>
			<%-- 이메일, 전화번호 --%>
			<div class="field">
				<b>본인 확인 이메일<small>(선택)</small></b> <input type="email"
					placeholder="선택입력">
			</div>

			<div class="field tel-number">
				<b>휴대전화</b> <select>
					<option value="">대한민국 +82</option>
				</select>
				<div>
					<input type="tel" placeholder="전화번호 입력"> <input
						type="button" value="인증번호 받기">
				</div>
				<div>
					<input type="text" placeholder="인증번호를 입력하세요"> <input
						type="button" value="인증번호 확인">
				</div>
			</div>
			<%-- 가입하기 --%>
			<input type="submit" value="가입하기">
		</div>
	</div>
<jsp:include page="../include/footer.jsp" />