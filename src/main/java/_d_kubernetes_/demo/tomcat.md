

## k8s 集群部署tomcat

    创建一个deployment 镜像是tomcat9.0.37

`kubectl create deployment tomcat9 --image=tomcat:9.0.37-jre8`

    kubectl get all 得到所有资源
    其中会有 pod/tomcat9-id
    还有一个service
    还有一个 deployment.apps/tomcat9 
    启动成功就会有一个 ready
    
    
    kubectl get pods -o wide
    找到部署所在的节点
    
    在节点可以 docker ps 查看
    
    kubectl get pods 在master查看
    
### 暴露端口 

    service (暴露端口)
    pod （包含多个容器）
    
    service 接收到暴露端口
    转发给pod
    pod 在处理
    
`kubectl expose deployment tomcat9 --port=80 --target-port=8080 --type=NodePort`

    service/tomcat9 exposed
    
    暴露一个service 端口
    
`kubectl get svc`


### 动态扩容

    kubectl get deployment 
    升级 kubectl set image
    
    扩容 
    kubectl scale --replicas=3 deployment tomcat9
    
    减少
    kubectl scale --replicas=1 deployment tomcat9
    
### 删除

    kubectl delete deployment.app/tomcat9    
    kubectl delete service/tomcat9    
    
    