

> 查找 文本 按下/ 
    然后输入查找的字符串 回车ok

# shell 脚本

## 什么是shell

    shell 是一个程序， 采用C语言编写， user 与linux沟通的桥梁
    kernel -> shell -> user
    
## shell 可以做什么
    
 - 命令解释
 
 - 启动程序
 
 - 输入输出 重定向
 
 - 管道连接
 
 - 文件名置换
 
 - 变量维护
 
 - 环境控制

 - 数学计算
 
 - shell编程
 
    
## shell hello world 

    `echo`
    echo "hello world"
    打印 hello world
    
    管道 替换
    echo "hello world"|sed 's/world/亲亲/'    
    
    打印用户
    echo $user
    
    
## shell 就是 将一系列命令 写入文本中 然后按照先后顺序执行

    linux 中没有扩展名的概念
    
### demo 安装 nginx 步骤

```

vim shell_demo.sh

yum -y install wget gcc pcre-devel zlib-devel
wget //nginx
tar xf nginx-...
cd nginx
./configure --profix=/user/... // 安装目录
make
make install

```
`然后给予权限`
    
    chmod 700 shell_demo.sh # 执行权限
    
    // 注意 不要滥用777
    
    ./shell_demo.sh
    // 执行
    

## shell 语法规范
    
    命名规范 ， 建议 sh结尾 （linux 文件 没有扩展名概念）
    // 必须指定 运行环境声明 （解释器位置）
    #!/usr/bin/bash (使用which bash 查找目录)
    shell 注释 使用 #
    # 执行脚本 不许有中文 // 防止出问题
    #！是特例 组合 // 有其意义
    
    // 还可以加上
    # author
    # date time
    # script description : 描述
    
### 如何运行

    1、给予执行权限 chmod 700 ./执行
    2、使用解释器 直接运行，不需要权限 bash或者sh 都可以 建议 bash
    
