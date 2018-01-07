package com.spider.luolin.utils;

import java.math.BigDecimal;

/**
 * @author: luolin
 * @email: ll950129@gmail.com
 * create at 2018-01-07
 * version 1.0
 */
public class DecimalUtils {

    /**
     * 保留的小数精度，四舍五入
     * @param value
     * @param precision 保留的小数位数
     * @return
     */
    public static double formatPrecision(Double value, int precision) {
        BigDecimal d = new BigDecimal(value);
        return d.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double formatPrecision(Double value) {
        return formatPrecision(value, 2);
    }

    public static void main(String[] args) {
        System.out.println(formatPrecision(23.225332, 2));
        System.out.println(formatPrecision(23.224332, 2));
    }
}
