package com.herren.seha.domain.boards.anony;

import com.herren.seha.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author seha
 * @date 2019-05-15
 */

@NoArgsConstructor
@Getter
@Setter
@Entity
public class AnonyBoards extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "board_no")
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

    private String uuid;

    @OneToMany(mappedBy = "boardNo", cascade = {CascadeType.ALL})
    private Set<AnonyBoardsLike> anonyboardsLike = new HashSet<>();


    @Builder
    public AnonyBoards(String title, String passwd, String writer, String content, Integer hit,
                       String category, String sendyn, String uuid) {
        this.title = title;
        this.passwd = passwd;
        this.writer = writer;
        this.content = content;
        this.hit = hit;
        this.category = category;
        this.sendyn = sendyn;
        this.uuid = uuid;
    }

}
