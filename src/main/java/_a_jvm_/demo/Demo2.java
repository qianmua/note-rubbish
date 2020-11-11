package _a_jvm_.demo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/4  13:38
 * @description :
 */
public class Demo2 {

    /*
    * 元空间 默认 大小 21M
    * 不够会GC 然后 扩容与 虚拟内存 差不多
    * full GC 的牵引 （比较麻烦 对性能 由严重损耗）
    *
    *
    *
     * cglib 动态生成类
     * 动态生成Class  Class元数据 在 元空间中
    *   是Class 不是 对象
    *
    * 方法区产生内存溢出
    *
    *
    * // 调元空间 的大小
    * -XX:MaxMetaspaceSize=10m
    *
    * //
    *
    * 在运行期 动态的创建 类
    *
    * //
    * 在元空间中的
    *
    * 静态语言 和 动态语言
    *
    * java 半动态
    * //
    * 反射 机制
    * */


    //Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
    // 1，7 是 永久代
    //
    // error
    public static void main(String[] args) {
        for ( ; ;){
            //cglib

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Demo2.class);
            enhancer.setUseCache(false);

            // 代理
            enhancer.setCallback( (MethodInterceptor)
                    (v1, v2, v3, v4) -> v4.invokeSuper(v1,v3));

            System.out.println("--");
            // 创建 Demo2 的子类 ，（全新的）
            // 元信息 存在 元空间中
            enhancer.create();
        }
    }


    /*
    * 补充
    *
    * java 的动态代理 proxy 为什么 只能 是接口呢？
    *
    * 因为 代理类 已经继承了 proxy 类
    *
    * java 是单继承呀
    *
    * // 所以 只能 是 接口喽
    *
    * cglib 可以 非接口
    *
    * //
    * cglib 是继承了 代理类
    *
    * */


}
