package com.intellect.book.base.enums;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public enum ResponseCodeEnum {
    SYSTEM_FOFM_CHECK(102001, "表单验证未通过"),

    SUCCESS(1, "接口调用成功"),

    FAIL(0, "接口调用失败"),

    PARAM_INVALID(3, "搞啥嘞，你这是啥嘞……"),

    UN_AUTH(4, "用户未认证"),

    EXCEPTION(5, "亲，服务器开小差了"),

    PROMPT(6, "错误提示"),

    NEED_BIND_PHONE(7, "三方登录绑定手机号"),
    NOTEXIST(8, "查询的对象不存在"),
    CATEGORY_DELETE_ERROR(9, "该类别存在子类不能删除"),
    CATEGORY_NOTEXIST(10, "你所查看的类目在系统中不存在"),
    CATEGORY_LABEL_ERROR(11, "该标签存在子类不能删除"),
    ACCOUNT_IS_FROZEN(12, "该账户已被冻结！"),
    IMPROVE_ACCOUNT_INFORMATION(13, "完善用户信息！"),
    SERVER_BIND_THIRD_COMPLETE(14, "绑定成功！"),
    WENXIN__BIND(21, "已有微信号绑定手机！"),
    QQ_BIND(22, "已有QQ号绑定手机号！"),
    WEIBO_BIND(23, "已有微博号绑定手机号！"),
    SERVER_DEFAULT_REFUSE_REASON(24, "服务不符合要求！"),
    DEMAND_DEFAULT_REFUSE_REASON(25, "需求不符合要求！"),
    NULL_MSG(30, ""),
    NOT_NEED_PRINT_LOG(40, "正常业务逻辑，不需要打印错误日志");


    private int code;
    private String content;

    ResponseCodeEnum(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

}
