package com.intellect.book.base.enums;

/**
 * sql排序
 *
 * @author huijun
 * @date 2017/10/26 上午10:00
 */
public enum SqlOrderEnum {

    /* 降序 */
    DESC(1, "desc"),

    /* 升序 */
    ASC(2, "asc");

    private String name;
    private int code;

    SqlOrderEnum(int code, String name) {
        this.name = name;
        this.code = code;
    }


    // get set 方法
    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }


}
