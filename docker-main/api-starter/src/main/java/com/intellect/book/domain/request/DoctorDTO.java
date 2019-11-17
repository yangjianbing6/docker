package com.intellect.book.domain.request;

import lombok.Data;

/**
 * Created by yangjianbing
 *
 * @date 2019/11/17 17:31
 */
@Data
public class DoctorDTO extends BasePasswordDTO{
    /**
     * 用户在健康海淀中的id
     */
    private String doctorid;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 证件类型
     * 医生的证件类型1-身份证 2-护照
     *
     */
    private String idtype;
    /**
     * 证件号码
     */
    private String idcard;
    /**
     * 性别
     * 1-男  2-女
     */
    private String sex;
    /**
     * 医院id
     */
    private String hospid;
    /**
     * 医院名称
     */
    private String hospname;
    /**
     * 医生所在的科室id
     */
    private String docdepid;
    /**
     * 医生所在科室名称
     */
    private String docdepname;
    /**
     * 职称
     * 医生在健康海淀里登记的职称
     * 1主任医师、2副主任医师、3主治医师、4医师、5医士
     */
    private String title;

    /**
     * 电话
     */
    private String telephone;
}
