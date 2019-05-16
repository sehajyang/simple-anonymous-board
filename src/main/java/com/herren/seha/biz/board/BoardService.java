package com.herren.seha.biz.board;

import com.herren.seha.domain.boards.Boards;
import com.herren.seha.domain.boards.BoardsRepository;
import com.herren.seha.dto.boards.BoardsMainResponseDto;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author seha
 * @date 2019-05-15
 */

@AllArgsConstructor
@Service
@Log4j2
public class BoardService {
    private BoardsRepository boardsRepository;

    @Transactional(readOnly = true)
    public List<BoardsMainResponseDto> getBoardsList() {
        return boardsRepository.getBoardsList()
                .map(BoardsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long regBoards(BoardsSaveRequestDto dto) {
        return boardsRepository.save(dto.toEntity()).getBoardNo();
    }

    @Transactional(readOnly = true)
    public Boards getBoardsDetail(Long boardNo) {
        log.debug("###################" + boardsRepository.getBoardDetail(boardNo));
        return boardsRepository.getBoardDetail(boardNo);
    }

    @Transactional
    public int modBoards(Long boardNo, String title, String content) {
        return boardsRepository.modBoard(boardNo, title, content);
    }

    @Transactional
    public int delBoards(Long boardNo) {
        return boardsRepository.delBoard(boardNo);
    }
}
