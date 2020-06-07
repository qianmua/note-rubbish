

http 协议
超文本传输协议

    www文件 必须遵守http 协议
    
结构
    
    // http 协议规定
    客户端发送请求 服务器端 没有收到请求不会主动发起响应
    
    http 报文
        报文头部
            服务器端或者客户端req/res的属性和内容
        CR+LF
            空行 回车换行符
        报文主体
            data
            
    请求报文
        请求行
        请求头
        通用头
        实体头
        其他
    响应报文
        响应头
        通用头
        实体头
        其他
        
    http请求报文
        请求方法（GET/POST/PUT/HEAD/DELETE/OPTIONS/TRACE） + URL + 协议版本
        请求头
        内容
    http响应报文
        协议版本
        状态码
        状态码原因短语
        响应头
        实体
        
http 是无状态协议
    
    就是他不保存跟你的会话信息
    断开就断了
    
    
http通用/头部字段

    通用首部字段
        Cache-Control 操作缓存工作机制
        Connection  管理持久连接
        Date 创建 http 报文时间
        Via 追踪报文转发，避免请求回环发生 （必须要）
        
    请求头字段
        Accept
            通知服务器 用户代理处理的媒体类型及优先级
        Accept-Language
            告诉服务器用户代理的自然语言集
        Authorization
            告知服务器 用户代理的认证信息
        Host
            请求地址
        Referer
            告知服务器请求的原始字段地址
        User-Agent
            浏览器信息 和用户代理名称传达给服务器
            
    响应头字段
        Location
            将响应引导至某个与请求URI位置不同的资源
        Server
            告知客户端当前服务器安装得Http服务器应用程序信息
            
    实体头字段
        Allow
            通知客户端支持的所有http方法，服务器会把支持的http方法写入allow 然后返回
            服务器要是收不到会返回405
        Content-Length
            实体部分大小
        Content-Type
            实体部分类型
            html/text 等等。。
                
        
            

        
        
    
    
            
