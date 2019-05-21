package com.herren.seha.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.herren.seha.dto.boards.BoardsMainResponseDto;
import com.herren.seha.util.Constant;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
        double randomVal = Math.random();
        int intVal = (int) (randomVal * Constant.animalsList.length) + 1;
        return String.format("익명의 %s", Objects.firstNonNull(Constant.animalsList[intVal], "unknown"));
    }

    public int noticeBoardGradeCheck(String grade) {
        if("사장".equals(grade) || "관리자".equals(grade)){
            return 1;
        }else{
            return 0;
        }
    }
}



