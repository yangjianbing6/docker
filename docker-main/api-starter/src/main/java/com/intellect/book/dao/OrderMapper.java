package com.intellect.book.dao;

import com.intellect.book.base.mapper.BaseMapper;
import com.intellect.book.domain.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2019-10-30 23:22:13
 **/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("SELECT * FROM dict_book ORDER BY PublishDate DESC LIMIT #{limitCount}")
    List<Order> getLatestBooks(@Param("limitCount") Integer limitCount);
}