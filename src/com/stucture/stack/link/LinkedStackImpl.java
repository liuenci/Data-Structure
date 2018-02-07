package com.stucture.stack.link;

/**
 * @author cier
 * @date 2018/2/2 12:07
 */
public class LinkedStackImpl implements ILinkedStack {
    Node head; // 栈顶指针
    int size; // 结点的个数

    public LinkedStackImpl() {
        head = null;
        size = 0;
    }

    @Override
    public void push(Object object) {
        head = new Node(object,head);
        size++;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        Object object = head.getElement();
        head = head.getNext();
        size--;
        return object;
    }

    @Override
    public Object getTop() {
        return head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
