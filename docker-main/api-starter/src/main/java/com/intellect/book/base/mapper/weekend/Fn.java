package com.intellect.book.base.mapper.weekend;

import java.io.Serializable;
import java.util.function.Function;

/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public interface Fn<T, R> extends Function<T, R>, Serializable {
}
