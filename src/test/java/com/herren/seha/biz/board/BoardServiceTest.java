package com.herren.seha.biz.board;

import com.herren.seha.domain.boards.Boards;
import com.herren.seha.domain.boards.BoardsRepository;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author seha
 * @date 2019-05-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardsRepository boardsRepository;

    @After
    public void cleanup() {
        boardsRepository.deleteAll();
    }

    @Test
    public void BoardDto_데이터가_boards테이블에_저장된다() {
        //given
        BoardsSaveRequestDto dto = BoardsSaveRequestDto.builder()
                .title("테스트제목")
                .content("테스트내용")
                .passwd("1234pwd")
                .build();

        //when
        boardService.regBoards(dto);

        //then
        Boards boards = boardsRepository.findAll().get(0);
        assertThat(boards.getTitle()).isEqualTo(dto.getTitle());
        assertThat(boards.getContent()).isEqualTo(dto.getContent());
        assertThat(boards.getPasswd()).isEqualTo(dto.getPasswd());
    }

}