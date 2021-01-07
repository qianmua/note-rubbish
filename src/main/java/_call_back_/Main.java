package _call_back_;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  10:28
 * @description :
 */
public class Main {


    /*
    java 回调
    java8 lambda 回调
     */
    public static void main(String[] args) {
        java7Test();
        java8Test();
    }

    /**
     * lambda 表达式
     */
    public static final void java8Test(){
        Tools tools = new Tools();
        // 回调函数了
        tools.setJava7CallBack(System.out::println);
        tools.toolsCall();
    }


    /**
     *匿名内部类
     */
    public static final void java7Test(){
        Tools tools = new Tools();
        tools.setJava7CallBack(new Java7CallBack() {
            @Override
            public void sendMessage(String callName) {
                System.out.println(callName + "java7callBack");
            }
        });
        tools.toolsCall();
    }
}
