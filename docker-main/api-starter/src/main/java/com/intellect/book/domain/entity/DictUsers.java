package com.intellect.book.domain.entity;

import com.intellect.book.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 *<p> 患者实体 </p>
 * @author yangjianbing
 * @create 2019-11-17 19:15:48
 **/
@Table(name = "DICT_USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictUsers extends BaseEntity {

    /**
     * 
     */
    @Column(name = "id")
    private Long id;
    /**
     * 用户ID
     */
    @Column(name = "UserID")
    private String UserID;
    /**
     * 
     */
    @Column(name = "Password")
    private String password;
    /**
     * 姓名
     */
    @Column(name = "UserName")
    private String userName;
    /**
     * 100011
     */
    @Column(name = "SexCode")
    private String sexCode;
    /**
     * 生日
     */
    @Column(name = "UserBirth")
    private String userBirth;
    /**
     * 证件类型
     */
    @Column(name = "IDType")
    private String idType;
    /**
     * 证件号码
     */
    @Column(name = "IDNo")
    private String idNo;
    /**
     * 电话号码
     */
    @Column(name = "Phone")
    private String phone;
    /**
     * 微信对应的id
     */
    @Column(name = "WechatID")
    private String wechatID;
 }