package _2_demo_._3_demo_;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/5/24  16:46
 */
public class Demo1 {

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

        System.out.println(Demo1.checkDataFormat(str1)); // true
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
        Demo1 demo1 = new Demo1();
        System.out.println(demo1.a); // 0
        System.out.println(demo1.a_1); // null
        System.out.println(demo1.d);
        System.out.println(demo1.d_1);
        System.out.println(demo1.s);
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
            new Thread(() -> Demo1.testConcurrent(new TestConcurrentClass(1))).start();
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

}
