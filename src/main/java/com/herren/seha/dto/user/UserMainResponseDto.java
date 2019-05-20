package com.herren.seha.dto.user;

import com.herren.seha.domain.user.User;
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
    private String moddate;

    public UserMainResponseDto(User user) {
        userNo = user.getUserNo();
        id = user.getId();
        passwd = user.getPasswd();
        moddate = CommonUtil.toStringDateTime(user.getModdate());
    }

}
