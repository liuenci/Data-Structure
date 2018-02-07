package com.stucture.stack.link;

/**
 * @author cier
 * @date 2018/2/2 12:05
 */
public interface ILinkedStack {
    /**
     * 入栈
     * @param object
     */
    void push(Object object);

    /**
     * 出栈
     * @return
     */
    Object pop();

    /**
     * 获得栈顶元素
     * @return
     */
    Object getTop();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();
}
