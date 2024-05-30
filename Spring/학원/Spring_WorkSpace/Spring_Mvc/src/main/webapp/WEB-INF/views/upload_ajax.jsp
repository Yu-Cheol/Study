<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
 $(document).ready(function(){
	
	 $('#uploadBtn').on('click',function(){
		
		 var formData = new FormData();
		 /* 첨부파일을 업로드 하는 또 다른 방식은 jQuery 아작스를 이용해서 파일 데이터만을 전송
		 하는 방식이다. ajax를 이용하는 첨부파일 처리는 FormData라는 객체를 이용하는데 IE인 경
		 우에는 10버전 이후부터 지원된다. 그러므로 브라우저 제약이 있을 수 있다.	 
		 */
		 var inputFile = $("input[name='uploadFile']");//file객체를 네임피라미터
		 //이름으로 접근해서 구함
		 var files = inputFile[0].files;//첫번째 파일객체에서 첨부한파일을 배열로 구한다.
		 
		 for(var i=0;i<files.length;i++){
			 formData.append("uploadFile",files[i]);//첨부파일을 폼데이터에 추가
		 }//for
		 
		 $.ajax({//jQuery 비동기식 아작스 함수
			 url:'/uploadAjaxForm_OK',//서버 매핑주소
			 processData : false,//false로 지정해야 전송, processData를 컨텐트 타입
			 //에 맞게 변환여부
			 contentType:false,//요청 컨텐트 타입
			 data:formData,//formData자체를 전송
			 type:'POST', //메서드 보내는 방식
			 success:function(data){
				//받아오는 것이 성공시 호출 
			 }
		 });
	 });
 });
</script>
</head>
<body>
  <h1>비동기식 Upload with Ajax</h1>
  <input type="file" name="uploadFile" multiple >
  <hr>
  <button type="submit" id="uploadBtn">파일업로드</button>
</body>
</html>





