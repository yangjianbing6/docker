package com.intellect.book.service.impl;

import com.intellect.book.base.service.AbstractBaseService;
import com.intellect.book.dao.DictEmployeeMapper;
import com.intellect.book.domain.entity.DictEmployee;
import com.intellect.book.service.DictEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-10-29 22:25:26
 **/
@Service
public class DictEmployeeServiceImpl extends AbstractBaseService<DictEmployee, DictEmployeeMapper> implements DictEmployeeService {

    @Autowired
    DictEmployeeMapper dictEmployeeMapper;

}


