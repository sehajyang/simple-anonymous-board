package com.herren.seha.domain.user;

import com.herren.seha.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
public class Users extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long userNo;

    @NonNull
    private String id;

    @NonNull
    private String passwd;

    private String grade;

    @Builder
    public Users(String id, String passwd, String grade) {
        this.id = id;
        this.passwd = passwd;
        this.grade = grade;
    }
}
