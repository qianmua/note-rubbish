package _java_model_memoro;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/5
 * @time 21:50
 */
public class MemoroCaretaker {


    private HashMap<String , MemoroIF> hashMap;


    /**
     * initialized
     */
    public MemoroCaretaker(){
        hashMap = new HashMap<String,MemoroIF>();
    }

    /**
     * get
     * @param hashName
     * @return
     */
    public MemoroIF getMemoro(String hashName){
        return hashMap.get(hashName);
    }

    /**
     * set
     * @param name
     * @param memoroIF
     */
    public void saveMemoro(String name , MemoroIF memoroIF){
        this.hashMap.put(name,memoroIF);
    }
}
