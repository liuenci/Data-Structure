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
     * 初始化构造一个头结点
     */
    public Node() {
        this.data = null;
        this.next = null;
    }

    /**
     * 比较两个结点值是否相等，覆盖Object类的equals(obj)方法
     * obj == this 判断的是不是同一个对象
     * obj instanceof Node 判断的是 obj 是不是 Node 的一个实例
     * this.data.equals(((Node<T>)obj).data 判断的是两者之中的内容是不是相等
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj == this || obj instanceof Node && this.data.equals(((Node<T>)obj).data);
    }
}
