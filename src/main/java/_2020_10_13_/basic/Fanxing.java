package _2020_10_13_.basic;

import java.util.List;

/**
 * 通配符
 */
public class Fanxing {
    public void wildcard(List<? super Number> list) {
        list.add(1);
    }

    public void wildcardObject(List<Object> list) {
        list.add(1);
    }

    public static void main(String[] args) {

    }
}

class MyFanXing<T>{
    //public static T getnum(){}
}
