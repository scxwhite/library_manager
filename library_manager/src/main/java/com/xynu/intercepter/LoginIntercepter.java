package com.xynu.intercepter;


import com.xynu.util.RequestUtils;
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

        boolean hasLogin = StringUtils.isNotBlank(RequestUtils.getCookie("username", request));

        if (!hasLogin) {
            response.sendRedirect("/page/login");
            return false;
        }
        return super.preHandle(request, response, handler);
    }


}
