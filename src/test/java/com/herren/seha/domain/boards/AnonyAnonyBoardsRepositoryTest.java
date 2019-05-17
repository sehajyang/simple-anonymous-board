package com.herren.seha.domain.boards;

import com.herren.seha.domain.boards.anony.AnonyBoards;
import com.herren.seha.domain.boards.anony.AnonyBoardsRepository;
import org.junit.After;
import org.junit.Ignore;
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
@Ignore
public class AnonyAnonyBoardsRepositoryTest {

    @Autowired
    AnonyBoardsRepository anonyBoardsRepository;

    @After
    public void cleanup(){
        anonyBoardsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        anonyBoardsRepository.save(AnonyBoards.builder()
                .title("테스트입니다")
                .content("본문블라블라")
                .passwd("1234pwd")
                .build());
        //when
        List<AnonyBoards> anonyBoardsList = anonyBoardsRepository.findAll();

        //then
        AnonyBoards anonyBoards = anonyBoardsList.get(0);
        assertThat(anonyBoards.getTitle(), is("테스트입니다"));
        assertThat(anonyBoards.getContent(), is("본문블라블라"));
        assertThat(anonyBoards.getPasswd(), is("1234pwd"));
    }

    @Test
    public void BaseTime_Entity_등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        anonyBoardsRepository.save(AnonyBoards.builder()
                .title("테스트제목")
                .content("테스트본문")
                .passwd("1234pwd")
                .build());
        //when
        List<AnonyBoards> anonyBoardsList = anonyBoardsRepository.findAll();

        //then
        AnonyBoards anonyBoards = anonyBoardsList.get(0);
        assertTrue(anonyBoards.getRegdate().isAfter(now));
        assertTrue(anonyBoards.getModdate().isAfter(now));
    }
}