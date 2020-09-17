

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
    