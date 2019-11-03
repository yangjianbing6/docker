package com.intellect.book.domain.request;

import lombok.Data;

/**
 * Created by yangjianbing
 *
 * @date 2019/11/3 11:40
 */
@Data
public class ExecSql {
    /**
     * 执行的sql
     */
    String sql;

    /**
     * 类型
     */
    String type;
}
