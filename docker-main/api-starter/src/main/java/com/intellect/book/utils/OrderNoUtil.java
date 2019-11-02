package com.intellect.book.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OrderNoUtil {
    private static int sn = 0;

    /**
     * 随机数字
     *
     * @return
     */
    public static String NextOrderNo() {
        if (sn == 999999999)
            sn = 0;
        else
            sn++;
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date()) + padRight(String.valueOf(sn), 9, '0');
    }

    private static String padLeft(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    private static String padRight(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    // 防止创建类的实例
    private OrderNoUtil() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(OrderNoUtil.NextOrderNo());
        }
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        uuid = uuid.replace("-", "");
        System.out.println(uuid);

        System.out.println(getUUID());
    }

    /**
     * 获取num位随机字符串
     *
     * @return String
     */
    public static String getUUID(int num) {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        if (num <= 0 || num > uuid.length()) {
            num = uuid.length();
        }
        return uuid.substring(0, num);
    }

    /**
     * 获取20位随机字符串
     *
     * @return String
     */
    public static String getUUID() {
        return getUUID(20);
    }
}