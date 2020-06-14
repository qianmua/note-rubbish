

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

    

        
#### demo

> 倒计时 demo

    for time in `seq 9 -1 0` ; do
    echo -n -e "\b$time"
    sleep
    done
    echo       
    
 

    
    
    
    
     
    
    
    
    
    
    


    
