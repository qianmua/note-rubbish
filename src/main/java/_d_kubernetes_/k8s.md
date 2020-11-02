

# centos7 搭建k8s 集群
## 搭建 MySQL  ES  Redis 集群

## 新的centos7 环境

    安装docker
    
`wget https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo -O/etc/yum.repos.d/docker-ce.repo`

`yum -y install docker-ce-18.06.1.ce-3.el7`

    安装完成后：
    
`systemctl enable docker`

`systemctl start docker`

    检查完成安装：
    
`docker -v`


## 安装 k8s

    添加阿里云YUM软件源
    
```
cat > /etc/yum.repos.d/kubernetes.repo << EOF
[kubernetes]
name=Kubernetes
baseurl=https://mirrors.aliyun.com/kubernetes/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=1
repo_gpgcheck=1
gpgkey=https://mirrors.aliyun.com/kubernetes/yum/doc/yum-key.gpg
https://mirrors.aliyun.com/kubernetes/yum/doc/rpm-package-key.gpg
EOF
```

### 安装kubeadm，kubelet和kubectl

> kubeadm k8s集群管理

> kubelet 集群管理的节点worker 对容器生命周期进行管理，此worker就是 kubelet

> kubectl k8s命令行工具

    yum install -y kubelet-<version> kubectl-<version> kubeadm-<version>
    
    // 版本 选择1.17.3
    
> 使用yum安装程序时，提示xxx.rpm公钥尚未安装

    使用 yum install xxx.rpm --nogpgcheck 命令格式跳过公钥检查，如下：
    
`yum install cri-tools-1.17.3-0.x86_64 --nogpgcheck`

`yum install kubectl-1.17.3-0.x86_64 --nogpgcheck`

`yum install kubeadm-1.17.3-0.x86_64 --nogpgcheck` 

    或者直接添加在 yum install -y kubelet-1.17.3 kubectl-1.17.3 kubeadm-1.17.3 --nogpgcheck
    
    
### 添加 并启动

`systemctl enable kubelet`

`systemctl start kubelet`
    
## 部署Kubernetes Master

    初始化kubeadm
    
```
kubeadm init \
--apiserver-advertise-address=192.168.38.11 \
--image-repository registry.aliyuncs.com/google_containers \
--kubernetes-version v1.17.3 \
--service-cidr=10.1.0.0/16 \
--pod-network-cidr=10.244.0.0/16


```    
    上面第一个ip 为本机公网ip
    
    是外网可能pull不下来
    可以使用 提供的images.sh 先将镜像拉取下来
    
    运行可能提示权限不足
    chmod 添加可执行权限
    chmod 700 master_images.sh
    然后 ./ 执行即可
    
### 启动成功后：

    打印相关命令：
    执行
    
```
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config　　
```    
    
    此时可以执行kubectl 相关命令
    
`kubectl get node`

`kubectl get all`

    delete 
    start 
    .....
    
    
    安装网络插件 CNI
    
`kubectl apply -f https://raw.githubusercontent.com/coreos/flannel/a70459be0084506e4ec919aa1c114638878db11b/Documentation/kube-flannel.yml
`

    已经提供 kube-flannel.yml
    使用提供的kube-flannel.yml   
    
`kubectl apply -f kube-flannel.yml`
