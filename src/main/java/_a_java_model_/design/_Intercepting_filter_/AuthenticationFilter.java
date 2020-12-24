package _a_java_model_.design._Intercepting_filter_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  10:34
 * @description :
 */
public class AuthenticationFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println(" AuthenticationFilter request :" + request);
    }
}
