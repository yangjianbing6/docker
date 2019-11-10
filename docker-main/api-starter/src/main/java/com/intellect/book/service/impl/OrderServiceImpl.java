package com.intellect.book.service.impl;

import com.intellect.book.base.dto.result.PageResult;
import com.intellect.book.base.mapper.weekend.Weekend;
import com.intellect.book.base.service.AbstractBaseService;
import com.intellect.book.dao.OrderItemMapper;
import com.intellect.book.dao.OrderMapper;
import com.intellect.book.dao.OrderStatusMapper;
import com.intellect.book.domain.entity.Order;
import com.intellect.book.domain.entity.OrderItem;
import com.intellect.book.domain.entity.OrderStatus;
import com.intellect.book.domain.request.OrderVO;
import com.intellect.book.domain.response.OrderItemResDTO;
import com.intellect.book.domain.response.OrderResDTO;
import com.intellect.book.enums.OrderStatusEnum;
import com.intellect.book.service.OrderService;
import com.intellect.book.utils.DateUtil;
import com.intellect.book.utils.DictCodeUtil;
import com.intellect.book.utils.OrderNoUtil;
import org.apache.ibatis.session.RowBounds;
import org.assertj.core.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    OrderStatusMapper orderStatusMapper;

    @Autowired
    DictCodeUtil dictCodeUtil;

    @Override
    @Transactional
    public String insertOrders(OrderVO orderVO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderVO, order);
        final String ordId = OrderNoUtil.getUUID();
        order.setOrdid(ordId);
        order.setOrderStatus(String.valueOf(OrderStatusEnum.ORDER_INDEX_101.getCode()));
        orderMapper.insert(order);
        if (!CollectionUtils.isEmpty(orderVO.getField())) {
            List<OrderItem> orderItems = orderVO.getField();
            orderItems.forEach(x -> {
                x.setOrdid(ordId);
                orderItemMapper.insert(x);
            });
        }
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrdid(ordId);
        orderStatus.setRxno(order.getRxno());
        orderStatus.setStatus(String.valueOf(OrderStatusEnum.ORDER_INDEX_101.getCode()));
        orderStatus.setOperdate(DateUtil.getLocalDateString());
        orderStatusMapper.insert(orderStatus);
        return ordId;
    }

    @Override
    public PageResult<OrderResDTO> orderList(String status, RowBounds rowBounds) {
        Weekend<Order> weekend = new Weekend<>(Order.class);
        if (!Strings.isNullOrEmpty(status) && !"0".equals(status)) {
            weekend.weekendCriteria().andLike(Order::getOrderStatus, status);
        }
        weekend.orderBy("recipedate desc");
        List<Order> list = orderMapper.selectByExampleAndRowBounds(weekend, rowBounds);

        if (CollectionUtils.isEmpty(list)) {
            return new PageResult<>(rowBounds, 0, null);
        }

        List<OrderResDTO> result = list.stream().map(x -> {
            OrderResDTO orderResDTO = new OrderResDTO();
            BeanUtils.copyProperties(x, orderResDTO);
            return orderResDTO;
        }).collect(Collectors.toList());

        result.forEach(x -> {
            BigDecimal totalFee = orderMapper.getTotalFeeByOrdId(x.getOrdid());
            x.setTotalFee(totalFee);

            Integer drugsNum = orderMapper.getDrugsNum(x.getOrdid());

            x.setDrugNum(drugsNum);
        });

        Integer total = orderMapper.selectCountByExample(weekend);

        return new PageResult(rowBounds, total, result);
    }

    @Override
    public List<OrderItemResDTO> orderItemList(String ordId) {
        OrderItem param = new OrderItem();
        param.setOrdid(ordId);
        List<OrderItem> orderItemList = orderItemMapper.select(param);
        if (CollectionUtils.isEmpty(orderItemList)) {
            return null;
        }
        List<OrderItemResDTO> result = orderItemList.stream().map(x -> {
            OrderItemResDTO orderItemResDTO = new OrderItemResDTO();
            BeanUtils.copyProperties(x, orderItemResDTO);
            return orderItemResDTO;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    @Transactional
    public void orderHandOut(String ordId, String orderItemIds, String orderPicUrl) {
        //派发
        Weekend<OrderStatus> weekend = Weekend.of(OrderStatus.class);
        weekend.weekendCriteria()
                .andEqualTo(OrderStatus::getOrdid, ordId);

        //状态表中记录的是过程状态
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrdid(ordId);
        orderStatus.setOperdate(DateUtil.getLocalDateString());
        orderStatus.setStatus(String.valueOf(OrderStatusEnum.ORDER_INDEX_104.getCode()));

        orderStatusMapper.insert(orderStatus);

        if (!Strings.isNullOrEmpty(orderPicUrl)) {
            Weekend<Order> OrderWeekend = Weekend.of(Order.class);
            OrderWeekend.weekendCriteria()
                    .andEqualTo(Order::getOrdid, ordId);

            Order order = new Order();
            order.setOrderPicUrl(orderPicUrl);
            order.setOrderStatus(String.valueOf(OrderStatusEnum.ORDER_INDEX_104.getCode()));
            orderMapper.updateByExampleSelective(order, OrderWeekend);
        }
        if (Strings.isNullOrEmpty(orderItemIds)) {
            return;
        }

        List<String> orderItemIdList = Arrays.asList(orderItemIds.split(","));

        if (CollectionUtils.isEmpty(orderItemIdList)) {
            Weekend<OrderItem> orderItemWeekend = Weekend.of(OrderItem.class);
            orderItemWeekend.weekendCriteria()
                    .andEqualTo(OrderItem::getOrdid, ordId);

            OrderItem orderItem = new OrderItem();
            orderItem.setOutDrugFlag("0");

            orderItemMapper.updateByExampleSelective(orderItem, orderItemWeekend);
        } else {

            List<OrderItem> orderItemList = orderItemMapper.select(new OrderItem(ordId));
            List<Long> orderItemIdAll = orderItemList.stream().map(x -> x.getId()).collect(Collectors.toList());

            orderItemIdAll.forEach(x -> {
                if (orderItemIdList.contains(String.valueOf(x))) {
                    //设置为1
                    Weekend<OrderItem> orderItemWeekend = Weekend.of(OrderItem.class);
                    orderItemWeekend.weekendCriteria()
                            .andEqualTo(OrderItem::getId, Long.valueOf(x));

                    OrderItem orderItem = new OrderItem();
                    orderItem.setOutDrugFlag("1");

                    orderItemMapper.updateByExampleSelective(orderItem, orderItemWeekend);
                } else {
                    //设置为0
                    Weekend<OrderItem> orderItemWeekend = Weekend.of(OrderItem.class);
                    orderItemWeekend.weekendCriteria()
                            .andEqualTo(OrderItem::getId, Long.valueOf(x));

                    OrderItem orderItem = new OrderItem();
                    orderItem.setOutDrugFlag("0");

                    orderItemMapper.updateByExampleSelective(orderItem, orderItemWeekend);
                }
            });

        }

    }

    @Override
    public BigDecimal getTotalFeeByOrdId(String ordId) {
        return orderMapper.getTotalFeeByOrdId(ordId);
    }
}


