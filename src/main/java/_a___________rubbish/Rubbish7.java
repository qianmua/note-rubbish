package _a___________rubbish;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/14  14:37
 * @description :
 */
public class Rubbish7 {

    public static void main(String[] args) {

    }
    static class Demo{
        boolean b;
        int tv;

        void m1(){
            b = false;
        }
        void m2(){
            b = true;
        }

        String m3(int v1){
            return b ? setTV(v1) : "开机哦";
        }

        String setTV(int v1){
            tv = v1;
            return "ok!" + v1;
        }
    }
}
