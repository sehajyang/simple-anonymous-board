package com.herren.seha.biz.board;

import com.herren.seha.domain.boards.BoardsRepository;
import com.herren.seha.dto.boards.BoardsMainResponseDto;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import lombok.AllArgsConstructor;
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

//    public Integer modBoards(BoardsSaveRequestDto dto) {
//        return boardsRepository.modify(dto.toEntity().getBoardNo());
//    }
}
