package _a___________rubbish;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/8/25  14:47
 * @description :
 */
public class TimeU1 {

    public static void main(String[] args) {
        System.err.println("两小时后 : " + getLocalAfterTime(2 , 0));
        System.err.println("两小时后 : " + getLocalAfterTime( 120));
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
}
