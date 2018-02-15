package com.stucture.queue.linkedqueue;

public class LinkedQueue<T> {
    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        Node node = new Node(null, null);
        node.next = null;
        this.front = this.rear = node;
    }

    /**
     * 入队操作
     *
     * @param data
     */
    public void enqueue(T data) {
        // 创建一个结点
        Node node = new Node(data, null);
        // 将队尾指针指向新加入的结点，将结点插入队尾
        rear.next = node;
        rear = node;
        size++;
    }

    /**
     * 出队操作
     * @return
     */
    public T dequeue() {
        if (isEmpty()) {
            System.out.printf("队列为空，无法删除");
            return null;
        } else {
            // 暂存队头元素
            Node node = front.next;
            T t = node.data;
            front.next = node.next;
            size--;
            if (size == 0) {
                rear = front;
            }
            // 删除结点
            node = null;
            return t;
        }
    }
    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuffer stringBuffer = new StringBuffer("[");
            Node node = front;
            while (node.next!=null) {
                node = node.next;
                stringBuffer.append(node.data+"->");
            }
            int length = stringBuffer.length();
            stringBuffer.delete(length-2,length);
            stringBuffer.append("]");
            return stringBuffer.toString();
        }

    }

    /**
     * 队列结点的数据结构
     */
    private class Node {
        public T data;
        public Node next;

        public Node() {

        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        queue.enqueue(1);
        System.out.println(queue.toString());
        queue.enqueue(2);
        System.out.println(queue.toString());
        queue.enqueue(3);
        System.out.println(queue.toString());
        queue.enqueue(4);
        System.out.println(queue.toString());
        queue.enqueue(5);
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        System.out.println(queue.size);
    }
}
