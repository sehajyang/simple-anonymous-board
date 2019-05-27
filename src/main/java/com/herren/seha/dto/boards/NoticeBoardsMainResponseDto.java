package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.notice.NoticeBoards;
import com.herren.seha.util.CommonUtil;
import lombok.Getter;

/**
 * @author seha
 * @date 2019-05-16
 */

@Getter
public class NoticeBoardsMainResponseDto {
    private Long boardNo;
    private String title;
    private String passwd;
    private String writer;
    private String content;
    private String moddate;
    private String uuid;
    private String category;

    // XXX : private 이던 toStringDateTime > public 으로해서 에러날 수 있음
    public NoticeBoardsMainResponseDto(NoticeBoards entity) {
        boardNo = entity.getBoardNo();
        title = entity.getTitle();
        passwd = entity.getPasswd();
        writer = entity.getWriter();
        content = entity.getContent();
        moddate = CommonUtil.toStringDateTime(entity.getModdate());
        uuid = entity.getUuid();
        category = entity.getCategory();
    }
}

