package com.intellect.book.base.enums;


/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public enum DeleteStatusEnum {

    DELETE(1, "删除"),

    AVAILABLE(2, "可用");

    private int code;
    private String desc;

    DeleteStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }


}
