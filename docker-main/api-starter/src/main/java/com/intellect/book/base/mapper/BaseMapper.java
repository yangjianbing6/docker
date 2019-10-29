package com.intellect.book.base.mapper;


import com.intellect.book.base.mapper.weekend.WeekendInsertProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {


    /**
     * 不插入为空的字段，且自动生成ID
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = WeekendInsertProvider.class, method = "dynamicSQL")
    int insertSelectiveUseGeneratedKeys(T record);

    @Update("update ${tableName} set ${columnName} = #{value},update_time=CURRENT_TIMESTAMP where id = #{id} ")
    int put(@Param("id") long id, @Param("tableName") String tableName, @Param("columnName") String columnName, @Param("value") Object value);
}
