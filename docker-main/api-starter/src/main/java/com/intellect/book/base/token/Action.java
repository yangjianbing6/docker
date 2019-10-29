package com.intellect.book.base.token;

/**
 * @author huijun
 * @date 2017/10/24 下午7:43
 */
public enum Action {
    //执行验证
    NORMAL("0", "执行token验证"),
    //忽略验证
    SKIP("1", "跳过token验证");

    private final String key;
    private final String desc;

    Action(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return this.key;
    }

    public String getDesc() {
        return this.desc;
    }
}