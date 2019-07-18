package com.doft.common;

import com.doft.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Jack at 14:24 2018/3/10
 * version 1.0
 */
public class BaseFunc {

    /**
     * 在任意位置获取当前线程中的HttpServletRequest
     * @return
     * @throws IllegalStateException
     */
    public static HttpServletRequest getCurrentRequest() throws IllegalStateException {
        ServletRequestAttributes attrs =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            throw new IllegalStateException("There is no Request in context!");
        }
        return attrs.getRequest();
    }

    /**
     * 获取当前线程中的HttpSession
     * @return
     */
    public static HttpSession getCurrentSession() {
        return getCurrentRequest().getSession();
    }

    /**
     * get current user from current session
     * @return
     */
    public static User getCurrentUser() {
//        User user = (User) getCurrentSession().getAttribute(Const.CURRENT_USER);
//        return user == null ? null : user;
        return new User(Long.valueOf(4), "admin", "admin",
                "", "13800138000", BigDecimal.ZERO, 1, Boolean.FALSE,
                new Date(), "register", new Date(), "register",
                "question", "answser");
    }

}
