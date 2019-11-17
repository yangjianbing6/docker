package com.intellect.book.base.token;

import com.intellect.book.base.token.service.TokenService;
import com.intellect.book.base.token.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author huijun
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {
    Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

    @Autowired
    TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);
            if (annotation != null && annotation.action().getKey().equals(Action.SKIP.getKey())) {
                return true;
            }
            String readerIdFromRequest = RequestUtil.getReaderIdFromRequest(request);
            boolean checkResult = tokenService.checkToken(readerIdFromRequest);

            boolean checkResult2  = tokenService.checkToken4User(readerIdFromRequest);
            if (!checkResult && !checkResult2) {
                response.setStatus(401);
                return false;
            }
        } else {
            return super.preHandle(request, response, handler);
        }
        return true;
    }
}
