package _2_demo_;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/4/30  13:38
 */
public class Demo11 {


    public static void main(String[] args) {
        Demo11 demo11 = new Demo11();
        demo11.m1();
        demo11.m2();
    }


    public void m1(){
        List<Object> l1 = new ArrayList<>(101);
        Object o;
        for (int i = 0; i < 100; i++) {
            o = new Object();
            l1.add(o);
        }
        l1.forEach(oVal -> System.out.println(oVal.hashCode()));
    }

    public void m2(){
        List<Object> l2 = new ArrayList<>(101);
        for (int i = 0; i < 100; i++) {
            Object o1 = new Object();
            l2.add(o1);
        }
        l2.forEach(oVal -> System.out.println(oVal.hashCode()));
    }

    @Test
    public void m3(){
        int a = 7;
        scan: {
            for (int i = 0; i < 20; i++) {
                if( i == a){
                    break scan;
                }
                System.out.println(i);
            }
        }
    }

    @Test
    public void m4(){
        String ta = "你好"; // 2 byte
        String tb = "hello"; // 5 byte
        char[] tc = "你好".toCharArray(); // 2 char
        byte[] td = ta.getBytes();

        System.out.println(ta.length());
        System.out.println(tb.length());
        System.out.println(tc.length);
        System.out.println(td.length); // 6  110 >> 1 -> 11 -> 3

        // --
        System.out.println(((int) tc[0])); // 20320
        System.out.println(Arrays.toString(td)); // 0.0
    }
    
    @Test
    public void m5(){
        Double d1 = null;
        Double d2 = 12.0;

        Integer i1 = null;
        Integer i2 = 1;

        Long l1 = null;
        Long l2 = 2L;

        System.out.println(Demo11.checkNumber(d1 ));
        System.out.println(Demo11.checkNumber(d2 ));
        System.out.println(Demo11.checkNumber(i1 ));
        System.out.println(Demo11.checkNumber(i2 ));
        System.out.println(Demo11.checkNumber(l1 ));
        System.out.println(Demo11.checkNumber(l2 ));
    }

    /**
     * 检查 Long , Integer , Double
     * @param chekVal
     * @return
     */
    public static boolean checkNumber(Object... chekVal) {
        if (chekVal == null || chekVal.length == 0) {
            return false;
        }
        for (Object o : chekVal) {
            if (Objects.isNull(o)){
                return false;
            }
            if ((o instanceof Double) && (Double) o < 0) {
                return false;
            }
            if ( (o instanceof Integer) && (Integer) o < 0 ){
                return false;
            }
            if ( (o instanceof Long) && (Long) o < 0 ){
                return false;
            }

        }
        return true;
    }

    @Test
    public void m6(){
        Double d1 = 0.0;
        Double d2 = 0.0;

        System.out.println(d1.equals((double) 0));

    }

    @Test
    public void m7(){
        LocalDateTime now = LocalDateTime.now();
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(dayOfMonth);

        int dayOfYear = now.getDayOfYear();
        System.out.println(dayOfYear);

        int year = now.getYear();
        Month month = now.getMonth();

        System.out.println(year);
        System.out.println(month);

        int monthValue = now.getMonthValue();
        System.out.println(monthValue);

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek);

        Month quarter = now.getMonth().firstMonthOfQuarter();
        System.out.println(quarter);

    }

    @Test
    public void m8(){
        ArrayList<LocalDateTime> dateTimes = new ArrayList<>();
        extracted(dateTimes);


        Map<String, List<LocalDateTime>> stringListMap = dateTimes.stream().collect(
                Collectors.groupingBy(y -> y.getYear() + "-" + y.getDayOfMonth()));


        Map<String, List<LocalDateTime>> listMap = dateTimes.stream().collect(Collectors.groupingBy(x -> x.getMonth() + "-" + x.getDayOfWeek()));
        System.out.println(stringListMap);

        System.out.println(listMap);

        /*Map<Integer, Integer> collect = dateTimes.stream()
                .collect(Collectors.toMap(k -> k.getYear(), v -> v.getMonthValue()));*/

        Map<String, Integer> map = dateTimes.stream().collect(Collectors.groupingBy(
                y -> y.getYear() + "-" + y.getMonthValue() + "-" + y.getDayOfMonth(),
                Collectors.summingInt(d -> 1)));

        System.out.println(map);

    }

    private void extracted(ArrayList<LocalDateTime> dateTimes) {
        dateTimes.add(LocalDateTime.now().plusDays(1));
        dateTimes.add(LocalDateTime.now().plusDays(1));
        dateTimes.add(LocalDateTime.now().plusDays(1));
        dateTimes.add(LocalDateTime.now().plusDays(2));
        dateTimes.add(LocalDateTime.now().plusDays(2));
        dateTimes.add(LocalDateTime.now().plusDays(2));
        dateTimes.add(LocalDateTime.now().plusDays(2));
        dateTimes.add(LocalDateTime.now().plusDays(2));
        dateTimes.add(LocalDateTime.now().plusDays(2));
        dateTimes.add(LocalDateTime.now().plusDays(2));
        dateTimes.add(LocalDateTime.now().plusDays(2));
        dateTimes.add(LocalDateTime.now().plusDays(3));
        dateTimes.add(LocalDateTime.now().plusDays(3));
        dateTimes.add(LocalDateTime.now().plusDays(3));
        dateTimes.add(LocalDateTime.now().plusDays(3));
        dateTimes.add(LocalDateTime.now().plusDays(4));
        dateTimes.add(LocalDateTime.now().plusDays(4));
        dateTimes.add(LocalDateTime.now().plusDays(4));
        dateTimes.add(LocalDateTime.now().plusDays(4));
        dateTimes.add(LocalDateTime.now().plusDays(4));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
        dateTimes.add(LocalDateTime.now().plusDays(5));
    }

    @Test
    public void m9(){
        String s = new StringJoiner("-").add("hello").add("world").add("!").toString();

        System.out.println(s);

        LocalDate now = LocalDate.now().plusDays(2);
        System.out.println();
    }
}

