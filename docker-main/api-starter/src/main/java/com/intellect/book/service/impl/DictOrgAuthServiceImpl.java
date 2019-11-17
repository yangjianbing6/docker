package com.intellect.book.service.impl;

import com.intellect.book.base.service.AbstractBaseService;
import com.intellect.book.dao.DictEmployeeMapper;
import com.intellect.book.dao.DictOrgAuthMapper;
import com.intellect.book.dao.DictReaderOrgRelationMapper;
import com.intellect.book.domain.entity.DictEmployee;
import com.intellect.book.domain.entity.DictOrgAuth;
import com.intellect.book.domain.entity.DictReaderOrgRelation;
import com.intellect.book.domain.request.DoctorDTO;
import com.intellect.book.service.DictOrgAuthService;
import com.intellect.book.utils.ChineseToSpellUtil;
import com.intellect.book.utils.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-11-10 20:58:50
 **/
@Service
public class DictOrgAuthServiceImpl extends AbstractBaseService<DictOrgAuth, DictOrgAuthMapper> implements DictOrgAuthService {

    @Autowired
    DictOrgAuthMapper dictOrgAuthMapper;

    @Autowired
    DictEmployeeMapper dictEmployeeMapper;

    @Autowired
    DictReaderOrgRelationMapper dictReaderOrgRelationMapper;

    @Override
    public String getOrgIdByEmpId(String empId) {
        return dictOrgAuthMapper.getOrgIdByEmpId(empId);
    }

    @Override
    @Transactional
    public void saveDoctorInfo(DoctorDTO doctorDTO,String orgId) {
        //医生在系统的id
        String empId = OrderNoUtil.getUUID();
        DictEmployee dictEmployee = new DictEmployee();
        dictEmployee.setEmpID(empId);
        dictEmployee.setEmpName(doctorDTO.getName());
        dictEmployee.setInputStr(ChineseToSpellUtil.getPingYin(doctorDTO.getName()));
        dictEmployee.setLoginName(ChineseToSpellUtil.getPingYin(doctorDTO.getName()));
        dictEmployee.setPassword(ChineseToSpellUtil.getPingYin(doctorDTO.getName()));
        dictEmployee.setSexID("1".equals(doctorDTO.getSex())? 101:102);
        dictEmployee.setSexName("1".equals(doctorDTO.getSex())?"男":"女");
        dictEmployee.setAppUserID(doctorDTO.getDoctorid());
        dictEmployeeMapper.insert(dictEmployee);

        DictReaderOrgRelation dictReaderOrgRelation = new DictReaderOrgRelation();
        dictReaderOrgRelation.setEmpID(empId);
        dictReaderOrgRelation.setOrgID(orgId);
        dictReaderOrgRelationMapper.insert(dictReaderOrgRelation);

    }
}


