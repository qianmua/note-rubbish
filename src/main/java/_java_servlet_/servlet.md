


#   servlet 

    注册方式
    
        web.xml
        注解  （servlet3.0）
        编码  （java config）
        
        
## 生命周期
    
    servlet
    初始化 init
    服务 service  （doget ， dopost）
    销毁 destroy        
    
    filter
    初始化 init
    过滤 dofilter （责任链）
    销毁  destroy
    
    context
    初始化 contextinit
    销毁  contextdestroy
    
    
## servlet 异步

    支持 （类）
    
    deferredResult  //异步执行（结果-----）   // 麻烦 需要自己调整队列
    
    Callable    //  异步执行
    
    CompletionStage    // 流
    
    
    
## mvc 用例 实现异步

    DefferredResult    
    
    
    Callable 执行// 可以直接lambda    用的多
    
    CompletionStage （java 1.8 doug lea）  链式   // 线程池 forkijionpool
    
    
    
## MVC 实现  异步servlet    围绕servlet规范操作的

    （boot 不会去引导 他的自动装配 （他是 不支持servletContainerInit 的实现接口））

    HandlerMethodReturnVauleHandle
    
    
    servlet3.0 anyncContext
    
    DispatcherSerblet // 整合
    
    
## servlet 实现

    webServlet // 默认是false      （不是 全局 的 只是 针对 当前 servlet）
     // 先激活 
     // 
     
     use
     
     // 创建异步上下文
     // 创建 监听
     // 
     //输出
     getResponse
     // setContetxType 设置响应媒体类型
     Writer //字符输出流
     
     
> 超时 是需要两个线程 切换的

    用户态到内核态 调度
    
## springboot 嵌入servlet容器限制

    不支持web.xml      
        RegisterBean、Bean去注册
    
    不支持servletContainerInit 接口  //servlet spi （自动化装配）   
        去实现servletContextInit       // lambda？ - -!
        // 重新注入
        // onStartUp
        // 子类 包含RegisterBean
        （不会生成 日志 打印 (没写)）
        
        
    
    注解驱动限制 （@WebServlet filter listener等）    
        依赖ServletComponsentScan 去扫描
        //  扫描  定义 注册bean
        注册了一个 RegisterBean // 扫描 WebServlet.class -> Bean 定义    filter linstener //同理
        //
        使用 Bean 去注册 // 不太友好
        使用ServletRegisterBean 去注册 servlet
        
    @Order（Ordered.）    //  提高运行顺序 
    // 内部 会有一个 Order 的排序
    
    
    servlet 部署 springboot
    springboot 部署 servlet （嵌入式） （不支持spi 哦）
    

## mvc
    
    servlet spi
    
    spring适配 （springServletContainerInit）    
    
    spring spi
    接口  webApp
    编码  abs
    注解  absAnno
    
    
    
## boot 传统 servlet

    SpringBootServletInitializer
    扩展 config 方法        

    tomcat 插件
    
    
##  reactive

    webflux 底层框架
    
>  反应堆 模式 reactor

>   ProActor

>   观察者模式   ob

>   迭代器模式

>   java 并发 模型

    reactive
    
        实现框架
        RxJava  
        Reactor webFlux 类库（Spring）    
        Flow API    java9 API 实现
        
> reactive 观点

    阻塞 导致性能 瓶颈 与 资源浪费
    并行 并发
    并行 不能 解决所有
    
    烧开水 模型-》 烧开水 的时候 我去 干点 别的 事情
    
##  reactive eg：

    ！springboot-all
    
    
>  future 阻塞？

    是的
    future#get()
    会强制 等待 完成
    // 
    虽然 也是 线程池
    //
    阻塞源泉
    //
    
    
> future 链式

    future 依赖 问题
    //  异步的
    F1 -> F2 -> F3    
    //
    
    CompletableFuture   // j8   // 串行
    // 另起线程
    // 不阻塞 了 main
    // 一定程度上
    // future 数据 问题 // 链式的
    
## 问题 2

    流式数据容量判定
    异步编程复杂
    源和消费端资源消耗 不容平均
    
    
    
    Reactive 是什么？
    使用？    
    限制？
    
    
    
##  reactive


    关键字
    
    响应的
    适应性强的
    弹性的
    消息驱动的
    
    
    流 （stream）
    传播 变化 （ob）
    
    
    // 事件 驱动 / 约定
    EventListener   //  事件 规约 // 无方法实现 // 规约 事件 驱动 继承 此 方法
    
    变化响应        asyncListener
    非阻塞         servlet3.0  ReaderListener/WriterListener
    
    
    
    // 屏蔽并发细节
    exectuor    future      runnable
    
    
>   reactor

    观察者
    响应流
    迭代
    拉
    推（反应堆）    
    
    
## reactive
    
>   reactive stream

    java stream 提供了 大量 运算符 （filter map ， count ,, 等等..）
    

    框架

    api
    
    publisher   数据发布者   上游
    subscriber  数据订阅者   下游
    subscriptin 订阅信号    （控制）
    processor   承上启下    （中间服务）
    
    信号事件
    
    obSub   下游订阅时
    onNext  下游接收时
    onComp  完成时
    onError 错误时
    
    信号操作
    
    request 请求上游
    cancel  请求停止发送 并且清除 资源
    
    
>   背压    

    关键字
    
    I/O 切换
    缓存填满
    数据无法接受
    传输设备
    停止数据包发送
    
    
    reactor
    
    传播上游信号
    无边界信号
    处理最大元素数量
    
    
    
    总结： 背压
    当上下游 供过于求 下游通过信号 告诉 上游 限制 或者停止 数据 产生
    
    
## reactor

    api

    mono    0-1 非阻塞结果   （单）
    flux    0-n 非阻塞序列   （流）
    scheduler   reactor 调度线程池
    
    
> java 8 optional   (npe)    

>   schedule    

    调度线程 池
    
    当前线程 immediate
    
    单复用线程 single        idel  存活时间 1
    
    弹性线程池   elastic idel 60
    
    并行 线程池  parallel    idel    60
    
    
    实现  ScheduleThreadPoolExecutor
    
    
    
    
    
        
    
    
    
        
    
    
            

            
            
        
    
    
    
    

          
    