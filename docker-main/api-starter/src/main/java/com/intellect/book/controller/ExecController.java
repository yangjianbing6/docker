package com.intellect.book.controller;

import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Action;
import com.intellect.book.base.token.Token;
import com.intellect.book.dao.JunitBaseDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by yangjianbing
 *
 * @date 2019/10/10 22:24
 */
@Api(description = "执行sql")
@RestController
@RequestMapping(value = "/main/sql")
@Slf4j
public class ExecController extends BaseController {

    @Autowired
    JunitBaseDao junitBaseDao;

    /**
     * @return
     */
    @ApiOperation("执行sql")
    @GetMapping("/exec")
    @Token
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object execSql(@RequestParam String sql
            , @RequestParam String type
    ) {
        String[] types = new String[]{"insert", "delete", "update", "select"};
        if (Strings.isNullOrEmpty(type) || !Arrays.asList(types).contains(type)) {
            unSuccessResponse("参数异常");
        }
        try {
            if (types[0].equals(type)) {
                int result = junitBaseDao.insert(sql);
                return successResponse(result > 0 ? true : false);
            } else if (types[1].equals(type)) {
                int result = junitBaseDao.delete(sql);
                return successResponse(result > 0 ? true : false);
            } else if (types[2].equals(type)) {
                int result = junitBaseDao.update(sql);
                return successResponse(result > 0 ? true : false);
            } else {
                List<LinkedHashMap<String, Object>> list = junitBaseDao.select(sql);
                return successResponse(list);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return unSuccessResponse("执行sql失败");
        }

    }

}
