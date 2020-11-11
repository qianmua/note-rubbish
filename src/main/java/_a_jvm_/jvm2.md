

# jvm

    元空间 默认 大小 21M
    
    不够会GC 然后 扩容与 虚拟内存 差不多
    full GC 的牵引 （比较麻烦 对性能 由严重损耗）
    
    
## cglib 动态生成类

    动态生成Class  Class元数据 在 元空间中
    是Class 不是 对象
    
    方法区产生内存溢出
    
    // 调元空间 的大小
    -XX:MaxMetaspaceSize=10m
    
    
    在元空间中的
    
    静态语言 和 动态语言
    java 半动态 // 反射 机制
    
    
## java 的动态代理 proxy 为什么 只能 是接口呢？

     因为 代理类 已经继承了 proxy 类
      java 是单继承呀
    