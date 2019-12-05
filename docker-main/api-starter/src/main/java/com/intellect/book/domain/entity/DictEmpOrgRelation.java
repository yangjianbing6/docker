package com.intellect.book.domain.entity;

import com.intellect.book.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 *<p> </p>
 * @author yangjianbing
 * @create 2019-11-17 18:33:05
 **/
@Table(name = "DICT_EMP_ORG_RELATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictEmpOrgRelation extends BaseEntity {

    /**
     *
     */
    @Column(name = "ID")
    private Long id;
    /**
     * 所属机构,如具体科室
     */
    @Column(name = "OrgID")
    private String orgID;
    /**
     *
     */
    @Column(name = "EmpID")
    private String empID;

    /**
     * 所属机构的一类如医院,卫生局
     */
    @Column(name = "orgid_belong")
    private String orgidBelong;
    /**
     * 医生,护士,技师,
     */
    @Column(name = "TypeID")
    private String typeID;
    /**
     *
     */
    @Column(name = "TitleID")
    private String titleID;
    /**
     *
     */
    @Column(name = "UserType")
    private String userType;
    /**
     *
     */
    @Column(name = "StopFlag")
    private Integer stopFlag;

 }