package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.anony.AnonyBoards;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author seha
 * @date 2019-05-15
 */

@Getter
@Setter
@NoArgsConstructor
public class BoardsLikeSaveRequestDto {

    private Long userNo;
    private Set<AnonyBoards> boardNo;

    @Builder
    public BoardsLikeSaveRequestDto(Long userNo, Set<AnonyBoards> boardNo) {
        this.userNo = userNo;
        this.boardNo = boardNo;
    }

}
