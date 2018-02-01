package com.stucture.stack.sequence;

/**
 * @author cier
 * @date 2018/2/1 12:03
 */
public class SequenceStackImpl implements ISequenceStack{
    public Object[] stack; //对象数组(栈的顺序结构使用数组完成)
    public final int DEFAULTSIZE = 10; // 栈的默认长度
    public int top; // 栈顶位置，也可以理解成栈的实际长度
    public int maxSize; // 最大长度

    public SequenceStackImpl(){
        init(DEFAULTSIZE);
    }

    public SequenceStackImpl(int size){
        init(size);
    }

    /**
     * 初始化栈操作
     * @param size
     */
    public void init(int size) {
        this.maxSize = size;
        top = -1;
        stack = new Object[size];
    }

    /**
     * 压栈操作
     * @param obj
     */
    @Override
    public void push(Object obj) {
        // 首先判断栈是否已经满了
        if ( top == maxSize) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = obj;
    }

    /**
     * 出栈操作
     * @return
     */
    @Override
    public Object pop() {
        // 首先判断栈是否为空
        if (isEmpty()){
            System.out.println("栈为空");
        }
        Object obj = stack[top];
        stack[top] = null;
        top--;
        return obj;
    }

    /**
     * 得到栈顶元素
     * @return
     */
    @Override
    public Object getTop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        return stack[top - 1];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
