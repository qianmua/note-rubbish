package _a_java_model_.design._font_controller_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  10:12
 * @description :
 */
public class Dispatcher {

    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher(){
        studentView = new StudentView();
        homeView = new HomeView();
    }

    public void dispatch(String request){
        if (request.equalsIgnoreCase("A"))
            studentView.show();
        else
            homeView.show();
    }
}
