package com.intellect.book.service;

import com.intellect.book.base.dto.result.PageResult;
import com.intellect.book.base.service.IBaseService;
import com.intellect.book.domain.entity.Order;
import com.intellect.book.domain.request.OrderVO;
import com.intellect.book.domain.response.OrderItemResDTO;
import com.intellect.book.domain.response.OrderResDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-10-30 23:22:13
 **/
public interface OrderService extends IBaseService<Order> {

    String insertOrders(OrderVO orderVO, String empId);

    PageResult<OrderResDTO> orderList(String empId, String status, RowBounds rowBounds);

    PageResult<OrderResDTO> userOrderList(String userId, String status, RowBounds rowBounds);

    List<OrderItemResDTO> orderItemList(String ordId);

    /**
     * 派发药品
     *
     * @param ordId
     * @param orderItemIds
     */
    void orderHandOut(String ordId, String orderItemIds, String orderPicUrl);

    /**
     * 获取处方的总金额
     *
     * @param ordId
     * @return
     */
    BigDecimal getTotalFeeByOrdId(@Param("ordId") String ordId);
}