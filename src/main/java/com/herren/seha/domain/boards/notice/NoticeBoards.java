package com.herren.seha.domain.boards.notice;

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
public class NoticeBoards extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 500)
    private String title;

    private String passwd;

    private String writer;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Integer hit;

    private String uuid;

    private String category;

    @Builder
    public NoticeBoards(String title, String passwd, String writer,
                        String content, String uuid, String category) {
        this.title = title;
        this.passwd = passwd;
        this.writer = writer;
        this.content = content;
        this.uuid = uuid;
        this.category = category;
    }

}
