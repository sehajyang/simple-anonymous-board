package com.herren.seha.domain.boards.anony;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author seha
 * @date 2019-05-22
 */

@NoArgsConstructor
@Getter
@Setter
@Entity
public class AnonyBoardsLike {

    @Id
    @GeneratedValue
    private Long boardLikeNo;

    private Long userNo;

    @ManyToOne
    private AnonyBoards boardNo;

    @Builder
    public AnonyBoardsLike(Long userNo, AnonyBoards boardNo) {
        this.userNo = userNo;
        this.boardNo = boardNo;
    }
}
