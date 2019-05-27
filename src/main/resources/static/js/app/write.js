var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save: function () {
        var data;
        if($('#board-kind').val() === 'anony'){
            data = {
                title: $('#title').val(),
                passwd: $('#passwd').val(),
                writer: $('#writer').val(),
                content: $('#content').val(),
                category : $('#category').val(),
                sendyn : $('#sendyn').val()
            };
        }else{
            data = {
                title: $('#title').val(),
                passwd: $('#passwd').val(),
                writer: $('#writer').val(),
                content: $('#content').val(),
                category: $('#category').val()
            };
        }

        if($('#title').val() === "" || $('#content').val() === ""){
            alert('빈 필드를 채워주세요');
            return false;
        }

        $.ajax({
            type: 'POST',
            url: '/boards/' + $('#board-kind').val() + '/',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            location.href = '/boards/'+ $('#board-kind').val() +'/';
        }).fail(function (error) {
            alert(error);
        });
    }

};

main.init();

var join = {
    init: function () {
        var _this = this;
        $('#btn-join').on('click', function () {
            _this.save();
        });
    },
    save: function () {

        var userData = {
            id : $('#id').val(),
            passwd : $('#passwd').val()
        };

        if($('#id').val() === "" || $('#passwd').val() === ""){
            alert('빈 필드를 채워주세요');
            return false;
        }

        $.ajax({
            type: 'POST',
            url: '/register',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(userData),
            success: function(data) {
                console.log(data)
            }}
        ).done(function (data) {
            if(data === 1){
                alert('회원가입이 완료되었습니다. 로그인 해주세요');
                location.href='/login'
            }else{
                alert('이미 가입된 아이디입니다.');
            }
        }).fail(function (error){
            alert('오류가 발생했습니다.');
            console.log(error);
        });
    }
};

join.init();