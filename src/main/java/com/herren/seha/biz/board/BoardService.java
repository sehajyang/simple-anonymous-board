package com.herren.seha.biz.board;

import com.herren.seha.domain.boards.anony.AnonyBoards;
import com.herren.seha.domain.boards.anony.AnonyBoardsRepository;
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
    private AnonyBoardsRepository anonyBoardsRepository;

    @Transactional(readOnly = true)
    public List<BoardsMainResponseDto> getAnonyBoardsLists() {
        return anonyBoardsRepository.getBoardsList()
                .map(BoardsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long regAnonyBoards(BoardsSaveRequestDto dto) {
        return anonyBoardsRepository.save(dto.toEntity()).getBoardNo();
    }

    @Transactional(readOnly = true)
    public AnonyBoards getAnonyBoardsDetail(Long boardNo) {
        return anonyBoardsRepository.getBoardDetail(boardNo);
    }

    @Transactional
    public int modAnonyBoards(Long boardNo, String title, String content) {
        return anonyBoardsRepository.modBoard(boardNo, title, content);
    }

    @Transactional
    public int delAnonyBoards(Long boardNo) {
        return anonyBoardsRepository.delBoard(boardNo);
    }
}
