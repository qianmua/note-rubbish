package _a_alg_.leetCode;

import _a_alg_.medium.list.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/24  15:42
 * @description :
 */
public class _23 {

    // k 个有序链表的合并。

    @Test
    public void m1(){

    }

    private ListNode margeKLists(ListNode[] lists){

        // 优先队列比较器
        Comparator<ListNode> cmp = Comparator.comparingInt(o -> o.val);

        // 优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(cmp);
        for (ListNode list : lists) {
            if (list != null)
                queue.add(list);
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!queue.isEmpty()){
            // 出
            queue.poll();

            point = point.next;

            ListNode next = point.next;
            if (next != null)
                queue.add(next);
        }

        return head.next;

    }
}
