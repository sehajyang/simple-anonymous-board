function onclickDelPost(boardNo, grade) {
    if($('#board-kind').val() === 'notice'){
        if(grade !== '관리자' && grade !== '사장'){
            alert('권한이 없습니다');
            location.href= '/boards/notice';
            return false;
        }
    }
    $.ajax({
        url: '/boards/' + $('#board-kind').val() + '/' + boardNo + '/delete',
        type: 'POST',
        success: function (data) {
            if (data == 'SUCCESS') {
                alert('삭제되었습니다');
                location.href = '/boards/' + $('#board-kind').val();
            }
        }
    });
}