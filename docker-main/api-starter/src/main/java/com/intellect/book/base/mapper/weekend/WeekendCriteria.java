package com.intellect.book.base.mapper.weekend;

import com.intellect.book.base.mapper.weekend.reflection.Reflections;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.Map;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public class WeekendCriteria<A, B> extends Criteria {

    private Weekend weekend;

    protected WeekendCriteria(Map<String, EntityColumn> propertyMap, boolean exists, boolean notNull) {
        super(propertyMap, exists, notNull);
    }

    public WeekendCriteria<A, B> setWeekend(Weekend weekend) {
        this.weekend = weekend;
        return this;
    }

    public Weekend weekend() {
        return this.weekend;
    }


    public WeekendCriteria<A, B> andIsNull(Fn<A, B> fn) {
        this.andIsNull(Reflections.fnToFieldName(fn));
        return this;
    }

    public WeekendCriteria<A, B> andIsNotNull(Fn<A, B> fn) {
        super.andIsNotNull(Reflections.fnToFieldName(fn));
        return this;
    }

    public WeekendCriteria<A, B> andEqualTo(Fn<A, B> fn, Object value) {
        super.andEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> andNotEqualTo(Fn<A, B> fn, Object value) {
        super.andNotEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> andGreaterThan(Fn<A, B> fn, Object value) {
        super.andGreaterThan(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> andGreaterThanOrEqualTo(Fn<A, B> fn, Object value) {
        super.andGreaterThanOrEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> andLessThan(Fn<A, B> fn, Object value) {
        super.andLessThan(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> andLessThanOrEqualTo(Fn<A, B> fn, Object value) {
        super.andLessThanOrEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> andIn(Fn<A, B> fn, Iterable values) {
        super.andIn(Reflections.fnToFieldName(fn), values);
        return this;
    }

    public WeekendCriteria<A, B> andNotIn(Fn<A, B> fn, Iterable values) {
        super.andNotIn(Reflections.fnToFieldName(fn), values);
        return this;
    }

    public WeekendCriteria<A, B> andBetween(Fn<A, B> fn, Object value1, Object value2) {
        super.andBetween(Reflections.fnToFieldName(fn), value1, value2);
        return this;
    }

    public WeekendCriteria<A, B> andNotBetween(Fn<A, B> fn, Object value1, Object value2) {
        super.andNotBetween(Reflections.fnToFieldName(fn), value1, value2);
        return this;
    }

    public WeekendCriteria<A, B> andLike(Fn<A, B> fn, String value) {
        super.andLike(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> andNotLike(Fn<A, B> fn, String value) {
        super.andNotLike(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> orIsNull(Fn<A, B> fn) {
        super.orIsNull(Reflections.fnToFieldName(fn));
        return this;
    }

    public WeekendCriteria<A, B> orIsNotNull(Fn<A, B> fn) {
        super.orIsNotNull(Reflections.fnToFieldName(fn));
        return this;
    }

    public WeekendCriteria<A, B> orEqualTo(Fn<A, B> fn, Object value) {
        super.orEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> orNotEqualTo(Fn<A, B> fn, Object value) {
        super.orNotEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> orGreaterThan(Fn<A, B> fn, Object value) {
        super.orGreaterThan(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> orGreaterThanOrEqualTo(Fn<A, B> fn, Object value) {
        super.orGreaterThanOrEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> orLessThan(Fn<A, B> fn, Object value) {
        super.orLessThan(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> orLessThanOrEqualTo(Fn<A, B> fn, Object value) {
        super.orLessThanOrEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> orIn(Fn<A, B> fn, Iterable values) {
        super.orIn(Reflections.fnToFieldName(fn), values);
        return this;
    }

    public WeekendCriteria<A, B> orNotIn(Fn<A, B> fn, Iterable values) {
        super.orNotIn(Reflections.fnToFieldName(fn), values);
        return this;
    }

    public WeekendCriteria<A, B> orBetween(Fn<A, B> fn, Object value1, Object value2) {
        super.orBetween(Reflections.fnToFieldName(fn), value1, value2);
        return this;
    }

    public WeekendCriteria<A, B> orNotBetween(Fn<A, B> fn, Object value1, Object value2) {
        super.orNotBetween(Reflections.fnToFieldName(fn), value1, value2);
        return this;
    }

    public WeekendCriteria<A, B> orLike(Fn<A, B> fn, String value) {
        super.orLike(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A, B> orNotLike(Fn<A, B> fn, String value) {
        super.orNotLike(Reflections.fnToFieldName(fn), value);
        return this;
    }
}
