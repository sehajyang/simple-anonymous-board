package com.herren.seha.dto.boards;

import com.herren.seha.domain.boards.anony.AnonyBoards;
import com.herren.seha.domain.boards.anony.AnonyBoardsLike;
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
public class BoardsLikeSaveRequestDto {

    private Long userNo;
    private AnonyBoards boardNo;

    @Builder
    public BoardsLikeSaveRequestDto(Long userNo, AnonyBoards boardNo) {
        this.userNo = userNo;
        this.boardNo = boardNo;
    }

    public AnonyBoardsLike toEntity() {
        return AnonyBoardsLike.builder()
                .userNo(userNo)
                .boardNo(boardNo)
                .build();
    }

}
