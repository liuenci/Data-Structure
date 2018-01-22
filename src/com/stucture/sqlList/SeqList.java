package com.stucture.sqlList;

/**
 * @author cier
 * @date 2018/1/2210:57
 */
public class SeqList<T> implements ISeqList<T> {
    public static final int MAXSIZE = 20; // 存储空间的初始化大小

    private T[] data; // 数组存储数据元素
    private int length; // 线性表当前长度

    public SeqList() {
        data = (T[]) new Object[MAXSIZE];
    }

    /**
     * 获得元素
     *
     * @param i 需要获得第i个元素
     * @return
     */
    @Override
    public T getElem(int i) {
        if (i < 0 || i > MAXSIZE) {
            return null;
        }
        T t = data[i - 1];
        return t;
    }

    /**
     * 插入元素
     *
     * @param i 元素的插入位置
     * @param t 插入的元素
     * @return
     */
    @Override
    public boolean insertElem(int i, T t) {
        // 线性表已经满了
        if (length == MAXSIZE) {
            System.out.println("该线性表已经满了");
            return false;
        }
        // 插入的位置不在范围内
        if (i < 1 || i > MAXSIZE) {
            System.out.println("该位置不合法");
            return false;
        }
        // 插入的位置不在表尾
        if (i < length) {
            for (int j = length; j >= i; j--) {
                data[j] = data[j - 1];
            }
        }
        // 线性表的下标是从1开始，但是数组的下标是从0开始的，所以插入的t是在 i-1 的位置
        data[i - 1] = t;
        length++;
        return true;
    }

    @Override
    public T deleteElem(int i) {

        // 线性表为空时
        if (length == 0) {
            System.out.println("线性表为空");
            return null;
        }
        // 删除的数据不在范围内时
        if (i < 1 || i > length) {
            System.out.println("删除位置不在范围内");
            return null;
        }
        T t = data[i - 1];
        for (int j = i; j < length; j++) {
            data[j - 1] = data[j];
        }
        length--;
        return t;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length < 0 || length > MAXSIZE){
            System.out.println("长度不合法");
        }
        this.length = length;
    }
}
