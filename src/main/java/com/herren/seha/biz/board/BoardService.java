package com.herren.seha.biz.board;

import com.herren.seha.domain.boards.BoardsRepository;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author seha
 * @date 2019-05-15
 */

@AllArgsConstructor
@Service
public class BoardService {
    private BoardsRepository boardsRepository;

    @Transactional
    public Long regBoards(BoardsSaveRequestDto dto) {
        return boardsRepository.save(dto.toEntity()).getBoardNo();
    }
}
