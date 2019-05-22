package com.herren.seha.util;

import com.herren.seha.dto.boards.BoardsMainResponseDto;
import com.herren.seha.dto.boards.NoticeBoardsMainResponseDto;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
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

        if (list.size() < max) {
            max = list.size();
        }
        for (int i = 0; i < max; i++) {
            resultList.add(list.get(i));
        }
        return resultList;
    }

    public static Boolean checkGradeAndRedirect(HttpSession session) {
        String grade = (String) session.getAttribute("grade");
        if (!"사장".equals(grade)) {
            return false;
        }
        return true;
    }

    public static String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    //TODO : 결과 받아야됨
    public static void sendSlack(String msg) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            // 안쓰면 한글 깨짐.
            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

            String payload = "{'channel': '#anonytest','text': '" + msg + "', 'username': '익명게시판 알림','icon_emoji': 'racoon_man'}";
            restTemplate.postForObject("https://hooks.slack.com/services/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",
                    payload, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            restTemplate = null;
        }
    }
}
