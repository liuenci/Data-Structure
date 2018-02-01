package com.stucture.stack.sequence;

/**
 * @author cier
 * @date 2018/2/1 12:00
 */
public interface ISequenceStack {
    /**
     * 入栈
     * @param obj
     */
    void push(Object obj);

    /**
     * 出栈
     * @return
     */
    Object pop();

    /**
     * 获取栈顶元素
     * @return
     */
    Object getTop();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();
}
