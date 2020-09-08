

> 使用 final 关键字修饰一个变量时，是引用不能变，还是引用的对象不能变？

    指引用不可变 ， 引用指向的对象 可以改变
    
> 静态变量和实例变量的区别
    
    静态变量加 static 类变量
    加载了类的字节码，静态变量就会被分配空间，就可以被使用
    
    实例变量必须创建对象后才可以通过这个对象 来使用
    
    
> "=="和 equals 方法究竟有什么区别

    == 如果判断值类型的话，判断内容是否相同。如果判断引用类型则是判断内存地址是否相同
    Equals判断值内容是否相等
    
> Integer 与 int 的区别

    Integer 是引用类型,默认值是null。而int是是值类型默认值是0
    
> 重载与重写区别

    重载是同一个类中，方法名称相同， 但是参数或个数不同
    重写是在多个类中， 产生继承关系
    
> 接口与抽象类的区别

    接口中成员不能有私有， 抽象类可以
    接口中定义的成员， 是finl public static 类型， 抽象类没有。
    接口中的不能有普通方法， 抽象类中可以
    
> final, finally, finalize

    finally 是异常处理语句结构的一部分，表示总是执行
    finalize 是 Object 类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可
    以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。 JVM 不保证此方法总被
    调用


> String、StringBuffer与StringBuilder的区别

    String 字符串常量
    StringBuffer 字符串变量（线程安全）
    StringBuilder 字符串变量（非线程安全）

> object类常用的方法

    clone
    getClass
    toString
    finalize
    equals
    
> 数组有没有length()这个方法

    数组没有length()这个方法，有length的属性
    
> hashCode方法

    该方法用于哈希查找，重写了equals方法一般都要重写hashCode方法。这个方法在一些具有哈希功能的Collection中用到
    
> wait方法

    wait()方法一直等待，直到获得锁或者被中断
    wait(long timeout)设定一个超时间隔
    
    唤醒：
    （1）其他线程调用了该对象的notify方法。
    （2）其他线程调用了该对象的notifyAll方法。
    （3）其他线程调用了interrupt中断该线程。
    （4）时间间隔到了。
    
> notify方法

    该方法唤醒在该对象上等待的某个线程。
    
> notifyAll

    该方法唤醒在该对象上等待的所有线程
    
> 反射的优缺点

    增加程序的灵活性
    
    维护问题
    性能问题
    
> 中有几种类型的流

    字节流，字符流
    
    
    
> 线程和进程有什么区别

    线程是进程的一条执行路径，而进程是线程的集合
    
> 线程同步、异步

    线程执行完后下一个线程接着执行
    
    
> 线程之间如何同步

    synchronized、wait 与 notify lock
    
> 如何创建一个线程

    thread
    Runnalbe
    
> sleep()和 wait()
    
    a、sleep是让当前线程指定休眠时间，然后继续工作  不释放锁
      b、让当前线程wait则是等待，直到有线程通知notify（）唤醒他才会重新工作。释放锁

> 数组   链表

    存储区间是连续的，占用内存严重，故空间复杂的很大
    特点：寻址容易，插入和删除困难
    
    
    物理存储单元上非连续、非顺序的存储结构
    在插入的时候可以达到O(1)的复杂度
    空间复杂度很小
    时间复杂度很大
    
> 什么是哈希表

    一种寻址容易，插入删除也容易的数据结构
    
    实现：
        拉链法 链表的数组
        
        
> ArrayList底层实现方式

    通过数组实现，数组初始化长度为10
    
    增加的元素个数超过了10个
    新生成一个数组
    长度为原数组的1.5倍+1
    扩容数组调用的方法 Arrays.copyOf(objArr, objArr.length + 1);
    
> LinkedList

    LinkedList底层的数据结构是基于双向循环链表的，且头结点中不存放数据
    
    节点  节点实例保存业务数据，前一个节点的位置信息和后一个节点位置信息
    
    
    
> HashMap底层实现方式

    数组+链表
    key的hash值%Entry[].length 得到下标
    

> ArrayList 和 Vector 

    有序集合
    
    Vector 是线程安全的
    
    Vector 默认增长为原来两倍
    
    ArrayList 增长为原来的1.5倍
    

> hashMap 和 Hashtable 的区别

    hashmap
        线程不安全
        允许有null的键和值
        效率高
        containsvalue和containsKey方法
        map interface 的一个实现
        是Hashtable的轻量级实现
        
    hashtable
        线程安全
        不允许有null的键和值
        效率稍低
        Synchronize的
        有contains方法方法
        Hashtable 继承于Dictionary 类
        Hashtable 比HashMap 要旧
        
        

> List 和Set、Map

    Java中的集合包括三大类，Set、List\Map
    
    Set 实现类能对集合中的对象按特定方式排序 ( eg: treeSet)
    
    List中的对象按照索引位置排序
    
    Map    
        
        
> List、Map、Set 三个接口

    list：存储： 有序的 可重复的
    
    set：存储：无序的 不重复的
    
    key值 是无序，不重复的。value值可重复
    
    
> contains（）方法判断是否包含该元素



