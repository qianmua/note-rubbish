package _a_java_model_.design._3_.action.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  13:20
 * @description :
 */
public class Subject {
    private List<ObServer> obServers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObServers();
    }

    public void attach(ObServer obServer){
        obServers.add(obServer);
    }

    public void notifyAllObServers(){
        for (ObServer obServer : obServers) {
            obServer.update();
        }
    }
}
