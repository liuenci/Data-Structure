package com.stucture.queue.sequence;

/**
 * @author cier
 * @date 2018/2/8 17:43
 */
public class QueueNode<E> {
    private E element;
    private QueueNode<E> next;

    public QueueNode() {
        this.element = null;
        this.next = null;
    }

    public QueueNode(E element, QueueNode<E> next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public QueueNode<E> getNext() {
        return next;
    }

    public void setNext(QueueNode<E> next) {
        this.next = next;
    }
}
