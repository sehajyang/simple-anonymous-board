package com.herren.seha.biz.board;

import com.herren.seha.domain.boards.anony.AnonyBoards;
import com.herren.seha.domain.boards.anony.AnonyBoardsRepository;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import org.junit.After;
import org.junit.Ignore;
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
@Ignore
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private AnonyBoardsRepository anonyBoardsRepository;

    @After
    public void cleanup() {
        anonyBoardsRepository.deleteAll();
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
        boardService.regAnonyBoards(dto);

        //then
        AnonyBoards anonyBoards = anonyBoardsRepository.findAll().get(0);
        assertThat(anonyBoards.getTitle()).isEqualTo(dto.getTitle());
        assertThat(anonyBoards.getContent()).isEqualTo(dto.getContent());
        assertThat(anonyBoards.getPasswd()).isEqualTo(dto.getPasswd());
    }

    @Test
    public void Board의_특정_데이터가_조회된다() {

    }

}