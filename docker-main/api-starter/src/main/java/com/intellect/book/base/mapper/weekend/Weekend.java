package com.intellect.book.base.mapper.weekend;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public class Weekend<T> extends tk.mybatis.mapper.entity.Example {

    public Weekend(Class<T> entityClass) {
        super(entityClass);
    }

    public Weekend(Class<T> entityClass, boolean exists) {
        super(entityClass, exists);
    }

    public Weekend(Class<T> entityClass, boolean exists, boolean notNull) {
        super(entityClass, exists, notNull);
    }

    public static <A> Weekend<A> of(Class<A> clazz, Boolean exists, boolean notNull) {
        return new Weekend<A>(clazz, exists, notNull);
    }

    public static <A> Weekend<A> of(Class<A> clazz, Boolean exists) {
        return new Weekend<A>(clazz, exists, Boolean.FALSE);
    }

    public static <A> Weekend<A> of(Class<A> clazz) {
        return new Weekend<A>(clazz, Boolean.TRUE);
    }

    public WeekendCriteria<T, Object> createCriteriaAddOn() {
        WeekendCriteria<T, Object> weekendCriteria = new WeekendCriteria<>(this.propertyMap, this.exists, this.notNull);
        return weekendCriteria;
    }

    @Override
    protected Criteria createCriteriaInternal() {
        return this.createCriteriaAddOn();
    }

    @SuppressWarnings("all")
    public WeekendCriteria<T, Object> weekendCriteria() {
        WeekendCriteria<T, Object> criteria = (WeekendCriteria<T, Object>) this.createCriteria();
        criteria.setWeekend(this);
        return criteria;
    }

    public Weekend orderByClause(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

}
