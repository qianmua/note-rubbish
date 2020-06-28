

# linux

## 目录结构

    一切皆文件
    
    / root 目录
    
    /bin 经常用的命令
    /sbin 系统管理员用的系统管理程序
    /home 普通用户的目录 // 目录名以用户的账户名
    /root root的主目录
    /lib 系统启动需要的基本动态链接库
    /lost+/found 系统异常关机后 存放的文件
    /etc 系统管理所需的配置文件和子目录
    /usr 用户的应用程序和文件都在这个目录
    /boot linux 核心文件
    /proc 虚拟目录，是系统内存的映射 // 可以访问次目录得到一些系统信息
    /srv 服务启动后需要提取的信息
    /sys 系统内核目录
    /tmp 临时文件 目录
    /dev 类似 设备管理器
    /media 外部设备 挂载目录（u盘 光驱等）
    /mnt 临时挂载别的文件系统的
    /opt 额外安装软件存放的目录 （eg: mysql）
    /var 一般可以将log 放在这里 // 不断变化的文件
    /selinux 
    
    
## vi/vim
    
    文本编辑器
    vi  老
    vim 新 功能多
    
    直接进去 是 一般模式
    操作：（vim 后按下 按键）
        yy 复制光标当前一行
        y数字y 复制一段
        p 粘贴
        u 撤销
        dd 删除当前行
        d数字d 删除一段
        x 删除一个字母 向后删
        X 向删
        yw 复制一个词
        dw 删除一个次
        shift+^ 移动到头
        shift+$ 移动到尾
        gg 移动到页头
        G  移动到页尾
        数字G 移动到指定行 // 先按数字 在G
        
    编辑模式：
    操作：
        i   光标前插入 
        a   关标后面（光标退一格）
        o   当先光标下一行
        I   行头
        A   行左后
        O   当前关标上一行
        
        
    指令模式：
    操作
        在一般模式下按下 ：/？任何一个都可移动到最底下哪一行 
        
        命令：
            :w  保存
            :q  退出
            :!  强制退出
            
            /查找的单词  n下一行 N 上一行
            ?查找的单词
            ：set nu     开启行号    
            ：set nonu   关闭行号 
            ZZ 退出（修改了 保存后退出）
            
            
## 网络

    ifconfig // 查看ip   （内网IP）
    
    设置静态ip
    vim /etc/sysconfig/netwprk-scripts/ifcfg-etc-o 
    修改
    onboot=yes
    bootroto=static # 静态的ip
    ipaddr=192.168.1.XXX
    gateway=192.168.XX.XX
    dns1=
    dns2=
    执行重启
    servie network restart
    
    
    查看主机名
    hostname
    /etc/sysconfig/network 下面可以修改主机名 (主机名不要有 下划线)
    vim /etc/hosts  # host 文件
    
    
## 防火墙
    
    service 后台服务管理 // 临时命令
    
        service 服务名 start/stop/restart/status
    
        // eg:
        查看所有服务
        service --status-all
        
    chkconfig   设置后台服务自动启动
    chkconfig --list // 查看程序运行级别
        进程运行级别
        0   关闭  停机状态  
        1   关闭  但用户状态，用于系统维护，禁止远程登录
        2   启动  多用户，无nfs 无网络
        3   启动  常用 有nfs 命令行
        4   启动  未使用 保留
        5   启动  常用  gui
        6   关闭  系统正常关闭重启
    
    //关闭自启
    chkconfig off/on
    
    
## 重启

    sync    同步 ， 将缓冲区数据 同步到磁盘    
    halt    1分钟后关机
    rebot   重启
    shutdown    
        -h
        -r  
        
        参数
        now
        数字
        
        
## 修改密码



## 帮助命令

    man 命令
    eg：
    man ls
    
    
    ll = ls -l
    
    
> help 得到shell 内置命令 信息

    
## 常用快捷键
    
    ctrl+c  停止进程
    
    ctrl+l  清屏 彻底清reset
    
    ctrl+q    退出
    
    tab     提示
    
    ctrl + alt  linux win 之间切换
    

## 文件目录

    ll
    权限  链接数 文件属主    文件属组    文件大小（byte）  新近修改时间  名字
    
    cd ~ cd 家目录
    cd - 上一次所在目录
    cd .. 上一级目录
    cf -P 跳转到实际物理路jing    
    
> mkdir

    mkdir -p 创建多级目录
    
    
> rmdir

    删除一个空目录
    
> touch

    创建空文件
    
    可以直接 vim 文件名
    
> cp

    cp -r 递归复制
    
    
> mv 

    也可以用来重命名
    
> cat 

    查看文件内容 （一般小文件）
    
    cat -n 显示行
    
    
    more 查看：
    
    命令
    空格  翻页
    回车  翻行
    q   离开
    ctrl f  滚以屏
    ctrl b  上一屏
    =   当前行号
    ：f  文件名和当前行号
    
    
    less （大型）    
    
    搜索
    /
    ？
    pagedown 翻页
    
    
