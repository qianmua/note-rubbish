package _a_jvm_._gcroots_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/12
 * @time 13:48
 */
public class Main {


    /**
     * gc roots
     *
     * 一个对象不在被引用的时候，就是一个垃圾
     *
     * gc roots 可达性分析
     * 从gc roots 对象为起点向下搜索，没有引用链，则不可用 ， 能找到的就叫做可达
     * 如果没有root 但是自己和别的互相引用，也是一个不可用 （垃圾块）
     *
     * gc root 起点
     *
     * 栈：局部变量表中引用的
     * 元空间 ： 类静态属性引用的对象
     * 方法区：常量引用的对象
     * 本地栈中(native) 引用的对象
     *
     *
     *
     * */
    public static void main(String[] args) {

    }
}
