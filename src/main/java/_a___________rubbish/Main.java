package _a___________rubbish;

import java.util.Scanner;
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
        f1();
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
