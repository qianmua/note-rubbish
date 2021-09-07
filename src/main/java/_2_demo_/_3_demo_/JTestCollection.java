package _2_demo_._3_demo_;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/5/24  16:46
 */
@Slf4j
public class JTestCollection {

    @Test
    public void m1() {
        int[] arr = {1, 2, 3};
        int f = 1;
        int[] arr2 = new int[arr.length + 1];
        arr2[0] = 1;
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1] ^ arr[i - 1];
        }

        System.out.println(Arrays.toString(arr2));
    }


    @Test
    public void m2() {
        double d1 = 123.123;
        double d2 = 123.123;

        var a = Integer.valueOf(11);
        var a2 = 12L;

        System.out.println(a);
        System.out.println(a2);
        System.out.println(a instanceof Integer);

        int compare = BigDecimal.valueOf(d1).compareTo(BigDecimal.valueOf(d2));

        System.out.println(compare);
    }

    @Test
    public void m3() {
        String sourceStr = "|1|2|3|4|5|6|7|8|"; //28 + 8
        int currentIndex = sourceStr.charAt(0) == '|' ? 1 : 0; // 判断第一位是否数字 确定起始下标
        int sum = 0; // result
        // 循环
        while (currentIndex < sourceStr.length()) {
            // 下标每次自增2, 取当前下标对应的数字 直接求和.
            sum += NumberUtils.toInt(sourceStr.charAt(currentIndex) + "");
            currentIndex += 2;
        }
        System.err.println(sum);
    }

    @Test
    public void m4() {
        String sourceStr = "|1|2|3|4|5|6|7|8|"; //28 + 8
        int currentIndex = sourceStr.charAt(0) == '|' ? 1 : 0; // 判断第一位是否数字 确定起始下标
        int result = 0;
        for (int i = currentIndex; i < sourceStr.length(); i += 2) {
            result += NumberUtils.toInt(sourceStr.charAt(i) + "");
        }
        System.err.println(result);
    }

    @Test
    public void m5() {
        String dirs = System.getProperty("user.dir");
        System.out.println(dirs);

        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + "\t\t\t" + value));

        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(securityManager);
    }

    /**
     * 导入可允许的特殊字符
     * 正则表达
     */
    public static final String ALLOW_SPECIAL_CHARSET = "^[\\da-zA-Z$._@*-]*$";
    /**
     * 过滤 中文字符集
     * 不允许有中文ID 输入
     */
    public static final String FILTER_CHARACTER = "[\\u4E00-\\u9FA5]*";

    /**
     * 校验规则
     * 检查 id规则
     *
     * @param matchValue
     * @return {true } | {false }
     */
    public static boolean checkDataFormat(CharSequence matchValue) {
        return !Pattern.matches(FILTER_CHARACTER, matchValue) &&
                Pattern.matches(ALLOW_SPECIAL_CHARSET, matchValue);
    }

    @Test
    public void m6() {
        String str1 = "KDS111111-11222";

        System.out.println(JTestCollection.checkDataFormat(str1)); // true
        String s2 = "hello";
        String s3 = "he" + new String("llo");
        System.out.println(s2 == s3);
        String ss1 = "^[a-zA-Z]*\\G";
        System.out.println(Pattern.matches(ss1, "abdjskadiNADSKNDASUJNdJksandij"));
    }


    String mail_format = "^\\s*\\w+(?:\\.?[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
    String mail_format2 = "^\\w+([-+.]\\w+){0,20}@\\w+([-.]\\w+){0,20}\\.\\w+([-.]\\w+){0,20}$";
    //                     ^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$
    String mail_format3 = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    @Test
    public void m7() {
        String mail1 = "267452111@qq.com";
        System.out.println(Pattern.matches(mail_format2, mail1));
        String mail2 = "www.267452111@qq.com";
        System.out.println(Pattern.matches(mail_format2, mail2));
        String mail3 = "jin-c-h.ao.hu@fa-software.com";
        System.out.println(Pattern.matches(mail_format2, mail3));
        String mail4 = "2342$%^&*hu@fa-software.com";
        System.out.println(Pattern.matches(mail_format2, mail4));
        String mail5 = "jinchao.hu@fa-software.com";
        System.out.println(Pattern.matches(mail_format2, mail5));
//        String mail6 = "dnjnfslkffkjkjkslioeo9edkdjfks";
//        System.out.println(Pattern.matches(mail_format2 , mail6));

        System.err.println("/////////////////////////////////////////////");

        Pattern compile = Pattern.compile("^\\w+([-+.]\\w+){0,10000}");
//        Pattern compile = Pattern.compile("(a|b)*");
        StringBuilder bu = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            bu.append("&^");
        }
        String s = bu.toString();
        Matcher matcher = compile.matcher(s);
