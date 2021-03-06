

计算机局部性原理： 取出一份数据的时候会从数据中取出相邻的数据
            取出那一页数据 大概4KB
            
            innoDB应用了这个 叶子单位是16KB = 16384字节
            
mysql 事务的ACID原则

    insert select update delete 会自动开启一个事务
    
    开始事务begin 或者 start transaction
    提交 commit 回滚 rollback
    
    事务自动提交
    set autocommit=0 事务持续存在知道你主动执行commit或rollback语句，或者链接断开
    show VARIABLES like 'autocommit';

    原子性（ Atomicity ）
    一致性（ Consistency ）
    隔离性（ Isolation ）
    持续性（ Durability ）

原子性： A
    什么是原子性操作?
        比如转账操作，要么转账成功，要么转账失败，不会说一般成功，一半失败，这种中间状态，
        这种不可分割的操作要么做，要么不做
        就是你干了，但是我还没干？  ..
        
隔离性：I
    两个操作互不影响
    四种隔离级别
        Read Uncommitted（读取未提交内容） 脏读 读取到了其他食物没有提交的数据
        Read Committed（读取提交内容 <不可重复度>） 读了一条，再次读不一样 幻读（重复读某范围又插入一条产生幻影条）
        Repeatable Read（可重读） 默认的隔离级别 同样的sql读出来的数据是一样的 可能产生幻读 mysql已解决了？（数据库储存引擎）
        Serializable（可串行化） 两个事务，读读可以，读写不行 ， 相当于 加上共享锁，解决幻读的问题 问题：超时与锁竞争        
    修改事务隔离级别：set session transaction isolation level <隔离级别>

一致性：C
    保证数据一致
    
持久性：D
    对于一些记录需要永久性的保存
    
版本链 （隐藏列） 基于版本号去查找

mysql 锁

    锁在事务里面使用的哦。
    
    读锁：共享锁、shared locks、S锁
    
    写锁：排他锁、Exclusive locks、X锁
    
    注意事务事务事务！！！！ 辣鸡~
    Demo：
        Select .... lock in share mode 将该条数据加上S锁 只能读不能写 ， 因为其他事务也可以继续枷锁。
        
        select ... for update 给查的数据加上X锁 不许其他事务得到这些锁 其他事务不能写也不能读， 其他事务阻塞
        
    行锁：
        单行记录上的锁
        间隙锁 锁定一个范围， 单行的上下记录加锁
        
    Read Committed 是对查出来的数据加锁
        
    Repeatable 如果锁的不是索引列，会把所有间隙锁起来，解决产生幻读的现象
    
    范围加锁的话 对于满足范围的数据都会加锁 ， 也不能插入
    
    事务提交或者回滚，他所持有的锁就会释放掉
    
    

索引结构：
    
    就是一些树
    
    二叉搜索树（有序树，叶节点不能超过2）      1 2 3 4 5 6
        性质： 
            二叉树中，第 i 层最多有 2i-1 个结点。
            如果二叉树的深度为 K，那么此二叉树最多有 2K-1 个结点。
            二叉树中，终端结点数（叶子结点数）为 n0，度为 2 的结点数为 n2，则 n0=n2+1。
        单树 出现链表情况
    
    红黑树 快 但是树高，磁盘IO高
    
    hash 查找快 范围查找的问题
    
    b树
         关键数分组，就是分裂，可能增加树高
         删除叶子节点直接删除，删除非叶子节点时将后继元素与节点交换然后删除
        
    b+树
        分组，储存的是索引，数据全在叶子节点key时从小到大
        树高是3哦 一般根节点会存在内存中，也就是说2次磁盘IO.....6b
        节点就是叶节点的起始值
        叶子节点有个双向指针，是自增的（后面大于前面）
        （mysql设置了大小16K） 存量 16kb / 14b（8b(bigint) + 6b(指针)） => 1170节点 * 1170节点 * 16字节 ~= 2000w条
        
        
    储存引擎：
        innoDB （MySQL5.5及其之后默认的存储引擎）
            表数据就是一个B+tree
            必须要有主键啦，要是你没有，他会自动帮你建一个(row_id 是隐藏的)，或者帮你生成一个了。
            推荐整形自增，因为树是比较大小的呀，从左到右增大 （不然分裂结构，增加树高）
            必须要有一个B+Tree维护数据！！
            是一个聚集索引（数据文件在一块），叶节点包含了完整的数据记录 推荐使用自增主键
            行级锁
            
        myISAM
            也是个B+树
            文件和数据是分离的
            叶节点是一个指针，对应的数据文件 即主键索引是非聚集索引（文件和数据分开）
            表级锁
        
        MEMORY
            数据记录是存在内存中的，每个memory表对应一个.frm文件（表定义、索引）
            使用hash索引，对数据类型有限制，表级锁
    
  
innoDB 
    每一行记录格式
    有一些额外的字段，记录这些额外的信息
    变长度字段列表 null标志 头信息 列数据1 2......
        varchar 5.7 之前表示字节，之后表示字符
        null标志 将空值标记（防止数据错乱，数据存储，按顺序的嘛。。）
    创建行大小不能超过65535字节（变长字段，null标记，头信息，总共占用3字节），会产生行溢出（叶大小，跨页查询）
    这个页存不下了的时候分存到下一个页，以此类推，然后将每个页的页码，和这个data指针存到一块，后面用指针指向下一页（B+树）
    
    查询：
    
    普通索引
        叶子节点储存主键值
        查询先扫描定位到主键值
        然后通过聚集索引定位到行记录 即回表扫描
    
    聚集索引（PK UK row_id）
        叶子节点储存行记录
        直接定位行
    
    无索引:
        全表扫描
        
        
优化方法1
    比如存一些网址的时候 如果要匹配后缀.com什么的用模糊查询是用不到索引的（最左前缀原则） ， 不过我们存的时候
    可以将字符串反转然后moc% 这样查，就可以用到索引了哦
优化方法2
    查找大于小的值 ， 会将最小和最大的索引找到，然后找他们俩中间的value
    and 连接 后面的不会用到索引 ， 前面找到索引，然后全表
    order by 可以考虑优化where（最左前缀）
    