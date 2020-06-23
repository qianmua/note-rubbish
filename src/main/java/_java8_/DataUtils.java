package _java8_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/23  10:21
 * @description :
 */
public class DataUtils {

    private static List<Emp> emps = new ArrayList<>();

    static {
        emps.add(new Emp(1L, "Morton", 22, 8000.0));
        emps.add(new Emp(2L, "Dahlia", 20, 13000.0));
        emps.add(new Emp(3L, "Babb", 23, 7000.0));
        emps.add(new Emp(4L, "Rice", 21, 15000.0));
        emps.add(new Emp(5L, "Handy", 26, 13000.0));
        emps.add(new Emp(6L, "Rudy", 30, 14000.0));
        emps.add(new Emp(7L, "Grady", 27, 12000.0));
        emps.add(new Emp(8L, "Brenton", 32, 6000.0));
        emps.add(new Emp(9L, "Vinson", 33, 7000.0));
        emps.add(new Emp(10L, "Kemp", 23, 14000.0));
        emps.add(new Emp(11L, "Sebastian", 22, 12000.0));
        emps.add(new Emp(12L, "Evangeline", 24, 18000.0));
        emps.add(new Emp(13L, "Lisette", 29, 8000.0));
        emps.add(new Emp(14L, "Wilkes", 25, 7000.0));
        emps.add(new Emp(15L, "Leach", 33, 6000.0));
        emps.add(new Emp(16L, "Geiger", 32, 12000.0));
        emps.add(new Emp(17L, "Holden", 34, 13000.0));
        emps.add(new Emp(18L, "Thorpe", 26, 15000.0));
        emps.add(new Emp(19L, "Adrienne", 23, 16000.0));
        emps.add(new Emp(20L, "Calderon", 21, 14000.0));
    }
    public static List<Emp> getEmployees() {
        return emps;
    }
}
