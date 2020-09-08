package _a___________rubbish;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/8/25  14:47
 * @description :
 */
public class TimeU1 {

    public static void main(String[] args) {
        getLocalAfterTimeCalendar();
    }


    public static String getLocalAfterTime(int lastHour , int lastMinute ){

        assert lastHour < 0 || lastMinute < 0;

        LocalTime now = LocalTime.now()
                .plusHours(lastHour)
                .plusMinutes(lastMinute);

        return now.getHour() + ":" + now.getMinute();
    }

    public static String getLocalAfterTime(int lastMinute ){
        return getLocalAfterTime(0 , lastMinute);
    }

    public static String getLocalAfterTime(int lastTime , TimeUnit type){
        LocalTime now = LocalTime.now();
        assert type != null;
        assert lastTime > 0;

        switch (type){
            case SECONDS:
                now = now.plusSeconds(lastTime);
                break;
            case HOURS:
                now = now.plusHours(lastTime);
                break;
            case MINUTES:
                now = now.plusMinutes(lastTime);
                break;
            default:
                now = now.plusSeconds(0);
                break;
        }
        return now.getHour() + ":" + now.getMinute();
    }

    public static List<String> getLocalAfterTime(){
        int baseNum = 1;
        ArrayList<String> hour = new ArrayList<>(24);
        LocalTime now = LocalTime.now();
        for (int i = baseNum; i < 24; i++) {
            if (now.getHour() >= 23)
                break;
            now = now.plusHours(baseNum);
            hour.add(now.getHour()+"");
        }
        return hour;
    }

    public static String getLocalAfterTimeCalendar(){

        // Creating the Calendar
        Calendar cal = Calendar.getInstance();

        // Creating the Locale
        Locale local = Locale.getDefault();

        // Calling the getdisplaynames method
        Map<String, Integer> cal_repres = cal.getDisplayNames(Calendar.HOUR,
                Calendar.LONG, local);

        System.out.println(cal_repres);

//        NavigableMap<String, Integer> Nav_Map = new TreeMap<>(cal_repres);

        // Displaying the results
//        System.out.printf("The complete list is: %n%s%n", Nav_Map);

        return "";
    }

    private static void m1(){
        final List<Integer> list = new ArrayList<>();
        list.add(11);
        final Integer number = 11;

    }
}
