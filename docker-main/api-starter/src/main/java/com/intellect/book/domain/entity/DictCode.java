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
@Table(name = "dict_code")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictCode extends BaseEntity {
    /**
     *
     */
    @Column(name = "ID")
    private Long id;

    /**
     *
     */
    @Column(name = "OrgID")
    private String orgId;
    /**
     * 编码类型
     */
    @Column(name = "CodeTypeID")
    private String codeTypeID;
    /**
     * 首字母拼音
     */
    @Column(name = "inputStr")
    private String InputStr;
    /**
     * 编码编号
     */
    @Column(name = "CodeID")
    private String codeID;
    /**
     * 编码名称
     */
    @Column(name = "CodeName")
    private String codeName;
}