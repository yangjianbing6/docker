package com.intellect.book.base.mapper.weekend;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public class WeekendInsertProvider extends BaseInsertProvider {


    public WeekendInsertProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String insertSelectiveUseGeneratedKeys(MappedStatement ms) {
        return super.insertSelective(ms);
    }

}
