package com.herren.seha.domain.boards.notice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

/**
 * @author seha
 * @date 2019-05-15
 */
public interface NoticeBoardsRepository extends JpaRepository<NoticeBoards, Long> {
   //  JpaRepository<Entity클래스, PK타입> 상속
   Page<NoticeBoards> findAll(Pageable request);

   @Query("SELECT b " +
           "FROM NoticeBoards b " +
           "WHERE b.boardNo = :boardNo")
   NoticeBoards getBoardDetail(@Param("boardNo") Long boardNo);

   @Modifying(clearAutomatically = true)
   @Query("UPDATE NoticeBoards b " +
           "SET b.title = :title," +
           "b.content = :content," +
           "b.uuid = :uuid," +
           "b.category = :category " +
           "WHERE b.boardNo = :boardNo")
   int modBoard(@Param("boardNo") Long boardNo, @Param("title") String title,
                @Param("content") String content, @Param("uuid") String uuid,
                @Param("category") String category);

   @Modifying
   @Query("DELETE FROM NoticeBoards b " +
           "WHERE b.boardNo = :boardNo")
   int delBoard(@Param("boardNo") Long boardNo);

   @Query("SELECT count(b) " +
           "FROM NoticeBoards b " +
           "WHERE b.regdate > :currentDate")
   int getThisWeekRegNoticePostCount(@Param("currentDate") LocalDateTime currentDate);
}
