


# aqs 同步器

## AQS

    abstract queue sync 抽象 队列 同步器

> java 并发的核心封装包 CAS

    //synchronized java的基于c语言设计的同步机制


## 三大核心 dougLi 基于java 实现的同步器


> 三大核心

    自旋
    
    lockSupport
    
    CAS
    
> 特性

    阻塞等待队列
    共享/独占
    公平/非公平
    可重入
    允许中断
    
### 公平锁/非公平锁
    
        公平锁：
            队列？ 拿锁
            无锁？ 初始化队列 拿锁？ 排队 cas
            无锁？ 队列？ 排队 cas
        
        非公平锁：
            拿锁 cas
                true  next
                false 检查 cas       
                


 ## cas
 
    用的是 for ， while 
    // 不用递归
    // 递归可能会造成栈溢出
    // end
 
> unsafe 类

    魔术类， 可以直接绕过虚拟机 直接操作 内存 // 1.7 之后
    
    // 不可以直接 访问 
    // 在构造方法 里面规定了 必须又 引导类加载器 去加载
    
    // 可以通过反射去加载这个 unsafe
    
    // 原子操作 方法
    //
    
> cas 中 如何 去阻塞线程 防止浪费cpu资源

    unsafe 中的 park 和 unpark 方法 可以有效地去阻塞（释放占用的 cpu资源）和唤醒线程
    
    一般不直接使用
    
    unsafe 实现类 lockSupport
    封装了 这俩 方法 直接用就好啦~
    
    
    
## aqs核心原理

    同步队列 比较器
    //
    就是 无锁 
    // 
    自己加锁 解锁
    //
    

    需要的 属性
    state // 锁状态
    lockThread // 得到锁的线程
    queueThread // 等待 唤醒的 线程 队列 //
            //LinkedBlockingQueue // AQS 实现的  同步
            //ConcurrentLinkedQueue  // juc下面的 没有使用aqs实现 // 使用的是 cas实现的
            
    公平锁 所以使用队列 // 后面的线程 进来 必须排队
    
    
    
    
    
    
    