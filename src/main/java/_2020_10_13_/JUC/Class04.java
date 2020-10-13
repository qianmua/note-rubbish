package _2020_10_13_.JUC;

//单例模式(DCL)
public class Class04 {
    //禁止在getInstance()中出现指令重排
    private static volatile Class04 INSTANCE = null;

    private Class04(){
        System.out.println("初始化!");
    }

    public static Class04 getInstance(){
        if(INSTANCE == null){
            synchronized (Class04.class){
                if(INSTANCE == null){
                    INSTANCE = new Class04();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Class04.getInstance();
                }
            }).start();
        }
    }
}
