package com.stucture.list.staticlist2;

/**
 * @author cier
 * @date 2018/1/26 9:21
 */
public interface IStaticList<T> {
    // 静态链表长度
    int length();

    // 获取当前备用链表的首结点地址
    int getBackupListFirstIndex();

    // 将空闲空间回收到备用链表中
    T increaseSpaceToBackupList(int k);

    // 尾插法插入结点
    boolean insert(T element);

    // 在第 i 个位置插入元素 element
    boolean insert(int i, T element);

    // 删除表中第 i 个位置的元素
    T remove(int i);

    // 删除表中所有元素
    void removeAll();
}
