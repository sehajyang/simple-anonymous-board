package com.herren.seha.domain.boards.anony;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author seha
 * @date 2019-05-22
 */

@NoArgsConstructor
@Getter
@Entity
public class AnonyBoardsLike {

    @Id
    @GeneratedValue
    private Long boardLikeNo;

    private Long userNo;

    @OneToMany
    private Set<AnonyBoards> boardNo = new HashSet<>();

}
