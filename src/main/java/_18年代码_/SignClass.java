package _18年代码_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/31  13:36
 * @description :
 */
public class SignClass {

    static final class Sign{

        private Sign(){
            throw new Error("don't instance this :" + this.getClass().getName());
        }
    }
}
