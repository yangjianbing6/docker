package com.intellect.book.service.impl;

import com.intellect.book.base.service.AbstractBaseService;
import com.intellect.book.dao.DictUsersMapper;
import com.intellect.book.domain.entity.DictUsers;
import com.intellect.book.service.DictUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *<p> </p>
 * @author yangjianbing
 * @create 2019-11-17 19:15:48
 **/
@Service
public class DictUsersServiceImpl extends AbstractBaseService<DictUsers,DictUsersMapper> implements DictUsersService {

    @Autowired
    DictUsersMapper dictUsersMapper;

}


