package com.intellect.book.dao;

import org.apache.ibatis.annotations.*;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface JunitBaseDao {

    @Select("${sql}")
    List<LinkedHashMap<String, Object>> select(String sql);

    @Insert("${sql}")
    int insert(String sql);

    @Update("${sql}")
    int update(String sql);

    @Delete("${sql}")
    int delete(String sql);
}