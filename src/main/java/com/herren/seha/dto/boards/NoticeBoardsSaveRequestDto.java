package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.notice.NoticeBoards;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

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
    private String uuid;
    private String category;

    @Builder
    public NoticeBoardsSaveRequestDto(String title, String content, String passwd,
                                      String writer, String uuid, String category) {
        this.title = title;
        this.content = content;
        this.passwd = passwd;
        this.writer = writer;
        this.uuid = UUID.randomUUID().toString();
        this.category = category;
    }

    public NoticeBoards toEntity(){
        return NoticeBoards.builder()
                .title(title)
                .content(content)
                .passwd(passwd)
                .writer(writer)
                .uuid(UUID.randomUUID().toString())
                .category(category)
                .build();
    }


}
