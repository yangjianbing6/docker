package com.intellect.book.service.impl;

import com.intellect.book.base.service.AbstractBaseService;
import com.intellect.book.dao.OrderItemMapper;
import com.intellect.book.dao.OrderMapper;
import com.intellect.book.domain.entity.Order;
import com.intellect.book.domain.entity.OrderItem;
import com.intellect.book.domain.request.OrderVO;
import com.intellect.book.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-10-30 23:22:13
 **/
@Service
public class OrderServiceImpl extends AbstractBaseService<Order, OrderMapper> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    @Transactional
    public void insertOrders(OrderVO orderVO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderVO, order);
        orderMapper.insert(order);
        if (!CollectionUtils.isEmpty(orderVO.getField())) {
            List<OrderItem> orderItems = orderVO.getField();
            orderItems.forEach(x -> orderItemMapper.insert(x));
        }
    }
}


