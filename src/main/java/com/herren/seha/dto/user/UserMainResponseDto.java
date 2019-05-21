package com.herren.seha.dto.user;

import com.herren.seha.domain.user.Users;
import com.herren.seha.util.CommonUtil;
import lombok.Getter;

/**
 * @author seha
 * @date 2019-05-20
 */
@Getter
public class UserMainResponseDto {
    private Long userNo;
    private String id;
    private String passwd;
    private String grade;
    private String moddate;

    public UserMainResponseDto(Users users) {
        userNo = users.getUserNo();
        id = users.getId();
        passwd = users.getPasswd();
        grade = users.getGrade();
        moddate = CommonUtil.toStringDateTime(users.getModdate());
    }

}
