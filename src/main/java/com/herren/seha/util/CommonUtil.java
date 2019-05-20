package com.herren.seha.util;

import com.herren.seha.dto.boards.BoardsMainResponseDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author seha
 * @date 2019-05-20
 */
public class CommonUtil {

    public static List<BoardsMainResponseDto> makeLimitFiveList(List<BoardsMainResponseDto> list, int max) {
        List<BoardsMainResponseDto> resultList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            resultList.add(list.get(i));
        }
        return resultList;
    }

}
