var main = {
    init: function () {
        var _this = this;
        $('#btn-modify').on('click', function () {
            _this.save();
        });
    },
    save: function () {
        var data;
        if ($('#board-kind').val() === 'anony') {
            data = {
                title: $('#title').val(),
                passwd: $('#passwd').val(),
                writer: $('#writer').val(),
                content: $('#content').val(),
                category: $('#category').val(),
                sendyn: $('#sendyn').val()
            };
        } else {
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
            url: '/boards/' + $('#board-kind').val() + '/' + $('#board-no').val(),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            location.href = '/boards/' + $('#board-kind').val() + '/' + $('#board-no').val();
        }).fail(function (error) {
            console.log(error);
        });
    }
};

main.init();