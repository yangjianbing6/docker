package com.intellect.book.base.token.utils;


import com.google.common.collect.Maps;
import com.intellect.book.base.token.Constant;
import com.intellect.book.base.token.TokenMangager;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public final class RequestUtil {

    private RequestUtil() {
    }

    private static Map<String, String> headerInfo(HttpServletRequest request) {
        Map<String, String> headerMap = Maps.newHashMap();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toUpperCase();
            headerMap.put(name, request.getHeader(name));
        }
        return headerMap;
    }


    private static Map<String, Object> tokenInfo(HttpServletRequest request) {
        return tokenInfo(headerInfo(request).get(Constant.TOKEN.toUpperCase()));
    }

    private static Map<String, Object> tokenInfo(String token) {
        if (token != null) {
            if (TokenMangager.getClaimsFromToken(token) == null) {
                return Collections.emptyMap();
            }
            return TokenMangager.getClaimsFromToken(token);
        } else {
            return Collections.emptyMap();
        }
    }

    public static String getReaderIdFromRequest(HttpServletRequest request) {
        Map<String, Object> tokenMap = tokenInfo(request);
        return tokenMap.getOrDefault(Constant.TOKEN_USER_ID, 0L).toString();
    }

    /**
     * 获取empId
     *
     * @param request
     * @return
     */
    public static String getEmpIdFromRequest(HttpServletRequest request) {
        Map<String, Object> tokenMap = tokenInfo(request);
        return tokenMap.getOrDefault(Constant.TOKEN_USER_ID, "").toString();
    }

    /**
     * 获取UserId
     *
     * @param request
     * @return
     */
    public static String getUserdFromRequest(HttpServletRequest request) {
        Map<String, Object> tokenMap = tokenInfo(request);
        return tokenMap.getOrDefault(Constant.TOKEN_USER_ID, "").toString();
    }

}
