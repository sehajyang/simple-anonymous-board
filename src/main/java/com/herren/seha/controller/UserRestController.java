package com.herren.seha.controller;

import com.herren.seha.biz.User.UserService;
import com.herren.seha.domain.user.Users;
import com.herren.seha.dto.user.UserSaveRequestDto;
import com.herren.seha.util.Sha256Util;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author seha
 * @date 2019-05-15
 */

@RestController
@AllArgsConstructor
@Log4j2
public class UserRestController {

    @Autowired
    private UserService userService;

    private final Environment env;

    @PostMapping("/login")
    public Long doLogin(@RequestBody UserSaveRequestDto dto, HttpSession session) {
        String salt = env.getProperty("salt");
        String decryptId = Sha256Util.getEncrypt(dto.getId(), Objects.requireNonNull(salt));
        dto.setId(decryptId);

        Users getUserData = userService.getUsersById(dto.getId());
        if(getUserData != null){
            return doCheckUserIdAndPasswdAndCreateSessionAndSaveLoginHist(getUserData, dto.getPasswd(), session, salt);
        }
        return 0L;
    }

    private Long doCheckUserIdAndPasswdAndCreateSessionAndSaveLoginHist(Users getUserData, String clientReceivedPasswd,
                                                                        HttpSession session, String salt){
        if (clientReceivedPasswd != null) {
            clientReceivedPasswd = Sha256Util.getEncrypt(clientReceivedPasswd, salt);

            if (clientReceivedPasswd.equals(getUserData.getPasswd())) {
                saveSessionAndGrade(session, getUserData);
                userService.regLoginHistory(getUserData.getUserNo());
                return 1L;
            }
            return 0L;
        }
        return 0L;
    }

    private void saveSessionAndGrade(HttpSession session, Users getUserData) {
        session.setAttribute("ssId", String.valueOf(getUserData.getUserNo()));
        session.setAttribute("grade", getUserData.getGrade());
    }

    @PostMapping("/register")
    public Long doRegister(@RequestBody UserSaveRequestDto dto) {
        String salt = env.getProperty("salt");
        String decryptId = Sha256Util.getEncrypt(dto.getId(), Objects.requireNonNull(salt));
        dto.setId(decryptId);
        dto.setGrade("사원");

        if(userService.getUsersById(dto.getId()) != null){
            return 0L;
        }else{
            if(userService.regUserData(dto) > 0){
                return 1L;
            }else{
                return 0L;
            }
        }
    }
}
