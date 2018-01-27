package com.stucture.list.circularLinkedList;

/**
 * @author cier
 * @date 2018/1/27 10:39
 */
public class Node {
    // 元素类型为 int 的结点
    private int data;
    private Node next;

    public Node(int data,Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int i) {
        this(i,null);
    }

    public Node() {
        this(0,null);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
