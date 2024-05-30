/**
 * bbs.js
 */

 function write_check(){
	
	$bbs_name = $.trim($('#bbs_name').val());
	if($bbs_name.length == 0){
		alert("글쓴이를 입력하세요!");
		$('#bbs_name').val('').focus();//글쓴이 입력박스 초기화 하고 포커스 이동
		return false;
	}
	
	if($.trim($('#bbs_title').val()).length == 0){
		window.alert('글제목을 입력하세요!');//window.생략가능함
		$('#bbs_title').val('');//글쓴이 입력필드 초기화
		$('#bbs_title').focus();//글쓴이 입력필드로 포커스 이동
		return false;
	}
	
	if($.trim($('#bbs_pwd').val()) == ''){
		alert('비밀번호를 입력하세요!');
		$('#bbs_pwd').val('').focus();
		return false;
	}
	
	if($.trim($('#bbs_cont').val()) == ''){
		alert('글내용을 입력하세요!');
		$('#bbs_cont').val('').focus();
		return false;
	}
 }
 
 
 
 
 