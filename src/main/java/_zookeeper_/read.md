

# zookeeper 学习笔记

    zookeeper 负责集中维护配置信息的服务
    
- 命名服务
- 配置管理
- 集群管理
- 分布式锁
- 队列管理

## 特点

    核心是一个精简的文件系统 ， 支持一些操作（排序，通知。。）
    
    可以实现 比如分布式队列，分布式锁，leader 选举等操作
    
    支持集群模式，高可用
    
    松耦合式交互
    
    
## zk
    
    文件系统
    通知机制
    
> 文件系统

    每个子目录 (eg: /spring) 都被成为 znode ， 可以自由增删改
    znode 可以储存数据
    
    znode 类型
    
- PERSISTENT    持久化目录节点 
- PERSISTENT_SEQUENTIAL 持久化顺序编号目录节点 
- EPHEMERAL 临时目录节点 
- EPHEMERAL_SEQUENTIAL 临时顺序编号目录节点 

    /
        /NameService
            /server1
            /server2
            
        /configuration
        /groupMembers
            /m1
            /m2
        /apps
            /app1
            /app2
            /app3
                /subApp1
                /subApp2
                
                
## zookeeper 通知机制

    客户端注册监听他关心的节点
    变化时会通知客户端
    
## zk 命名服务

    zk文件系统里面的目录 即唯一的path 无法找到机器时，可以通过约定的path 互相探索发现
    
## 配置管理

## 集群

    集群管理 两点 ： 机器加入，退出 ， 选举master
    
    文件 临时 通知
    
    master 选举 每次选择编号最小得机器作为master        
    
    
## zk 分布式锁

    zk 的一致性文件系统    
    锁：
        独占锁     znode
        控制时序    在独占锁下创建临时顺序编号目录 ， 与选举master一样 编号最小的 获得锁， 用完删除
        
## zk 队列管理

    同步队列 （一个队列所有成员聚齐才可以用，否则一直等待）       
    
    FIFO 方式 队列
    

## zk 角色

    leader
        负责人发起投票和决议， 更新系统状态
    learner
        followeer 接收客户端请求，并向客户端返回结果 ， 参与投票
        obServer 接收客户端连接，写请求转发给leader ， 不参加投票，只同步leader状态
    
    client  发起请求    
        
## zk

- 最终一致性         不管client 连接到那个server ， 数据视图都是一样的
- 可靠性             消息被一台服务器接收，它将被所有服务器接收  
- 实时性             
- 等待无关           慢的或失效的client 不可干预快速的client的请求
- 原子性             更新只可以成功或者失败
- 顺序性             



## 工作原理

    核心是原子广播
    
    保证各个server之间的同步， 实现机制的协议叫做Zab 协议
    
> zab 两种 模式

    恢复模式    选主
    广播模式    同步

    保证事务的一致性 采用递增的事务id号（zxid）
    
> server 状态

    LOOKING 正在查找leader
    LEADING 当前server为leader
    FOLLOWING 同步        
    

## zk 选举 leader

    zk 进入恢复模式 选举一个新的leader
    
    选举算法 basic paxos / fast paxos （默认）
    
    
> fast paxos

    某Server首先向所有Server提议自己要成为leader，
    当其它Server收到提议以后，
    解决epoch和 zxid的冲突，并接受对方的提议，
    然后向对方发送接受提议完成的消息，重复这个流程，最后一定能选举出Leader    
    
## Zookeeper同步流程

    Leader等待server连接
    Follower连接leader，将最大的zxid发送给leader
    Leader根据follower的zxid确定同步点 
    完成同步后通知follower 已经成为uptodate状态
    Follower收到uptodate消息后，可以重新接受client的请求进行服务
    
    
## leader 工作

    恢复数据
    维持与learner 心跳 ，并接受请求
    learner 消息类型 （PING ， REQUEST ， ACK ， REVALIDATE）
        PING leader心跳
        REQUEST follower发送的提议信息
        ACK 对follower 的回复 ， 过半数通过 则 commit
        REVALIDATE 延长 session有效期
        
        
## follower 工作

    向leader 发送请求
    接收leader 消息
    接收client 请求，写请求发送给leader 投票
    返回 client结果
    
    来自leader的 消息类型
    
    PING        心跳消息
    PROPOSAL    leader提案，需要投票
    COMMIT      服务端最新一次提案的信息
    UPTODATE    同步完成
    REVALIDATE      
    SYNC        返回sync结果
    
    
## docker 安装 zookeeper
    
    docker pull zookeeper
    
    run：
    docker run -p 2181：2181 zookeeper
    
    
## 基本命令
    
    查看server运行状态
    ./zKserver.sh status
    
    客户端连接服务器
    ./zKCli.sh
    
    
> 获取 节点数据
 
    get /zookeeper
    
> 获取节点更新信息
 
    stat .zookeeper
    
> 创建节点
 
    create -s(-e) path data acl // -s   创建顺序节点 -e 创建临时节点
    create /spring hello
    // 查看信息
    get /spring
    
    
> 修改节点
 
    set path data [version]
    set /spring spring-v1
    此时 dataVersion 会变为1
    
> 删除节点
  
    delete path [version]
    delete /path
    
> 设置watch 事件

    stat path [watch]
    stat spring/bootx watch
    // 没有节点报错
    create /spring/bootx bootx
    
    
    get path [warch]    
    get /spring/booty watch
    
    set /spring/booty new-boot-y
    
    
    
## ACL 权限

    zk 节点有五种
    create
    read
    write
    delete  
    admin
    
    delete 指对子节点删除
    其他都是自身节点
    
> 身份认证 方式

    world   默认全部
    auth    需要通过认证 才可以访问
    digest  用户名：密码 方式认证
    ip      使用 ip 地址认证
    


## zk 四字命令

    大多是查询命令

    conf    输出相关配置信息
    cons    列出所有连接到客户端的详细信息
    dump    列出未经过处理 的会话和临时节点
    envi    列出古纳于服务器配置信息
    reqs    列出未处理请求
    rouk    测试服务器是否处于正确状态
    stat    列出关于性能和连接的客户端列表
    wchs    列出服务去 watch详细信息
    wchc    通过session 列出
    wchp    通过路径列出
    
    
> 用法

    可以同过telnet 或者 nc 向 zk 传递数据
    
    
    echo stat | nc 127.0.0.1:2181
    