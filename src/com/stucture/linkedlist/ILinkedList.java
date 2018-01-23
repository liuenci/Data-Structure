package com.stucture.linkedlist;

/**
 * 泛型参数表示数据元素的数据类型，提高了程序的可扩展性
 * @author cier
 * @date 2018/1/23 11:42
 */
public interface ILinkedList<T> {
    /**
     * 判断线性表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 返回线性表的长度
     * @return
     */
    int length();

    /**
     * 返回第 i 个元素
     * @param i 下标索引
     * @return
     */
    T get(int i);

    /**
     * 设置第 i 个元素值为 t
     * @param i 下标索引
     * @param t 元素值
     */
    void set(int i, T t);

    /**
     * 插入第 i 个元素为 t
     * @param i 下标索引
     * @param t 元素值
     */
    void insert(int i, T t);

    /**
     * 在线性表的最后插入 t 元素
     * @param t 元素值
     */
    void append(T t);

    /**
     * 删除第 i 个元素并返回被删除的元素
     * @param i 下标索引
     * @return
     */
    T remove(int i);

    /**
     * 移除线性表中所有元素
     */
    void removeAll();

    /**
     * 查找元素并且返回首次出现的关键字为t的元素
     * @param t
     * @return
     */
    T search(T t);
}
