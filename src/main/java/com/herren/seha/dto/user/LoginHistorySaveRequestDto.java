package com.herren.seha.dto.user;

import com.herren.seha.domain.user.LoginHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author seha
 * @date 2019-05-24
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginHistorySaveRequestDto {

    private Long userNo;
    private String dateTime;

    @Builder
    public LoginHistorySaveRequestDto(Long userNo, String dateTime) {
        this.userNo = userNo;
        this.dateTime = dateTime;
    }
    public LoginHistory toEntity(){
        return LoginHistory.builder()
                .userNo(userNo)
                .dateTime(dateTime)
                .build();
    }
}
