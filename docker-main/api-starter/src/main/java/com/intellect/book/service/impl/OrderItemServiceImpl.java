package com.intellect.book.service.impl;

import com.intellect.book.base.service.AbstractBaseService;
import com.intellect.book.dao.OrderItemMapper;
import com.intellect.book.domain.entity.OrderItem;
import com.intellect.book.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-10-30 23:22:13
 **/
@Service
public class OrderItemServiceImpl extends AbstractBaseService<OrderItem, OrderItemMapper> implements OrderItemService {

    @Autowired
    OrderItemMapper orderItemMapper;

}


