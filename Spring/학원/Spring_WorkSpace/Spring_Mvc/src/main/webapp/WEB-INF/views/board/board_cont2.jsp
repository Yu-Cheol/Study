<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 게시판 내용보기와 비동기식 아작스댓글</title>
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

<br><hr><br>

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
 
 <br>
 <hr>
 [댓글 개수 : <span style="color:red;background:gold;font-size:18px;
 border-radius:15px; padding:5px; box-shadow:5px 5px 5px gray;">
 ${bc.replycnt} 개</span>]
 <br>
 
 
 <%--댓글 목록 --%>
 <ul id="replies"></ul>
 
 <script type="text/javascript">
   $bno = ${bc.bno};//게시판 번호 => 자바스크립트에서 JSP문법인 EL OR JSTL 사용가능,
   //${bc.bno}는 EL
   
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
    			 location.reload();//새로고침=>단축키 F5
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
				   location.reload();
				   getAllList();//댓글 목록함수 호출
			   }
		   }
	   });
   });
 </script>
</body>
</html>



