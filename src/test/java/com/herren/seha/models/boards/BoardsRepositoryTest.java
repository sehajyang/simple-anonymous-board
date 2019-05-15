package com.herren.seha.models.boards;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author seha
 * @date 2019-05-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardsRepositoryTest {

    @Autowired
    BoardsRepository boardsRepository;

    @After
    public void cleanup(){
        boardsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        boardsRepository.save(Boards.builder()
                .title("테스트입니다")
                .content("본문블라블라")
                .passwd("1234pwd")
                .build());
        //when
        List<Boards> boardsList = boardsRepository.findAll();

        //then
        Boards boards = boardsList.get(0);
        assertThat(boards.getTitle(), is("테스트입니다"));
        assertThat(boards.getContent(), is("본문블라블라"));
        assertThat(boards.getPasswd(), is("1234pwd"));
    }

    @Test
    public void BaseTime_Entity_등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        boardsRepository.save(Boards.builder()
                .title("테스트제목")
                .content("테스트본문")
                .passwd("1234pwd")
                .build());
        //when
        List<Boards> boardsList = boardsRepository.findAll();

        //tahen
        Boards boards = boardsList.get(0);
        assertTrue(boards.getRegdate().isAfter(now));
        assertTrue(boards.getModdate().isAfter(now));
    }
}