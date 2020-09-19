
## MVCC 多版本并发控制

    MySQL 的 InnoDB 存储引擎实现隔离级别的一种具体方式

    版本链指向上一个版本的数据快照
    
> 版本号

    系统版本号
        每开始一个新的事务，系统版本号就会自动递增。
    事务版本号
        事务开始时的系统版本号。

    MVCC 在每行记录后面都保存着两个隐藏的列，用来存储两个版本号
        创建版本号
        删除版本号
        
##  undo 日志

    MVCC 快照储存在undo日志中， 日志通过回滚指针将数据行 快照链接
    
    
## 实现过程 （可重复读隔离级别）

    当开始新一个事务时，该事务的版本号肯定会大于当前所有数据行快照的创建版本号
    
> select
    
    
    
> insert

    将当前系统版本号作为数据行快照的创建版本号
    
> delete
    
    将当前系统版本号作为数据行快照的删除版本号

> update

    先执行 DELETE 后执行 INSERT
    
## 快照读与当前读

    使用 MVCC 读取的是快照中的数据，这样可以减少加锁所带来的开销
    
    当前读最新的数据，需要加锁。以下第一个语句需要加 S 锁，其它都需要加 X 锁
    
    select * from table where ? lock in share mode;
    select * from table where ? for update;
    insert;
    update;
    delete;
    
    
    
## MVCC 不能解决幻读的问题

    Next-Key Locks 
    
    MVCC + next-key locks 解决幻读
    
> Record Locks

    锁定一个记录上的索引

> Gap Locks

    锁定索引之间的间隙，但是不包含索引本身

> Next-Key Locks
    
     Record Locks 和 Gap Locks 的结合