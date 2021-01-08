package _call_back_;

import org.junit.Test;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  10:28
 * @description :
 */
public class Main {

    @Test
    public void callbackFunctionTest(){
        CallBackFunction backFunction = null;

        callbackM1(backFunction);
        callbackM2(backFunction);

        backFunction.execute();


    }

    void callbackM1(CallBackFunction backFunction){
        String token1 = "token1";
        // 匿名内部类需要添加序列化字段？
        if (backFunction == null) {
            backFunction = () -> new HashMap<String, String>(){
                private static final long serialVersionUID = -3374614459939984327L;
                {
                put(token1 , "1");
            }};
        }
    }

    void callbackM2(CallBackFunction backFunction){
        String token2 = "token2";
        if (backFunction == null) {
            backFunction = () -> new HashMap<String, String>(){
                private static final long serialVersionUID = -3374614459939984327L;
                {
                    put(token2 , "2");
                }};
        }
    }


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
