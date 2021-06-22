package _f_fan_she_;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  16:18
 */
public class _Main_ {

    public static void main(String[] args) {
        f();
    }

    private static void f(){

        try {
            Method getValue = FFFFMAIN.class.getMethod("getValue", List.class);
            Type[] genericParameterTypes = getValue.getGenericParameterTypes();
            Type genericReturnType = getValue.getGenericReturnType();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

class FFFFMAIN<T> {
    private T data;

    public T getData() {
        return data;
    }

    public List<String> getValue(List<String> v){
        System.out.println(v);
        return v;
    }

    public void setData(T data) {
        this.data = data;
    }
}