## HashMap是在bucket中储存键对象和值对象

    作为Map.Entry
    
    
    rehashing
    
    
> 为什么String, Integer这样的wrapper类适合作为键

> 我们可以使用自定义的对象作为键吗？

    只要它遵守了equals()和hashCode()方法的定义规则，并且当对象插入到Map中之后将不会再改变了
    
> 使用ConcurrentHashMap来代替Hashtable吗？

    ConcurrentHashMap当然可以代替HashTable，但是HashTable提供更强的线程安全性。
    
    
    
>  Java里面的容器

    Map和Collection
    
> Iterator

    可以一个一个地获取集合中的元素
    
> ArrayList和LinkedList

    要快速获取一个值时,用ArrayList,用于顺序插入操作时,用LinkedList
    
> HashSet和TreeSet有什么区别

    HashSet中的元素不能重复,没有顺序
    TreeSet中的元素不能重复,但有顺序
    当集合中的元素需要排序时,用TreeSet


> ArrayList集合加入1万条数据，应该怎么提高效率
    
    实现不扩容,就提高了性能 指定容量
    
  
  
  
  
> Xml与JSON区别

    xml是重量级、json是轻量级
    
    json常用解析方法 gson、jsonobject、jackson
    
    xml dom sax pull 
    
    
    
> TCP与UDP区别

    udp:  
        a、是面向无连接, 将数据及源的封装成数据包中,不需要建立建立连接
        b、每个数据报的大小在限制64k内
        c、因无连接,是不可靠协议
        d、不需要建立连接,速度快
        
    tcp：  
        a、建议连接，形成传输数据的通道.
        b、在连接中进行大数据量传输，以字节流方式
        c 通过三次握手完成连接,是可靠协议
        d 必须建立连接m效率会稍低
        
        
> 说说三次握手

    第一次握手：
        建立连接时，客户端A发送SYN包（SYN=j）到服务器B，并进入SYN_SEND状态，等待服务器B确认。
    第二次握手：
        服务器B收到SYN包，必须确认客户A的SYN（ACK=j+1），同时自己也发送一个SYN包（SYN=k），即SYN+ACK包，
        此时服务器B进入SYN_RECV状态。 
    第三次握手：
        客户端A收到服务器B的SYN＋ACK包，向服务器B发送确认包ACK（ACK=k+1），
        此包发送完毕，客户端A和服务器B进入ESTABLISHED状态，完成三次握手。
        
        
        

> 什么是Webserivce

> WebService实现原理是？
    
    HTTP协议+XML
    
> 什么是Http协议无状态协议？怎么解决Http协议无状态协议

    对于事务处理没有记忆能力。后续处理需要前面的信息
    
    通过1、Cookie 2、通过Session会话保存。
    
> Http协议中302状态

    302表示重定向。
    
    服务器返回的头部信息中会包含一个 Location 字段，内容是重定向到的url
    

> Http协议中Http1.0与1.1区别

    在http1.0中，当建立连接后，发送一个请求，返回一个信息后就关闭连接
    
    在http1.1中，引入了持续连接的概念
    
> Http协议实现原理机制

    解析域名
    tcp 三次握手
    http请求
    响应 http请求
    浏览器 解析 html 代码 并请求资源
    浏览器 渲染资源
    
    
    域名解析过程
        浏览器搜索自身 dns缓存
        搜索 操作系统 dns缓存
        读取hosts 文件
        本地 dns服务器发起解析请求
        
        
        
> get与post请求区别

    get重点在从服务器上获取资源，post重点在向服务器发送数据；
    
    get传输数据是通过URL请求
    
    post传输数据通过Http的post机制，将字段与对应值封存在请求实体中发送给服务器
    
    Get传输的数据量小，因为受URL长度限制，但效率较高
    
    get是不安全的，因为URL是可见的
    
    get方式只能支持ASCII字符，向服务器传的中文字符可能会乱码。
    post支持标准字符集，可以正确传递中文字符。
    
    常见Http协议状态？
    
        200：请求被正常处理
        204：请求被受理但没有资源可以返回
        206：客户端只是请求资源的一部分，服务器只对请求的部分资源执行GET方法，相应报文中通过Content-Range指定范围的资源。
        301：永久性重定向
        302：临时重定向
        303：与302状态码有相似功能，只是它希望客户端在请求一个URI的时候，能通过GET方法重定向到另一个URI上
        304：发送附带条件的请求时，条件不满足时返回，与重定向无关
        307：临时重定向，与302类似，只是强制要求使用POST方法
        400：请求报文语法有误，服务器无法识别
        401：请求需要认证
        403：请求的对应资源禁止被访问
        404：服务器无法找到对应资源
        500：服务器内部错误
        503：服务器正忙


> Http优化

    利用负载均衡优化和加速HTTP应用
    利用HTTP Cache来优化网站


    get的数据大小有限制4k
    
    
    
> Jsp和servlet的区别

    jsp的可读性强，容易维护，并且jsp在最后会编译成servlet
    servlet容易调试


> Spring的底层实现机制

    使用Demo4j（解析XML）+Java反射机制
    
    
    
> Mybatis



    
    
    
    


    
    


    
    
    

    
        
        


    

    


    
    