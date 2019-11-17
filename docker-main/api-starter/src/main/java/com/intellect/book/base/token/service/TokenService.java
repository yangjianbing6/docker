package com.intellect.book.base.token.service;


import com.intellect.book.domain.entity.DictEmployee;
import com.intellect.book.domain.entity.DictUsers;

/**
 * <p></p>
 *
 * @author huijun
 * @create 2018-11-26 13:11
 **/
public interface TokenService {

    /**
     * 生成TOKEN
     *
     * @param dictEmployee
     */
    String generateToken(DictEmployee dictEmployee);

    /**
     * 生成TOKEN
     *
     * @param dictUsers
     */
    String generateToken(DictUsers dictUsers);

    /**
     * 校验
     *
     * @param
     */
    boolean checkToken(String dictEmployeeId);

    /**
     * 校验
     *
     * @param
     */
    boolean checkToken4User(String dictEmployeeId);
}
