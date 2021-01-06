

# gradle

    2002 maven  xml 繁琐
    2012 gradle 基于 groovy （支持 java groovy scala）
    

## gradle 项目目录

    src main
    src test
    
    build.gradle        配置坐标
    
    setting.gradle      gradle 配置
    
    
## groovy 简单语法 

    prinln "hello groovy" // 打印 // 可以不用； 不用 （ ）
    
    /// 定义变量
    def i = 100
    
    prinln i // def 弱类型 // 自动推断
    
    def a1 = [1,2,3,4]
    
    a1 << 5 // 添加
    
    a1.get(2) // 取出
    
    def a2 = ['k1':'v1' , 'k2': 'v2'] // 定义map      // class java linkedHashMap
    
    a2.k3 = 'v3' // 添加 // map.key
    
    a2.get("k1")
    
    //闭包 代码段
    def b1 = {
        prinln "66"
    }
    
    // 方法 需要闭包类型参数 // 不要导入包 闭包 不需要导包
    def b2(Closure c){
        c()
    }
    
    // 使用
    b2(b1)
    
    
    // 带参数 的 闭包
    def b3 = {
        v ->
            prinln("${v}")
    }
    
    def b4(Closure c){
        c("666")        // 传递 参数
    }
    
    b4(b3) // 带参数 闭包
    
    str1 = 'demo' // 定义普通字符串
    str2 = "demo ${varName}" // 可以引用变量
    str3 = '''
    
    '''     // 字符串模板
    
    
    // 调用方法时 直接 定义新的闭包作为实际参数
    
    m1{
        prinln '明'
    }
    
    m2{
        v1 -> 
            prinln "${v1}"
    }
    
    
    age = null
    age.equals(null) //return true // 空指针 处理
    
    
    
## gradle 配置

    build.gradle
    
    
    dependencies         gradle 工程的 jar包 坐标
        基本元素    group   name    version
        作用范围
        testcompile
        compile
        provided        // 编译期 
        
        
    repositories        指定所使用仓库
        mavenCentral    中央仓库 （下载到本地 .gralde 目录）
        
        
        
## 目录

    main ->
        java
        resources
        webapp          (识别为资源文件) -> gradle -> plugin 'war'
            WEB-INF
                web.xml
        
        
        
> spring 核心包

    spring-context
    spring-web
    spring-webmvc
    
    
> servlet jsp

    javax.servlet-api
    jsp-api
    
    
    
## 拆分 聚合

    settings.gradle
        incloude -> 子工程
        
    
    
    父工程 配置了 ，子工程 可以啥都不用配
    //
    只需要 配 自己 需要的 就ok
    // 
    故工程传递
    //
    
    
    项目 聚合
    ddependencies{
        作用域 project(":模块名称")
    }
    
    
## 构建脚本

    project / task
    
    project 表示 构建的整体
    
    task   project 包含多个 task 表示原子操作 -> 打包 javadoc 发布。。。。。
    
    
    task 任务动作
        dependOn
        doFitst
        dolast
        
> eg: task

    task a1 {
        prinln "666"
    }
    
    执行 a1
    task a2(dependOn 'a1'){
        //
        doFirst{
            prinln 'a2执行之前'
        }
        
        doLast{
            prinln 'a2执行之后'
        }
    }
    
    // 会在 配置 project时候 执行
    // 其他时间不会执行
    // 只有 first last 才会 在 调用 或者 构建 时执行
    // 建议 自定义任务写在 doFirst doLast 中
    
    
> 自定义 任务

    依赖 参数 dependOn
    
    // 带闭包形式
    m1{}
    //带括号形似
    m2(){}
    
    
    任务依赖 配置 dependOn
    参数
    内部
    task m3{
        dependOn 'm1'
        doFirst{}
    }
    
    dolast 简写 
    task m4 << {
    }
    
    
> 动态任务

    task {
        task"tk${v1}" << {
            prinln "is this ${v1}"
        }
    }
    
    
## 生命周期 钩子函数

>   初始化阶段

    settings.gradle 初始化 项目

>   配置阶段

    执行 build.gradle
    构造 task 关系

>   执行阶段

    执行 first 或者 last
    
### 钩子

    项目 构建之前 钩子方法
    
    setting.gradle
        
        gradle.afterProject{}
        gradle.beforeEvaluate{}
        gradle.projectEvaluated{}
        gradle.afterEvaluate{}


    build.gradle
    
        gradle.afterProject{}
        
        // 钩子 方法
    
    // 读取任务图
    
        gradle.taskGraph.whenReady{}
        gradle.taskGraph.beforeTask{}
        gradle.taskGraph.afterTask{}
        gradle.taskGraph.buildFinished{}


## 仓库

    依赖  
    compile runtime         源码依赖
    testCompile run time    测试依赖
    
    依赖配置
    compileruntime
    runtime
    testCompile
    testRuntime
    
    
    
    
    
    
        
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    