package _a_java_model_.design._3_.action.mediator;

import java.time.LocalDateTime;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/16  12:31
 * @description : 中介类
 */
public class ChatRoomClass {

    public static void showMessage(User user , String message){
        System.out.println(LocalDateTime.now() + " [ "+ user.getName() +" ] : " + message );
    }
}
