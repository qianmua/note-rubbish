package _2_demo_;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;

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
}
