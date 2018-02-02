package com.stucture.stack.link;

/**
 * @author cier
 * @date 2018/2/2 12:02
 */
public class Node {
    private Object element; // 数据域
    private Node next; // 指针域

    /**
     * 头结点的构造方法
     * @param next
     */
    public Node(Node next) {
        this.next = next;
    }

    /**
     * 非头结点的构造方法
     * @param element
     * @param next
     */
    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.element.toString();
    }
}
