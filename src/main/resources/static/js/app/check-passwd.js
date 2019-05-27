window.onload = function() {
    var checkPwd = {
        init: function () {
            var _this = this;
            $('#btn-check-pwd').on('click', function () {
                _this.checkPasswd();
            });
        },
        checkPasswd: function () {
            $.ajax({
                type: 'POST',
                url: '/boards/' + $('#board-kind').val() + '/' + $('#board-no').val() + '/checkpwd',
                data: {
                    passwd: $('#passwd').val()
                }
            }).done(function (data) {
                if (data !== 'FAIL') {
                    document.cookie = 'passauth='+data;
                    if($('#mod-del-type-save').val() === 'mod'){
                        location.href = '/boards/' + $('#board-kind').val() + '/' + $('#board-no').val() + '/editor';
                    }else if($('#mod-del-type-save').val() === 'del'){
                        onclickDelPost($('#board-no').val());
                    }
                } else {
                    alert('비밀번호가 다릅니다');
                }
            }).fail(function (error) {
                alert('오류가 발생했습니다. 계속되면 개발팀 세하에게 알려주세요');
                console.log(error);
            });
        }
    };

    checkPwd.init();
};