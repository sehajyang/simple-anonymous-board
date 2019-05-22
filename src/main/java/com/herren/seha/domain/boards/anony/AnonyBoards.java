package com.herren.seha.domain.boards.anony;

import com.herren.seha.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author seha
 * @date 2019-05-15
 */

@NoArgsConstructor
@Getter
@Entity
public class AnonyBoards extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long boardNo;

    @Column(length = 500)
    private String title;

    private String passwd;

    private String writer;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Integer hit;

    private String category;

    private String sendyn;

    @Builder
    public AnonyBoards(String title, String passwd, String writer, String content, Integer hit, String category, String sendyn) {
        this.title = title;
        this.passwd = passwd;
        this.writer = writer;
        this.content = content;
        this.hit = hit;
        this.category = category;
        this.sendyn = sendyn;
    }

}
