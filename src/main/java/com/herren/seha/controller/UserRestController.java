package com.herren.seha.controller;

import com.herren.seha.biz.User.UserService;
import com.herren.seha.domain.user.LoginHistoryRepository;
import com.herren.seha.domain.user.Users;
import com.herren.seha.dto.user.UserSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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

    private LoginHistoryRepository loginHistoryRepository;

    @PostMapping("/login")
    public Long doLogin(@RequestBody UserSaveRequestDto dto, HttpSession session) {
        Users getUserData = userService.getUsersById(dto.getId());
        return doCheckUserIdAndPasswdAndCreateSessionAndSaveLoginHist(getUserData, dto.getPasswd(), session);
    }

    private Long doCheckUserIdAndPasswdAndCreateSessionAndSaveLoginHist(Users getUserData, String clientReceivedPasswd, HttpSession session) {
        if (clientReceivedPasswd != null && getUserData.getPasswd() != null) {
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
