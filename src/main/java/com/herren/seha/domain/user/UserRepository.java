package com.herren.seha.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author seha
 * @date 2019-05-20
 */
public interface UserRepository extends JpaRepository<Users, Long> {
}
