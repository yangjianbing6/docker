package com.intellect.book.service;

import com.intellect.book.base.dto.result.PageResult;
import com.intellect.book.base.service.IBaseService;
import com.intellect.book.domain.entity.Order;
import com.intellect.book.domain.request.OrderVO;
import com.intellect.book.domain.response.OrderItemResDTO;
import com.intellect.book.domain.response.OrderResDTO;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-10-30 23:22:13
 **/
public interface OrderService extends IBaseService<Order> {

    String insertOrders(OrderVO orderVO);

    PageResult<OrderResDTO> orderList(String status, RowBounds rowBounds);

    List<OrderItemResDTO> orderItemList(String ordId);

    /**
     * 派发药品
     *
     * @param ordId
     * @param orderItemIds
     */
    void orderHandOut(String ordId, String orderItemIds, String orderPicUrl);
}