package com.intellect.book.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    /**
     * 判断两个时间间隔是否大于指定的时间区间
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param pattern   时间pattern  默认是“yyyy-MM-dd”
     * @param nums      区间数量
     * @param field     区间单位  对应Calendar field
     * @return
     */
    public static boolean timeDiff(String startTime, String endTime, String pattern, int nums, int field) {
        if (StringUtils.isBlank(startTime)) {
            throw new IllegalArgumentException(
                    "The startTime is Null or ''.It's unbelievable!");
        }
        if (StringUtils.isBlank(endTime)) {
            throw new IllegalArgumentException(
                    "The endTime is Null or ''.It's unbelievable!");
        }
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyy-MM-dd";
        }
        Date startDate = string2Date(startTime, pattern);
        Date endDate = string2Date(endTime, pattern);
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(field, nums);
        Calendar d = Calendar.getInstance();
        d.setTime(endDate);
        return c.before(d);
    }

    /**
     * 根据用户生日计算年龄
     */
    public static int getAgeByBirthday(Date birthday) {
        Calendar cal = Calendar.getInstance();
        if (birthday == null) {
            return 0;
        }

        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth
                age--;
            }
        }
        return age;
    }

    public static String date2string(Date time, String pattern) {
        Date d = time;

        if (pattern == null) {
            pattern = "yyyy-MM-dd";
        }

        if (time == null) {
            return "";
        }
        return DateFormatUtils.format(d, pattern);
    }

    public static Date string2Date(String dateStr, String pattern) {

        if (pattern == null) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            if (dateStr == null || "".equals(dateStr)) {
                return date;
            }
            date = format.parse(dateStr + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    public static synchronized String getLocalDateString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(new Date());
        return dateStr;
    }

    public static synchronized String getLocalDateString(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String dateStr = format.format(new Date());
        return dateStr;
    }

    public static void main(String[] args) {
//        System.out.println(date2string(new Date(815184000000L),null));
        boolean flag = timeDiff("2018-08-02", "2018-10-02", "yyyy-MM-dd", 60, Calendar.DATE);
        System.out.println("BB:" + flag);

    }


}
