        
#docker swarm

    集群 部署
    
##

    基础 服务器 搭建
    // 
    安装docker
    
    
## swarm 集群

    管理节点
    工作节点
    
    docker swarm --help
    
    // init join leave lock update
    
> 配置

    docker swarm init --help
    // 配置 工作 节点
    docker swarm init --advertise-addr ip
    
    // 加入一个节点
    docker swarm join
    
    // 创建一个 节点 令牌
    // 主节点 
    docker swarm join-token manager
    // 工作节点
    docker swarm join-token worker
            
    查看 节点
    docker node ls
    
    
## raft 一致性协议

    保证 大多数节点 存活才可用 >1
    
    leader 挂掉 ， 会 重新选举 即使上线
    
    要保证 主节点 数量 >=3
    保证 存活 > 1 才可用
    
## 弹性 / 扩缩容 / 集群

    集群 swarm docker service
    
    容器 -> 服务 -> 副本
    
> redis 服务  -> 10个 20 个 副本 （弹性 ）

    创建 ， 动态扩展 动态更新
    
    灰度发布
    
    
    // 创建 服务 （docker run 不具有 扩缩容）
    docker service --help
    docker service create --help
    
    docker service create -p 8888:80 --name nginx-1 nginx // 创建 一个 服务
    
    
    docker service inspact nginx-1 // 查看信息
    
    // 开启 服务后 会随机分布到一个 节点上 
    
    
    // 动态 扩缩容 update
    docker service update --replicas 5 nginx-1
    // 在任意一个集器 都可以 访问 到 服务 
    // 集群就是一个整体
    
    
    // 动态 回滚
        docker service update --replicas 1 nginx-1

    //服务高可用 // 服务器 高可用
    
    
    // 扩缩容 方式 2
    // 与 update 一样 
    docker service scale --help
    // -d
    docker service scale nginx-1=5
    docker service scale nginx-1=1
    
    // 删掉 服务
    docker service rm nginx-1
    
    
## 


    swarm 集群 管理
    node docker 节点 多个节点 组成一个 网络
    service 在管理 或者 工作节点运行 ， 核心操作
    
    task 容器内命令 (副本)    
    
    --mode // 调整 副本以什么 方式 启动 // worker 还是 master
    
    
    
> docker stack 
    
    docker-compose // 单机部署
    docker stack 集群部署
    
    docker stack deploy file.yml
   
> docker secret    

    安全 配置密码 整数

> docker config    