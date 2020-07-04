package com.example.krpano.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期格式转换类
 */

public final class DateUtil {
    private static final Log log = LogFactory.getLog(DateUtil.class);

    private static final String ZERO_POINT = " 00:00:00";

    private static SimpleDateFormat DATE_DAY = new SimpleDateFormat("yyyyMMdd");

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

    private DateUtil() {
    }


    /**
     * 将日期对象转换为yyyy-MM-dd HH:mm:ss格式字符串
     *
     * @param date 时间对象
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     */
    public static String toStringYmdHmsWthH(Date date) {
        if (date == null) {
            return null;
        }
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
    }

    /**
     * 将日期对象转换为yyyy/MM/dd 格式字符串
     *
     * @param date 时间对象
     * @return yyyy/MM/dd格式字符串
     */
    public static String toStringYmdHmsWthyMd(Date date) {
        if (date == null) {
            return null;
        }
        return (new SimpleDateFormat("yyyy/MM/dd")).format(date);
    }

    /**
     * 将字符串yyyy/MM/dd  转换为日期对象
     *
     * @param dateStr 时间对象
     * @return yyyy/MM/dd格式字符串
     */
    public static Date toDateYmd(String dateStr) {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            return new SimpleDateFormat("yyyy/MM/dd").parse(dateStr);
        } catch (ParseException e) {
            log.error("toDateYmd ParseException", e);
            return null;
        }
    }

    /**
     * 将日期对象转换为yyyy-MM-dd格式字符串
     *
     * @param date 时间对象
     * @return yyyy-MM-dd格式字符串
     */
    public static String toStringYmdWthH(Date date) {
        if (date != null) {
            return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
        }
        return null;
    }


    /**
     * 将yyyy-MM-dd HH:mm:ss格式字符串转换为日期对象
     *
     * @param dateStr yyyy-MM-dd HH:mm:ss格式字符串
     * @return 日期对象或null
     */
    public static Date toDateYmdHmsWthH(String dateStr) {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(dateStr);
        } catch (ParseException e) {
            log.error("toDateYmdHmsWthH ParseException", e);
            return null;
        }
    }


    /**
     * 将yyyy-MM-dd格式字符串转换为日期对象
     *
     * @param dateStr yyyy-MM-dd格式字符串
     * @return 日期对象
     */
    public static Date toDateYmdWthH(String dateStr) {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            return (new SimpleDateFormat("yyyy-MM-dd")).parse(dateStr);
        } catch (ParseException e) {
            log.error("toDateYmdWthH parseException", e);
            return null;
        }
    }


    /**
     * 将日期对象转换为yyyyMMdd格式字符串
     *
     * @param date 时间对象
     * @return yyyyMMdd格式字符串
     */
    public static String toStringYmd(Date date) {
        if (date == null) {
            return null;
        }
        return (new SimpleDateFormat("yyyyMMdd")).format(date);
    }


    /**
     * 将日期对象转换为yyyy-MM格式字符串
     *
     * @param date 时间对象
     * @return yyyy-MM格式字符串
     */
    public static String toStringYcrm(Date date) {
        if (date == null) {
            return null;
        }
        return (new SimpleDateFormat("yyyy-MM")).format(date);
    }


    /**
     * 比较两个日期的大小
     * <p/>
     * <p>
     * <pre>
     *  1、日期参数为空表示无穷小
     * </pre>
     *
     * @param inDate1 第一个日期参数 @param inDate2 第二个日期参数 @return 处理结果 0:相等, -1:inDate1 <
     *                inDate2, 1:inDate1 > inDate2 @throws
     */
    public static int dateCompare(Date inDate1, Date inDate2) {
        return dateCompare(inDate1, inDate2, Calendar.SECOND);
    }

    /**
     * 比较日期大小
     *
     * @param inDate1 日期1
     * @param inDate2 日期2
     * @param unit    比较精度 年：1 ;月：2; 周：3; 日：5; 时：10; 分：12;秒：13
     * @return 处理结果 0:相等, -1:inDate1<inDate2, 1:inDate1>inDate2
     */
    public static int dateCompare(Date inDate1, Date inDate2, int unit) {
        // 字符空验证
        if (inDate1 == null && inDate2 == null) {
            // 两个日期都为空返回相等
            return 0;
        } else if (inDate1 == null) {
            // 日期1为空，日期2不为空返回-1
            return -1;
        } else if (inDate2 == null) {
            // 日期1不为空，日期为空返回2
            return 1;
        }
        return DateUtils.truncatedCompareTo(inDate1, inDate2, unit);
    }

    /**
     * 调整时间, 按照需要调整的单位调整时间
     * <p/>
     * <p>
     * <pre>
     * 例如:保留到日期的年change("20120511154440", DateUtil.YEAE, 2);返回：20140511154440<br/>
     * </pre>
     *
     * @param inDate 传入日志
     * @param unit   调整单位 年：1 ;月：2; 周：3; 日：5; 时：10; 分：12;秒：13
     * @param amount 调整数量
     * @return 调整后的日期
     */
    public static Date change(Date inDate, int unit, int amount) {
        if (inDate == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inDate);
        calendar.add(unit, amount);
        return calendar.getTime();
    }

    /**
     * 按照精度要求对日期进行舍取
     * <p/>
     * <p>
     * <pre>
     * 例如:保留到日期的年truncate("20120511154440", DateUtil.YEAE);返回：20120101000000<br/>
     * </pre>
     *
     * @param inDate 输入日期
     * @param unit   单位 年：1 ;月：2;日：5; 时：10; 分：12;秒：13
     * @return 处理后的日期
     */
    public static Date truncate(Date inDate, int unit) {
        if (inDate == null) {
            return null;
        }
        return DateUtils.truncate(inDate, unit);
    }


    /**
     * 将日期格式化为指定的格式
     *
     * @param date    日期
     * @param pattern 格式化模式
     * @return
     */
    public static String format(Date date, String pattern) {
        if (StringUtils.isBlank(pattern) || date == null) {
            return null;
        }
        return DateFormatUtils.format(date, pattern);
    }

    public static Integer equation(Date startTime, Date endTime) {
        if (null == startTime || null == endTime) {
            return null;
        }
        return (int) ((endTime.getTime() - startTime.getTime()) / (1000 * 3600 * 24));
    }

    /**
     * 根据传入的日期字符串和转换格式，格式化日期字符串
     *
     * @param strDate   日期字符串 如 2015-09-17 17：00：45
     * @param formatStr 格式化字符串，如 yyyy-MM-dd HH:mm:ss
     * @return
     * @author fangyy
     * @date 2015年9月17日 下午5:00:45
     */
    public static Date strToDate(String strDate, String formatStr) {
        if (StringUtils.isBlank(formatStr)) {
            return null;
        }

        if (StringUtils.isBlank(strDate)) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            return sdf.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 根据传入的日期和转换格式，将日期转换成字符串输出
     *
     * @param date      要格式化的日期
     * @param formatStr 格式化字符串，如 yyyy-MM-dd HH:mm:ss
     * @return 格式化后的字符串 2015-09-17 17：00：45
     * @author fangyy
     * @date 2015年9月17日 下午5:00:45
     */
    public static String dateToStr(Date date, String formatStr) {

        if (StringUtils.isBlank(formatStr)) {
            return null;
        }

        if (date == null) {
            return null;
        }

        return new SimpleDateFormat(formatStr).format(date);

    }


    /**
     * 8 位整数转化位date
     *
     * @return
     */
    public static Date covertIntegerToDate(Integer date) {
        if (date == null || String.valueOf(date).length() != 8) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            return sdf.parse(String.valueOf(date));
        } catch (Exception e) {
            log.error("日期转换异常", e);
            return null;
        }
    }

    /**
     * 8 位整数转化位date-yyyy-MM-dd
     *
     * @return
     */
    public static Date covertIntegerToDateWithYmd(Integer date) {
        if (date == null || String.valueOf(date).length() != 8) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(String.valueOf(date));
        } catch (Exception e) {
            log.error("日期转换异常", e);
            return null;
        }
    }

    /**
     * 将时间设置成一天最小
     *
     * @return
     */
    public static Date gainDate2Min(Date date) {
        if (date == null) {
            return date;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 将时间设置成一天最大
     *
     * @return
     */
    public static Date gainDate2Max(Date date) {
        if (date == null) {
            return date;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);

        return calendar.getTime();
    }

    /**
     * 获取某季度的第一天和最后一天
     *
     * @param num
     */
    public static String[] getCurrQuarter(int year, int num) {
        String[] s = new String[2];
        String str = "";
        Calendar quarterCalendar = Calendar.getInstance();
        quarterCalendar.set(Calendar.YEAR, year);

        switch (num) {
            case 1: // 本年到现在经过了一个季度，在加上前4个季度
                quarterCalendar.set(Calendar.MONTH, 3);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = toStringYmdWthH(quarterCalendar.getTime());
                s[0] = str.substring(0, str.length() - 5) + "01-01";
                s[1] = str;
                break;
            case 2: // 本年到现在经过了二个季度，在加上前三个季度
                quarterCalendar.set(Calendar.MONTH, 6);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = toStringYmdWthH(quarterCalendar.getTime());
                s[0] = str.substring(0, str.length() - 5) + "04-01";
                s[1] = str;
                break;
            case 3:// 本年到现在经过了三个季度，在加上前二个季度
                quarterCalendar.set(Calendar.MONTH, 9);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = toStringYmdWthH(quarterCalendar.getTime());
                s[0] = str.substring(0, str.length() - 5) + "07-01";
                s[1] = str;
                break;
            case 4:// 本年到现在经过了四个季度，在加上前一个季度
                str = toStringYmdWthH(quarterCalendar.getTime());
                s[0] = str.substring(0, str.length() - 5) + "10-01";
                s[1] = str.substring(0, str.length() - 5) + "12-31";
                break;
        }
        return s;
    }

    /**
     * 获取某季度的第一天和最后一天
     *
     * @param num
     */
    public static Date[] getDatesByCurrQuarter(int year, int num) {
        Date[] resultDateArray = new Date[2];
        String str = "";
        Calendar quarterCalendar = Calendar.getInstance();
        quarterCalendar.set(Calendar.YEAR, year);

        switch (num) {
            case 1: // 本年到现在经过了一个季度，在加上前4个季度
                quarterCalendar.set(Calendar.MONTH, 3);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = toStringYmdWthH(quarterCalendar.getTime());
                break;
            case 2: // 本年到现在经过了二个季度，在加上前三个季度
                quarterCalendar.set(Calendar.MONTH, 6);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = toStringYmdWthH(quarterCalendar.getTime());
                break;
            case 3:// 本年到现在经过了三个季度，在加上前二个季度
                quarterCalendar.set(Calendar.MONTH, 9);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = toStringYmdWthH(quarterCalendar.getTime());
                break;
            case 4:// 本年到现在经过了四个季度，在加上前一个季度
                str = toStringYmdWthH(quarterCalendar.getTime());
                str = str.substring(0, str.length() - 5) + "12-31";
                break;
        }
        Date minDate = DateUtil.toDateYmdHmsWthH(DateUtil.toStringYmdHmsWthH(DateUtil.toDateYmdWthH(year + "-01-01")));
        Date maxDate = DateUtil.toDateYmdHmsWthH(DateUtil.toStringYmdHmsWthH(DateUtil.gainDate2Max(DateUtil.toDateYmdWthH(str))));
        resultDateArray[0] = minDate;
        resultDateArray[1] = maxDate;
        return resultDateArray;
    }


    public static Date printMethodExpendTimes(Date startDate, String logMsg) {
        Date endDate = new Date();
        log.info(logMsg + (endDate.getTime() - startDate.getTime()));
        return endDate;
    }

    public static Date getLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 0);//设置日历时间，月份必须减一
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    public static Date getCurrQuarterDate(int year, int num) {
        String dateStr = getCurrQuarter(year, num)[1].concat(ZERO_POINT);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (Exception e) {
            log.error("日期转换异常", e);
            return null;
        }
    }

    //获取某年所有月份得最后一天
    public static Date[] getMonthLastDayOfYear(int year) {
        Date[] dateArr = new Date[12];
        for (int i = 0; i < 12; i++) {
            Calendar cal = Calendar.getInstance();
            //设置年份
            cal.set(Calendar.YEAR, year);
            //设置月份
            cal.set(Calendar.MONTH, i);
            //设置日历中月份的最大天数
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            dateArr[i] = cal.getTime();
        }
        return dateArr;
    }

    /**
     * 获取指定年月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth1(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(cal.getTime());
    }

    /**
     * 获取指定时间的上一个月时间
     *
     * @param date
     * @return
     */
    public static Date minusMonth(Date date, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //当前时间前去指定月，即指定月前的时间
        calendar.add(Calendar.MONTH, -num);
        //获取一年前的时间，或者一个月前的时间
        return calendar.getTime();
    }

    /**
     * 获取指定时间减去指定月份的第一天和最后一天
     */
    public static String[] getFistDayAndLastDay(Date date, int num) {
        String[] dayArr = new String[2];
        Date currentDate = DateUtil.minusMonth(date, num);
        int[] arr = DateUtil.getYearAndMonth(currentDate);
        //获取指定年月的第一天
        String lastDay = DateUtil.getLastDayOfMonth1(arr[0], arr[1]);
        //获取指定年月的最后一天
        String firstDay = DateUtil.getFirstDayOfMonth1(arr[0], arr[1]);
        dayArr[0] = firstDay;
        dayArr[1] = lastDay;
        return dayArr;
    }

    /**
     * 获取指定时间的年和月
     */
    public static int[] getYearAndMonth(Date date) {
        int[] dateArr = new int[2];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        dateArr[0] = year;
        dateArr[1] = month;
        return dateArr;

    }

    /**
     * 获取指定年月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth1(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(cal.getTime());
    }

    /**
     * 获取指定年月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取指定年份，月份得最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Integer[] getLastQuarter(Date date) {
        Integer[] dateArr = new Integer[2];
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(date);
        startCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        int month = startCalendar.get(Calendar.MONTH) + 1;
        dateArr[0] = startCalendar.get(Calendar.YEAR);
        dateArr[1] = month / 3 + 1;
        return dateArr;
    }

    /**
     * 当前时间处于该年哪个季度
     *
     * @param date
     * @return
     */
    public static Integer getQuarterByDate(Date date) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(date);
        startCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        int month = startCalendar.get(Calendar.MONTH) + 1;
        return month / 3 + 1;
    }

    //获取当前月份第一天
    public static Date getCurMonthBeginDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    //获取当前月份最后一天
    public static Date getCurMonthLastDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    //将日期转换 yyyy-MM-dd 格式
    public static String getDayStrByDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    //获取前一天日期 yyyy-MM-dd 格式
    public static String getDayStrOfLastDay() {
        //获取前一天日期
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, day - 1);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    //获取本周周一日期
    public static Date getMondayOfCurWeek() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    //获取本周周日日期
    public static Date getSundayOfCurWeek() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 7);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 获取年
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    //获取上周周一日期
    public static Date getMondayOfLastWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getMondayOfCurWeek());
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    //获取上周周日日期
    public static Date getSundayOfLastWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getSundayOfCurWeek());
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    /**
     * 获取指定日期的上月最后一天日期
     * 如果指定日期为空，则默认当前日期
     *
     * @return
     */
    public static Date getLastDayOfPrevMonth(Date date) {
        try {
            if (date == null) {
                date = new Date();
            }
            Calendar c = Calendar.getInstance();
            //设置为指定日期
            c.setTime(date);
            //指定日期月份减去一
            c.add(Calendar.MONTH, -1);
            //指定日期月份减去一后的 最大天数
            c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
            //获取最终的时间
            Date lastDateOfPrevMonth = c.getTime();
            return lastDateOfPrevMonth;
        } catch (Exception e) {
            log.error("获取上月最后一天日期异常", e);
            return null;
        }
    }

    /**
     * 获取时间区间 每个月 一年内
     *
     * @return
     * @throws ParseException
     */
    public static ArrayList<String> genEveryMonth(Date date) {
        Date minDate = DateUtils.addYears(date, -1);
        Date maxDate = new Date();
        ArrayList<String> result = new ArrayList<String>();
        //格式化为年月
        FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM");
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(minDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(maxDate);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(fdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 获取日期下一个月份
     *
     * @param date
     * @return
     */
    public static Date getNextMonthDate(Date date) {
        return getCalendarTime(date, 1);
    }

    /**
     * 获取日期上一个月份
     *
     * @param date
     * @return
     */
    public static Date getLastMonthDate(Date date) {
        return getCalendarTime(date, -1);
    }

    /**
     * 获取转换日期
     *
     * @param date
     * @param addMonth 调整的月份
     * @return
     */
    private static Date getCalendarTime(Date date, int addMonth) {
        try {
            if (date == null) {
                return null;
            }
            Calendar c = Calendar.getInstance();
            //设置为指定日期
            c.setTime(date);
            //指定日期月份减去一
            c.add(Calendar.MONTH, addMonth);
            //获取最终的时间
            return c.getTime();
        } catch (Exception e) {
            log.error("获取转换日期", e);
            return null;
        }
    }

    public static Date genWorkDay(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int week = 0;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//获取该月最大一天
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        week = cal.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1;//获得最后一天是星期几
        if (week == 7) {
            lastDay = lastDay - 2;
        } else if (week == 6) {
            lastDay = lastDay - 1;
        }
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);//设置日历时间，月份必须减一
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }


    /**
     * 获取当天日期yyyyMMdd
     *
     * @param
     */
    public static String getCurrentDate2Day() {
        try {
            return DATE_DAY.format(new Date());
        } catch (Exception e) {
            log.error("getCurrentDate2Day exception", e);
        }
        return null;
    }

    /**
     * 获取两个时间相差月份
     */
    public static int getDiffMonths(Date date1, Date date2) {
        int result = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(sdf.format(date1)));
            c2.setTime(sdf.parse(sdf.format(date2)));
            int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
            int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
            result = 12 * year + month;
        } catch (ParseException e) {
            log.error("获取两个时间相差月份 exception", e);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Date d1 = sdf.parse("2019-10");
        System.out.println(getDay(new Date()));
    }

    /**
     * 获取当前月份 去年同月份时间
     *
     * @param date
     * @param format
     * @return
     */
    public static String getLastYearMoth(Date date, String format) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.YEAR, -1);
            return dateToStr(c.getTime(), format);
        } catch (Exception e) {
            log.error("获取当前月份去年同月份时间 exception", e);
            return "";
        }
    }

    /**
     * 获取当前月份 去年同月份时间
     *
     * @param date
     * @return
     */
    public static Date getLastYearMothDate(Date date) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.YEAR, -1);
            return c.getTime();
        } catch (Exception e) {
            log.error("获取当前月份去年同月份时间 exception", e);
            return null;
        }
    }

    /**
     * 计算两个时间月份差
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 两者月份差
     */
    public static Integer differMonth(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null) {
            return null;
        }
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(beginDate);
        aft.setTime(endDate);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result);
    }

    /**
     * 获取年第一个月 第一天
     */
    public static Date getYearStartTime(Date date){
        if (date == null) {
            return null;
        }
        try{
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.MONTH,0);
            c.set(Calendar.DAY_OF_YEAR,1);
            return c.getTime();
        }catch (Exception e){
            log.error("获取年第一个月异常",e);
            return null;
        }
    }

    /**
     * 根据年月获取当月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthBeginTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate = yearMonth.atDay(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));
        return Date.from(zonedDateTime.toInstant());
    }
    /**
     * 根据年月获取当月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthEndTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();
        LocalDateTime localDateTime = endOfMonth.atTime(23, 59, 59, 999);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 根据年获取当年第一天
     *
     * @param year
     * @return
     */
    public static Date getYearBeginTime(int year) {
        Year yearMonth = Year.of(year);
        LocalDate localDate = yearMonth.atDay(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));

        return Date.from(zonedDateTime.toInstant());
    }
    /**
     * 根据年获取当年第一天
     *
     * @param year
     * @return
     */
    public static Date getYearEndTime(int year) {
        Year yearMonth = Year.of(year);
        LocalDate endOfMonth = yearMonth.atMonthDay(MonthDay.of(12,31));
        LocalDateTime localDateTime = endOfMonth.atTime(23, 59, 59, 999);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 获取去年最后个月 最后一天
     */
    public static Date getLastYearEndDayTime(Date date){
        if (date == null) {
            return null;
        }
        try{
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.MONTH,0);
            c.set(Calendar.DAY_OF_YEAR,0);
            return c.getTime();
        }catch (Exception e){
            log.error("获取去年最后一个月异常",e);
            return null;
        }
    }

    /**
     * 获取去年第一个月 第一一天
     */
    public static Date getLastYearStartDayTime(Date date){
        if (date == null) {
            return null;
        }
        try{
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.YEAR,-1);
            c.set(Calendar.MONTH,0);
            c.set(Calendar.DAY_OF_YEAR,1);
            return c.getTime();
        }catch (Exception e){
            log.error("获取去年第一个月异常",e);
            return null;
        }
    }

    /**
     * 获取前一天日期
     */
    public static Date getLastDayTime(Date date){
        if (date == null) {
            return null;
        }
        try{
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DAY_OF_YEAR,-1);
            return c.getTime();
        }catch (Exception e){
            log.error("获取前一天日期异常",e);
            return null;
        }
    }

    /**
     * 获取日期在当月的 天数
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        if (date == null) {
            return 0;
        }
        try{
            Calendar c = Calendar.getInstance();
            return c.get(Calendar.DAY_OF_MONTH);
        }catch (Exception e){
            log.error("获取前一天日期异常",e);
            return 0;
        }
    }

    /**
     * 时间设置当前时分秒
     * @param date 入参
     * @return Date
     */
    public static Date setCurrentHourMinSecond(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar call = Calendar.getInstance();
        call.setTime(date);
        // 设置当前时分秒
        call.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY));
        call.set(Calendar.MINUTE, now.get(Calendar.MINUTE));
        call.set(Calendar.SECOND, now.get(Calendar.SECOND));
        return call.getTime();
    }
}
