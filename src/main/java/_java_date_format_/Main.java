package _java_date_format_;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/10
 * @time 19:59
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(smt.format(new Date()));
        long l = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(smt.format(l));
    }
}
