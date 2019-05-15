package com.herren.seha.models.boards;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author seha
 * @date 2019-05-15
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Boards extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long boardNo;

    @Column(length = 500)
    private String title;

    private String passwd;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Integer hit;

    @Builder
    public Boards(String title, String passwd, String content) {
        this.title = title;
        this.passwd = passwd;
        this.content = content;
    }
}
