/**
 * board.js
 */

//게시판 유효성 검증
 function write_check(){//function키워드로 write_check()라는 함수를 정의
	
	if($.trim($('#writer').val()) == ''){
$('#error_writer').html("<font size='2' color='red'>글쓴이를 입력하세요</font>");
       $('#writer').val('').focus();
       return false;
	}
	
	if($.trim($('#writer').val()) != ''){
		$('#error_writer').text('');//유효성 검증 메시지 초기화
	}
	
	if($.trim($('#title').val()) ==''){
$('#error_title').html("<font size='2' color='red'>글제목을 입력하세요.</font>");
        $('#title').val('').focus();
        return false;		
	}
	
	if($.trim($('#title').val()) != ''){
		$('#error_title').text('');
	}
	
	if($.trim($('#content').val()) == ''){
$('#error_content').html("<font size='2' color='red'>글내용을 입력하세요.</font>");
       $('#content').val('').focus();
       return false;		
	}
	
	if($.trim($('#content').val()) != ''){
       $('#error_content').text('');		
	}
 }
 
 
 