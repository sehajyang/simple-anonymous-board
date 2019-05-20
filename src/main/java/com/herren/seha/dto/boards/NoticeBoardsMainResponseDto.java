package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.notice.NoticeBoards;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

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

    public NoticeBoardsMainResponseDto(NoticeBoards entity) {
        boardNo = entity.getBoardNo();
        title = entity.getTitle();
        passwd = entity.getPasswd();
        writer = entity.getWriter();
        content = entity.getContent();
        moddate = toStringDateTime(entity.getModdate());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}

