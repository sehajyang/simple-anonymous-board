package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.anony.AnonyBoards;
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
public class BoardsSaveRequestDto {

    private String title;
    private String content;
    private String passwd;
    private String writer;
    private String category;
    private Integer hit;
    private String sendyn;
    private String uuid;

    @Builder
    public BoardsSaveRequestDto(String title, String content, String passwd, String writer,
                                String category, Integer hit, String sendyn, String uuid) {
        this.title = title;
        this.content = content;
        this.passwd = passwd;
        this.writer = writer;
        this.category = category;
        this.hit = 0;
        this.sendyn = sendyn;
        this.uuid = UUID.randomUUID().toString();
    }

    public AnonyBoards toEntity() {
        return AnonyBoards.builder()
                .title(title)
                .content(content)
                .passwd(passwd)
                .writer(writer)
                .category(category)
                .hit(0)
                .sendyn(sendyn)
                .uuid(UUID.randomUUID().toString())
                .build();
    }


}
