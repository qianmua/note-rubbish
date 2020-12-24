package _a_java_model_.design._font_controller_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  10:14
 * @description :
 */
public class FrontController {

    private Dispatcher dispatcher;

    public FrontController(){
        dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser(){
        System.out.println("SUCCESS");
        return true;
    }

    private void trackRequest(String request){
        System.out.println("page Req: " + request);
    }
    public void dispathcerRequest(String request){
        trackRequest(request);

        if (isAuthenticUser())
            dispatcher.dispatch(request);
    }

}
