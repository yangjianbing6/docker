package com.intellect.book.service.impl;

import com.intellect.book.base.service.AbstractBaseService;
import com.intellect.book.dao.OrderStatusMapper;
import com.intellect.book.domain.entity.OrderStatus;
import com.intellect.book.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-10-30 23:22:14
 **/
@Service
public class OrderStatusServiceImpl extends AbstractBaseService<OrderStatus, OrderStatusMapper> implements OrderStatusService {

    @Autowired
    OrderStatusMapper orderStatusMapper;

}


