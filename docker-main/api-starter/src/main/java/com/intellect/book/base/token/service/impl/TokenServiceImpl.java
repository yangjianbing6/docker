package com.intellect.book.base.token.service.impl;

import com.google.common.base.Preconditions;
import com.intellect.book.base.token.Constant;
import com.intellect.book.base.token.TokenMangager;
import com.intellect.book.base.token.service.TokenService;
import com.intellect.book.dao.DictEmployeeMapper;
import com.intellect.book.domain.entity.DictEmployee;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-26 10:10:40
 **/
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    DictEmployeeMapper dictEmployeeMapper;

    /**
     * token过期时间 单位天
     */
    private final int tokenTime = 30;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String generateToken(DictEmployee dictEmployee) {
        Preconditions.checkNotNull(dictEmployee);

        return genToken(dictEmployee);

    }

    @Override
    public boolean checkToken(String dictEmployeeId) {
        if (Strings.isNullOrEmpty(dictEmployeeId)) {
            return false;
        }
        DictEmployee param = new DictEmployee();
        param.setEmpID(dictEmployeeId);

        List<DictEmployee> list = dictEmployeeMapper.select(param);
        if (list.size() > 0) {
            return true;
        }
        return false;
    }


    private String genToken(DictEmployee dictEmployee) {
        String randomNo = String.valueOf(Math.random()).substring(2, 6);
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.TOKEN_USER_ID, dictEmployee.getEmpID());
        map.put(Constant.TOKEN_GEN_TIME, System.currentTimeMillis());
        map.put(Constant.SYS_VERSION, "v1");
        map.put(Constant.RANDOM_NO, randomNo);
        String token = TokenMangager.generateToken(map, DateUtils.addDays(new Date(),
                tokenTime));
        return token;


    }
}
