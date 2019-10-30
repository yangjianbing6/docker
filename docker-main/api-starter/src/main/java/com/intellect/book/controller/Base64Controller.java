package com.intellect.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Token;
import com.intellect.book.domain.request.OrderVO;
import com.intellect.book.service.OrderItemService;
import com.intellect.book.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.iharder.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by yangjianbing
 * 登录接口
 *
 * @date 2019/8/10 16:01
 */
@Api(description = "登录接口")
@RestController
@RequestMapping(value = "/main/base64")
@Slf4j
public class Base64Controller extends BaseController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    /**
     * 解析base64
     *
     * @return
     */
    @ApiOperation("解析base64")
    @GetMapping("/decode")
    @Token
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object decodeOrder(@ApiParam(required = true, value = "base64数据", name = "base64Msg")
                              @RequestParam("base64Msg") String base64Msg) {
        String jsonStr;
        try {
            byte[] bytes = Base64.decode(base64Msg);
            jsonStr = new String(bytes, "UTF-8");
            OrderVO orderVO = JSONObject.parseObject(jsonStr, OrderVO.class);
            if (orderVO == null) {
                return unSuccessResponse("解析失败");
            }
            orderService.insertOrders(orderVO);

        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return unSuccessResponse("解析失败");
        }

        return successResponse("解析保存成功");
    }

}
