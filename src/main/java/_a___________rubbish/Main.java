package _a___________rubbish;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/25
 * @time 19:15
 */
public class Main {
    public static void main(String[] args) {
        List<Character[]> list = new ArrayList<>(500);
        while (true){
            list.add(new Character[1024 * 1024]);
            System.out.println(list.size());
        }
        // 398 OOM


//        f1();
    }

    private static void f1(){
        String str = new Scanner(System.in).next();
        String temp2 = str.replaceAll("[^0-9]","");
        String temp = str.replaceAll("[0-9a-zA-Z]","");
        if (temp.length() <=0){
            System.out.println(str);
        }else {
            System.out.println(temp);
        }
    }
}
