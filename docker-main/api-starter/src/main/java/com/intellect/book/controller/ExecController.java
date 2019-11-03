package com.intellect.book.controller;

import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Token;
import com.intellect.book.dao.JunitBaseDao;
import com.intellect.book.domain.request.ExecSql;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @PostMapping("/exec")
    @Token
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object execSql(@RequestBody ExecSql execSql) {

        String[] types = new String[]{"insert", "delete", "update", "select"};

        if (execSql == null || Strings.isNullOrEmpty(execSql.getSql()) || !Arrays.asList(types).contains(execSql.getType())) {
            unSuccessResponse("参数异常");
        }
        try {
            if (types[0].equals(execSql.getType())) {
                int result = junitBaseDao.insert(execSql.getSql());
                return successResponse(result > 0 ? true : false);
            } else if (types[1].equals(execSql.getType())) {
                int result = junitBaseDao.delete(execSql.getSql());
                return successResponse(result > 0 ? true : false);
            } else if (types[2].equals(execSql.getType())) {
                int result = junitBaseDao.update(execSql.getSql());
                return successResponse(result > 0 ? true : false);
            } else {
                List<LinkedHashMap<String, Object>> list = junitBaseDao.select(execSql.getSql());
                return successResponse(list);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return unSuccessResponse("执行sql失败");
        }

    }

}
