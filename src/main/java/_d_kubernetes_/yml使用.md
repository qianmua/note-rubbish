
# yaml 语法

    模板
    
    apiVersion
    
    Kind (Pod Service Deployment...)
    
    Metadata (元数据 ， name ， labels )
    
    
    Spec    （规格定义 ， 容器镜像， 暴露端口..）
    
    
    
## 使用 yaml

    kuectl apply -f exp-service.yaml 使用 yaml 中创建的服务
    
    kubectl applyu -f <> .yaml .yml .json
    
> eg:

    kubectl create deployment tomcat6 --image=tomcat:9999-jar8 --dry-run -o yaml
    输出 yaml 定义的格式
    
    
    kubectl create deployment tomcat6 --image=tomcat:9999-jar8 --dry-run -o yaml > tomcat9.yml
    
    
    // 暴露nginx 
    kubectl expose deployment tomcat6 --port=80 --target-port=8080 --type=NodePort --dry-run -o yaml
    
        
        
        
## pod

    // pod yml 信息
    kubectl get pod id -o yaml
    
    
    apiVersion: v1
    Kind: Pod
    metadata:
        labels:
            app: tomcat6-new
        name: tomcat-new 
        namespace: default
    spec:
        containers:
        - image: tomcat9.0.37-jre8
          imagePullPolicy: InNotPresent
          name: tomcat6-new
        - image: nginx
          imagePullPolicy: InNotPresent
          name: nginx

    使用
        
    