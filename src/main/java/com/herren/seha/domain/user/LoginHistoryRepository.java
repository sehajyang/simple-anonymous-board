package com.herren.seha.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author seha
 * @date 2019-05-24
 */
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {

    @Query("select lh.dateTime from LoginHistory lh group by lh.dateTime")
    Page<String> getdateTimeLoginHistoriesByDateTime(Pageable pageable);

    @Query("select count(lh) from LoginHistory lh group by lh.dateTime")
    Page<Integer> getCountLoginHistoriesByDateTime(Pageable pageable);
}
