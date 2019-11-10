package com.intellect.book.domain.entity;

import com.intellect.book.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by yangjianbing
 *
 * @date 2019/11/10 20:59
 */
@Table(name = "dict_org_auth")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictOrgAuth extends BaseEntity {
    /**
     *
     */
    @Column(name = "id")
    private Long id;

    /**
     *
     */
    @Column(name = "OrgID")
    private String orgId;
    /**
     *
     */
    @Column(name = "appid")
    private String appid;
    /**
     *
     */
    @Column(name = "appkey")
    private String appkey;
}
