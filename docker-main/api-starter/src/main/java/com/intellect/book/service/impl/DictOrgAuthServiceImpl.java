package com.intellect.book.service.impl;

import com.intellect.book.base.service.AbstractBaseService;
import com.intellect.book.dao.DictOrgAuthMapper;
import com.intellect.book.domain.entity.DictOrgAuth;
import com.intellect.book.service.DictOrgAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public String getOrgIdByEmpId(String empId) {
        return dictOrgAuthMapper.getOrgIdByEmpId(empId);
    }
}


