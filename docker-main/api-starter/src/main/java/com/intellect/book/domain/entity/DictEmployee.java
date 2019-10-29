package com.intellect.book.domain.entity;

import com.intellect.book.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-10-29 22:25:26
 **/
@Table(name = "DICT_EMPLOYEE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictEmployee extends BaseEntity {

    /**
     *
     */
    @Column(name = "ID")
    private Long id;

    /**
     *
     */
    @Column(name = "empID")
    private String EmpID;
    /**
     *
     */
    @Column(name = "empName")
    private String EmpName;
    /**
     *
     */
    @Column(name = "inputStr")
    private String InputStr;
    /**
     *
     */
    @Column(name = "loginName")
    private String LoginName;
    /**
     *
     */
    @Column(name = "password")
    private String Password;

    /**
     *
     */
    @Column(name = "sexID")
    private Integer SexID;
    /**
     *
     */
    @Column(name = "SexName")
    private String sexName;

    /**
     * 0停用 1-未停用
     */
    @Column(name = "stopFlag")
    private Integer StopFlag;
    /**
     * 电话
     */
    @Column(name = "Phone")
    private String phone;
    /**
     * 微信ID
     */
    @Column(name = "WechatID")
    private String wechatID;
    /**
     * 医生用户在健康海淀app中的ID
     */
    @Column(name = "AppUserID")
    private String appUserID;
}