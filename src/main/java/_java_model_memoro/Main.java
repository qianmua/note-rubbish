package _java_model_memoro;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/5
 * @time 21:30
 */
public class Main {

    private static MemoroCaretaker memoroCaretaker = new MemoroCaretaker();
    private static Originator originator = new Originator();


    public static void main(String[] args) {
        originator.testHash1();

        memoroCaretaker.saveMemoro("save1" , originator.createMemoro());
        originator.showHash();
        originator.testHash2();
        originator.showHash();

        // 读档
        originator.restoreMemoro(memoroCaretaker.getMemoro("save1"));
        originator.showHash();

    }

}
