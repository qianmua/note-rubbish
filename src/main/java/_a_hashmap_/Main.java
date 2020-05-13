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
     * */

    /**
     * 简单的node
     */
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
