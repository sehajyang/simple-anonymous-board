package com.herren.seha.domain.boards.anony;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

/**
 * @author seha
 * @date 2019-05-15
 */
public interface AnonyBoardsRepository extends JpaRepository<AnonyBoards, Long> {
   //  JpaRepository<Entity클래스, PK타입> 상속
   @Query("SELECT b " +
           "FROM AnonyBoards b " +
           "ORDER BY b.regdate DESC")
   Stream<AnonyBoards> getBoardsList();

   @Query("SELECT b " +
           "FROM AnonyBoards b " +
           "WHERE b.boardNo = :boardNo")
   AnonyBoards getBoardDetail(@Param("boardNo")Long boardNo);

   @Modifying(clearAutomatically = true)
   @Query("UPDATE AnonyBoards b " +
           "SET b.title = :title," +
           "b.content = :content " +
           "WHERE b.boardNo = :boardNo")
   int modBoard(@Param("boardNo") Long boardNo, @Param("title") String title, @Param("content") String content);

   @Modifying
   @Query("DELETE FROM AnonyBoards b " +
           "WHERE b.boardNo = :boardNo")
   int delBoard(@Param("boardNo")Long boardNo);
}
