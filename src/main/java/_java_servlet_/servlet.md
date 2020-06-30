


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
    
    
    
    
        

            

            
            
        
    
    
    
    

          
    