package com.herren.seha.biz.User;

import com.herren.seha.domain.user.UserRepository;
import com.herren.seha.domain.user.Users;
import com.herren.seha.dto.user.UserSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author seha
 * @date 2019-05-20
 */

@AllArgsConstructor
@Service
@Log4j2
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long regUserData(UserSaveRequestDto dto) {
        return userRepository.save(dto.toEntity()).getUserNo();
    }

    @Transactional(readOnly = true)
    public Users getUsersById(String id) {
        return userRepository.getUsersById(id);
    }

    @Transactional(readOnly = true)
    public Users getUsersByIdPasswd(String id, String passwd) {
        return userRepository.getUsersByIdPasswd(id, passwd);
    }
}
