package com.nilzxq.common;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author zxq @date 2017年1月3日
 *
 */
public class MyDateFormatter implements Formatter<Date> {

    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(text);
    }

    public String print(Date object, Locale locale) {
        return null;
    }
}
