package com.intellect.book.domain.entity;

import com.intellect.book.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author yangjianbing
 * @create 2019-10-30 23:29:02
 **/
@Table(name = "order_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus extends BaseEntity {

    /**
     *
     */
    @Column(name = "id")
    private Integer id;

    /**
     * 处方号
     */
    @Column(name = "rxno")
    private String rxno;

    /**
     * 医嘱id
     */
    @Column(name = "ordid")
    private String ordid;

    /**
     * 状态100063
     */
    @Column(name = "status")
    private String status;

    /**
     * 操作员id
     */
    @Column(name = "operid")
    private String operid;

    /**
     * 操作日期
     */
    @Column(name = "operdate")
    private String operdate;

}