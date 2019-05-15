package com.herren.seha.domain.boards;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author seha
 * @date 2019-05-15
 */
public interface BoardsRepository extends JpaRepository<Boards, Long> {
   //  JpaRepository<Entity클래스, PK타입> 상속
}
