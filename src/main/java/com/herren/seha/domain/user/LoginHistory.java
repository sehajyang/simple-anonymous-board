package com.herren.seha.domain.user;

import com.herren.seha.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author seha
 * @date 2019-05-24
 */

@NoArgsConstructor
@Getter
@Entity
@ToString
public class LoginHistory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long loginNo;

    private Long userNo;

    private String dateTime;

    private Long count;

    @Builder
    public LoginHistory(Long userNo, String dateTime, Long count) {
        this.userNo = userNo;
        this.dateTime = dateTime;
        this.count = count;
    }
}
