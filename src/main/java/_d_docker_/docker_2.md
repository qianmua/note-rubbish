
# docker 二

    docker compose
    docker swarm
    docker stack
    docker secret
    docker config

## docker compose
    
    projiect    
    dockerFile
    dockerFile build run 单个容器
    
    依赖 麻烦
    
> docker compose 管理容器 ， 定义运行多个容器

    使用 yaml 文件 配置 应用
    
    1、在dockerFile 定义 应用环境 保证 可以运行
    2、定义 services 在 docker-compose.yml 文件
    3、docker-compose up  // 运行 应用
    
    // 批量容器 编排
    
    
> compose
    
    service 容器 应用
    project 关联 容器， 类似 maven pom 
    
    就是 把 一个 项目 中的 多个 子项目 编排
    
> 安装

    // 下载 安装    

    curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

    // 慢 换源 // 
    
    // 授权
    chmod +x docker-compose
    
> 开始体验    
    
    // base dockerFile
    
    vim docker-compose.yml
    
    version: ''
    service:
        web:
            # 自己 build 镜像
            build: .
            ports:
                - "5000:5000"
        # 拉取 镜像    
        redis:
            image: "redis:alpine"
    
    
    然后 启动
    docker-compose up .
    
    
    /////////////////////////////////
    应用
    dockerfile  (单机)
    docker-compose yml 整合 服务需要的环境 （完整上线 服务）
    up
    
    默认 服务名
    fileName_服务名_num
    hello_web_1
    hello_web_2
    hello_redis_1
    
    // 服务器 集群
    // 副本 数量
    
    // 会创建出一个 网络
    docker network
    打通对内的网络
    
    
    stop
    down 停止
    
> yml 规则

    



        
        
## docker swarm

    集群 部署
