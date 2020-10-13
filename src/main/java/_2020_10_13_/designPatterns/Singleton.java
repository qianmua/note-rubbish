package _2020_10_13_.designPatterns;

/**
 *单例模式，DCL
 * @author ACER
 */
public class Singleton {
    private volatile Singleton INSTANCE;

    private Singleton() {
    }

    public Singleton getINSTANCE(){
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
