package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.notice.NoticeBoards;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author seha
 * @date 2019-05-15
 */

@Getter
@Setter
@NoArgsConstructor
public class NoticeBoardsSaveRequestDto {

    private String title;
    private String content;
    private String passwd;
    private String writer;

    @Builder
    public NoticeBoardsSaveRequestDto(String title, String content, String passwd, String writer) {
        this.title = title;
        this.content = content;
        this.passwd = passwd;
        this.writer = writer;
    }

    public NoticeBoards toEntity(){
        return NoticeBoards.builder()
                .title(title)
                .content(content)
                .passwd(passwd)
                .writer(writer)
                .build();
    }


}
