package com.stucture.sqlList;

/**
 * 线性表顺序存储结构的接口
 * 指的是用一段地址连续的存储单元存储线性表的数据元素
 * @ClassName: ISeqList
 * @author cier
 * @date 2018-1-22
 */

public interface ISeqList<T> {
    /**
     * 获得元素
     * @param i 需要获得第i个元素
     * @return
     */
    public T getElem(int i);

    /**
     * 插入元素
     * @param i 元素的插入位置
     * @param t 需要插入的元素
     * @return 是否成功删除
     */
    public boolean insertElem(int i,T t);

    /**
     * 删除元素
     * @param i 需要删除元素的位置
     * @return
     */
    public T deleteElem(int i);
}
