package com.stucture.queue.sequence;

/**
 * @author cier
 * @date 2018/2/8 17:38
 */
public interface Queue<E> {
    /**
     * 添加元素到队列
     * @param element
     */
    void enqueue(E element);

    /**
     * 删除元素
     * @return
     */
    E dequeue();

    /**
     * 得到队头元素
     * @return
     */
    E getFirstVal();

    /**
     * 判空
     * @return
     */
    boolean isEmpty();

    /**
     * 清除所有元素
     */
    void clear();
}
