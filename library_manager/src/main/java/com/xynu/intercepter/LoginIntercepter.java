package com.xynu.intercepter;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */
public class LoginIntercepter extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURL().toString();

        if (StringUtils.endsWith(url, "/login")
                || StringUtils.endsWith(url, "/login/check")
                ) {
            return true;
        }

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        boolean hasLogin = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (StringUtils.equals(cookie.getName(),"username")) {
                    hasLogin = true;
                    break;
                }
            }
        }

        if (!hasLogin) {
            response.sendRedirect("/page/login");
            return false;
        }
        return super.preHandle(request, response, handler);
    }


}
