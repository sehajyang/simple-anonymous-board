package com.herren.seha.helper;

import com.google.common.base.Objects;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

/**
 * @author seha
 * @date 2019-05-20
 */

@HandlebarsHelper
public class CommonHelper {
    public String sayHello(String name) {
        return String.format("Hello %s!", Objects.firstNonNull(name, "unknown"));
    }


}
