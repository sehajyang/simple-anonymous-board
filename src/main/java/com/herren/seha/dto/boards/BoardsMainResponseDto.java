package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.anony.AnonyBoards;
import lombok.Getter;

import static com.herren.seha.util.CommonUtil.toStringDateTime;

/**
 * @author seha
 * @date 2019-05-16
 */

@Getter
public class BoardsMainResponseDto {
    private Long boardNo;
    private String title;
    private String passwd;
    private String writer;
    private String content;
    private String category;
    private String sendyn;
    private String moddate;

    public BoardsMainResponseDto(AnonyBoards entity) {
        boardNo = entity.getBoardNo();
        title = entity.getTitle();
        passwd = entity.getPasswd();
        writer = entity.getWriter();
        content = entity.getContent();
        category = entity.getCategory();
        sendyn = entity.getSendyn();
        moddate = toStringDateTime(entity.getModdate());
    }


}