//        System.out.println(matcher.find());

        System.err.println("/////////////////////////////////////////////");

        Pattern compile2 = Pattern.compile("[^']@[cC]\\{[[ \t]*a-zA-Z_\u4e00-\u9fa5]+[ \t]*\\}");
        StringBuilder builder = new StringBuilder();
        String s2 = "pattern@C{ thisValue   ";
        builder.append(s2);
        builder.append("a".repeat(100000));
        builder.append("}");
        s2 = builder.toString();
//        System.out.println(compile2.matcher(s2).find());

        System.err.println("/////////////////////////////////////////////");
    }

    @Test
    public void m8() {
        int[] arr = {2, 3, 4, 6, 8, 9, 11, 14, 18};
        bst2(arr, 0, 20);
    }

    public void bst(int[] arr, int start, int end) {
        int mid;
        mid = (end + 1) >> 1;
        if (end - start == 1 && (arr[end] - 1 ^ arr[start]) == 0) {
            return;
        }
        if (end - start == 1 && (arr[end] - 1 ^ arr[start]) != 0) {
            System.out.println(arr[start] + "\t\t" + arr[end]);
            return;
        }
        bst(arr, start, mid);
        bst(arr, mid + 1, end);
    }

    public void bst2(int[] arr, int start, int end) {
        if (end - start == 1) {
            if (arr[end] - arr[start] != 1) {
                System.out.println(arr[start] + "\t\t" + arr[end]);
                return;
            } else {
                return;
            }
        } else {
            int mid = (end + 1) >> 1;
            bst2(arr, start, mid);
            bst2(arr, mid + 1, end);
        }
    }


    int a;
    Integer a_1; //default null;
    double d; // 0.0
    Double d_1;  // null
    String s; // null

    @Test
    public void m9() {
        JTestCollection JTestCollection = new JTestCollection();
        System.out.println(JTestCollection.a); // 0
        System.out.println(JTestCollection.a_1); // null
        System.out.println(JTestCollection.d);
        System.out.println(JTestCollection.d_1);
        System.out.println(JTestCollection.s);
    }

    @Test
    public void m10() {
        List<String> list = emptyList();
        System.out.println(list.size());
        System.out.println(CollectionUtils.isEmpty(list));
    }

    private List<String> emptyList() {
        return new ArrayList<>(0);
    }

    @Test
    public void m11() {

        System.out.println("start");
        startTest:
        {
            for (int i = 0; i < 10; i++) {
                if (i == 2) {
                    break startTest;
                }
                System.out.println(i);
            }
            System.out.println("hu");
        }
        System.out.println("jinchao");
    }

    @Test
    public void m12() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> JTestCollection.testConcurrent(new TestConcurrentClass(1))).start();
        }
    }

    private static void testConcurrent(TestConcurrentClass testConcurrentClass) {
        System.out.println(testConcurrentClass.v);
    }

    private class TestConcurrentClass {
        Integer v;

        public TestConcurrentClass(Integer v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return "TestConcurrentClass{" +
                    "v=" + v +
                    '}';
        }
    }

    @Test
    public void m13() {
        List<TestConcurrentClass> v1 = new ArrayList<>();
        v1.add(new TestConcurrentClass(2));
        v1.add(new TestConcurrentClass(2));
        v1.add(new TestConcurrentClass(2));
        v1.add(new TestConcurrentClass(2));
        setV(v1);
        System.out.println(v1);
    }

    public void setV(List<TestConcurrentClass> v) {
        for (TestConcurrentClass testConcurrentClass : v) {
            testConcurrentClass.v = new Integer(500);
        }
    }

    @Test
    public void m14() {
        Pages pages = new Pages();
        ArrayList<Values> values = Lists.newArrayList(
                new Values(1), new Values(2),
                new Values(3), new Values(4));
        pages.setValues(values);
        pages.getValues().forEach(this::setParams);
        System.err.println(pages);
    }

    void setParams(Values values){
        values.setValue2(values.value << 1);
    }

    class Pages {
        private List<Values> values;

        public void setValues(List<Values> values) {
            this.values = values;
        }

        public List<Values> getValues() {
            return values;
        }
    }

    class Values {
        Integer value;
        Integer value2;

        Values(Integer v) {
            this.value = v;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public void setValue2(Integer value2) {
            this.value2 = value2;
        }

        @Override
        public String toString() {
            return "Values{" +
                    "value=" + value +
                    ", value2=" + value2 +
                    '}';
        }
    }

    @Test
    public void m16(){
        String s3 = "+86 18290098330";
        // 区号匹配规则
        System.out.println(Pattern.compile("(\\+?\\d{0,7}[ \\-])\\d{1,15}$").matcher(s3).find());
    }


    @Test
    public void m17(){
        F1 f = F1.F;
        F1 e = F1.H;
        System.out.println(f.v1(e));
    }

    public enum F1 {
        F("1"){
            @Override
            boolean v1(F1 f) {
                return f == E;
            }
        },
        E("2"){
            @Override
            boolean v1(F1 f) {
                return f == H;
            }
        },
        H("3"){
            @Override
            boolean v1(F1 f) {
                return false;
            }
        },
        ;
        private final String s1;
        abstract boolean v1(F1 f);

        F1(String s1){
            this.s1 = s1;
        }

        public String getS1() {
            return s1;
        }
    }

    @Test
    public void m18() {
        String ss = "\\x8f6f\\x4ef6\\x5bf9";
        System.out.println(new String(ss.getBytes() , StandardCharsets.UTF_8));
    }
    
    @Test
    public void m19() {
        FiledDemos filedDemos = new FiledDemos();
        filedDemos.setV1("A");
        filedDemos.setV2(2);
        filedDemos.setV3(3.0);
//        filedDemos.setThis$0(4);
        Map<String, Object> objectMap = checkFiled(filedDemos);
        System.out.println(objectMap);
    }

    @Data
    class FiledDemos {
        private String v1;
        @TableField(exist = false)
        private Integer v2;
        private Double v3;
        private boolean v5; // default false.

        private int this$0;

    }

    public <T> Map<String, Object> checkFiled(T t) {
        Map<String , Object> bilibili = new HashMap<>(8);

        // 内部类,如果是内部类需要去除掉外部类的字段引用
        boolean isMemberClass = t.getClass().isMemberClass();
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                // 基本类型,基本类型默认值问题.
                //  这里 判断对基本类型无效
                if (field.get(t) != null && StringUtils.isNotBlank(field.get(t).toString())) {
                    if (field.getType() == int.class) {

                    }
                    if (field.getType() == long.class){

                    }
                    // 拿到mybatis plus 注解
                    // 数据库不需要的直接去掉
                    TableField annotation = field.getAnnotation(TableField.class);
                    if (Objects.nonNull(annotation)){
                        if (!annotation.exist()) {
                            continue;
                        }
                    }
                    if (isMemberClass){
                        // 过滤掉 final 修饰字段(内部内引用是final的,这里不好做判断)
                        if (Modifier.isFinal(field.getModifiers())) {
                            continue;
                        }
                    }
                    bilibili.put(field.getName() , field.get(t));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bilibili;
    }
    
    @Test
    public void m20(){

    }

    class X {
        public X a() {return new X();}
    }

    @Test
    public void m21(){
        Map<String , Object> map = new HashMap<>(8);
        map.put("A" , "SADNIU");
        map.put("B" , 21312);
        map.put("C" , "21312");
        System.out.println(JSON.toJSONString(map));

    }

    @Test
    public void m22(){
        String ss = "$P{asdfghjkl}";
        if (StringUtils.startsWith(ss , "$P{") && StringUtils.endsWith(ss , "}")){
            System.out.println(StringUtils.substring(ss , 3 , ss.length() - 1));
        }
    }

    @Test
    public void m23(){
        long n = System.nanoTime();
        arrayListAdd();       // 126202100 nano // 683552699 // 122971599 // 116413400
//        linkedListAdd();      // 288750100 nano // 2756008000
//        linkedListAddLast();  // 291301200 nano // 2759652700
        System.out.println(System.nanoTime() - n);
    }

    private void arrayListAdd(){
        ArrayList<String> strings = new ArrayList<>(10000001);
        for (int i = 0; i < 10000000; i++) {
            strings.add(new String("A") + i);
        }
    }

    private void linkedListAdd(){
        LinkedList<String> strings = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            strings.add(new String("A") + i);
        }
    }

    private void linkedListAddLast(){
        LinkedList<String> strings = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            strings.addLast("A" + i);
        }
    }

    @Test
    public void m24(){
        String ss = "Hello world";
        System.out.println(firstLowercase(ss));
    }

    public static String firstLowercase(String sources) {
        if (StringUtils.isEmpty(sources)){
            return StringUtils.EMPTY;
        }
        String current = sources.trim();
        char ct = current.charAt(0);
        if (ct >= 'A' && ct <= 'Z'){
            ct = (char) (ct + (1 << 5 ));
            current = ct + current.substring(1);
        }
        return current;
    }


    @Test
    public void m25(){
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0){
                System.out.println("=");
            }
            System.out.println(i);

            if ( (i + 1) % 3 == 0){
                System.out.println("/=");
            }
        }
    }

    @Test
    public void m26() {
        int a = (Integer.MIN_VALUE+1) ^ Integer.MIN_VALUE;

        System.out.println( -1 ^ 1); // -2
        System.out.println( -1 ^ -2); // 1

        System.out.println( -1 ^ 0); // -1

        System.out.println( 1 ^ 0); // 1
        System.out.println( 1 ^ 2); // 3

        System.out.println(0 ^ -0); // 0
    }


    @Test
    public void m27() {
        FiledDemos fd = new FiledDemos();
        fd.setV1("hello");
        String v1 = Optional.ofNullable(fd).orElseGet(FiledDemos::new).getV1();
        System.out.println(v1);
    }

    enum MEx{
        ME1("1") {
            boolean ex(MEx pre, MEx next) {
                return !ME2.ex(pre, next);
            }
        },
        ME2("2") {
            boolean ex(MEx pre, MEx next) {
                return !ME3.ex(pre, next);
            }
        },
        ME3("3") {
            boolean ex(MEx pre, MEx next) {
                return !ME4.ex(pre, next);
            }
        },
        ME4("4") {
            boolean ex(MEx pre, MEx next) {
                return !ME5.ex(pre, next);
            }
        },
        ME5("5") {
            boolean ex(MEx pre, MEx next) {
                return next.equals(ME6) || next.equals(ME7);
            }
        },
        ME6("6") {
            boolean ex(MEx pre, MEx next) {
                return false;
            }
        },
        ME7("7") {
            boolean ex(MEx pre, MEx next) {
                return false;
            }
        },

        ;
        private final String symbol;
        abstract boolean ex(MEx pre, MEx next);

        MEx(String symbol){
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }


    @Test
    public void m28(){
        MEx me1 = MEx.ME1;
        System.out.println(me1.ex(null, MEx.ME2));
    }

    class V{
        String v;

        public V(String v) {
            this.v = v;
        }

        public void setV(String v) {
            this.v = v;
        }

        public String getV() {
            return v;
        }

        @Override
        public String toString() {
            return "V{" +
                    "v='" + v + '\'' +
                    '}';
        }
    }

    @Test
    public void m29(){
        List<V> strings = Arrays.asList(new V("A"), new V("B"), new V("C"), new V("D"), new V("E") , null , null);
        strings.stream().filter(Objects::nonNull).forEach(v -> v.setV(v.getV() + "1"));
        strings.forEach(System.out::println);
    }

    @Test
    public void m30(){
        System.out.println(abs(-20));
        System.out.println(abs(-1));
        System.out.println(abs(1));
        System.out.println(abs(20));

        System.out.println(abs(0));
        System.out.println(abs(-0));
    }

    // 取反
    // 反码 + 1 补码
    int ne(int num){
        return ~num + 1;
    }

    int abs(int num){
        return (num ^ (num >> 31)) - (num >> 31);
    }

    @Test
    public void m31(){
        Map<Character , String> typeMapper = new HashMap<>();
        typeMapper.put('一', "01");
        typeMapper.put('二', "02");
        typeMapper.put('三', "03");
        typeMapper.put('四', "04");
        String source = "一二三四";
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            if (typeMapper.containsKey(currentChar)){
                target.append(typeMapper.get(currentChar));
            }else {
                target.append(currentChar);
            }
        }
        System.out.println(target.toString());
    }

    @Test
    public void m32(){
        Map<String , Object> map = new HashMap<>();
        map.put("A" , "B");
        String str = (String) map.get("C");
        if (StringUtils.isEmpty(str)){
            System.out.println(str);
        }
    }

    class PK {
        private String k;

        private LocalDateTime joinTime;

        PK(String k , LocalDateTime joinTime){
            this.k = k;
            this.joinTime = joinTime;
        }
    }

    ConcurrentHashMap<String , Object> map = new ConcurrentHashMap<>(32);

    PriorityBlockingQueue<PK> queue = new PriorityBlockingQueue<>(32,
            (o, n) -> o.joinTime.equals(n.joinTime) ? 0 : o.joinTime.isAfter(n.joinTime) ? -1 : 1);

    ScheduledExecutorService schedule = new ScheduledThreadPoolExecutor(8);

    private Object o = new Object();

    void initSchedule(){
        // init map
        schedule.scheduleWithFixedDelay(() -> {
            for (int i = 0; i < 100; i++) {
                map.put(UUID.randomUUID().toString().replace("-" , "") , new Object());
            }
        }, 1L, 20L , TimeUnit.SECONDS);
        // swap
        schedule.scheduleWithFixedDelay(() -> {
            String s = map.keySet().stream().findFirst().get();
            log.info("swap join queue : {} , result : {}" , s , queue.offer(new PK(s, LocalDateTime.now())));
        } ,2L ,1L , TimeUnit.SECONDS);
        // init queue
        schedule.scheduleWithFixedDelay(() -> {
            for (;;){
                PK poll = queue.poll();
                if (poll == null){
                    return;
                }
                map.remove(poll.k);
                log.info("Remove k : {}" , poll.k);
            }
        } , 40L , 40L , TimeUnit.SECONDS);

        // monitor
        schedule.scheduleWithFixedDelay(() -> {
            log.info("Map capacity : {}" , map.size());
            log.info("Queue capacity : {}" , queue.size());
        } , 1L , 1L , TimeUnit.SECONDS);
    }

    void init2(){

    }

    @Test
    public void m33() throws IOException {
        initSchedule();

        System.in.read();
    }

    static ConcurrentHashMap<String , Object> c = new ConcurrentHashMap<>(128);

    @Test
    public void m34() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            c.put(i + "" , i + "");
        }
        c.entrySet().stream().map( se -> {
            String key = se.getKey();
            c.remove(key);
            System.err.println(key);
            return se.getValue();
        }).forEach(System.out::println);
        TimeUnit.SECONDS.sleep(2L);
        System.err.println("========");
        System.out.println(c);
    }


    @Test
    public void m35() {
        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>(60);
        for (int i = 0; i < 100; i++) {
            System.out.println(queue.offer(UUID.randomUUID().toString()));
        }
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Rela{
        private Long to;
        private Long from;
        private String lx;
        private String ly;

        private List<Long> toList;
    }

    @Test
    public void m36(){
        Rela r1_1 = new Rela(11L, 1L, "1", "1" , new ArrayList<>(Arrays.asList(11L)));
        Rela r1_2 = new Rela(12L, 1L, "1", "1" , null);
        Rela r1_3 = new Rela(13L, 1L, "1", "1" , null);
        Rela r1_4 = new Rela(14L, 1L, "1", "1" , null);

        Rela r2_1 = new Rela(21L, 2L, "2", "2" , new ArrayList<>(Arrays.asList(21L)));
        Rela r2_2 = new Rela(22L, 2L, "2", "2" , null);
        Rela r2_3 = new Rela(23L, 2L, "2", "2" , null);
        Rela r2_4 = new Rela(24L, 2L, "2", "2" , null);

        Stream.of(r1_1, r1_2, r1_3, r1_4, r2_1, r2_2, r2_3, r2_4)
                .collect(Collectors.groupingBy(rk -> new StringJoiner("-")
                        .add(rk.getFrom().toString())
                        .add(rk.getLx())
                        .add(rk.getLy()).toString()))
                .values().stream().map(
                relas -> relas.stream().reduce(
                        (v1, v2) -> {
                            List<Long> toList = v1.toList;
                            toList.add(v2.to);
                            return new Rela(v1.to,
                                    v1.from,
                                    v1.lx,
                                    v1.ly,
                                    toList);
                        }).get()).collect(Collectors.toList());
        Map<String, List<Rela>> map = Stream.of(r1_1, r1_2, r1_3, r1_4, r2_1, r2_2, r2_3, r2_4)
                .collect(Collectors.groupingBy(rk -> new StringJoiner("-")
                        .add(rk.getFrom().toString())
                        .add(rk.getLx())
                        .add(rk.getLy()).toString()));
    }

    @Test
    public void m37(){
        System.out.println(Duration.between(LocalDateTime.now().minusMinutes(100L),LocalDateTime.now()).toMinutes());
    }

    @Test
    public void m38(){
        int[] ints = IntStream.of(1, 2, 3, 4, 5, 6).map(v -> v * 100).toArray();
        System.out.println(Arrays.toString(ints));

    }

    @Test
    public void m39(){
        Double d1 = 2.35678;
        System.out.println(NumberUtils.toScaledBigDecimal(d1).doubleValue());

        DI di = new DA();
        di.m1();
    }

    interface DI{
        @Deprecated
        void m1();
    }

    class DA implements DI{
        @Override
        public void m1() {

        }
    }

    @Test
    public void m40(){
        EnumS.applyEnumOf(EnumSet.of(EnumS.Type.A , EnumS.Type.B) );
    }

    static class EnumS {
        enum Type {A, B , C , D , E , F}

        public static void applyEnumOf(Set<Type> types){

        }
    }

    @Test
    public void m41(){
        EnumS2.P.T t = EnumS2.P.T.from(EnumS2.P.A, EnumS2.P.B);
        System.out.println(t);
    }

    static class EnumS2{
        enum P {
            A, B , C ;
            enum T {
                D(A,B) , E(B,C) , F(A,C) ;
                private final P from ;
                private final P to;
                T(P from , P to) {
                    this.from = from;
                    this.to = to;
                }

                private static final Map<P , Map<P , T>> m = Stream
                        .of(values())
                        .collect(Collectors.groupingBy(t -> t.from ,
                                () -> new EnumMap<>(P.class) ,
                                Collectors.toMap( t -> t.to ,
                                        t -> t ,
                                        (x , y) -> y ,
                                        () -> new EnumMap<>(P.class))));

                // from to
                public static T from(P from , P to){
                    return T.m.get(from).get(to);
                }
            }
        }
    }


    @Test
    public void m42(){

    }

    enum RT{
        R1 , R2 , R3 , R4 ;
        enum RTT {
            TT1(EnumSet.of(R1 , R2)) , TT2(EnumSet.of(R2 , R3)) , TT3(EnumSet.of(R3 , R4))  ;
            private final Set<RT> rt;
            
            RTT(Set<RT> rt){
                this.rt = rt;
            }
        }

    }


    @Test
    public void m43(){
        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        System.out.println(dayOfWeek.getValue());
        System.out.println(dayOfWeek);

        LocalTime now = LocalTime.now();
        LocalTime parse = LocalTime.parse("12:34");
        System.out.println(now.isAfter(parse));
    }

    @Test
    public void m44(){
        String str = "[1,2,3,4,5,6,7,8,9]";
        log.info(" log params : {} ",str.substring(1 , str.length() - 1));
    }

    @Test
    public void m45(){
        // limiter
        for(;;){
            SlidingLimiter.slideWindow();
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class SlidingLimiter {
        private static final LoadingCache<Long, AtomicLong> counter =
                CacheBuilder.newBuilder()
                        .expireAfterWrite(10, TimeUnit.SECONDS)
                        .build(new CacheLoader<>() {
                            @Override
                            public AtomicLong load(Long seconds) throws Exception {
                                return new AtomicLong(0);
                            }
                        });

        private static final long limit = 15;
        private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        /**
         * 滑动时间窗口
         * 每隔1s累加前5s内每1s的请求数量，判断是否超出限流阈值
         */
        public static void slideWindow() {
            scheduledExecutorService.scheduleWithFixedDelay(() -> {
                try {
                    long time = System.currentTimeMillis() / 1000;
                    //每秒发送随机数量的请求
                    int reqs = (int) (Math.random() * 5) + 1;
                    limiter(time , reqs);
                } catch (Exception e) {
                    log.error("slideWindow error", e);
                }
            }, 5000, 1000, TimeUnit.MILLISECONDS);
        }

        public static void limiter(long time , long reqs) throws Exception{
            counter.get(time).addAndGet(reqs);
            long nums = 0;
            // time windows 5 s
            for (int i = 0; i < 5; i++) {
                nums += counter.get(time - i).get();
            }
            log.info("time=" + time + ",nums=" + nums);
            if (nums > limit) {
                log.info("限流了,nums=" + nums);
            }
        }
    }

    class Node {
        Integer id;
        Integer parentId;
        String value;
        List<Node> children;

        public Node(Integer id, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", parentId=" + parentId +
                    ", value='" + value + '\'' +
                    ", children=" + children +
                    '}';
        }
    }

    @Test
    public void m46(){
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(1 , null));
        nodes.add(new Node(2 , null));
        nodes.add(new Node(3 , 1));
        nodes.add(new Node(4 , 2));
        nodes.add(new Node(5 , 3));
        nodes.add(new Node(6 , 4));

        List<Node> nodeList = buildRootNode(nodes);
        for (Node node : nodeList) {
            List<Node> children = buildToNode(node , nodes);
            node.children = children;
            System.out.println(node);
        }


    }

    private List<Node> buildToNode(Node node, List<Node> nodes) {
        // 子集树
        List<Node> nodeList = nodes.stream().filter(n -> n.parentId != null && n.parentId.equals(node.id)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(nodeList)){
            return null;
        }
        for (Node node1 : nodeList) {
            node1.children = buildToNode(node1 , nodes);
        }
        return nodeList;
    }

    private List<Node> buildRootNode(List<Node> nodes) {
        return nodes.stream().filter(node -> node.parentId == null).collect(Collectors.toList());
    }
    
    @Test
    public void m47() {
        String heisi = "heisi";
        method(heisi);
        System.out.println(heisi + "wa");
    }
    private static void method(String h) {
        System.out.println("将温柔给予黑丝");
        System.exit(1);
    }

    @Test
    public void m48(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);
    }

    @Test
    public void m49(){
        Scanner sc = new Scanner(System.in);
        String res = "";
        boolean reFlg = false;
        System.out.println("天气:");
        int flg = sc.nextInt();
        re: {
            switch (flg){
                case 0:
                    res = reFlg ? "女士,要下雨了,记得穿黑丝哇" : "一起玩耍啦";
                    break ;
                case 1:
                    if (reFlg) {
                        res = "男士,下雨啦,出去看~";
                    }
                    reFlg = true;
                    System.out.println("性别:");
                    flg = sc.nextInt();
                    break re;
                default:
                    res = reFlg ? "性别参数错了~" : "天气参数错了~";
            }

        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next());
        System.out.println("-------------------------------------");
//        System.out.println(sc.nextLine());
    }

    @Test
    public void m50(){
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String level =
                score >= 90 ? "A" :
                score >= 75 ? "B" :
                score >= 60 ? "C" : "D" ;

        if (score >= 90){
            level = "A";
        }else if (score >= 75){
            level = "B";
        }else if (score >= 60){
            level = "C";
        }else{
            level = "D";
        }

        log.info("成绩级别是: {};" ,level );
    }

    @Test
    public void m51(){
        jc(9 , 1);
    }

    private void jc(int s , int base){
        if (s < base) return;
        for (int i1 = 1; i1 <= base; i1++) {
            System.out.printf("%d * %d = %d\t" , base , i1 , base * i1 );
        }
        System.out.println();
        jc(s , ++ base);
    }
    
    @Test
    public void m52(){
        int i = 0;
        for(println("A") ; println("B") && i < 1; println("C")){
            println("D");
            i++;
        }
    }

    private boolean println(String s){
        System.out.println(s);
        return true;
    }

    @Test
    public void m53(){
        CustomStack<Long> longCustomStack = new CustomStack<Long>(2);

        longCustomStack.push(1L);
        longCustomStack.push(2L);
        longCustomStack.push(3L);

        longCustomStack.pop();
        longCustomStack.pop();
        longCustomStack.pop();

    }

    @Slf4j
    static class CustomStack<T> {

        private int index = 0;

        private List<T> elements;

        private Integer cap = 10;

        public CustomStack(){
            elements = new ArrayList<>(cap);
        }

        public CustomStack(Integer cap){
            this.cap = cap;
            elements = new ArrayList<>(cap);
        }

        public void push(T val){
            if (checkSize()){
                log.warn("容器已经满啦~ , 当前大小 {} , 容器容量 {}" , index , cap);
                return;
            }
            elements.add(val);
            index++;
        }

        public T pop() {
            if(checkSize()){
                log.warn("我什么都没有了. , 当前大小 {} , 容器容量 {}" , index , cap);
                return null;
            }
            T t = elements.get(index);
            index--;
            return t;
        }

        public boolean checkSize(){
            return index >= cap;
        }
    }

    @Test
    public void m54(){
        CustomStackObj stackObj = new CustomStackObj(2);
        stackObj.push(1);
        stackObj.push(2);
        stackObj.push(3);

        System.out.println(stackObj.pop());
        System.out.println(stackObj.pop());
        System.out.println(stackObj.pop());
    }

    class CustomStackObj {
        // 索引下标
        private int index = 0;
        // 栈
        private Object[] elements;
        // 栈大小
        private int cap = 10;

        // 初始化栈大小
        public CustomStackObj() { initElementCap(cap); }

        public CustomStackObj(int cap) {
            this.cap = cap;
            initElementCap(cap);
        }

        // 压栈
        public void push(Object element){
            // 判断是否超容
            if (index >= cap){
                log.warn("已经满了. , 当前大小 {} , 容器容量 {}" , index , cap);
                return;
            }
            // 添加到栈里面 并且 栈指针自增
            elements[index++] = element;
        }

        // 弹栈
        public Object pop() {
            // 判断指针位置
            if (index <= 0){
                log.warn("我什么都没有了. , 当前大小 {} , 容器容量 {}" , index , cap);
                return null;
            }
            // 返回该位置值 并且 栈指针回缩
            return elements[--index];
        }

        private void initElementCap(int cap){
            elements = new Object[cap];
        }
    }

    @Test
    public void m55() {
        System.out.println(zanQian(100, 1, 0));
    }

    private int zanQian(double yuan , int day , double cun){
        cun += 2.5;
        if (cun >= yuan) {
            return day;
        }
        if (day % 5 == 0) {
            cun -= 6;
        }
        return zanQian(yuan, ++day, cun);
    }

    @Test
    public void m56() {
        List list = new ArrayList();
        list.add(1);
        list.add(1L);
        list.add("1");
        list.add(1.0);

        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
    }

}
