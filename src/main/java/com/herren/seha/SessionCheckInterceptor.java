package com.herren.seha;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author seha
 * @date 2019-04-11
 */

@Log4j2
public class SessionCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ssId = (String) request.getSession().getAttribute("ssId");
        if (ssId != null) {
            return true;
        } else {
            try {
                log.debug("세션 정보가 없습니다. 로그인 페이지로 이동합니다.");
                response.sendRedirect("/login");
            } catch (IOException ie) {
                //redirection error
                log.error(ie);
            }
            return false;
        }
    }

}
