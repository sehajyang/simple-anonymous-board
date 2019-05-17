package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.anony.AnonyBoards;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author seha
 * @date 2019-05-16
 */

@Getter
public class BoardsMainResponseDto {
    private Long boardNo;
    private String title;
    private String passwd;
    private String content;
    private String moddate;

    public BoardsMainResponseDto(AnonyBoards entity) {
        boardNo = entity.getBoardNo();
        title = entity.getTitle();
        passwd = entity.getPasswd();
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

