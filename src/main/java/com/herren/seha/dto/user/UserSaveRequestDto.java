package com.herren.seha.dto.user;

import com.herren.seha.domain.user.Users;
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
    private String grade;

    @Builder
    public UserSaveRequestDto(String id, String passwd, String grade) {
        this.id = id;
        this.passwd = passwd;
        this.grade = grade;
    }
//FIXME : grade 넣을것
    public Users toEntity(){
        return Users.builder()
                .id(id)
                .passwd(passwd)
                .grade(grade)
                .build();
    }
}
