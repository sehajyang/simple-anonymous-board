function onclickDelPost(boardNo) {
    $.ajax({
        url: '/boards/anony/' + boardNo + '/delete',
        type: 'POST',
        success: function (data) {
            if(data == 'SUCCESS'){
                alert('삭제되었습니다');
                location.href='/boards/anony';
            }
        }
    });
}