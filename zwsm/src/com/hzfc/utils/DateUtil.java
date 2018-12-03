package com.hzfc.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 方法说明：取当前日期(格式 20030801)
     * 
     */
    public static String getStrNowDate() {
        java.util.Date tdate = new java.util.Date();
        String nowtime = new Timestamp(tdate.getTime()).toString();
        nowtime = nowtime.substring(0, 10);
        String nowYear = nowtime.substring(0, 4);
        String nowMonth = nowtime.substring(5, 7);
        String nowDay = nowtime.substring(8, 10);
        String nowdate = nowYear + nowMonth + nowDay;
        return nowdate;

    }

    /**
     * 方法说明：取当前日期 (格式 2003-08-01)
     * 
     */
    public static String getNowDate() {
        java.util.Date tdate = new java.util.Date();
        String nowtime = new Timestamp(tdate.getTime()).toString();
        nowtime = nowtime.substring(0, 10);
        return nowtime;
    }
    /**
     * 方法说明：取当前日期 (格式 2003\08\01) (格式 2003/08/01)
     * 
     */
    public static String getNowDateSplit(String splitchar) {
           return getNowDate().replace("-", splitchar); 
    }
    
    public static Timestamp getNowTimestamp() {
        java.util.Date tdate = new java.util.Date();
        return new Timestamp(tdate.getTime());
    }
    /**
	 * 从指定Timestamp中得到相应的日期
	 * 
	 * @param datetime
	 *            指定的Timestamp
	 * @return 日期 "2003-09-08"
	 */
    
    public static String getDateFromDate(Timestamp datetime) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return sdf.format(datetime).toString();
    }
    public static String getDateFromDate(Timestamp datetime,String formatString) {
            SimpleDateFormat sdf = new SimpleDateFormat(formatString);
            return sdf.format(datetime).toString();
    }
    public static String getDateFromDate(Date datetime){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(datetime).toString();
    }
    public static String getDateFromDate(Date datetime,String formatStr){
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
            return sdf.format(datetime).toString();
    }
    
        /**
	 * 从指定Timestamp中得到相应的时间
	 * 
	 * @param datetime
	 *            指定的Timestamp
	 * @return 日期 "2003-09-08"
	 */
    public static String getDateFromTime(Timestamp datetime) {
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            return sdf.format(datetime).toString();
    }
    public static int getIntMonth() {
        java.util.Date tdate = new java.util.Date();
        String nowtime = new Timestamp(tdate.getTime()).toString();
        nowtime = nowtime.substring(0, 10);
        return Integer.parseInt(nowtime.substring(5, 7)) ;
    }
    public static Date StringToDate(String dateStr,String formatStr){
		DateFormat sdf=new SimpleDateFormat(formatStr);
		Date date=null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	} 
}
