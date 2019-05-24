package com.herren.seha.domain.boards.anony;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author seha
 * @date 2019-05-15
 */
@Repository
public interface AnonyBoardsLikeRepository extends JpaRepository<AnonyBoardsLike, Long> {
    List<AnonyBoardsLike> findByBoardNo(AnonyBoards ab);

    AnonyBoardsLike findByBoardNoAndUserNo(AnonyBoards ab, Long userNo);
}
