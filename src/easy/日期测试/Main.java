package easy.日期测试;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(getDayRemainingTime(new Date(),1));
//        LocalDateTime of = LocalDateTime.of(2020, 2, 25, 24, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-Mm-dd HH:mm:ss");
        Date tom = null;
        try {
            tom = sdf.parse("2020-02-25 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(Long.MAX_VALUE / (24*60*60*365));
//        System.out.println(getDayRemainingTime(tom));

    }

    public static Integer getDayRemainingTime(Date currentDate,int days) {
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        seconds += days*24*60*60;
        return (int) seconds;
    }
}
