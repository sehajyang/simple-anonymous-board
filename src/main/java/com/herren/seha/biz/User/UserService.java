package com.herren.seha.biz.User;

import com.herren.seha.domain.user.LoginHistoryRepository;
import com.herren.seha.domain.user.UserRepository;
import com.herren.seha.domain.user.Users;
import com.herren.seha.dto.user.LoginHistorySaveRequestDto;
import com.herren.seha.dto.user.UserSaveRequestDto;
import com.herren.seha.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private LoginHistoryRepository loginHistoryRepository;

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

    @Transactional
    public Long regLoginHistory(Long userNo){
        LoginHistorySaveRequestDto dto = new LoginHistorySaveRequestDto();
        dto.setUserNo(userNo);
        dto.setDateTime(CommonUtil.getTodayyyyyMMdd());

        return loginHistoryRepository.save(dto.toEntity()).getLoginNo();
    }

    @Transactional
    public Page<String> getdateTimeLoginHistoriesByDateTime(){
        Pageable pageable = PageRequest.of(0, 7, new Sort(Sort.Direction.DESC, "dateTime"));
        return loginHistoryRepository.getdateTimeLoginHistoriesByDateTime(pageable);

    }

    public Page<Integer> getCountLoginHistoriesByDateTime() {
        Pageable pageable = PageRequest.of(0, 7, new Sort(Sort.Direction.DESC, "dateTime"));
        return loginHistoryRepository.getCountLoginHistoriesByDateTime(pageable);
    }
}
