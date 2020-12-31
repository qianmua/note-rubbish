package _clone_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/31  17:17
 * @description :
 */
public class Main {

    /**
     * 深克隆
     * 使用序列
     * @param args
     */
    public static void main(String[] args) {
        Father father = new Father("Jack");
        Son son = new Son("Slack" , father);
        "A".intern();

        Son clone = CloneUtils.clone(son);
        System.out.println(clone);


    }
}
