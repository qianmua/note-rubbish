package _a_jvm_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/5
 * @time 12:39
 */
public class ClassLoaderTest {
    //汇编指令
    //-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
    /**
     * 类加载器
     *
     * 引导类（启动类）
     * 扩展类
     * 系统类
     * 自定义
     *
     * //间接或者直接继承了ClassLoader就叫自动类
     *
     *
     *
     *
     * */

    public static void main(String[] args) {

        //得到系统类加载器
        // 你自己写的叭
        //
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);

        // 得到其上次，扩展类加载器
        //ext 目录下的jar
        ClassLoader parent = loader.getParent();
        System.out.println(parent);

        //上层 引导类
        // 引导类加载器 是使用c / c++ 编写的 不可以直接访问获取
        // 加载的是java核心类库
        //rt.jar
        //resources.jar
        //sun.boot.class.path 下的类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1); // null

        // 用户自定义的类
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // 用户自定的类是使用系统类加载器
        System.out.println(classLoader);


        /**
         *
         * 自定义类加载器
         * 制定类的加载方式
         *
         * 隔离加载类 // 冲突的问题 做一个类的仲裁
         * 修改类的加载方式 //动态加载
         * 扩展加载源
         * 防止源码泄露 // 实现解密操作 (●'◡'●)
         *
         *
         * 编写自定义加载器
         * 继承ClassLoader
         * 重写findClass，写入加载逻辑
         * 要是没有负载的要去
         * 可以直接继承URLClassLoader 避免自己编写findClass
         *
         *
         * 双亲委派机制
         * //防止一些安全的问题发生
         * // 也是保护底层代码
         * //避免类重复加载
         *  类加载接到加载请求把类加载请求交给父类，父类能加载就去加载，不能那么子类去尝 试加载
         *
         * 沙箱安全机制
         * 保证对java核心代码的保护
         *
         *
         * 表示两个class对象是否是同一个
         * 1、完全限定类名一致
         * 2、ClassLoader一项
         *
         *
         * */
    }
}
