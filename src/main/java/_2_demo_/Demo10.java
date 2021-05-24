package _2_demo_;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/4/6  15:52
 */
public class Demo10 {

    private void mFileUrl(){
        System.out.println("================================");
        System.err.println(new File("demo3.java").toURI().toASCIIString());
    }

    public static void main(String[] args) {
        System.out.println("================================A");
        System.err.println(new File("demo3.java").toURI().toASCIIString());
        System.out.println("================================A");
        new Demo10().mFileUrl();

    }

    @Test
    public void m101(){
        if (mms() || mms())
            ;
        System.out.println();
        if (mms() | mms())
            ;

    } 
    private boolean mms(){
        System.out.println("1");
        return true;
    }

    @Test
    public void m102(){
        if (false | true) {
            System.out.println(1);
        }
        if(true & false){
            System.out.println(2);
        }

    }


    @Test
    public void m103(){
        String d = null;
        TestM103 testM103 = TestM103.match(d);
        System.out.println(testM103.getName());
    }
    enum TestM103{
        A("A"),
        B("B"),
        C("C"),

        EMPTY(null),
        ;
        private final String name;

        TestM103(String name) {
            this.name = name;
        }

        public static TestM103 match(String checklistType) {
            if (StringUtils.isEmpty(checklistType)){
                return EMPTY;
            }
            for (TestM103 value : TestM103.values()) {
                if (StringUtils.equalsIgnoreCase(value.getName() , checklistType)){
                    return value;
                }
            }
            return EMPTY;
        }


        public String getName() {
            return name;
        }
    }


    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    enum M_104{
        M1(new C_M104() , "hellos"),
        ;
        private final C_M104 c_m104;
        private final String hellos;

        M_104(C_M104 c_m104 , String hellos) {
            this.c_m104 = c_m104;
            this.hellos = hellos;
        }

        public C_M104 getC_m104() {
            return c_m104;
        }

        public String getHellos() {
            return hellos;
        }
    }



    @Test
    public void m104(){
        ObjectMapper objectMapper = new ObjectMapper();
        // 对于空的对象转json的时候不抛出错误
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 允许属性名称没有引号
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许单引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String string = objectMapper.writeValueAsString(M_104.M1);
            C_M104.setComments("I m , good");
            ArrayList<C_M104_1> c_m104_1s = new ArrayList<>();
            c_m104_1s.add(new C_M104_1());
            string = objectMapper.writeValueAsString(M_104.M1);
            System.out.println(string);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void m105(){
        String str1 = "{{s1_1} , {s1_1} , {s1_1}}";
        System.out.println(str1.replaceAll("\\{s1_1}", "123"));
    }
}
class C_M104 {
    @JsonIgnore
    public static final List<C_M104_1> c_m104_1s = new ArrayList<>();
    private static String comments = "hello world";
    private String desc;
    private List<C_M104_1> c_m104_1 = c_m104_1s;
    private C_M104_2 c_m104_2;

    public String getComments() {
        return comments;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public static void setComments(String comments) {
        C_M104.comments = comments;
    }

    public List<C_M104_1> getC_m104_1() {
        return c_m104_1;
    }

    public void setC_m104_1(List<C_M104_1> c_m104_1) {
        this.c_m104_1 = c_m104_1;
    }

    public C_M104_2 getC_m104_2() {
        return c_m104_2;
    }
    public void setC_m104_2(C_M104_2 c_m104_2) {
        this.c_m104_2 = c_m104_2;
    }
}
class C_M104_1 {
    private String he;

    public void setHe(String he) {
        this.he = he;
    }
    public String getHe() {
        return he;
    }

    @Override
    public String toString() {
        return "{" +
                "he='" + he + '\'' +
                '}';
    }
}
class C_M104_2 {
    private String he;

    public void setHe(String he) {
        this.he = he;
    }
    public String getHe() {
        return he;
    }

    @Override
    public String toString() {
        return "{" +
                "he='" + he + '\'' +
                '}';
    }
}
