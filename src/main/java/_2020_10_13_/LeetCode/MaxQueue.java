package _2020_10_13_.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    public Queue<Integer> queue = new LinkedList<>();
    public Deque<Integer> maxQueue = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        if(maxQueue.isEmpty()){
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!maxQueue.isEmpty() && maxQueue.peekLast() < value){
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);

    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int popValue = queue.peek();
        if(popValue == maxQueue.peekFirst()){
            maxQueue.removeFirst();
        }
        return queue.poll();
    }


    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.max_value();
        maxQueue.pop_front();
        maxQueue.max_value();
    }
}
