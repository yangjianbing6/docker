package com.intellect.book.controller;

import com.google.common.collect.Maps;
import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Action;
import com.intellect.book.base.token.Constant;
import com.intellect.book.base.token.Token;
import com.intellect.book.base.token.service.TokenService;
import com.intellect.book.domain.entity.DictUsers;
import com.intellect.book.domain.request.LoginWeChatIdDTO;
import com.intellect.book.service.DictUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by yangjianbing
 * 患者登录接口
 *
 * @date 2019/8/10 16:01
 */
@Api(description = "患者登录接口")
@RestController
@RequestMapping(value = "/main/user-login")
@Slf4j
public class UserLoginController extends BaseController {

    @Autowired
    DictUsersService dictUsersService;

    @Autowired
    private TokenService tokenService;


    /**
     * 根据微信对应的id登录
     *
     * @return
     */
    @ApiOperation("根据微信对应的id登录")
    @PostMapping("/by_wechatid")
    @Token(action = Action.SKIP)
    public Object loginByPassword(@RequestBody LoginWeChatIdDTO loginWeChatIdDTO) {
        if (loginWeChatIdDTO == null || Strings.isNullOrEmpty(loginWeChatIdDTO.getWechatID())) {
            return unSuccessResponse("参数异常");
        }

        DictUsers param = new DictUsers();
        param.setWechatID(loginWeChatIdDTO.getWechatID());

        DictUsers dictUsers = dictUsersService.selectOne(param);

        if (dictUsers == null) {
            return unSuccessResponse("用户信息不存在");
        }

        Map<String, Object> result = Maps.newHashMap();
        convert(result, dictUsers);

        return successResponse(result);
    }


    /**
     * 数据转换
     *
     * @param result
     * @param dictUsers
     */
    private void convert(Map<String, Object> result, DictUsers dictUsers) {
        //赋值token
        String token = tokenService.generateToken(dictUsers);
        result.put(Constant.TOKEN, token);
        result.put("user", dictUsers);
    }

}
