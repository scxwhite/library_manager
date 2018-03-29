package com.xynu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wyr
 * @date 2018/3/29
 */
public class DateUtil {

    public static String getStringDate(String formatter, Date date) {
        if (formatter == null) {
            formatter = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        return sdf.format(date);
    }
}
