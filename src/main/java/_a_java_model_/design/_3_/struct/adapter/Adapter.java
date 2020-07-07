package _a_java_model_.design._3_.struct.adapter;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/7  21:40
 * @description :
 */
public class Adapter {

    /**
     *
     * 适配器模式
     * 插座 插头 //
     * 不同 标准插头 转换器
     *
     * 兼容 不同的 接口 类
     *
     * A (adapter) B
     * 是解耦的 //  没有 暴露 B
     *
     * 三类
     * (source)
     * 类适配器
     * 对象适配器
     * 接口适配器
     *
     *
     * springMVC HandlerAdapter
     *
     * 适配器 的 应用
     * 1、请求
     * 2、HandlerMapping 处理 找到 Handler（Controller）
     * 3、执行 （适配器 去 寻找）
     *      HandlerAdapter
     *      // 不同的 handler 去使用 不同的 适配器
     *      通过 适配器去调用 Handler 方法 // 注解？ 反射？
     *
     * 4、返回 结果
     * 5、InternalResourceViewResolve 解析 // 视图解析
     * 6、Jsp 执行 代码 并 返回结果 给tomcat
     * 7、tomcat 封装 Http 响应
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * */

    public static void main(String[] args) {

    }
}
