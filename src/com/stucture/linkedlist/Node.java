package com.stucture.linkedlist;

/**
 * @author cier
 * @date 2018/1/23 11:55
 */
public class Node<T> {
    // 结点的数据域，用于保存数据元素
    public T data;
    // 节点的地址域，对应C语言中的指针域，next表示后继结点
    public Node<T> next;

    /**
     * 初始化结点
     * @param data
     * @param next
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * 构造结点
     */
    public Node() {
        // 这也是一种初始化的方式，不过我更喜欢后一种
        // this(null,null);
        this.data = null;
        this.next = null;
    }

    /**
     * 返回结点元素值对应的数据元素和地址域
     * @return
     */
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    /**
     * 比较两个结点值是否相等，覆盖Object类的equals(obj)方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj == this || obj instanceof Node && this.data.equals(((Node<T>)obj).data);
    }
}
