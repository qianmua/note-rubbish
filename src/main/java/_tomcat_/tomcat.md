

# tomcat

> tomcat 是一个 servlet容器

    servlet doget
    tomcat 会去调用 这个 方法
    // 
    HttpServletRequest实现类
    tomcat 去实现 
    
    // servlet是一个规范
    
    HttpServletRequest实现类 有个实现 RequestFacted // 门面模式
    
    
> tomcat 如何部署应用？

    war
    文件夹
    conf 去定义 xml配置表示部署
    
    
    jar war
    应用 就是 war ， 其他 就是 jar
    /// 
    tomcat内部 是写死的， 只能是 .war
    
## tomcat 四大servlet 容器
    
    实现了 container 接口 ：
    
>    engine          管理host节点

        储存的是host节点 
        
>    host            虚拟主机 （lcalhost） // 可以管理多个 // 比如localhost 

        存放的 应用 context
        // 
       还可以去隔离日志
       
>    context         应用 servlet （servlet容器） // 

        存放的是 wrapper
        
    
>    wrapper         servlet容器 存放的 是真正的servlet容器

        servlet 实例 和 class
        //
        servlet规范
        一个servlet 必须实现 SignleThreadModel
        // 每个请求单独对应一个servlet实例
        如果没有 实现 
        所有 请求 共同享用一个servlet实例 
    
> tomcat 会去 解析 web.xml

    要是 碰到 servlet
    就会转换为 wrapper 对象
    然后设置属性
     
    
## 请求 容器

    每个容器都有一个 pipeline
    
    请求会包含他的一些信息 ，协议
    
    // tomcat 封装的 Request 对象 // 实现了 ReqeustServletRequest // 接口
    // 包含了 请求的信息 （method、url、serverName.....）
    // tomcat 会解析这个请求 
    然后把 信息存到Request中去 
    set......
    
    ->
    
    然后交给容器去处理
    
    -> host -> context -> wrapper -> servlet
    
    每个容器 都会有相应的处理 （valve 【阀门】 所有 的请求 都会进入 阀门 ， 跟过滤器类似 ） 处理完后交给 下一个容器
    
    到达warpper后 就去找 servlet //
    找到后 就会去 生成 servlet 实例 
    // 前后 会先调用 filter 或者 linstener 
    // 然后 传递 Request 生成 RequestFacted    
    然生调用 servlet 方法
    <init
    <service
    然后调用 doget 这个 方法
    
## Request 怎么生成

    网络传输数据 （http ( tcp/ip (os 或者 自己实现的协议 (数据传输协议) ) ) .. 等等协议）  -> 网卡 -> tomcat -> new Request
    
### 
    
    tcp ——> 连接 
    传输 数据 
    // os
    os 解析 
    交给 响应端口 处理
    
    // tomcat 得到数据
    
    按照http规则 转成 Request对象
    
    
    
## IO 模型
    
>   AIO / BIO / NIO

    取数据 // 速度 不一样 
    tomcat 7 支持 NIO + BIO
    以后只支持 NIO
    
    // 通过 BIO（Socket） NIO
    去监听一个连接
    一个 socket 对应一个线程
    
    
    
    
    
    
    
    
    
    
    
    
    
    