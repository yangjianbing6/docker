package com.intellect.book.base.mapper.weekend.reflection;


import com.google.common.collect.Maps;
import com.intellect.book.base.entity.BaseEntity;
import com.intellect.book.base.mapper.weekend.Fn;

import javax.persistence.Column;
import java.beans.Introspector;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public class Reflections {
    private Reflections() {
    }

    public static String fnToFieldName(Fn fn) {
        try {
            Method method = fn.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(Boolean.TRUE);
            SerializedLambda serializedLambda = (SerializedLambda) method.invoke(fn);
            String getter = serializedLambda.getImplMethodName();
            String fieldName = Introspector.decapitalize(getter.replace("get", ""));
            return fieldName;
        } catch (ReflectiveOperationException e) {
            throw new ReflectionOperationException(e);
        }
    }

    public static <T extends BaseEntity> Map<String, String> fieldMapColumn(Class<T> clazz) {

        final Map<String, String> fieldMap = Maps.newHashMapWithExpectedSize(20);

        Stream.concat(Stream.of(clazz.getDeclaredFields()), Stream.of(clazz.getSuperclass().getDeclaredFields()))
                .forEach(field -> {
                    String column = field.getAnnotation(Column.class) == null ? field.getName() :
                            field.getAnnotation(Column.class).name();
                    fieldMap.put(field.getName(), column);
                });
        return fieldMap;
    }
}
