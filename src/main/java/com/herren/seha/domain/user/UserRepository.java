package com.herren.seha.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author seha
 * @date 2019-05-20
 */
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u " +
            "FROM Users u " +
            "WHERE u.id = :id")
    Users getUsersById(@Param("id") String id);

    @Query("SELECT u " +
            "FROM Users u " +
            "WHERE u.id = :id " +
            "AND u.passwd = :passwd")
    Users getUsersByIdPasswd(@Param("id") String id, @Param("passwd") String passwd);
}
