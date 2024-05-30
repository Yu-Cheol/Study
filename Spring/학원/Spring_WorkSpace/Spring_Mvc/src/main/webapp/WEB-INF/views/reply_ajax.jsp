<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
 #modDiv{ /*댓글 수정화면 */
   width:300px; height:100px;
   background-color:gray;
   position: absolute;
   top:50%;
   left:50%;
   margin-top:-50px;
   margin-left:-150px;
   padding:10px;
   z-index:1000; /* position:absolute or fixed;로 설정된 상태에서 사용한다.
   이 속성은 요소가 겹쳐지는 순서를 제어할 수 있다. 숫자가 클수록 앞에 배치된다. */
 }
</style>
</head>
<body>
 <%--댓글 수정화면 --%>
 <div id="modDiv" style="display:none;"> 
 <%-- css속성값에서 display:none;은 자리도 차지하지 않고 안보이게 한다. --%>
   <div class="modal-rno"></div> <%--댓글 번호가 출력되는 부분 --%>
   <div>
    <textarea rows="3" cols="30" id="replytext"></textarea>
   </div>
   <div>
    <button type="button" id="replyModBtn">댓글수정</button>
    <button type="button" id="replyDelBtn">댓글삭제</button>
    <input type="button" value="닫기" id="closeBtn"
     onclick="modDivClose();" >
   </div>
 </div>
 
 <h2>아작스 댓글 페이지</h2>
 <div>
  <div>
   댓글 작성자:<input type="text" name="replyer" id="newReplyWriter" >
  </div>
  <br>
  <div>
   댓글 내용:<textarea rows="5" cols="30" 
   name="replytext" id="newReplyText"></textarea>
  </div>
  <br>
  <button id="replyAddBtn">댓글 등록</button>
  <%--button 태그에서 type 속성 생략하면 기본값은 submit 이다. --%>
 </div>
 
 <br><hr><br>
 
 <%--댓글 목록 --%>
 <ul id="replies"></ul>
 
 <script type="text/javascript">
   $bno = 14;//게시판 번호
   
   getAllList();//댓글 목록 함수 호출
   function getAllList(){//자바스크립트 예약어인 function으로 getAllList()함수 정의
	   $.getJSON("/replies/all/"+$bno, function(data){
		  var result="";//javascript에서 var은 변수정의 키워드이다.
		  $(data).each(function(){//each()함수로 li태그 기준으로 반복
			  
			  result += "<li data-rno='"+this.rno+"' class='replyLi'>"
+ this.rno +" : <span class='com' style='color:blue;font-weight:bold;'>"
+ this.replytext +"</span> <button>댓글수정</button></li><br>";
		  });
		  
		  $('#replies').html(result);//태그와 문자를 함께 변경 적용
	   });
   }//getAllList()
   
   //댓글 등록
   $('#replyAddBtn').on('click',function(){
      $replyer = $('#newReplyWriter').val();//댓글 작성자
      $replytext = $('#newReplyText').val();//댓글 내용
      
      $.ajax({//jQuery 비동기식 아작스 함수
    	 type:'post',//메서드 보내는 방식
    	 url:'/replies/addReply', //매핑주소 경로
    	 headers:{
    		"Content-Type":"application/json",
    		"X-HTTP-Method-Override":"POST"
    	 }, //http 헤더 앞에 붙여서 json방식 키,값 쌍데이터가 추가되어져서 전달
    	 dataType:'text',//자료 타입이 문자
    	 data:JSON.stringify({
    		bno:$bno, //키:값 쌍 JSON데이터
    		replyer:$replyer,
    		replytext:$replytext
    	 }),
    	 success:function(data){//받아오는 것이 성공시 호출되는 콜백함수, 받아온 데이터는
    		 //data매개변수에 저장
    		 if(data == 'success'){
    			 alert('댓글이 등록되었습니다!');
    			 getAllList();//댓글목록함수 호출
    		 }
    	 }
      });
   });
   
   //댓글수정 화면
   $('#replies').on("click",".replyLi button", function(){
      $reply = $(this).parent();//parent()부모요소는 li태그를 가리킴.this는 버튼
      $rno = $reply.attr('data-rno');//data-rno속성값 댓글번호를 구함
      $replytext = $reply.children('.com').text();//댓글 내용
      
      $('.modal-rno').html($rno);//댓글 번호를 표시
      $('#replytext').val($replytext);//textarea입력필드에 댓글내용을 표시
      $('#modDiv').show('slow');//댓글수정 화면 표시
   });
   
   //댓글수정 화면닫기
   function modDivClose(){
	   $('#modDiv').hide('slow');
   }
   
   //댓글수정 완료
   $('#replyModBtn').on("click",function(){
	  $rno = $('.modal-rno').html();//댓글번호
	  $replytext = $('#replytext').val();//댓글 수정내용
	  
	  $.ajax({
		 type:'put',//전송되는 방식
		 url:'/replies/'+$rno,
		 headers:{
			"Content-Type":"application/json",
			"X-HTTP-Method-Override":"PUT"
		 },
		 data:JSON.stringify({
			replytext:$replytext //키:값 쌍 JSON데이터 
		 }),
		 dataType:'text',
		 success:function($result){
			 if($result == 'success'){
				 alert('댓글이 수정되었습니다!');
				 $('#modDiv').hide('slow');
				 getAllList();
			 }
		 }
	  });
   });
   
   //댓글 삭제
   $('#replyDelBtn').on('click',function(){
	   $rno = $('.modal-rno').html();//댓글 번호
	   
	   $.ajax({//jQuery 비동기식 아작스 함수
		   type:'delete', //메서드 방식
		   url:'/replies/'+$rno, //삭제 매핑주소
		   headers:{
			   "Content-Type":"application/json",
				"X-HTTP-Method-Override":"DELETE"
		   },
		   dataType:'text',
		   success:function($result){
			   if($result == 'success'){
				   alert('댓글이 삭제되었습니다!');
				   $('#modDiv').hide('slow');
				   getAllList();//댓글 목록함수 호출
			   }
		   }
	   });
   });
 </script>
</body>
</html>































