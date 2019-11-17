package com.intellect.book.domain.request;

import lombok.Data;

/**
 * Created by yangjianbing
 *
 * @date 2019/11/10 20:50
 */
@Data
public class WeChatDTO {
    /**
     * 微信对应的id
     */
    private String wechatId;
    /**
     * 患者名称
     */
    private String name;
    /**
     * 证件类型
     * 患者的证件类型1-身份证 2-护照
     */
    private String idtype;
    /**
     * 证件号码
     */
    private String idcard;
    /**
     * 性别
     * 1-男  2-女
     */
    private String sex;
    /**
     * 患者的电话
     */
    private String telephone;
}
