package com.intellect.book.enums;

import com.intellect.book.base.enums.IndexedEnum;

import java.util.List;

/**
 * Created by yangjianbing
 * 处方状态
 *
 * @date 2019/11/2 20:54
 */
public enum OrderStatusEnum implements IndexedEnum {
    ORDER_INDEX_101(101, "新建"),
    ORDER_INDEX_102(102, "已记账"),
    ORDER_INDEX_103(103, "已发药"),
    ORDER_INDEX_104(104, "已派发");

    private String name;
    private int code;


    // 构造方法
    OrderStatusEnum(int code, String name) {
        this.name = name;
        this.code = code;
    }

    private static final List<OrderStatusEnum> INDEXES = IndexedEnum.IndexedEnumUtil.toIndexes(OrderStatusEnum.values());


    /**
     * 根据code 获取name
     *
     * @param code
     * @return
     */
    public static OrderStatusEnum codeOf(final int code) {
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
        OrderStatusEnum m = OrderStatusEnum.codeOf(9);
        System.out.println(m.getName());
        OrderStatusEnum.valueOf("name");
    }

}
