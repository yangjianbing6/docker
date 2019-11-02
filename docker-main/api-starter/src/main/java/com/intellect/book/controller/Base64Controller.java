package com.intellect.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Token;
import com.intellect.book.domain.request.Base64DTO;
import com.intellect.book.domain.request.OrderVO;
import com.intellect.book.service.OrderItemService;
import com.intellect.book.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.iharder.Base64;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangjianbing
 * 解析base64
 *
 * @date 2019/8/10 16:01
 */
@Api(description = "解析base64")
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
    @PostMapping("/decode")
    @Token
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object decodeOrder(@ApiParam(required = true, value = "base64数据", name = "base64Msg")
                              @RequestBody Base64DTO base64DTO) {
        if (base64DTO == null || Strings.isNullOrEmpty(base64DTO.getBase64Msg())) {
            return unSuccessResponse("参数异常");
        }
        try {
            byte[] bytes = Base64.decode(base64DTO.getBase64Msg());
            String jsonStr = new String(bytes, "UTF-8");
            OrderVO orderVO = JSONObject.parseObject(jsonStr, OrderVO.class);
            if (orderVO == null) {
                return unSuccessResponse("解析失败");
            }
            String ordId = orderService.insertOrders(orderVO);
            orderVO.setOrdid(ordId);
            return successResponse(orderVO);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return unSuccessResponse("解析失败");
        }

    }

}
