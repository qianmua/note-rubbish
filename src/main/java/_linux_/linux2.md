

#   linux

## 版本

    1.	Red Hat Linux （红帽操作系统）
    
    2.	CentOS （社区企业版操作系统   服务器）
    
    3.	Ubuntu  （以桌面应用为主的Linux操作系统）
    
    4.	SUSE Linux ()
    
    5.	Fedora Linux (面向日常应用的快速、稳定、强大的操作系统)
    
## 32位与64位操作系统

    	32位操作系统表示32位CPU对内存寻址的能力；
    
    	64位操作系统表示64位CPU对内存寻址的能力；
    
    	32位的操作系统安装在32位CPU处理器和64位CPU处理器上；
    
    	64位操作系统只能安装64位CPU处理器上；
    
    	32位操作系统对内存寻址不能超过4GB；
    
    	64位操作系统对内存寻址可以超过4GB，企业服务器更多安装64位操作系统，支持更多内存资源的利用；
    
    	64位操作系统是为高性能处理需求设计，数据处理、图片处理、实时计算等领域需求；
    
    	32位操作系统是为普通用户设计，普通办公、上网冲浪等需求。
    
    
## Linux内核

    进程管理
    内存管理
    文件系统
    系统管理
    网络操作
    
    
    命名 规则
    
        R.X.Y-Z
        
        R 内核版本 （4）
        
        X 内核主版本号 （奇偶）
        
        Y 内核 次 版本号
        
        Z 内核 小版本号
        
        
## windows
    
    文件系统类型
    
    FAT    
    FAT16    
    FAT32 （单文件最大 4G）
    NTFS    2T
    
    
## 文件分区
    
    swap
    交换分区 （虚拟内存）        
    
    阿里云 交换分区为0
    
    /data分区
    自定义分区
    


## 必备命令
    
       cd、
       ls、
       pwd、
       clear、
       chmod、
       chown、
       chattr、
       useradd、
       userdel、
       groupadd、
       vi、vim、
       cat、
       more、
       less、
       mv、
       cp、
       rm、
       rmdir、
       touch、
       ifconfig、
       ip addr、
       ping、
       route、
       echo、
       wc、
       expr、
       bc、
       ln、
       head、
       tail、
       who、
       hostname、
       top、
       df、
       du、
       netstat、
       ss、
       kill、
       alias、
       man、
       tar、zip、unzip、jar、
       fdisk、
       free、
       uptime、
       lsof、
       lsmod、
       lsattr、
       dd、
       date、
       crontab、
       ps、
       find、
       awk、
       sed、
       grep、
       sort、
       uniq
       
       
## 常见服务

    DHCP、
    SAMBA、
    DNS、
    Apache、
    MySQL、
    Nginx、
    Zabbix、
    Squid、
    Varnish、
    LVS、
    Keepalived、
    ELK、
    MQ、
    Zookeeper、
    Docker、
    Openstack、
    Hbase、
    Mongodb、
    Redis
    
    
## 基本概念

    BIOS 基本输入输入 （最底层）
    
    MBR 硬盘分区初始化 （2TB 以下 硬盘）
    GUID 更大的硬盘
    载入在引导 程序 521B
    
    GPT 全局唯一标识符 （GUID）
    
    GRUB 内核 选择 （引导）
    
## 启动流程

    BIOS加电 ——》 加载BIOS ——》 读取MBR
    ——》 GRUB引导 ——》 加载内核 ——》 rc0-rc6 级别启动（初始化服务）
    ——》 加载内核模块 ——》 加载 rc.sysinit (环境变量，网络，swap，/proc，系统函数，配置。。) 
    ——》 inittab 运行级别（设置守护进程init 级别）
    ——》 读取rc.lcoal ——》 login shell
    
    
    
## ip
    
    互联网协议地址
    逻辑地址
    互联网设备 通信 编号
    
## 子网掩码

    标识ip种那些位是主机所在子网 以及 位掩码        
    
## 网关

    不同层次 交换 数据
    
## MAC 地址

    物理地址 ， 定义 网络设备的位置
    
## linux 网卡名

    ifcfg-eth0
    ifcfg-eth1
    ifcfg-eth2
    ifcfg-eth3
    ...
    
    
## 详细命令    

    pwd 显示 当前目录
    
    cat 查看 文件 内容
    
    （more ） 分页 查看某文件内容
    
    head （从文件 头 查看）
    
    df 磁盘分区 查看 df -h

    
## linux 用户 权限

    uid 区分 权限 级别
    0 最高
    系统用户 1-499
    普通 500+
    
    /etc/passwd 查看 用户 独立uid
    
    每个用户 最多有 31个 附属组
    
    chown 修改文件权限
    chmod 修改 用户权限
    

## yum 

    maven 0.0
    
## 文件服务器

    FTP （文件传输协议）
    
    Vsftpd 服务器
    //
    yum 安装
    
## 架构

    LAMP + redis
    linux + apache + mysql/mongo perl/php/py
    
    
    
         
    
    
