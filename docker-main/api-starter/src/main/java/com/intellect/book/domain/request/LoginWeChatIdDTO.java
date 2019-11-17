package com.intellect.book.domain.request;

import lombok.Data;

/**
 * Created by yangjianbing
 *
 * @date 2019/11/10 20:50
 */
@Data
public class LoginWeChatIdDTO {
    /**
     * 微信对应的id
     */
    private String wechatId;
}
