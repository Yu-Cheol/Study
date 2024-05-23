function login_check(){
    if($.trim($('#user_id').val()) == ''){
        alert('아이디를 입력해주세요');
        $('#user_id').val('').focus();
        return false;
    }

    if($.trim($('#user_pwd').val()) == ''){
        alert('비밀번호를 입력해주세요');
        $('#user_pwd').val('').focus();
        return false;
    }

}