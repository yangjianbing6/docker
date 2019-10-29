package com.intellect.book.base.service;

import com.intellect.book.base.entity.BaseEntity;
import com.intellect.book.base.enums.SqlOrderEnum;
import com.intellect.book.base.mapper.BaseMapper;
import com.intellect.book.base.mapper.weekend.Weekend;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public abstract class AbstractBaseService<T extends BaseEntity, M extends BaseMapper<T>> implements IBaseService<T> {

    public Logger logger = LoggerFactory.getLogger(getEntityClass());

    @Autowired
    private M baseMapper;
    private Class<?> clazz = null;

    protected Class<?> getEntityClass() {
        if (clazz == null) {
            clazz = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clazz;
    }

    @Override
    public List<T> select(T var1) {
        return baseMapper.select(var1);
    }

    @Override
    public T selectById(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增一条数据
     *
     * @param entity
     */
    @Override
    public int insert(T entity) {
        enhanceNewCreateBaseEntity(entity);
        return baseMapper.insertSelective(entity);
    }

    /**
     * 修改一条数据
     *
     * @param entity 要更新的实体对象
     */
    @Override
    public int edit(T entity) {
        return baseMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 删除一条数据
     *
     * @param baseEntity
     */
    @Override
    public int delete(T baseEntity) {

        return baseMapper.updateByPrimaryKeySelective(baseEntity);

    }

    public boolean deleteWeekend(T entity, Weekend<T> weekend) {
//        entity.setIsDelete(DeleteStatusEnum.DELETE.getCode());
        return this.baseMapper.updateByExampleSelective(entity, weekend) > 0;
    }

    /**
     * 删除一条数据
     *
     * @param id
     */
    @Override
    public int delete(Long id) {
        /*Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        criteria.andEqualTo("status", DataStatusEnum.ENABLE.getCode());*/
//        T entity = baseMapper.selectByPrimaryKey(id);
//        if (entity != null) {
//            entity.setIsDelete(DeleteStatusEnum.DELETE.getCode());
//            return baseMapper.updateByPrimaryKeySelective(entity);
//        }
        return 0;
    }

    /**
     * 更新对象,如果属性为空，则不会进行对应的属性值更新
     *
     * @param entity 要更新的实体对象
     */
    @Override
    public int update(T entity) {
        return baseMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int updateByMap(T entity, Map<String, Object> condition) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andEqualTo(field, condition.get(field));
        }

        return baseMapper.updateByExampleSelective(entity, condition);
    }

    @Override
    public boolean updateByIdSelective(T entity, Long id) {
        Example example = new Example(entity.getClass());
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return baseMapper.updateByExampleSelective(entity, example) > 0;
    }

    @Override
    public int insertSelective(T entity) {
        enhanceNewCreateBaseEntity(entity);
        return baseMapper.insertSelective(entity);
    }

    @Override
    public int insertUseGeneratedKeys(T entity) {
        enhanceNewCreateBaseEntity(entity);
        return this.baseMapper.insertSelectiveUseGeneratedKeys(entity);
    }

    @Override
    public List<T> findList(Map<String, Object> condition) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andEqualTo(field, condition.get(field));
        }
        return baseMapper.selectByExample(example);
    }

    @Override
    public List<T> findList(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum) {

        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andEqualTo(field, condition.get(field));
        }
        if (StringUtils.isNotBlank(orderBy) && sqlOrderEnum != null) {
            if (sqlOrderEnum.getName().equals("desc")) {
                example.orderBy(orderBy).desc();
            } else {
                example.orderBy(orderBy).asc();
            }
        }
        return baseMapper.selectByExample(example);
    }

    /**
     * 根据传入的泛型参数类型查询该类型对应表中的所有数据，返回一个集合对象
     *
     * @return 返回泛型参数类型的对象集合
     */
    @Override
    public List<T> findAll() {
        return baseMapper.selectAll();
    }

    @Override
    public List<T> findAll(String orderBy, SqlOrderEnum sqlOrderEnum) {
        Example example = new Example(getEntityClass());
        if (sqlOrderEnum.getName().equals("desc")) {
            example.orderBy(orderBy).desc();
        } else {
            example.orderBy(orderBy).asc();
        }
        return baseMapper.selectByExample(example);
    }


    @Override
    public List<T> like(Map<String, Object> condition, Map<String, Object> likeCondition) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andEqualTo(field, condition.get(field));
        }

        for (String field : likeCondition.keySet()
                ) {
            criteria.andLike(field, likeCondition.get(field) + "%");
        }
        return baseMapper.selectByExample(example);
    }


    /**
     * 根据任意属性和属性值进行对象模糊查询
     *
     * @param condition
     * @return
     */
    @Override
    public List<T> like(Map<String, Object> condition) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andLike(field, (String) condition.get(field) + "%");
        }
        return baseMapper.selectByExample(example);
    }

    @Override
    public List<T> like(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andLike(field, (String) condition.get(field) + "%");
        }
        if (StringUtils.isNotBlank(orderBy) && sqlOrderEnum != null) {
            if (sqlOrderEnum.getName().equals("desc")) {
                example.orderBy(orderBy).desc();
            } else {
                example.orderBy(orderBy).asc();
            }
        }

        return baseMapper.selectByExample(example);
    }

    /**
     * 根据条件集合进行指定类型单一对象查询
     *
     * @param condition 进行查询的条件集合
     * @return 返回泛型参数类型的对象
     */
    @Override
    public T queryOne(Map<String, Object> condition) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andLike(field, (String) condition.get(field));
        }
        List<T> list = baseMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public T queryOne(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andLike(field, (String) condition.get(field));
        }

        if (StringUtils.isNotBlank(orderBy) && sqlOrderEnum != null) {
            if (sqlOrderEnum.getName().equals("desc")) {
                example.orderBy(orderBy).desc();
            } else {
                example.orderBy(orderBy).asc();
            }
        }
        List<T> list = baseMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


    /**
     * 根据条件进行数量的查询
     *
     * @param condition
     * @return 返回符合条件的泛型参数对应表中的数量
     */
    @Override
    public int count(Map<String, Object> condition) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andLike(field, (String) condition.get(field));
        }

        return baseMapper.selectCountByExample(example);
    }

    @Override
    public T selectOne(T entity) {
        return baseMapper.selectOne(entity);
    }

    @Override
    public int updateByExampleSelective(T entity, Map<String, Object> condition) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andLike(field, (String) condition.get(field));
        }
        return baseMapper.updateByExampleSelective(entity, example);
    }

    /**
     * 根据条件集合进行分页查询
     *
     * @param condition 查询条件
     * @param offset    偏移
     * @param rows      查询条数
     * @return 返回Pager对象
     */
    @Override
    public List<T> listByPage(Map<String, Object> condition, int offset, int rows) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andEqualTo(field, condition.get(field));
        }
        return baseMapper.selectByExampleAndRowBounds(example, new RowBounds(offset, rows));
    }

    @Override
    public List<T> listByPage(Map<String, Object> condition, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum) {
        Example example = new Example(getEntityClass());
        Example.Criteria criteria = example.createCriteria();
        for (String field : condition.keySet()
                ) {
            criteria.andEqualTo(field, condition.get(field));
        }
        if (StringUtils.isNotBlank(orderBy) && sqlOrderEnum != null) {
            if (sqlOrderEnum.getName().equals("desc")) {
                example.orderBy(orderBy).desc();
            } else {
                example.orderBy(orderBy).asc();
            }
        }

        return baseMapper.selectByExampleAndRowBounds(example, new RowBounds(offset, rows));
    }

    @Override
    public int selectCount(T var1) {
        return baseMapper.selectCount(var1);
    }

    private final T enhanceNewCreateBaseEntity(T entity) {
        if (entity instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) entity;
//            baseEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
//            baseEntity.setIsDelete(DeleteStatusEnum.AVAILABLE.getCode());
        }
        return entity;
    }


}
