package _a_hashmap_;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/13
 * @time 18:06
 */
public class Main {
     // *  arrayList 默认大小是10
    // 查询，插入慢
    // LinkList 插入快，查询慢

    /**
     *
     *
     * jdk7
     * hashMap
     * 储存结构 数组加链表
     * 会把key value 封装为一个entity
     * 思路 : key下标怎么得到？ 得到hashCode % table.length = 就是他的数组下标了
     * 要是key重复了，那就放到链表中
     * 解决速度插入头部
     * 问题： 怎么get？
     * 如果插入头部，怎么得到？（链表只有next 没有 prev）
     * 解决 插入后向下移动一位就行了
     * 移动 ： 将指针向下移动一个就行了
     *
     * 如果index 相等且hashcode也相等，那么覆盖并且返回覆盖之前的value
     *
     * 初始化容量是一个2的n次幂
     * 初始化的容量很init的value不只是直接相等的
     * (init - 1) < 1 然后计算处他里面的最大的 2的N次幂
     *
     * 作用：
     * hashMap真实算数组的下标
     * 得到hashcode值 ， 还有容量
     * hashcode & (size -1)
     * 即 取得的value在容量范围之内
     *
     * 扩容： 最大size : 1 << 30 2^32
     *  判断已存的大小是否大于这个阈值 (数组大小 * 负载因子)
     *  并且当前下标没有key（jdk7）
     *  扩容时会拷贝一份（链表也会拷贝的 （反向的）） 是个双重for （for + while）
     *
     * 多线程问题
     *  多线程下要是拷贝的时候会产生循环链表的问题
     *  线程一二都会拷贝一份
     *  线程一完了，线程二还没完
     *  线程二拷贝的时候，产生循环链表死循环
     *
     * 扩容的目的：
     *  缩小链表的容量
     *
     *
     * java8
     *
     * 使用的是 数组 + node + 红黑树
     *
     * resize 扩容
     * 通过四组指针
     * 指针分离去扩容的
     *
     *
     * 为什么是2的n次幂
     *
     *
     *
     * 因为2的幂-1都是11111结尾的，所以碰撞几率小。
     * 将二进制进行按位于，(16-1) 是 1111,末位是1，这样也能保证计算后的index既可以是奇数也可以是偶数
     *
     *
     * 不是的话
     *
     * 增加了碰撞的几率，
     *
     * 减慢了查询的效率，
     *
     * 造成空间的浪费。
     *
     *  所以说，当数组长度为2的n次幂的时候，不同的key算得得index相同的几率较小，
     *  那么数据在数组上分布就比较均匀，也就是说碰撞的几率小，
     *  相对的，查询的时候就不用遍历某个位置上的链表，这样查询效率也就较高了。
     *
     *
     * 还是 有点 线程不安全的。
     * 在扩容的时候 可能会造成 数据丢失哦
     *
     * 添加数据的时候 刚好正在扩容
     * 数据 放到原node
     * 造成数据丢失
     *
     *
     *
     *
     * ConcurrentHashMap 保证线程安全
     *
     * 通过 加锁 + cas
     *
     * put 的时候 通过 cas 去放入
     * 要是 桶内不是 空的，就给 这个桶去加锁
     *
     * 相比 hashtable 锁粒度更小
     * 不用去 锁整张table
     *
     *
     *
     *
     *
     *
     * hashMap 可以放空的
     *
     * ConcurrentHashMap 不许 放入空 k，v
     *
     * put 时候
     *
     * 先判断
     * 然后 cas
     * 节点无值 直接添加
     * 有值
     * 加锁
     *
     *
     * 多线程下扩容机制
     *
     * 对放入的数据 进行 标记
     *
     * 帮助 扩容 ？
     * 每个线程不是 自己扩容自己的
     * 插入的那个线程也会去帮助 扩容 转移数据
     *
     *
     *
     *
     *
     *
     *
     *
     * hashMap 链表 长度为8 转为红黑树
     *
     * 8 定义在 hashMap中
     * 转成树 bin 长度 必须足够长才可以
     * 因为 treeNode 大小 是普通Node 的两倍
     * 那么长度 超过 8 （就是 0-7）第9个时就变为红黑树
     * 低于6个就变成普通的bin
     *
     * 空间和时间 的权衡 // 所以不是直接 成树
     *
     * 而且 达到8的 概率的很小很小的
     *
     *
     *
     *
     *
     *
     *
     * */

    /**
     * 简单的node
     */

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
    }


    class Node{
        Object object;
        Node next;

        public Node(Object object, Node next) {
            this.object = object;
            this.next = next;
        }

        // 向下移动
    }
    private void f(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1","2");
        Node node = new Node("a", null);
        //存一个   存到尾部
        node.next = new Node("b" , null);

        // 存到头部
        new Node("c" , node);

        // table[index] = new Node(key , value , table[index]);
    }
}
