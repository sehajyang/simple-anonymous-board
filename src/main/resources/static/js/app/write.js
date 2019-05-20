var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save: function () {
        var data = {
            title: $('#title').val(),
            passwd: $('#passwd').val(),
            writer: $('#writer').val(),
            content: $('#content').val()
        };

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