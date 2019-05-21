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
                content: $('#content').val()
            };
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

        $.ajax({
            type: 'POST',
            url: '/register',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(userData)
        }).done(function () {
            alert('회원가입이 완료되었습니다. 로그인 해주세요');
            location.href= '/login'
        }).fail(function (error){
            alert('회원가입에 실패했습니다 재시도 해주세요. 만약 문제가 반복되면 개발팀 세하에게 알려주세요');
            console.log(error);
        });
    }
};

join.init();