package com.herren.seha.domain.boards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

/**
 * @author seha
 * @date 2019-05-15
 */
public interface BoardsRepository extends JpaRepository<Boards, Long> {
   //  JpaRepository<Entity클래스, PK타입> 상속
   @Query(value = "SELECT b " +
           "FROM Boards b " +
           "ORDER BY b.regdate DESC")
   Stream<Boards> getBoardsList();
}
