package com.intellect.book.controller;

import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.token.Token;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangjianbing
 * 订单接口
 *
 * @date 2019/8/10 16:01
 */
@Api(description = "订单接口")
@RestController
@RequestMapping(value = "/main/order-bill")
@Slf4j
public class OrderBillController extends BaseController {

//    @Autowired
//    OrderService orderService;

    /**
     * 获取订单列表
     *
     * @return
     */
    @ApiOperation("获取订单列表")
    @PostMapping("/list")
    @Token
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object orderBillList(@ApiParam(required = false, value = "当前页数", name = "page")
                                @RequestParam(value = "page", defaultValue = "1")
                                        Integer page,
                                @ApiParam(required = false, value = "当前页面显示多少条 , 默认10条", name = "limit")
                                @RequestParam(value = "limit", defaultValue = "10")
                                        Integer limit,
                                @ApiParam(required = true, value = "订单状态：（0：全部，101：未记账，102：已记账，103：记账撤销）", name = "status")
                                @RequestParam(value = "status")
                                        String status) {
//        try {
//            PageResult<OrderResDTO> result = orderService.orderList(status, getRowRounds(page, limit));
//            return successResponse(result);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            return unSuccessResponse("查询失败");
//        }
        return unSuccessResponse("开发中");
    }

    /**
     * 获取详细明细订单列表
     *
     * @return
     */
    @ApiOperation("获取详细明细订单列表")
    @GetMapping("/item")
    @Token
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object orderList(@ApiParam(required = true, name = "ordId")
                            @RequestParam(value = "ordId")
                                    String ordId) {
//        try {
//            List<OrderItemResDTO> result = orderService.orderItemList(ordId);
//            return successResponse(result);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            return unSuccessResponse("查询失败");
//        }
        return unSuccessResponse("开发中");
    }

}
