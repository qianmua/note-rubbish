

## 

    Redis的列表类型键可以用来实现队列，并且支持阻塞式读取，可以很容易的实现一个高性能的优先队列。
    同时在更高层面上，Redis还支持"发布/订阅"的消息模式，可以基于此构建一个聊天系统。
    
    在Redis中，List类型是按照插入顺序排序的字符串链表。
    和数据结构中的普通链表一样，我们可以在其头部(left)和尾部(right)添加新的元素。
    在插入时，如果该键并不存在，Redis将为该键创建一个新的链表。
    与此相反，如果链表中所有的元素均被移除，那么该键也将会被从数据库中删除。
    List中可以包含的最大元素数量是4294967295。
    
    
## :brpop和blpop实现阻塞读取(重要)

    需要一直调用rpop命令或者lpop命令才可以实现不停的监听且消费消息。
    
    为了解决这一问题，redis提供了阻塞命令 brpop和blpop。
    
    brpop命令可以接收多个键，其完整的命令格式为 BRPOP key [key ...] timeout,
    
    如:brpop key1 0。意义是同时检测多个键，如果所有键都没有元素则阻塞，
    如果其中一个有元素则从该键中弹出该元素(会按照key的顺序进行读取，可以实现具有优先级的队列)。
    
## 发布/订阅模式(类似于MQ的主题模式-只能消费订阅之后发布的消息，一个消息可以被多个订阅者消费)

    "发布/订阅"模式包含两种角色，分别是发布者和订阅者。
    订阅者可以订阅一个或者多个频道(channel),而发布者可以向指定的频道(channel)发送消息，所有订阅此频道的订阅者都会收到此消息。
    
    发布者发布消息的命令是  publish,用法是 publish channel message，如向 channel1.1说一声hi
    
    
    这样消息就发出去了。返回值表示接收这条消息的订阅者数量。
    发出去的消息不会被持久化，也就是有客户端订阅channel:1后只能接收到后续发布到该频道的消息，之前的就接收不到了。
    
    
    
    
    订阅频道:
    
    订阅频道的命令是 subscribe，可以同时订阅多个频道，用法是 subscribe channel1 [channel2 ...],
    例如新开一个客户端订阅上面频道:(不会收到消息，因为不会收到订阅之前就发布到该频道的消息)
    subscribe channel:1
    
    
    
    执行上面命令客户端会进入订阅状态，
    处于此状态下客户端不能使用除subscribe、unsubscribe、psubscribe和punsubscribe这四个属于"发布/订阅"之外的命令，否则会报错。
    
    　　进入订阅状态后客户端可能收到3种类型的回复。每种类型的回复都包含3个值，第一个值是消息的类型，根据消类型的不同，
    第二个和第三个参数的含义可能不同。
    
    消息类型的取值可能是以下3个:
    
    　　(1)subscribe。表示订阅成功的反馈信息。第二个值是订阅成功的频道名称，第三个是当前客户端订阅的频道数量。
    
    　　(2)message。表示接收到的消息，第二个值表示产生消息的频道名称，第三个值是消息的内容。
    
    　　(3)unsubscribe。表示成功取消订阅某个频道。第二个值是对应的频道名称，第三个值是当前客户端订阅的频道数量，
    当此值为0时客户端会退出订阅状态，之后就可以执行其他非"发布/订阅"模式的命令了。
    