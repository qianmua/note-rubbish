package _2_demo_;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/1/27  19:57
 */
public class ReflectDemo {

    @Test public void m1() throws NoSuchFieldException {
        Class<DemoT1> aClass = DemoT1.class;
        Field[] fields = aClass.getDeclaredFields();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
    }

}


@Data
class DemoT1{
    private String name;

    private String address;
}