package _lcoal_date_;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/7  12:09
 * @description :
 */
public class TestDate {

    @Test
    public void m1(){

        LocalDate now = LocalDate.now();
        // 2020-10-07
        System.out.println(now);

        LocalDate parse = LocalDate.parse("2019-09-09");
        // 2019-09-09
        System.out.println(parse);

        LocalDate with = now.with(TemporalAdjusters.firstDayOfMonth());
        // 2020-10-01
        System.out.println(with);

        // 2020-10-02
        System.out.println(now.withDayOfMonth(2));

        LocalDate with1 = now.with(TemporalAdjusters.lastDayOfMonth());
        //2020-10-31
        System.out.println(with1);

        System.out.println(now.plusDays(1L));
    }


    @Test
    public void m2(){
        /**
         *
         *
         *
         * local time
         *
         *
         */


        LocalTime time = LocalTime.now();

        // 12:15:50.565
        System.out.println(time);
        // 12:16:19
        System.out.println(time.withNano(0));

        LocalTime of = LocalTime.of(8, 43);
        /// 08:43
        System.out.println(of);

        LocalTime parse = LocalTime.parse("12:00:00");
        // 12:00
        System.out.println(parse);

    }

    @Test
    public void m3(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalTime localTime = now.toLocalTime();
        LocalDate localDate = now.toLocalDate();

        /*
        2020-10-07
        12:19:32.199
         */
        System.out.println(localDate);
        System.out.println(localTime);

        String format = now.toString();
        System.out.println(format);
    }

    @Test
    public void m4(){
        TestPo testPo = new TestPo();
        testPo.setName("A");
        testPo.setBir(LocalDateTime.now());
        System.out.println(testPo);
    }
}
