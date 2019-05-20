var main = {
    init : function () {
        var _this = this;
        $('#btn-modify').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            passwd: $('#passwd').val(),
            writer: $('#writer').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/boards/anony/'+ $('#board-no').val(),
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            location.reload();
        }).fail(function (error) {
            location.reload();
        });
    }

};

main.init();