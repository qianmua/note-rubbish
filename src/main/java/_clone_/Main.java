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

        Son son1 = son.clone();
        Son clone = CloneUtils.clone(son);
        System.out.println(clone);
        System.out.println(son1);

        son.getFather().setName("Hello");

        System.out.println(clone);
        System.out.println(son1);



    }
}
