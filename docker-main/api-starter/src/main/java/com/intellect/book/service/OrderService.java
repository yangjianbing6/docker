package com.intellect.book.service;

import com.intellect.book.base.service.IBaseService;
import com.intellect.book.domain.entity.Order;
import com.intellect.book.domain.request.OrderVO;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-10-30 23:22:13
 **/
public interface OrderService extends IBaseService<Order> {

    void insertOrders(OrderVO orderVO);
}