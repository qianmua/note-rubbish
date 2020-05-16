package _d_docker_;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/16
 * @time 19:04
 */
public class Main {

    /*
    * docker 容器化
    * 容器之间是相互隔离的， 每个容器 之间 都有自己的文件系统 互不影响
    *
    * docker 基本组成
    * 镜像 image 相当一个模板，通过镜像可以创建多个容器提供服务
    * 容器 container  通过镜像创建，独立运行多个应用
    * 仓库 repository 存放镜像的 公有，私有
    *
    * 安装docker
    * 系统内核版本 uname -r
    * 系统版本 cat /etc/os-release
    *
    * 基本环境
    * yum install -y yum-utils
    * 设置镜像仓库
    * yum-config-manager \
    *   --add-repo \
    *   https://dow.....阿里镜像
    * 安装
    * yum install docker-ce docker-ce-cli containerd.io
    * 启动
    * systemctl start docker
    *
    * //测试
    * docker version
    *
    * hello world
    * docker run hello-world
    *
    * 查看镜像
    * docker images
    *
    * 卸载docker
    * yum remove docker-ce docker-ce-cli containerd.io
    * // docker 默认工作路径
    * rm -rf /var/lib/docker
    *
    * 配置 镜像加速器
    * 　在/etc/docker目录下找到在daemon.json文件（没有就新建），将下面内容写入
    *   "registry-mirrors": ["https://xxxxxxx.mirror.aliyuncs.com"]   //这里输入阿里给你分配到的镜像url
    * 然后重启镜像 重启docker
    *
    * run 流程
    * run ——》 在本机寻找镜像 ——》 有就运行 没有就去下载（没有就报错） 然后运行
    *
    * 怎么工作？
    * docker 是 c/s结构的 docker守护线程运行在主机
    * 通过socket 从客户端访问
    * docker server 接受到client命令 然后去执行
    *
    * docker 比vm快？
    * 1、docker 比虚拟机有更少的抽象层
    * 2、docker 用的是宿主机的内核 vm是模拟的内核
    *
    * 命令
    *
    * 帮助命令
    * docker info //docker系统信息
    * docker version
    * docker --help
    *
    * 镜像命令
    * docker images (docker images --help)
    * 解释 镜像仓库源 标签 id 创建时间 镜像大小
    * docker images -a 显示所有
    * docker images -q 只显示id
    * docker images -aq 如上
    *
    * docker search mysql // 搜索镜像
    *
    * docker pull mysql //下载镜像 默认最新
    * docker pull mysql:8.0 //按版本下载
    * 包含 分层下载（可以公用，有新的版本只下载不同的就行了，公用的，节省） images核心 联合文件系统 签名 真实地址
    *
    * docker rmi -f <id><name>  //删除镜像
    * 批量删除
    * docker rmi -f $(docker images -aq) //$ 跟sql查询差不多
    *
    *
    * 容器命令
    * 镜像创建容器
    *
    * docker run [参数] image
    * 参数
    * --name 容器名
    * -d 后台命令
    * -i -t   -it  交互方式运行 进入容器查看
    * -p 指定容器端口
    *   -p 主机端口：容器端口
    *   -p 容器端口，不可以外网访问
    * -P 随机端口
    *
    * docker ps 查看正在运行的容器
    * docker ps -a 查看所有 包括历史
    * docker ps -a -n=1 查看最近创建的一个容器
    *
    * 退出
    * exit 退出后容器停止
    * ctrl + p + q 退出后不停止
    *
    * 移除容器
    * docker rm 容器id  正在运行的容器请 rm -rf
    * docker ps -a -q|xargs docker rm 删除所有
    *
    * 启动停止容器
    * docker start mysql
    * docker restart mysql
    * docker stop mysql
    * docker kill mysql //强制停止
    *
    * 后台启动
    * docker -run -d mysql
    *
    * 查看日志
    * docker logs -tf --tail 500 容器id
    *
    *
    * 查看进程信息
    * docker top 容器id
    *
    * 查看容器元数据
    * docker inspect 容器id
    *
    *
    * 进入当前运行容器
    * docker exec -it 容器id或者名字 bash
    * docker attach 容器id 进入容器正在执行的终端 不会
    *
    * 文件拷贝
    *
    * docker cp id:容器内路径 宿柱机路径
    * 可以使用 -v 卷 打通内外部 实现同步
    *
    * docker 部署 nginx
    * pull run over
    * //容器之间端口互不影响哦
    * docker run -d --name nginx1 -p 3344:1111 nginx
    * // 就是发送个请求
    * curl localhost:3344
    *
    * docker 部署 tomcat
    * docker -it --rm tomcat：9.0 用完删除 --rm
    * docker pull tomcat：9.0
    * docker run -d -p 3355:8080 --name tomcat01 tomcat
    * 外部挂载目录
    * 打同内外部
    *
    *
    * 部署es + kibana
    * 下载并启动es
    * docker run -d --name es1 -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elstaticsearch:7.6.2
    * es 很卡的哦
    * docker stats 查看cpu状态
    * 修改配置文件 -e
    * docker run -d --name es1 -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e ES_JAVA_OPTS="-Xms64m -Xmx512m" elstaticsearch:7.6.2
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    * */

    public static void main(String[] args) {

    }
}
