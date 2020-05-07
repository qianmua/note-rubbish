package _a_jvm_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/3
 * @time 12:43
 */
public class jvm_Info {
    /*
    * 运行时数据区
    *
    * 虚拟机栈是线程似有的，每个线程都有自己的虚拟机栈 栈帧frame 每个方法都有一个frame
    * pc线程计数器，也是线程独有的，当前线程正在执行的指令地址 cpu切换用的
    * 本地方法栈，线程独有的哦
    *
    *堆，线程共享
    *方法区（永久代，元空间），存放class的东西，线程共享
    * 常量池
    *
    * 区域
    * new（eden，form，to 8 : 1 : 1 可以调整） , old
    * new 出来一般在new，特别大的直接在old
    *
    *
    * gc 算法 : copy
    *
    * 怎么确定是垃圾：
    * 1、 引用计数 -- 问题：循环引用。。A-B-C-D-A 内存泄露
    * 2、根搜索（正向可达）
    *
    *
    * stp cms
    *
    * gc算法
    * 标记清除 - 碎片化问题
    * 拷贝 一分为二 ， 用一半，把需要存活的cp到另一半，速度快， 内存浪费问题
    * 标记整理 回收顺便整理
    *
    * 垃圾收集器
    * g1
    * serial串行化
    * parallel并行化
    * concurrent mark sweep 并发标记
    *
    *
    *
    * Object 32bit
    * 对象信息
    *
    *
    *
    *
    *
     * */


    //-server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,*TestInterrupt2.main
    //-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
}