## shell 特殊符号

    ~ root目录
    - 上次目录
    ！ 执行历史命令 !! 执行上一次命令 history 查看历史命令 !行号 执行历史命令
    $ 取得变量内容
    + - * / % 数学四则运算
    & 后台执行
    * 通配符
    ? 匹配一个字符
    ; 在一行中执行多个命令使用;
    | 管道 比如 上一个 命令输出作为下一个 命令输入 ps-aux|grep nginx
    \ 转义字符
    `` 反引号 在命令中 执行命令 echo "date is : `date + %F`"  不解析$ 要使用 "" 或者 ''''
    "" 双引号 字符
    
## shell 管道
    
    上一个输出 下一个输入
    grep 检索
    ps -aux | grep tomcat 
    
## 重定向
    
    > 输入 （一次性，之前的会被清除） // 输入到某个地方
    >> 输入追加
    < 输出 
    << 追加输出 比如 磁盘？
        eg:
            vim shell_demo2.sh
            #!/usr/bin/bash
            @author : hjc
            @date : 2020
            @description : free
            
            fdisk /dev/sdb <<EOF
            n   #命令
            p
            3
            
            +500M # 加
            w # 保存
            EOF #结束
            
## 数学运算
    
    expr 做简单数学运算 （注意空格） （整数）
    * 需要转义 \*
    expr 1 + 2 &> /dev/null ; echo $?
    
    // 
    可以进行浮点运算
    bc
    echo "scale=2;100/3"|bc // scale 表示保留小数点
    echo "`echo "scale=2;100/3"|bc `%"
    
    双括号运算也可以
    （（））
    echo $((100 * 3))
    echo $((100 ** 3)) // 次方
    
## 退出脚本

    exit  可以带一个返回值 0-255
    exit 1
    
    
## shell 格式化 输出

    echo 输出 在末尾 自动换行
    //
    参数 命令
    -n 取消 末尾换行
    -e 转义字符
        \a // 发出警告声音 嘟嘟嘟嘟嘟~~
        \b 删除前一个字符
        \t 制表符
        \c 最后不加上 换行 
        \f 换行光标不移动
        \n 换行 关标移动
        \r 光标移动到首 不换行
        \v 同\f
        \nnn 八进制代表的 ASCII 字符
        
        
> 颜色 输出

    echo -e // 需要转义
    
    // 格式
    
    echo -e "\033[字体背景颜色；文字颜色m 字符串\033[0m"
    echo -e "\033[40；36m 字符串\033[0m"
    
    //字体颜色
    30-37
    // 背景颜色
    40-47
    
    \033[0m 字体效果
    0m 关闭所有
    1m 设置高度
    4m 下划线
    5m 闪烁
    7m 反显
    8m 消隐
    
    // 还有光标前景
    
    
## shell 程序交互

    clear   清屏

    // shell 基本输入
    
> read

    接收键盘输入 回车符代表结束
    
    // 命令
    -p  // 打印 提示信息 （read + echo）  // read -p "login" user
    -t // 限时输入 // 超时 退出
    -s // 不显示输入选项
    -n // 限制 输入长度
    
    
    read 变量名 // 将读到数据从内存放到 变量中
    
    
## 变量

> 补充 32位 计算机4G内存 2^32 64位 2^48 还有12位保留 最小 单位是b // 分成1b 1b 的块

    linux c环境 使用
    gcc a.c -o a // 编译
    使用 ./a
    
> 变量类型

    格式 变量名=值
    变量名 和 值之间不可以 有空格
    
    
    本地变量 只能本地用户使用 家目录下 .bash_profile \ .bashrc 目录
    全局变量 /etc/profile \ /ect/bashrc 目录下
    自定义变量 //脚本中的变量
    临时变量  控制台中 变量 // 退出终端就没有啦~
    
    
    字符串变量 使用 "" 或者 '' 包围起来
    可以使用下划线开头
    不可以是中文
    
    取消变量名 
    unset
    
    
    在家目录下的变量生效 source ~/.bash_profile 
    //去加载家目录下的私有变量保存 


    全局变量 前面需要 加上 export  // 就可以所有用户访问了
    
    
## 数组

    数组之间使用 （）
    arr=(1 2 3 4 5)    
    
    数组使用 ${arr[下标]}
    
    // 
    数组赋值
    arr[4] = 6
    
    
    // 查看数组
    declare -a 查看系统所有声明的数组
    
    arr[@] // 访问所有元素
    
    #arr[@] // 统计数组中多少元素
    
    !arr[@] // 得到索引
    
    arr[@]:1 // 从第一个开始访问
    arr[@]:1：2 // 从第一个开始访问，总共访问俩
    
    
> 关联数组

    用户可以自定义索引 // 类似map k v
    
    
    声明一个关联数组
    
    declare -A arr
    
    // 赋值
    arr([name]="3" [age]=11)
    或者 
    arr[name]="3"
    
        
#### demo

> 倒计时 demo

    for time in `seq 9 -1 0` ; do
    echo -n -e "\b$time"
    sleep
    done
    echo       
    
    
## shell 比较运算 流程控制


    使用 test 判断
    
    // 或者
    
    使用 if 判断

> 运算符 

    -eq 等于 
    -gt 大于
    -lt 小于
    -ge 大于等于
    -le 小于等于
    -ne 不等于
    
    // shell 判断 返回 0 or 其他值 // 0为 真 其他假
    
    test 1 -eq 1; echo $?           // 使用test 判断
    
    shell 对小数点不太友好 可以使用cut 截取
    eg:
    test `echo "1.5*10"|bc|cut -d '.' -f1` -eq 20; echo $?
    
    -f1 // 分割的 只需要第一个值   
    // 小数需要处理 
    
    
> 文件类型 比较运算
    
    -d 文件是否存在 且是否未目录 
    -e 文件是否存在                   // 文件 或者 目录
    -f 文件存在 且未文件
    -r 存在 且 可读
    -s 存在 且 不为空
    -w 存在 且 可写
    -x 存在 且 可执行
    -o 存在 且 当前用户 是否拥有
    -G 存在 且 为当前用户拥有
    file1 -nt file2  检查file1 是否比 file2 新
    file1 -ot file2  检查file1 是否比 file2 旧
    
    // 注意 root 用户 的权限 // 特殊
    
    // 给文件 添加权限
    //
    chmod o+w files
    
    
    
>  字符串比较运算

    ==
    !=
    -n  // 字符串长度 是否大于零
    -z  // 字符串长度是否为0
    
    
    test -z ""; echo $?
    
    
> 逻辑运算

    //if 支持

    &&
    ||
    ！
    
    eg: 
        if [1 -eq 1] && [2 -eq 2 ];then echo "1" ;else echo "2";fi
        
        
> if 运算

    运算 
    
    if []
        then
            pass
            exit 1  # 退出脚本
    fi
    
    if []
        then
            pass
            exit 1  # 退出脚本
        else
            pass
            
    fi
    
    可以在 if 条件表达式 中植入  （数学运算）    (())
    
    if (( 100%3+1 >10 )); then echo "1" fi
    
    [[]] 可以做 字符串 条件匹配
    
    for i in r1 r2 r3 rr rr4
        do
            if [[ $i == r* ]] ;then
                echo $i
            fi
    done        
            
            
            
> for 循环

    // seq跟 .. 差不多
    seq 1 9
    seq 9 -1 0
    seq 9 -2 0


    语法: 
    
    // foreach
    for var in v1 v2 v3 v4..
        do
            pass
    done
    
    //条件
    for ((i=1 ;i<10;i++))
        do  
            echo $i
    done


    死循环
    for((;;))
        do
        
    done
    
> 条件退出
    
    ping 判断主机存活
    ping -c1 $1 &>/dev/null
    if [$? -eq 0]
        echo "date: `data + "%F %H:%M:%S"` : $1 is \033[32m UP \033[0m"      
    fi
    
    // 跳过本次迭代
    continue
    
    // 跳出循环
    break 
    break 2 // 双层循环 跳出外循环
    
    
> while

    语法格式
        
        while [条件]
            do
            
            done
            
    eg:
    while [! -p /temp/demp ]
        do
            echo "111"
    done
    
    while [$m -lt 1000 ] || [$c -lt 1] 
        do
            echo "fail ->"
    done            
    
> 封装起来

    m1() {
        while......
    }
    
    // 调用
    m1()
    

> case 语句

    
    语法结构
        
        case 变量 in
            条件1）
                pass
            ;;
            条件2）
                pass
            ;;
            条件3）
                pass
            ;;
            .....
            *)              //其他匹配
                pass
            ;;
        esac    
        


## 函数

    语法格式
    函数名 () {
        代码块
        
        return N
    }
    
    第二种
    fuction name {
        
        return N
    }            
    
    // shell 中
    return 意义不大
    
    
    // 函数 没有 调用 是不会执行的
    
    调用函数
    直接调用 name 就可以拉~~
    m1
    
### Demo

> nginx 启动脚本

    nginx_install_doc=/usr/lcoal/nginx
    nginxd=$nginx_install_doc/sbin/nginx
    pid_file=$nginx_install_doc/lgos/nginx.pid
    proc=nginx

    # 系统函数库
    if [-f /etc/init.d/functions ];then
        . /etc/init.d/functions
    else
        echo "not found init.d/functions in /etc/init.d/functions"
        exit
    fi
    
    # 判断 nginx 是否启动
    if [ -f $pid_file ];then
        nginx_process_id=`cat $pid_file`
        nginx_process_num=`ps -aux|grep $nginx_process_id|grep -v "grep"|wc -l`
    fi
        
    start () {
        
        if [ -f $pid_file ] && [ $nginx_process_num -ge 1 ] ;then
            echo "nginx running.."
        else
            if [ 0f $pid_file ] && [ $nginx_process_num -lt 1 ] ;then
                rm -f $pid_file
                # 函数库 里面的 执行
                # action 也可以
                daemon $nginxd
            fi
            daemon $nginxd
        fi        
    }
    
    stop () {
        if [ -f $pid_file ] && [ $nginx_process_num -ge 1 ] ;then
            action "nginx stop" killall -s QUIT $proc
            rm -f $pid_file
        else
            # kill 会报一个 没找到进程错误 ，直接重定向输出放垃圾堆
            echo "stop fail" killall -s QUIT $proc 2>/dev/null  
        fi
    }     
    
    resart () {
         stop
         sleep 2
         start
    }
    
    reload () {
        if [ -f $pid_file ] && [ $nginx_process_num -ge 1 ] ;then
            action "nginx reload ->" killall -s HUP $proc
        else
            # reload HUP killall md
            action "nginx reload ->" killall -s HUP $proc 2>/dev/null
        fi        
    }
    
    status () {
        if [ -f $pid_file ] && [ $nginx_process_num -ge 1 ] ;then
            echo "nginx running..."
        else
            echo "nginx stop..."
        fi
    }
    
    # 接收第一个参数
    case $1 in
        start) start ;;
        stop) stop ;;
        resart) resart ;;
        reload) reload ;;
        status) status ;;
        *) echo "USAGE: $0 start|stop|resart|reload|status"
    easc


    // 测试 
    sh demo.sh start // start 参数
    
    
    
    
## 正则表达式

> 定位符
 
    ^ // ^a开头
    $ // c$结尾
    
    
> 匹配符
    
    . //匹配除回车任意一个字符
    
    []  // 匹配一个 // 可以指定范围 [^  ] 取反
    
    \ 转义字符
    | 管道 // 或的意思
    a|b //a 或者b
    
    () // 字符串分组
    
> 限定符

    * // 某个字符 出现0次或者多次 a*
    
    ? // 某个字符 出现0次或者1次
    
    + // 出现 1次 或者 多次
    
    {n,m} // 最少n次 最多m次
    
    {m} // 正好出现m次
    
    
    
> posix 特殊字符

    [:alnum:]       匹配 0-9a-zA-X
    
    [:alpha:]       匹配任意字母
    
    [:digit:]       数字0-9
    
    [:graph:]       非空字符

    [:lower:]       小写

    [:upper:]       大写

    [:cntrl:]       控制字符

    [:print:]       非空 包括空格

    [:punct:]       标点符号

    [:blank:]       空格和tab

    [:xdigit:]      16进制数字

    [:space:]       所有空白字符 新行 空格 制表


    //eg:
        ^a[[:alnum:]]c$  // 注意[] 里面不能有空格   
        
        
        
## shell 操作 文件

    sed //命令 //shell操作文本
    
    sed 是一个行编辑器 // 一次处理一行的数据
    
    原理：
    
    文本行 -> 缓存 （sed处理） -> 打印到屏幕
    
    语法：
    sed option '{操作}[标记]' [文件名]
    
    -e          将文件中指定命令添加到处理输入执行的命令 ，多条件
    -f          将文件中指定命令添加到处理输入执行的命令
    -n          抑制自动输出
    -i          编辑文件
    -i.bak      修改时创建备份
    -r          正则
    !           取反
    
    操作命令
    a   后面添加
    i   前面添加
    p   打印
    d   删除
    s   查找替换
    c   更改
    y   转换 N P O
    
    标记命令
    
    数字 //新文本替换的模式
    g   //新闻本替换所有匹配
    p   //打印原始数据
    w fileName: //替换结果输入到新文件       
    
    eg:
    sed 'ahello world' file //第一个字符是命令 // 后面的后在每一行处理
    sed '3ahello world' file //第一个字符是命令 // 在第三行处理
    sed '1,3ahello world' file //第一个字符是命令 // 在1-3处理
    
    
    sed '/3 demo/a\hello world' file //匹配模式  '//' 匹配模式 /3 demo/ 行号 匹配 
    
    //操作的是内存中的数据 // 文件没改
    
    eg:
    sed -r '/^#/d' file         // 匹配删除
    
    sed 'y/abc/xyz/' file       // abc 转换为 xyz
    
    sed 's/dog/cat' file        // 替换
    
    sed -e 's/green/red/;s/dog/cat/' file   // 多条件 // 可以写入文件中 
    //  执行文件
    se'd -f fileScript file         //
    
    sed -i '/s/dog/cat/g' file      // 修改文件 // 不可逆
    // 建议备份原文件
    send -i.bak 's/dog/cat/g' file //
    
    
    
    // 使用管道
    echo "hello qianmuna "|sed 's/hello/world/g'
    
    
    eg：
    统计文本有多少行
    sed -n '$=' file
    
    正则匹配
    send -n -r '/^(root)(.*)(bash)$/p' file
    
    
## awk 处理数据

    
        
    
    
    
    
    
     
    
    
    
    
    


    
