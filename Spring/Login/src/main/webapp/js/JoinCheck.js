function join_check() {
    if($.trim($('#m_id').val()) == ''){
        alert('아이디를 입력해주세요');
        $('#m_id').val('').focus();
        return false;
    }

    if($.trim($('#m_pwd').val()) == ''){
        alert('비밀번호를 입력해주세요');
        $('#m_pwd').val('').focus();
        return false;
    }

    if($.trim($('#m_pwdC').val()) == ''){
        alert('비밀번호 확인를 입력해주세요');
        $('#m_pwdC').val('').focus();
        return false;
    }

    if($.trim($('#m_pwd').val()) != ($.trim($('#m_pwdC').val()))){
        alert("비밀번호가 다릅니다");
        $('#m_pwd').val('').focus();
        $('#m_pwdC').val('');
        return false;
    }

    if($.trim($('#m_name').val()) == ''){
        alert('이름을 입력해주세요');
        $('#m_name').val('').focus();
        return false;
    }

    if($.trim($('#m_day').val()) == ''){
        alert('생년월일을 입력해주세요');
        $('#m_day').val('').focus();
        return false;
    }

    if($.trim($('#m_phone').val()) == ''){
        alert('전화번호를 입력해주세요');
        $('#m_phone').val('').focus();
        return false;
    }


}