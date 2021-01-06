package _a_java_model_.design._3_.create.singleton;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/6  20:01
 * @description :
 */
public class EnumSingleton {
    private EnumSingleton(){}


    private enum SingletonEnum{
        SINGLETON_ENUM;

        private final EnumSingleton enumSingleton;


        SingletonEnum(){
            enumSingleton = new EnumSingleton();
        }

        public static EnumSingleton getInstance() {
            return SINGLETON_ENUM.enumSingleton;
        }
        
    }

    public static EnumSingleton getInstance() {
        return SingletonEnum.getInstance();
    }
}
