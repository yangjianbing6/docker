package com.intellect.book.base.service;

import com.intellect.book.base.enums.SqlOrderEnum;
import com.intellect.book.base.mapper.weekend.Weekend;

import java.util.List;
import java.util.Map;


/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public interface IBaseService<T> {
    /**
     * 新增一条数据
     *
     * @param entity
     */
    int insert(T entity);

    int insertSelective(T var1);

    int insertUseGeneratedKeys(T var1);

    List<T> select(T var1);

    int selectCount(T var1);

    T selectById(Long id);

    /**
     * 修改一条数据
     *
     * @param entity 要更新的实体对象
     */
    int edit(T entity);

    /**
     * 删除一条数据
     *
     * @param baseEntity
     */
    int delete(T baseEntity);


    /**
     * 删除一条数据
     *
     * @param id
     */
    int delete(Long id);

    /**
     * 根据条件集合进行分页查询
     *
     * @param condition 查询条件
     * @param offset    偏移
     * @param rows      查询条数
     * @return 返回Pager对象
     */
    List<T> listByPage(Map<String, Object> condition, int offset, int rows);

    List<T> listByPage(Map<String, Object> condition, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum);


    /**
     * 更新对象,如果属性为空，则不会进行对应的属性值更新
     *
     * @param entity 要更新的实体对象
     */
    int update(T entity);


    int updateByMap(T entity, Map<String, Object> entityMap);

    boolean deleteWeekend(T entity, Weekend<T> weekend);

    boolean updateByIdSelective(T entity, Long id);

    List<T> findList(Map<String, Object> condition);

    List<T> findList(Map<String, Object> conditione, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 根据传入的泛型参数类型查询该类型对应表中的所有数据，返回一个集合对象
     *
     * @return 返回泛型参数类型的对象集合
     */
    List<T> findAll();

    List<T> findAll(String orderBy, SqlOrderEnum sqlOrderEnum);


    List<T> like(Map<String, Object> condition, Map<String, Object> likeCondition);

    /**
     * 根据任意属性和属性值进行对象模糊查询
     *
     * @param condition
     * @return
     */
    List<T> like(Map<String, Object> condition);

    List<T> like(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum);


    /**
     * 根据条件集合进行指定类型单一对象查询
     *
     * @param condition 进行查询的条件集合
     * @return 返回泛型参数类型的对象
     */
    T queryOne(Map<String, Object> condition);

    T queryOne(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 根据条件进行数量的查询
     *
     * @param condition
     * @return 返回符合条件的泛型参数对应表中的数量
     */
    int count(Map<String, Object> condition);


    T selectOne(T entity);


    int updateByExampleSelective(T entity, Map<String, Object> condition);


}
