package _18年代码_;

import com.google.common.base.Strings;

import java.util.Objects;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/16  17:38
 * @description :
 */
public class Demo {

    public static void main(String[] args) {

        try{
            System.out.println("A");
//            throw new RuntimeException("one exception");
            int c = 1/0;
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            try {
                System.out.println("B");
//                throw new ("two exception");
                int a = 1/0;
            }catch (RuntimeException e){
                e.printStackTrace();
            }
            System.out.println("C");
        }

        System.out.println("OK");

//        System.runFinalizersOnExit(false);
    }

    private String name;
    private Integer age;

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Demo) )
            return false;
        if (this == obj)
            return true;
        Demo demo = (Demo) obj;

        return this.name.equals(demo.name)
                && this.age.equals(demo.age);
    }

    @Override
    public int hashCode() {
//        int hash = Objects.hash(age, name);

        int res = Integer.hashCode(age);
        res = 31 * res + this.name.hashCode();
        return res;
    }
}
