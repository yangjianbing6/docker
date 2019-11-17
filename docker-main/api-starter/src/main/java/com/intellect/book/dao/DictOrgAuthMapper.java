package com.intellect.book.dao;

import com.intellect.book.base.mapper.BaseMapper;
import com.intellect.book.domain.entity.DictOrgAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-11-10 20:58:50
 **/
@Mapper
public interface DictOrgAuthMapper extends BaseMapper<DictOrgAuth> {


    /**
     *
     *
     * @param empId
     * @return
     */
    @Select("select r.OrgID from dict_employee e left JOIN dict_reader_org_relation r on e.EmpID= r.EmpID where e.EmpID = #{empId}")
    String getOrgIdByEmpId(@Param("empId") String empId);
}