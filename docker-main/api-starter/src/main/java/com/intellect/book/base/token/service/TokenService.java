package com.intellect.book.base.token.service;


import com.intellect.book.domain.entity.DictEmployee;

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
     * 校验
     *
     * @param
     */
    boolean checkToken(String dictEmployeeId);

}
