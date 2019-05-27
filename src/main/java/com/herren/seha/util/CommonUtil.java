package com.herren.seha.util;

import com.herren.seha.dto.boards.BoardsMainResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author seha
 * @date 2019-05-20
 */
@Log4j2
public class CommonUtil {

    //FIXME : 중복코드 해결요망!
    public static List<BoardsMainResponseDto> makeLimitList(List<BoardsMainResponseDto> list, int max) {
        List<BoardsMainResponseDto> resultList = new ArrayList<>();

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

    public static int getTodayyyyyMMdd(String kind) {
        Date date = new Date();
        log.debug("date"+date);
        SimpleDateFormat sdf = new SimpleDateFormat();
        if ("year".equals(kind)) {
            sdf = new SimpleDateFormat("yyyy");
        } else if ("month".equals(kind)) {
            sdf = new SimpleDateFormat("MM");
        } else if ("day".equals(kind)) {
            sdf = new SimpleDateFormat("dd");
        }
        return Integer.parseInt(sdf.format(date));
    }

    public static String getTodayyyyyMMdd() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return (sdf.format(date));
    }
}
