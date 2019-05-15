package com.herren.seha.models.boards;

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

    public Boards toEntity(){
        return Boards.builder()
                .title(title)
                .content(content)
                .passwd(passwd)
                .build();
    }


}
