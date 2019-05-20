package com.herren.seha.domain.user;

import com.herren.seha.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author seha
 * @date 2019-05-20
 */
@NoArgsConstructor
@Getter
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long userNo;

    private String id;

    private String passwd;

    @Builder
    public User(String id, String passwd) {
        this.id = id;
        this.passwd = passwd;
    }
}