>echo   

    输出
    echo -e 支持转义 
    

> head

    查看文件头部内容
    
>tail 
    
    查看文件尾部信息
    
    tail -f 动态显示
    
    日志
    
>   

    >覆盖 
    >>追加

> ln

    软连接 相当于快捷方式
    ln -s 源目录 目标目录
    
    wo -> 源
    
> rm
    
    移除
    -r  递归删除
    -f  强制执行 不提示
    -v  显示详细操作过程
    
## 日期
    
> date

    date -d // 格式   
    date -s // 设置时间    
    
    date "+%Y-%m-%d %H %M %S"
    
    date -d '1 days ago' 前一天
    date -d '-1 days ago' 明天
    
    
> cal 日历

    cal 年份
    cal 当月
    
## 用户管理

    useradd name 添加用户
    
    passwd 设置密码
        passwd username
        
    id username 查看用户存在
    
    su 切换用户 不能得到环境变量
    su - username 可以得到 
    
    userdel 删除用户 保存用户主目录
    userdel -r 完全删除
    
    who 查看用户信息
    whoami      你自己
    who am i    上一个登录是谁
    
    sudo    设置普通用户有管理员权限 （管理员执行）    
    // 
    修改配置文件 /etc/sudoers
    改为 all
    然后用sudo 就可以管理员 操作了 （管理员执行）
    
    usermod 修改用户
    usermod -g 修改用户组
    
    组管理
    
    groupadd 添加组
    groupdel
    groupmod -n 新 老
    

## 文件权限

    ll
    10个字符
    第一个
    是d 表示目录 是- 表示文件 1链接文档
    下三个（主）u
    rwx 读写执行 权限
    下三个（组）g
    r-X 读写执行
    下三个（其他）o
    r-x 读写执行
        
    chmod 改变权限
    chmod [{ugoa}{+-=}{rwx}] file
    chmod 数字
    eg:
    chmod a+r filename
    数字
    r 4 w 2 x 1
    rwx = 7
    chmod 777 
    chmod 666
    comod 444
        
        
    chown   改变所有者
    
    chown username filename
    chown -R    递归改变
    
    
    chgrp   改变所属组   类似chown
    
    
## 文件查找

    find
    查找方式
    find -name
    find -user
    find -size
    
    find -name  sName/  "type"
    
    grep 过滤 | 管道
    -n 显示行号
    ll |grep    name
    
    which 查找 
    which ll
    
    
## 压缩

    gzip    压缩 只能是 .gz 不会保留原文件
    gunzip  解压缩
    不能压缩目录
    
    zip 可保留原文件
    unzip
    -r 压缩目录
    -d 指定解压后文件目录
    
    zip dmeo.zip file1  file2   ...
    -> demo.zip
    
    
    tar 打包
    tar [选项]  xxx.tar.gz  内容    
    选项：
        -z  打包同时压缩
        -c  产生 .tar打包文件
        -v  显示详细信息
        -f  指定压缩的文件名
        -x  解包 .tar 文件
    
    
    tar -zxcf demo.tar.gz   file1   file2   .....
    
    tar -zxvf
      
      
## 磁盘分区命令

    df
    查看磁盘空余空间
    -h  GB  MB 等显示
    df -h
    
    fdisk 查看分区
    -l  查看详情
    
    
    mount/umount    挂载卸载
    
    
## 进程   线程

    ps 查看 进程状态
    
    ps aux // 查看系统中所有进程
    ps -ef // 查看父子进程之间关系    
    
    ps aux | grep xxx // 管道处理
    
    操作
    -a  所有进程
    -u  所有用户
    -x  没有终端的进程
    
    ps -ef
    uid
    pid
    ppid // 父进程id
    
    
    kill 终止 进程
    kill -9 强制 终止
    killall
    
    pstree 查看进程树
    选项
    -p  显示pid
    -u  显示所属用户
    
    top 查看系统健康状况 
    
    操作（按下）
    P   以cpu使用率排行
    M   内存使用率排行
    N   进程号排行
    q   退出top
    
    netstat 显示网络和端口占用情况
    
    -n  不显示别名 能以数字就用数字显示
    -l  列出 有在监听的状态
    -p  表示那个进程再用
    
    
## 系统定时任务

    crontab 选项
    
    -e 编辑定时任务
    
    语法： cron表达式
    * * * * * 执行的任务 (最小是分)   分时日月年 
    
    符号：
    *   任意
    ，  代表不连续 8，10，12   整点 执行
    -   代表不连续   8-16    8-16 执行
    */n 每隔多久执行
    
    eg:
        crontab -e 
        */1 * * * * /bin/echo "test" >> /local/text/demo.txt
        
        
    
    
    
    
            
    
