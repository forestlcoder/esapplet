package com.spider.luolin.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: luolin
 * @email: ll950129@gmail.com
 * create at 2018-01-07
 * version 1.0
 */
public class DateUtils {

    /**
     * @param dateStr
     * 把es中取出来的时间数据转化为date，
     * 他的时间字符串类似2017-06-12T03:30:53.221Z
     * @throws Exception
     */
    public static Date esDateFormat(Object dateStr) {
        if (StringUtils.isEmpty(dateStr)) return null;
        String s = String.valueOf(dateStr);
        String fDate = s.replace("Z", " UTC").replace("z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        try {
            return format.parse(fDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String date2str(Date date, String formatPattern) {
        if (date == null) return null;
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        return format.format(date);
    }

    public static String date2str(Date date) {
        return date2str(date, "yyyy-MM-dd");
    }

    public static void main(String[] args) {
        try {
            System.out.println(esDateFormat("2017-06-12T03:30:53.221Z"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
