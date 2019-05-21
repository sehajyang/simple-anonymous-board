package com.herren.seha.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.herren.seha.dto.boards.BoardsMainResponseDto;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author seha
 * @date 2019-05-20
 */

@HandlebarsHelper
public class CommonHelper {
    public String sayHello(String name) {
        return String.format("Hello %s!", Objects.firstNonNull(name, "unknown"));
    }

    public String limitList(List<BoardsMainResponseDto> arr, int limit_num) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();

        for (int i = 0; i < limit_num; i++) {
            mapper.writeValue(out, arr.get(i));

        }
        final byte[] data = out.toByteArray();

        return new String(data);
    }

    public String randomWriterName() {
        ArrayList<String> animalList = new ArrayList();
        animalList.add("크라켄");
        animalList.add("고슴도치");
        animalList.add("로보로보스키");
        animalList.add("고양이");
        animalList.add("강아지");
        animalList.add("기린");
        animalList.add("치타");
        animalList.add("다람쥐");
        animalList.add("코끼리");

        double randomVal = Math.random();
        int intVal = (int) (randomVal * animalList.size()) + 1;
        System.err.println("ajdajd"+animalList.get(intVal));
        return String.format("익명의 %s", Objects.firstNonNull(animalList.get(intVal), "unknown"));
    }

    public int noticeBoardGradeCheck(String grade) {
        if("사장".equals(grade) || "관리자".equals(grade)){
            return 1;
        }else{
            return 0;
        }
    }
}



