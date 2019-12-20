package easy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
public class DateUtil {
        private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

        public final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

        public final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

        public final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public static Date getConventTime(String date) throws ParseException {
            return date != null && date != "" ? sdfTime.parse(date) : null;
        }

        public final static SimpleDateFormat sdfDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);

        public final static SimpleDateFormat sdfinalDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        public static String GetstandDate(String date) {
            String dateString = "";
            try {
                if (date.length() > 5) {
                    SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
                    if (date.contains(".")) {
                        String[] datalist = date.split("\\.");
                        dateString = datalist.length > 0 ? datalist[0] : "";

                    } else {
                        Date conventdate = sdf1.parse(date);

                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        dateString = formatter.format(conventdate);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return dateString;

        }

        /**
         * @Title: getSeconds
         * @Description: 获取今天还剩下多少秒
         * @param: @return
         * @author: manji
         * @return: int
         * @throws
         */
        public static int getTomorrowSeconds(){
            Calendar curDate = Calendar.getInstance();
            Calendar tommorowDate = new GregorianCalendar(curDate
                    .get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate
                    .get(Calendar.DATE) + 1, 0, 0, 0);
            return (int)(tommorowDate.getTimeInMillis() - curDate .getTimeInMillis()) / 1000;
        }
        /**
         * 获取YYYY格式
         *
         * @return
         */
        public static String getYear() {
            return sdfYear.format(new Date());
        }

        /**
         * 获取YYYY-MM-DD格式
         *
         * @return
         */
        public static String getDay() {
            return sdfDay.format(new Date());
        }

        /**
         * 获取YYYY-MM-DD格式
         *
         * @return
         */
        public static String getDay(Date date) {
            return sdfDay.format(date);
        }


        /**
         * 获取YYYYMMDD格式
         *
         * @return
         */
        public static String getDays() {
            return sdfDays.format(new Date());
        }

        /**
         * 获取YYYY-MM-DD HH:mm:ss格式
         *
         * @return
         */
        public static String getTime() {
            return sdfTime.format(new Date());
        }

        /**
         * 获取YYYY-MM-DD HH:mm:ss格式
         *
         * @return
         */
        public static String getTime(Date date) {
            return sdfTime.format(date);
        }

        /**
         * 获取两分钟之后的时间
         *
         */
        public static String getTime2MinLater(){
            return sdfTime.format(new Date().getTime() + 2*60*1000);
        }
        /**
         * @Title: compareDate
         * @Description:
         * @param s
         * @param e
         * @return boolean
         * @throws
         * @author luguosui
         */
        public static boolean compareDate(String s, String e) {
            if (fomatDate(s) == null || fomatDate(e) == null) {
                return false;
            }
            return fomatDate(s).getTime() >= fomatDate(e).getTime();
        }

        /**
         * 格式化日期
         *
         * @return
         */
        public static Date fomatDate(String date) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return fmt.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * 校验日期是否合法
         *
         * @return
         */
        public static boolean isValidDate(String s) {
            // DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                // fmt.format(s);
                if (s.indexOf("-") >= 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
                return false;
            }
        }

        public static int getDiffYear(String startTime, String endTime) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                long aa = 0;
                int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
                return years;
            } catch (Exception e) {
                // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
                return 0;
            }
        }

        /**
         * <li>功能描述：时间相减得到天数
         *
         * @param beginDateStr
         * @param endDateStr
         * @return long
         * @author Administrator
         */
        public static long getDaySub(String beginDateStr, String endDateStr) {
            long day = 0;
            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date beginDate = null;
            java.util.Date endDate = null;

            try {
                beginDate = format.parse(beginDateStr);
                endDate = format.parse(endDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
            // System.out.println("相隔的天数="+day);

            return day;
        }

        //计算两个日期相差年数
        public static int yearDateDiff(String startDate,String endDate){
            Calendar calBegin = Calendar.getInstance(); //获取日历实例
            Calendar calEnd = Calendar.getInstance();
            calBegin.setTime(stringTodate(startDate,"yyyy")); //字符串按照指定格式转化为日期
            calEnd.setTime(stringTodate(endDate,"yyyy"));
            return calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);
        }

        public static Date stringTodate(String dateStr, String formatStr) {
            // 如果时间为空则默认当前时间
            Date date = null;
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            if (dateStr != null && !dateStr.equals("")) {
                String time = "";
                try {
                    Date dateTwo = format.parse(dateStr);
                    time = format.format(dateTwo);
                    date = format.parse(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } else {
                String timeTwo = format.format(new Date());
                try {
                    date = format.parse(timeTwo);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return date;
        }
        /**
         * 得到n天之后的日期
         *
         * @param days
         * @return
         */
        public static String getAfterDayDate(String days) {
            int daysInt = Integer.parseInt(days);

            Calendar canlendar = Calendar.getInstance(); // java.util包
            canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
            Date date = canlendar.getTime();

            SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdfd.format(date);

            return dateStr;
        }

        /**
         * 得到n天之后是周几
         *
         * @param days
         * @return
         */
        public static String getAfterDayWeek(String days) {
            int daysInt = Integer.parseInt(days);

            Calendar canlendar = Calendar.getInstance(); // java.util包
            canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
            Date date = canlendar.getTime();

            SimpleDateFormat sdf = new SimpleDateFormat("E");
            String dateStr = sdf.format(date);

            return dateStr;
        }

        /**
         * 校验日期是否符合预期格式
         *
         * @return
         */
        public static boolean isValidDateTime(String dateStr) {
            boolean convertSuccess = true;
            try {
                Date date = (Date) sdfinalDate.parse(dateStr);
                String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                System.err.println(formatStr2);
            } catch (ParseException e) {
                convertSuccess = false;
            }
            return convertSuccess;
        }

        /**
         * 计算2个日期间隔时间
         *
         * @param date1
         * @param date2
         * @return
         * @throws ParseException
         */
        public static String getIntervalDate(String date1, String date2) throws ParseException {

            String value = "";
            boolean b1 = isValidDateTime(date1);
            boolean b2 = isValidDateTime(date2);
            if (b1 == true && b2 == true) {

                Date begin = (Date) sdfinalDate.parse(date1);
                Date end = (Date) sdfinalDate.parse(date2);
                /*
                 * String formatStr2 = new
                 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                 * System.err.println(formatStr2);
                 */
                long l = end.getTime() - begin.getTime();// 除以1000是为了转换成秒
                long day = l / (24 * 60 * 60 * 1000);
                long hour = (l / (60 * 60 * 1000) - day * 24);
                long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
                long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
                System.out.println("" + day + "天" + hour + "小时" + min + "分" + s + "秒");
                value = day + "天" + hour + "小时" + min + "分" + s + "秒";
            }
            return value;

        }

        /**
         * 比较2个时间先后
         *
         * @param dt1
         * @param dt2
         * @return
         */
        public static boolean compareDate(Date dt1, Date dt2) {
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return false;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return true;
            } else {// 相等
                return true;
            }
        }

        /**
         * 根据日期获得星期
         *
         * @return
         */
        /*
         * public static String getWeekOfDate(Date date) {
         *
         * String[] weekDaysName = { "SAT", "MON", "TUE", "WED", "THU", "FRI", "SUN"
         * }; String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };
         * Calendar calendar = Calendar.getInstance(); calendar.setTime(date); int
         * intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; return
         * weekDaysName[intWeek]; } /** 字符串转换成日期
         *
         * @param str
         *
         * @return date
         */
        public static Date ConverToDate(String str) {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = null;
            try {
                date = format.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }

        /**
         * 获取当前日期是星期几<br>
         *
         * @param dt
         * @return 当前日期是星期几
         */
        public static String getWeekOfDate(Date dt) {
            String[] weekDays = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            return weekDays[w];
        }

        /**
         * 通过周知道星期简称
         *
         * @param week
         * @return
         */
        public static String getweekShortName(String week) {
            // String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI",
            // "SAT"};
            String result = "";
            if("星期一".equals(week.trim())||"0".equals(week.trim()))
            {
                result = "MON";
            }
            else  if("星期二".equals(week.trim())||"1".equals(week.trim()))
            {
                result = "TUE";
            }
            else  if("星期三".equals(week.trim())||"2".equals(week.trim()))
            {
                result = "WED";
            }
            else  if("星期四".equals(week.trim())||"3".equals(week.trim()))
            {
                result = "THU";
            }
            else  if("星期五".equals(week.trim())||"4".equals(week.trim()))
            {
                result = "FRI";
            }
            else  if("星期六".equals(week.trim())||"5".equals(week.trim()))
            {
                result = "SAT";
            }
            else  if("星期日".equals(week.trim())||"6".equals(week.trim()))
            {
                result = "SUN";

            }else{
                result = "";
            }
            return result;
        }

        /**
         * 将时间转为秒
         *
         * @param time
         * @return
         */
        public static int getSeconds(String time) {

            String[] times = time.split(":");
            int seconds = 0;
            if (times.length == 3) {
                seconds += Long.valueOf(times[0]) * 60 * 60;
                seconds += Long.valueOf(times[1]) * 60;
                seconds += Long.valueOf(times[2]);
            }
            return seconds;

        }

        /**
         * 给指定日期添加时间
         *
         * @param date
         * @param time
         * @return
         * @throws ParseException
         */
        public static Date addTagrgetTime(String date, String time) throws ParseException {
            Date syncTime = null;
            try {
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date obj = sdf1.parse(date);
                String Time = obj.getHours() + ":" + obj.getMinutes() + ":" + obj.getSeconds();
                // 将时间转为秒添加
                int seconds = getSeconds(time);
                Calendar canlandar = Calendar.getInstance();
                canlandar.setTime(obj);
                // 添加时间
                canlandar.add(canlandar.SECOND, seconds);
                syncTime = canlandar.getTime();
                // 格式化成标准时间
                // syncTime = sdf1.format(canlandar.getTime()).toString();
            } catch (Exception e) {

            }
            return syncTime;
            // return syncTime;

        }

        /**
         * 解析流程定时表达式
         *
         * @param type
         *            方式类型
         * @param dateType
         *            每周每月每天
         * @param week
         *            周
         * @param dateTypeTime
         *            时间
         * @param day
         *            指定月份日期
         * @param flag
         *            标识是否是月末最后一天
         * @return
         * @throws ParseException
         */
        public static String CronExpressions(int type, Date date, String dateType, String week, String dateTypeTime, String day, int flag) throws ParseException {
            String Cron = "";

            // 方式一:本节点初次打开时间
            if (type == 1 || type == 2 || type == 3) {
                //Date time = sdfTime.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                Cron = calendar.get(calendar.SECOND) + " " +  calendar.get(calendar.MINUTE) + " " +  calendar.get(calendar.HOUR_OF_DAY) + " " +  calendar.get(calendar.DAY_OF_MONTH) + " " +  (calendar.get(calendar.MONTH )+ 1) + " ? " +  calendar.get(calendar.YEAR);
            }
            if (type == 4) {

                if (dateType.equals("每天"))// 按天重复,只需要设置对应的时间
                {
                    if (dateTypeTime != "" && dateTypeTime != null && dateTypeTime.contains(":")) {
                        Cron = "0 " + dateTypeTime.split(":")[1] + " " + dateTypeTime.split(":")[0] + " * * ?";
                    }
                }
                if (dateType.equals("每周"))// 按周重复必须设置时间
                {
                    /*
                     * if ((dateTypeTime != "" && dateTypeTime != null &&
                     * dateTypeTime.contains("-")) && (dateTypeTime == "" ||
                     * dateTypeTime == null))// 每周值设定只有日期 { String week =
                     * getWeekOfDate(new SimpleDateFormat(
                     * "yyyy-MM-dd").parse(date)); // "0 15 10 ? * MON" 周一上午10:15触发
                     * 。 Cron = "0 0 0 ? *" + week;// 每周什么时间执行 }
                     */
                    if ((dateTypeTime != "" && dateTypeTime != null && dateTypeTime.contains(":")) && (week != "" && week != null)) {
                        String shortWeek = getweekShortName(week);
                        Cron = "0 " + dateTypeTime.split(":")[1] + " " + dateTypeTime.split(":")[0] + " " + " ? * " + shortWeek;// 指定每周指定时间执行
                    }
                }
                if (dateType.equals("每月"))// 按月重复必须设置日期和时间
                {
                    if ((dateTypeTime != "" && dateTypeTime != null && dateTypeTime.contains(":")) && (day != null && day != "")) {
                        // 每月月末
                        if (flag == 1) {
                            Cron = "0 " + dateTypeTime.split(":")[1] + " " + dateTypeTime.split(":")[0] + " " + "L" + " * ? ";
                        }
                        // 指定日期执行
                        else {
                            Cron = "0 " + dateTypeTime.split(":")[1] + " " + dateTypeTime.split(":")[0] + " " + day + " * ? ";

                        }
                    }
                }

            }
            return Cron;
        }

        /**
         *
         * 定时表达式解析 格式: [秒] [分] [小时] [日] [月] [周] [年]
         *
         * @param type
         *            触发类型
         * @param date
         *            日期
         * @param time
         *            时间
         * @param Isrepeat
         *            是否重复(1-重复/0-不重复)
         * @param repeatType
         *            重复方式(taskDay-天/taskWeek-周/taskmonth-月)
         * @return
         * @throws ParseException
         */
        public static String CronExpressions(String type, String date, String time, String Isrepeat, String repeatType) throws ParseException {

            String Cron = "";
            if ("-1".equals(type)) {
                // 重复的时候
                if (Isrepeat.equals("1")) {
                    if (repeatType.equals("taskDay"))// 按天重复,只需要设置对应的时间
                    {
                        if (time != "" && time != null && time.contains(":")) {
                            Cron = "0 " + time.split(":")[1] + " " + time.split(":")[0] + " * * ?";
                        }
                    }
                    if (repeatType.equals("taskWeek"))// 按周重复必须设置时间
                    {
                        if ((date != "" && date != null && date.contains("-")) && (time == "" || time == null))// 每周值设定只有日期
                        {
                            String week = getWeekOfDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                            // "0 15 10 ? * MON" 周一上午10:15触发 。
                            Cron = "0 0 0 ? *" + week;// 每周什么时间执行
                        }
                        if ((time != "" && time != null && time.contains(":")) && (date != "" && date != null && date.contains("-"))) {
                            String week = getWeekOfDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                            Cron = "0 " + time.split(":")[1] + " " + time.split(":")[0] + " " + " ? * " + week;// 每周什么日期什么时间执行
                        }
                    }
                    if (repeatType.equals("taskmonth"))// 按月重复必须设置日期和时间
                    {
                        if ((time != "" && time != null && time.contains(":")) && (date != "" && date != null && date.contains("-"))) {

                            Cron = "0 " + time.split(":")[1] + " " + time.split(":")[0] + " " + date.split("-")[2] + " * ? ";
                        }
                    }

                }
                // 不重复
                if (Isrepeat.equals("0")) {
                    if ((date != "" && date != null && date.contains("-")))// 不重复指定日期时间
                    {
                        Cron = "0 0 0 " + date.split("-")[2] + " " + date.split("-")[1] + " ? ";

                    }
                    if ((time != "" && time != null && time.contains(":")) && (date != "" && date != null && date.contains("-")))// 不重复指定日期时间
                    {

                        Cron = "0 " + time.split(":")[1] + " " + time.split(":")[0] + " " + date.split("-")[2] + " " + date.split("-")[1] + " ? "
                                + date.split("-")[0];
                    }
                }

            } else if ("1".equals(type))// 条件表达式
            {

            } else if ("2".equals(type)) {
                // 重复的时候
                if (Isrepeat.equals("1")) {
                    if (repeatType.equals("taskDay"))// 按天重复,只需要设置对应的时间
                    {
                        if (time != "" && time != null && time.contains(":")) {
                            // 0 0 12 * * ?
                            Cron = "0 " + time.split(":")[1] + " " + time.split(":")[0] + " * * ?";
                        }
                    }
                    if (repeatType.equals("taskWeek"))// 按周重复必须设置时间
                    {
                        if ((date != "" && date != null && date.contains("-")) && (time == "" || time == null))// 每周值设定只有日期
                        {

                            String week = getWeekOfDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                            // "0 15 10 ? * MON" 周一上午10:15触发 。
                            Cron = "0 0 0 ? * " + week;// 每周什么时间执行
                        }
                        if ((time != "" && time != null && time.contains(":")) && (date != "" && date != null && date.contains("-"))) {
                            String week = getWeekOfDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                            Cron = "0 " + time.split(":")[1] + " " + time.split(":")[0] + " " + " ? * " + week;// 每周什么日期什么时间执行
                        }
                    }
                    if (repeatType.equals("taskmonth"))// 按月重复必须设置日期和时间
                    {
                        if ((time != "" && time != null && time.contains(":")) && (date != "" && date != null && date.contains("-"))) {

                            Cron = "0 " + time.split(":")[1] + " " + time.split(":")[0] + " " + date.split("-")[2] + " * ?";
                        }

                    }

                }
                // 不重复
                if (Isrepeat.equals("0")) {
                    if ((date != "" && date != null && date.contains("-")))// 不重复指定日期时间
                    {
                        Cron = "0 0 0 " + date.split("-")[2] + " " + date.split("-")[1] + " ? ";

                    }
                    if ((time != "" && time != null && time.contains(":")) && (date != "" && date != null && date.contains("-")))// 不重复指定日期时间
                    {

                        Cron = "0 " + time.split(":")[1] + " " + time.split(":")[0] + " " + date.split("-")[2] + " " + date.split("-")[1] + " ? "
                                + date.split("-")[0];
                    }
                }

            } else {

            }

            return Cron;
        }

        /**
         * 计算是否在区间内
         * @author xinghy 2017年8月9日
         * @param mathTime 需计算时间（Date）
         * @param smallTime 时间区间-小 HH:mm:ss
         * @param bigTime 时间区间-大 HH:mm:ss
         * @return
         */
        public static boolean betweenTime(Date mathTime,String smallTime,String bigTime) {
            try {
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                Date mathDate =df.parse(df.format(mathTime));
                Date smallDate = df.parse(smallTime);
                Date bigDate = df.parse(bigTime);
                if(mathDate.getTime()>smallDate.getTime()&&mathDate.getTime()<bigDate.getTime()){
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        /**
         * 得到上周周五日期，并拼接时间
         * @author xinghy 2017年8月9日
         * @param time 要拼接的时间
         * @return
         */
        public static Date getLastFriday(Date date,String time) throws ParseException{
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            calendar.setTime(date);
            Integer week = calendar.get(Calendar.DAY_OF_WEEK);
            if(week==1||week==2){
                calendar.add(Calendar.WEDNESDAY, -1);
            }
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            return sdf1.parse(sdf.format(calendar.getTime())+" "+time) ;
        }




//	/**
//	 * 计算从1900-01-01至当前时间相差的分钟数
//	 * @author xinghy 2017年8月9日
//	 * @param date 当前时间
//	 * @return
//	 */
//	public static int getMmss(Date date) {
//		Calendar calendar=Calendar.getInstance();
//	    calendar.set(1900,1,1);
//	    Long old=calendar.getTime().getTime();//1900年的时间戳
//	    Long now=date.getTime();//当前时间的时间戳
//		int a =(int) (now - old);
//		return  Math.abs(a)/1000/60;
//	}
        /**
         *
         * @author xinghy 2017年8月11日
         * @return
         */
        public static int betMin(Date startDate,Date endDate) {
            return (int) ((startDate.getTime() - endDate.getTime())/1000/60);
        }
        /**
         * 得到当前时间前几天的日期，并拼接时间
         * @author xinghy 2017年8月9日
         * @param date 时间
         * @param time 要拼接的时间（HH:mm:ss）
         * @param day 天数
         * @return
         * @throws ParseException
         */
        public static Date getDateBefore(Date date, String time, int day) throws ParseException {
            Calendar now = Calendar.getInstance();
            now.setTime(date);
            now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
            date = now.getTime();
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter1.format(date);
            return formatter.parse(dateString + " " + time);
        }

        /**
         * 获取每天的7点
         * @return
         */
        public static Date getSevenDate(){
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            if(!betweenTime(new Date(),"22:59:59","23:59:59")){
                cal.add(Calendar.DAY_OF_YEAR, 1);
            }
            cal.set(Calendar.HOUR_OF_DAY, 7);
            cal.set(Calendar.MINUTE, 1);
            cal.set(Calendar.SECOND, 0);
            return cal.getTime();
        }

        /**
         * 返回指定时间当天零点的Date
         *
         * @param date
         * @return
         */
        public static Date toZeroTime(Date date) throws Exception{
            return sdfDay.parse(sdfDay.format(date));
        }

        /**
         * date转string yyyyMMdd
         *
         * @param date
         * @return
         */
        public static String dateToShortStringNull(Date date) {
            String result = null;
            result = sdfDays.format(date);
            return result;
        }


        public static void main(String[] args) {
            System.out.println(getSevenDate());
            String string = "2019-04-26 23:10:01";
            try {
                System.out.println(getConventTime(string));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
}

