package com.stucture.queue.sequence;

/**
 * @author cier
 * @date 2018/2/8 19:44
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new CircularSeqQueueImpl<Integer>(8);
        System.out.println(q.toString());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(7);
        System.out.println(q.toString());
        System.out.println(q.dequeue());
        System.out.println(q.toString());
    }

}
