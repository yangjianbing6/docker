package com.intellect.book.base.dto;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

/**
 * <p> </p>
 *
 * @author yangjianbing
 * @create 2018-11-23 12:56:25
 **/
public class BaseDTO implements Serializable {

    public static final int FIRST_PAGE = 1;
    public static final int DEFAULT_PAGE = FIRST_PAGE;
    public static final int DEFAULT_LIMIT = 20;

    public static final int MAX_PAGE = 1000;
    public static final int MAX_COUNT = MAX_PAGE * DEFAULT_LIMIT;


    public static final int DEFAULT_LBS_DISTANCE_KM = 5;

    public static final int CENT = 100;

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


}
