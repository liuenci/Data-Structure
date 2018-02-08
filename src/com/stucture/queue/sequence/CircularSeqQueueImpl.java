package com.stucture.queue.sequence;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author cier
 * @date 2018/2/8 17:47
 */
public class CircularSeqQueueImpl<E> implements Queue<E> {
    private static final int DEFAULTSIZE = 10;
    private int size;
    private int front;
    private int rear;
    private E[] listArray;

    public CircularSeqQueueImpl() {
        size = DEFAULTSIZE + 1;
        front = rear = 0;
        listArray = (E[]) new Object[size];
    }

    public CircularSeqQueueImpl(int size) {
        this.size = size + 1;
        front = rear = 0;
        listArray = (E[]) new Object[size];
    }

    /**
     * 插入元素
     *
     * @param element
     */
    @Override
    public void enqueue(E element) {
        if ((rear + 1) % size == front) {
            System.out.println("队列满，无法插入元素。");
        } else {
            listArray[rear] = element;
            rear = (rear + 1) % size;
        }
    }

    /**
     * 删除元素
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法删除。");
            return null;
        } else {
            E e = listArray[front];
            listArray[front] = null;
            front = (front + 1) % size;
            return e;
        }
    }

    /**
     * 得到队头元素
     *
     * @return
     */
    @Override
    public E getFirstVal() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        } else {
            return listArray[front];
        }
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 清空队列
     */
    @Override
    public void clear() {
        front = rear = 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (E e : listArray) {
            if (e!=null){
                stringBuffer.append(e+" ");
            }
        }
        if (!stringBuffer.toString().equals("[")){
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        return stringBuffer.append("]").toString();
    }
}
