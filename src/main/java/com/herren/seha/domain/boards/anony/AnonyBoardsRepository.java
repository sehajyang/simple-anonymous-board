package com.herren.seha.domain.boards.anony;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author seha
 * @date 2019-05-15
 */
public interface AnonyBoardsRepository extends JpaRepository<AnonyBoards, Long> {
    //  JpaRepository<Entity클래스, PK타입> 상속

    Page<AnonyBoards> findAll(Pageable request);

    @Query("SELECT b " +
            "FROM AnonyBoards b " +
            "WHERE b.boardNo = :boardNo")
    AnonyBoards getBoardDetail(@Param("boardNo") Long boardNo);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE AnonyBoards b " +
            "SET b.title = :title," +
            "b.content = :content, " +
            "b.category = :category, " +
            "b.passwd = :passwd," +
            "b.sendyn = :sendyn " +
            "WHERE b.boardNo = :boardNo")
    int modBoard(@Param("boardNo") Long boardNo, @Param("title") String title, @Param("content") String content,
                 @Param("passwd") String passwd, @Param("category") String category, @Param("sendyn") String sendyn);

    @Modifying
    @Query("DELETE FROM AnonyBoards b " +
            "WHERE b.boardNo = :boardNo")
    int delBoard(@Param("boardNo") Long boardNo);

    @Query("SELECT b.passwd " +
            "FROM AnonyBoards b " +
            "WHERE b.boardNo = :boardNo " +
            "AND b.passwd = :passwd")
    String getBoardsCheckPasswd(@Param("boardNo") Long boardNo, @Param("passwd") String passwd);

    @Modifying
    @Query("UPDATE AnonyBoards b " +
            "SET b.hit = b.hit+1 " +
            "WHERE b.boardNo =:boardNo")
    int doBoardsLikeCountPlus(@Param("boardNo") Long boardNo);

    @Query("SELECT b.hit " +
            "FROM AnonyBoards b " +
            "WHERE b.boardNo = :boardNo")
    int getBoardsNowLikeCount(@Param("boardNo") Long boardNo);

    @Modifying
    @Query("UPDATE AnonyBoards b " +
            "SET b.sendyn = :yn " +
            "WHERE b.boardNo = :boardNo")
    int modAnonyBoardsSetSendYn(@Param("boardNo")Long boardNo, @Param("yn")String yn);

    @Query("SELECT count(b) " +
            "FROM AnonyBoards b " +
            "WHERE b.regdate > :currentDate")
    int getTodaysNewAnonyPostCount(@Param("currentDate") LocalDateTime currentDate);

    @Query("SELECT b.category " +
            "FROM AnonyBoards b " +
            "GROUP BY b.category " +
            "ORDER BY b.category asc")
    List<String> getAnonyBoardsCategoryList();

    @Query("SELECT count(b) " +
            "FROM AnonyBoards b " +
            "GROUP BY b.category " +
            "ORDER BY b.category asc")
    List<Integer> getAnonyBoardsCategoryCountList();
}
