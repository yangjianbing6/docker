package com.intellect.book.controller;

import com.google.common.collect.Maps;
import com.intellect.book.base.controller.BaseController;
import com.intellect.book.base.dto.result.PageResult;
import com.intellect.book.base.token.Token;
import com.intellect.book.base.token.utils.RequestUtil;
import com.intellect.book.domain.entity.Order;
import com.intellect.book.domain.response.OrderItemResDTO;
import com.intellect.book.domain.response.OrderResDTO;
import com.intellect.book.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by yangjianbing
 * 患者处方接口
 *
 * @date 2019/8/10 16:01
 */
@Api(description = "患者处方接口")
@RestController
@RequestMapping(value = "/main/user-order")
@Slf4j
public class UserOrderController extends BaseController {

    @Autowired
    OrderService orderService;

    /**
     * 患者关联处方
     *
     * @return
     */
    @ApiOperation("患者关联处方")
    @PostMapping("/contact_order")
    @Token
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object contactOrder(HttpServletRequest request,
                            @ApiParam(required = true, value = "处方编号", name = "ordId")
                            @RequestParam(value = "ordId")
                                    String ordId) {
        try {
            String userId = RequestUtil.getUserdFromRequest(request);

            Order param = new Order();
            param.setOrdid(ordId);

            Order order = orderService.selectOne(param);
            if(order == null){
                return unSuccessResponse("获取处方信息失败");
            }
            if(!Strings.isNullOrEmpty(order.getUserID())){
                return unSuccessResponse("该处方已关联患者信息");
            }

            Order param2 = new Order();
            param2.setUserID(userId);
            orderService.updateByIdSelective(param2,order.getId());

            return successResponse("关联成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return unSuccessResponse("关联失败");
        }
    }

    /**
     * 获取患者本人的处方列表
     *
     * @return
     */
    @ApiOperation("获取患者本人的处方列表")
    @PostMapping("/list")
    @Token
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object orderList(HttpServletRequest request,
                            @ApiParam(required = false, value = "当前页数", name = "page")
                            @RequestParam(value = "page", defaultValue = "1")
                                    Integer page,
                            @ApiParam(required = false, value = "当前页面显示多少条 , 默认10条", name = "limit")
                            @RequestParam(value = "limit", defaultValue = "10")
                                    Integer limit,
                            @ApiParam(required = true, value = "状态（0：全部，101：新建，102：已记账，103：已发药，104：已派发）", name = "status")
                            @RequestParam(value = "status")
                                    String status) {
        try {
            String userId = RequestUtil.getUserdFromRequest(request);

            PageResult<OrderResDTO> result = orderService.userOrderList(userId,status, getRowRounds(page, limit));
            return successResponse(result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return unSuccessResponse("查询失败");
        }
    }

    /**
     * 获取处方详细明细列表
     *
     * @return
     */
    @ApiOperation("获取处方详细明细列表")
    @GetMapping("/order-item-list")
    @Token
    @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",
            paramType = "header")
    public Object orderList(@ApiParam(required = true, name = "ordId")
                            @RequestParam(value = "ordId")
                                    String ordId) {
        try {
            Map<String, Object> map = Maps.newHashMap();
            List<OrderItemResDTO> result = orderService.orderItemList(ordId);

            Order param = new Order();
            param.setOrdid(ordId);
            List<Order> orderList = orderService.select(param);
            OrderResDTO orderResDTO = new OrderResDTO();
            BeanUtils.copyProperties(orderList.get(0), orderResDTO);
            orderResDTO.setTotalFee(orderService.getTotalFeeByOrdId(ordId));

            map.put("order", orderResDTO);
            map.put("item", result);
            return successResponse(map);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return unSuccessResponse("查询失败");
        }
    }



}
