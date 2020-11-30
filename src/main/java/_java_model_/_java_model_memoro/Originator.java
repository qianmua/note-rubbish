package _java_model_._java_model_memoro;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/5
 * @time 21:55
 */
public class Originator {
    private HashMap<String , String> hashMap;

    public Originator(){
        hashMap = new HashMap<>();
    }

    public MemoroIF createMemoro(){
        return new Memoro(hashMap);
    }

    public void restoreMemoro(MemoroIF memoroIF){
        hashMap = ((Memoro) memoroIF).getHashMap();
    }

    /**
     * 调试
     */
    public void showHash(){
        hashMap.entrySet().forEach(System.out::println);
    }

    /**
     * 测试数据
     */
    public void testHash1(){
        hashMap.put("blood","100");
        hashMap.put("god","100W");
        hashMap.put("hand","99");
    }
    public void testHash2(){
        hashMap.put("blood","200");
        hashMap.put("god","200W");
        hashMap.put("hand","199");
    }


    /**
     * 具体实现
     */
    private class Memoro implements MemoroIF{

        public HashMap<String, String> getHashMap() {
            return hashMap;
        }

        public void setHashMap(HashMap<String, String> hashMap) {
            this.hashMap = hashMap;
        }

        private HashMap<String , String> hashMap;

        private Memoro(HashMap<String, String> hashMap1){
            //克隆一份
            this.hashMap = new HashMap<>(hashMap1);
        }


    }
}
