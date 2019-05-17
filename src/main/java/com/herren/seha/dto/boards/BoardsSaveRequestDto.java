package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.anony.AnonyBoards;
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
public class BoardsSaveRequestDto {

    private String title;
    private String content;
    private String passwd;

    @Builder
    public BoardsSaveRequestDto(String title, String content, String passwd) {
        this.title = title;
        this.content = content;
        this.passwd = passwd;
    }

    public AnonyBoards toEntity(){
        return AnonyBoards.builder()
                .title(title)
                .content(content)
                .passwd(passwd)
                .build();
    }


}
