package com.herren.seha.util;

import com.herren.seha.dto.boards.BoardsMainResponseDto;
import com.herren.seha.dto.boards.NoticeBoardsMainResponseDto;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author seha
 * @date 2019-05-20
 */
public class CommonUtil {

    //FIXME : 중복코드 해결요망!
    public static List<BoardsMainResponseDto> makeLimitList(List<BoardsMainResponseDto> list, int max) {
        List<BoardsMainResponseDto> resultList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            resultList.add(list.get(i));
        }
        return resultList;
    }

    public static List<NoticeBoardsMainResponseDto> makeLimitListForNotice(List<NoticeBoardsMainResponseDto> list, int max) {
        List<NoticeBoardsMainResponseDto> resultList = new ArrayList<>();

        if(list.size() < max){
            max = list.size();
        }
        for (int i = 0; i < max; i++) {
            resultList.add(list.get(i));
        }
        return resultList;
    }

    public static Boolean checkGradeAndRedirect(HttpSession session){
        String grade = (String)session.getAttribute("grade");
        if(!"사장".equals(grade)){
            return false;
        }
        return true;
    }

    /**
     * Java 8 버전
     */
    public static String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

}
