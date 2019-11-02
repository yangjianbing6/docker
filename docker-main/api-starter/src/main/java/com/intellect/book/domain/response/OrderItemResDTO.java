package com.intellect.book.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * @author yangjianbing
 * @create 2019-10-30 23:29:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResDTO {

    /**
     *
     */
    @Column(name = "id")
    private Long id;

    /**
     *
     */
    @Column(name = "ordid")
    private String ordid;

    /**
     *
     */
    @Column(name = "orditemid")
    private String orditemid;

    /**
     * 外配处方明细序号
     */
    @Column(name = "rxitemno")
    private String rxitemno;

    /**
     * 处方序号
     */
    @Column(name = "rxno")
    private String rxno;

    /**
     * HIS项目代码
     */
    @Column(name = "itemcode")
    private String itemcode;

    /**
     * HIS项目名称
     */
    @Column(name = "hisname")
    private String hisname;

    /**
     * 项目类别
     */
    @Column(name = "itemtype")
    private String itemtype;

    /**
     * 单价
     */
    @Column(name = "unitprice")
    private java.math.BigDecimal unitprice;

    /**
     * 数量
     */
    @Column(name = "count")
    private java.math.BigDecimal count;

    /**
     * 费用总金额
     */
    @Column(name = "fee")
    private java.math.BigDecimal fee;

    /**
     * 剂型
     */
    @Column(name = "dose")
    private String dose;

    /**
     * 规格
     */
    @Column(name = "specification")
    private String specification;

    /**
     * 单位
     */
    @Column(name = "unit")
    private String unit;

    /**
     * 用法(用药频次)
     */
    @Column(name = "howtouse")
    private String howtouse;

    /**
     * 单次用量
     */
    @Column(name = "dosage")
    private String dosage;

    /**
     * 包装单位
     */
    @Column(name = "packaging")
    private String packaging;

    /**
     * 最小包装
     */
    @Column(name = "minpackage")
    private String minpackage;

    /**
     * 换算率
     */
    @Column(name = "conversion")
    private String conversion;

    /**
     * 用药天数
     */
    @Column(name = "days")
    private java.math.BigDecimal days;

    /**
     * 药品批准文号
     */
    @Column(name = "drugapprovalnumber")
    private String drugapprovalnumber;

    /**
     * 记账时间
     */
    @Column(name = "BillTime")
    private String billTime;

    /**
     * 医嘱状态100063
     */
    @Column(name = "orderstatus")
    private String orderstatus;

    /**
     * 是否外流0-否 1-是
     */
    @Column(name = "OutDrugFlag")
    private String outDrugFlag;

}