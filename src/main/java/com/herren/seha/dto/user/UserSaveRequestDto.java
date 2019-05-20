package com.herren.seha.dto.user;

import com.herren.seha.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author seha
 * @date 2019-05-20
 */
@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String id;
    private String passwd;

    @Builder
    public UserSaveRequestDto(String id, String passwd) {
        this.id = id;
        this.passwd = passwd;
    }
//FIXME : grade 넣을것
    public User toEntity(){
        return User.builder()
                .id(id)
                .passwd(passwd)
                .build();
    }
}
