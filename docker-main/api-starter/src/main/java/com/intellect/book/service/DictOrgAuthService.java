package com.intellect.book.service;

import com.intellect.book.base.service.IBaseService;
import com.intellect.book.domain.entity.DictOrgAuth;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-11-10 20:58:50
 **/
public interface DictOrgAuthService extends IBaseService<DictOrgAuth> {
    /**
     * 获取orgId
     * @param empId
     * @return
     */
    String getOrgIdByEmpId(String empId);
}