package com.yonyou.bamboo.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yonyou.bamboo.service.UserService;
import com.yonyou.bamboo.util.Constants;
import com.yonyou.bamboo.util.CookieUtil;

public class SigninInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = Logger.getLogger(SigninInterceptor.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object object = session.getAttribute(Constants.SESSION_USER);
        if (null == object) {
            Cookie[] cookies = request.getCookies();
            String su = CookieUtil.getValue(cookies, Constants.COOKIE_SU);
            if (null != su) {
                String[] values = su.split(":");
                String email = values[0];
                String password = values[1];
                if (userService.verifyPassword(email, password)) {
                    session.setAttribute(Constants.SESSION_USER, userService.get(email));
                }
            }
        }
        log.debug(request.getServletPath() + "-----SigninInterceptor Done!");
        return super.preHandle(request, response, handler);
    }
}
