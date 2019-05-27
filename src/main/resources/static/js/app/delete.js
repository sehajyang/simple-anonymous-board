function onclickDelPost(boardNo) {
    if(document.cookie !== 'passauth='+'{{boardDetail.uuid}}'){
        alert('부적절한 경로로 접근했습니다');
        location.href = "/boards/"+$('#board-kind').val()+"/{{boardNo}}"
    }else{
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
}