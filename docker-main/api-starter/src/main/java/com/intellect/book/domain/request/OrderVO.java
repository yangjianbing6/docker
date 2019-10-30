package com.intellect.book.domain.request;

import com.intellect.book.domain.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.util.List;

/**
 * @author yangjianbing
 * @create 2019-10-30 23:29:01
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderVO {

    /**
     *
     */
    private Long id;

    /**
     * 处方来源机构编码
     */
    private String orgid;

    /**
     *
     */
    private String ordid;

    /**
     * 医疗类别codetype=100062
     */
    @Column(name = "curetype")
    private String curetype;

    /**
     * 处方序号
     */
    @Column(name = "rxno")
    private String rxno;

    /**
     * 诊断序号
     */
    @Column(name = "diagnoseno")
    private String diagnoseno;

    /**
     * 处方日期/时间
     */
    @Column(name = "recipedate")
    private String recipedate;

    /**
     * 处方类别
     */
    @Column(name = "recipetype")
    private String recipetype;

    /**
     * 诊断名称
     */
    @Column(name = "diagnosename")
    private String diagnosename;

    /**
     * 诊断编码
     */
    @Column(name = "diagnosecode")
    private String diagnosecode;

    /**
     * 病历信息
     */
    @Column(name = "medicalrecord")
    private String medicalrecord;

    /**
     * 就诊科别代码
     */
    @Column(name = "sectioncode")
    private String sectioncode;

    /**
     * 就诊科别名称
     */
    @Column(name = "sectionname")
    private String sectionname;

    /**
     * HIS就诊科别名称
     */
    @Column(name = "hissectionname")
    private String hissectionname;

    /**
     * 医师编码
     */
    @Column(name = "drid")
    private String drid;

    /**
     * 医师姓名
     */
    @Column(name = "drname")
    private String drname;

    /**
     * 医师职称
     */
    @Column(name = "drlevel")
    private String drlevel;

    /**
     * 挂号交易流水号
     */
    @Column(name = "registertradeno")
    private String registertradeno;

    /**
     * 单据类型
     */
    @Column(name = "billstype")
    private String billstype;

    /**
     * 上传处方人员id
     */
    @Column(name = "empid")
    private String empid;

    /**
     * 患者id
     */
    @Column(name = "UserID")
    private String userID;

    /**
     * 患者姓名
     */
    @Column(name = "UserName")
    private String userName;

    /**
     * 患者性别
     */
    @Column(name = "UserSex")
    private String userSex;

    /**
     * 患者年龄
     */
    @Column(name = "UserAge")
    private String userAge;

    /**
     * 处方创建日期
     */
    @Column(name = "CrateDate")
    private String crateDate;

    /**
     * 记账标志
     */
    @Column(name = "BillFlag")
    private String billFlag;

    /**
     * 医嘱状态标志
     */
    @Column(name = "OrderStatus")
    private String orderStatus;

    /**
     * 医嘱的图片路径
     */
    @Column(name = "OrderPicUrl")
    private String orderPicUrl;

    private List<OrderItem> field;

}