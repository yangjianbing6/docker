package com.intellect.book.controller;

import com.google.common.collect.Maps;
import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Action;
import com.intellect.book.base.token.Constant;
import com.intellect.book.base.token.Token;
import com.intellect.book.base.token.service.TokenService;
import com.intellect.book.domain.entity.DictEmployee;
import com.intellect.book.service.DictEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by yangjianbing
 * 登录接口
 *
 * @date 2019/8/10 16:01
 */
@Api(description = "登录接口")
@RestController
@RequestMapping(value = "/main/login")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    DictEmployeeService dictEmployeeService;

    @Autowired
    private TokenService tokenService;


    /**
     * 登录
     *
     * @return
     */
    @ApiOperation("根据医生用户在健康海淀app中的ID登录")
    @GetMapping("/app_user_id")
    @Token(action = Action.SKIP)
    public Object loginBypersonId(@ApiParam(required = true, value = "医生用户在健康海淀app中的ID", name = "appUserID")
                                  @RequestParam("appUserID") String appUserID) {
        DictEmployee param = new DictEmployee();
        param.setAppUserID(appUserID);

        DictEmployee dictEmployee = dictEmployeeService.selectOne(param);

        if (dictEmployee == null) {
            return unSuccessResponse("没有该医生的AppID");
        }


        Map<String, Object> result = Maps.newHashMap();
        convert(result, dictEmployee);

        return successResponse(result);
    }

    /**
     * 数据转换
     *
     * @param result
     * @param dictEmployee
     */
    private void convert(Map<String, Object> result, DictEmployee dictEmployee) {
        //复制token
        String token = tokenService.generateToken(dictEmployee);
        result.put(Constant.TOKEN, token);

        result.put("docker", dictEmployee);
    }
}
