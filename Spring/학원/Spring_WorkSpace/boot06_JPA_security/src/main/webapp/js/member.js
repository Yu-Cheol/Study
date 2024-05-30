/**
 * member.js
 */

 function join_check(){
   if($.trim($("#mem_id").val())==""){
      alert("회원아이디를 입력하세요!");
      $("#mem_id").val("").focus();
      return false;
   }
   
   $mem_pwd=$.trim($("#mem_pwd").val());
   $mem_pwd2=$.trim($("#mem_pwd2").val());
   if($mem_pwd == ""){
      alert("비번을 입력하세요!");
      $("#mem_pwd").val("").focus();
      return false;
   }
   if($mem_pwd2 == ""){
      alert("비번확인을 입력하세요!");
      $("#mem_pwd2").val("").focus();
      return false;
   }
   if($mem_pwd != $mem_pwd2){
      alert("비번이 다릅니다!");
      $("#mem_pwd").val("");//비번 입력박스를 초기화
      $("#mem_pwd2").val("");
      $("#mem_pwd").focus();
      return false;
   }
   if($.trim($("#mem_name").val())==""){
      alert("회원이름을 입력하세요!");
      $("#mem_name").val("").focus();
      return false;
   }   
   
   
}//join_check()

//중복아이디 검색
function id_check(){
   $("#idcheck").hide();
   //아이디 영역을 숨김
   $mem_id=$.trim($("#mem_id").val());
   //alert($mem_id);
   
   //1.입력글자 길이 체크
   if($mem_id.length < 4){
      $newtext='<font color="red" size="3"><b>아이디는 4자 이상이어야 합니다.</b></font>';
      $("#idcheck").text('');
      //idcheck 아이디 영역 문자열을 초기화
      $("#idcheck").show();
      //idcheck 아이디 영역을 보이게 함.
      $("#idcheck").append($newtext);
      //idcheck영역에 문자열을 추가
      $("#mem_id").val('').focus();
      return false;
   };
   if($mem_id.length > 12){
      $newtext='<font color="red" size="3"><b>아이디는12자 이하이어야 합니다.</b></font>';
      $("#idcheck").text('');
      //idcheck 아이디 영역 문자열을 초기화
      $("#idcheck").show();
      //idcheck 아이디 영역을 보이게 함.
      $("#idcheck").append($newtext);
      //idcheck영역에 문자열을 추가
      $("#mem_id").val('').focus();
      return false;
   };
   //2.입력글자 확인
   if(!(validate_userid($mem_id))){
      $newtext='<font color="red" size="3"><b>아이디는 영문소문자,숫자,_조합만 가능합니다.</b></font>';
      $("#idcheck").text('');
      $("#idcheck").show();
      $("#idcheck").append($newtext);
      $("#mem_id").val('').focus();
      return false;
   };
   
   /*스프링 시큐리티에서 비동기식 ajax 통신 시 403 forbidden 에러 발생 해결법)   
      에러 원인=> csrf(Cross-site request forgery)의 token이 누락으로 발생한다고 한다.
      
      mem_join.jsp에 head 태그 내에 csrf meta tag를 추가해준다
       <meta name="_csrf_header" content="${_csrf.headerName}">
       <meta name="_csrf" content="${_csrf.token}">
       
        var header = $("meta[name='_csrf_header']").attr('content');
        var token = $("meta[name='_csrf']").attr('content');
        
        beforeSend: function(xhr){
         xhr.setRequestHeader(header, token);
        },
        코드를 추가한다. 그러면 403 접근 금지 에러가 해결된다.
   */
   
    var header = $("meta[name='_csrf_header']").attr('content');
    var token = $("meta[name='_csrf']").attr('content');

   //아이디 중복확인
    $.ajax({//$는 jQuery란 뜻. $.ajax 뜻은 jQuery 내의 아작스 실행
        type:"POST",//데이터를 서버로 보내는 방법
       //url:"./member/member_idcheck.jsp",    
        url:"member_idcheck", //url 패턴 매핑주소 경로
        beforeSend: function(xhr){
         xhr.setRequestHeader(header, token);
        },
        data: {"id":$mem_id},  //좌측 id 피라미터 이름에 우측 $mem_id변수값을 저장
        datatype:"int",//서버의 실행된 결과값을 사용자로 받아오는 자료형
        success: function (data) {//success는 아작스로 받아오는것이 성공했을경우
           //서버 데이터를 data변수에 저장
           if(data==1){//중복 아이디가 있다면
            $newtext='<font color="red" size="3"><b>중복 아이디입니다.</b></font>';
            $("#idcheck").text('');
           $("#idcheck").show();
           $("#idcheck").append($newtext);                
             $("#mem_id").val('').focus();
             return false;
        
           }else{//중복 아이디가 아니면
            $newtext='<font color="blue" size="3"><b>사용가능한 아이디입니다.</b></font>';
            $("#idcheck").text('');
            $("#idcheck").show();
            $("#idcheck").append($newtext);
            $("#mem_pwd").focus();
           }              
        },
         error:function(){//비동기식 아작스로 서버디비 데이터를
            //못가져와서 에러가 발생했을 때 호출되는 함수이다.
            alert("data error");
         }
      });//$.ajax
 /* end */   
}//id_check()

//정규표현식으로 아이디 유효성 검사
function validate_userid($mem_id)
{
  var pattern= new RegExp(/^[a-z0-9_]+$/);//아이디를 영문소문자와 숫자 와 _조합으로 처리
  return pattern.test($mem_id);
};