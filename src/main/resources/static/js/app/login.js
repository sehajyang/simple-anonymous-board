var login = {
    init: function () {
        var _this = this;
        $('#btn-login').on('click', function () {
            _this.save();
        });
    },
    save: function () {
        var data = {
            id: $('#id').val(),
            passwd: $('#passwd').val(),
        };

        if($('#id').val() === "" || $('#passwd').val() === ""){
            alert('빈 필드를 채워주세요');
            return false;
        }

        $.ajax({
            type: 'POST',
            url: '/login',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(responseData){
            if (responseData === 1) {
                alert('로그인 되었습니다');
                location.href = '/lobby';
            }else if(responseData === 0){
                alert('아이디 혹은 비밀번호가 다릅니다');
            }
        });
    }
};

login.init();