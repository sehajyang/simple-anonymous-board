package com.herren.seha.biz.User;

import com.herren.seha.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author seha
 * @date 2019-05-20
 */

@AllArgsConstructor
@Service
@Log4j2
public class UserService {
    private UserRepository userRepository;
}
