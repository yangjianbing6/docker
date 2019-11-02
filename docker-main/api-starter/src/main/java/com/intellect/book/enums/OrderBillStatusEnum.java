package com.intellect.book.enums;

import com.intellect.book.base.enums.IndexedEnum;

import java.util.List;

/**
 * Created by yangjianbing
 * 订单状态
 *
 * @date 2019/11/2 20:54
 */
public enum OrderBillStatusEnum implements IndexedEnum {
    ORDER_INDEX_101(101, "未记账"),
    ORDER_INDEX_102(102, "已记账"),
    ORDER_INDEX_103(103, "记账撤销");

    private String name;
    private int code;


    // 构造方法
    OrderBillStatusEnum(int code, String name) {
        this.name = name;
        this.code = code;
    }

    private static final List<OrderBillStatusEnum> INDEXES = IndexedEnumUtil.toIndexes(OrderBillStatusEnum.values());


    /**
     * 根据code 获取name
     *
     * @param code
     * @return
     */
    public static OrderBillStatusEnum codeOf(final int code) {
        return IndexedEnumUtil.valueOf(INDEXES, code);
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }


    public static void main(String[] args) {
        OrderBillStatusEnum m = OrderBillStatusEnum.codeOf(9);
        System.out.println(m.getName());
        OrderBillStatusEnum.valueOf("name");
    }

}
