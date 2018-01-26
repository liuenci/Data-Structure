package com.stucture.list.staticlist;

/**
 * @author cier
 * @date 2018/1/24 11:24
 */
public class NodeList<T> {
    public Node<T>[] data;
    public static int MAXSIZE = 1000;

    public NodeList() {
        data = new Node[MAXSIZE];
        initList(data);
    }

    /**
     * 初始化静态链表,初始化的时候应该是一条空链
     * 将一维数组data中的各个分量链成一条备用链表
     *
     * @param data 结点数组
     */
    private void initList(Node<T>[] data) {
        //  如果没有后继元素，则 cur 为 0;因此是 data.length - 1;
        for (int i = 0; i < data.length - 1; i++) {
            // 初始化每个结点的cur值，为其数组下标加1，指向下一个元素
            data[i] = new Node<T>(null, i + 1);
        }
        // 数组的最后一个元素的cur，用来存放第一个插入元素的下标，即第一个有值元素的下标
        data[MAXSIZE - 1] = new Node<T>(null, 0);
    }

    /**
     * 顺序添加元素
     *
     * @param item 要添加的元素
     * @return
     */
    public boolean addNode(T item) {
        // 找到第一个空闲空间的下标
        int newCur = data[0].cur;
        // 保存第一个空闲空间的游标
        int temp = data[newCur].cur;
        // 新添加的元素，由于是最后一个元素，将其游标置为0
        Node<T> newNode = new Node<T>(item, 0);
        data[newCur] = newNode;
        // 如果静态链表不为空，应在添加时将前一元素的游标和新元素的下标联系起来
        if (data[0].cur > 1) {
            data[newCur - 1].cur = newCur;
        }
        // 新的空闲空间，赋给第一个元素的游标
        data[0].cur = temp;
        // 最后一个元素的游标存放第一个有值元素的下标，为1
        data[data.length - 1].cur = 1;
        return true;
    }

    /**
     * 返回静态链表的长度
     *
     * @return
     */
    public int length() {
        // 找到最后一个元素的 cur,这个 cur 是静态链表的第一个结点的下标
        int firstNodeIndex = data[MAXSIZE - 1].cur;
        // 遍历链表
        int length = 1;
        while (data[firstNodeIndex].cur != 0) {
            firstNodeIndex = data[firstNodeIndex].cur;
            length++;
        }
        return length;
    }

    /**
     * 思想：
     * 1. 先将 index - 1 的结点的 cur 赋给新的结点的 cur
     * 2. 再将新结点的 cur 赋给 index - 1 的结点的 cur
     * 3. 将新结点放到第一个空闲分量上
     * 4. 最后找到数组中第一个空闲分量
     *
     * @param item
     * @param index 插入的索引从 1 开始
     * @return
     */
    public boolean insert(T item, int index) {
        // k 是最后一个元素的数组下标
        int k = MAXSIZE - 1;
        if (index < 1 || index > length() + 1) {
            System.out.println("插入的位置不合法");
            return false;
        }
        // 找到第一个空闲分量的下标
        int emptyIndex = data[0].cur;

        // 找到第 index 个元素之前的位置
        for (int i = 1; i <= index - 1; i++) {
            k = data[k].cur;
        }
        // 把第 index 个元素之前的 cur 赋值给新元素的cur
        Node<T> newNode = new Node<T>(item, data[k].cur);
        // 把新元素的下标赋值给第 index 个元素之前元素的 cur
        data[k].cur = emptyIndex;
        // 将新结点放在第一个空余的分量上
        data[emptyIndex] = newNode;
        // 寻找新的第一个空闲分量
        int i = 1;
        while (data[i].data != null) {
            i++;
        }
        data[0].cur = i;
        return true;
    }

    /**
     * 删除结点
     * index 是链表中的索引，不是数组中的索引
     *
     * @param index
     * @return
     */
    public boolean remove(int index) {
        if (index < 1 || index > length()) {
            System.out.println("删除的位置不合法");
            return false;
        }
        int k = MAXSIZE - 1;
        // 找到 index 前一个元素的数组下标
        for (int i = 1; i <= index - 1; i++) {
            k = data[k].cur;
        }
        // 存储前一个元素的 cur
        int qcur = data[k].cur;
        // 将 index 之后一个元素的数组下标赋给前一个元素的 cur
        data[k].cur = data[qcur].cur;
        // 将 index 结点清除
        data[qcur].data = null;
        // 找到第一个空闲分量
        int i;
        for (i = 1; i < MAXSIZE - 1; i++) {
            if (data[i].data == null) {
                break;
            }
        }
        data[0].cur = i;
        int j;
        for (j = 2; j < 6; j++) {
            System.out.println(data[i].data);
            /*if (data[i].data != null) {
                break;
            }*/
        }
        data[MAXSIZE - 1].cur = j;
        return true;
    }

    @Override
    public String toString() {
        System.out.println("data[0].cur=" + data[0].cur);
        System.out.println("data[MAXSIZE-1].cur=" + data[MAXSIZE - 1].cur);
        StringBuffer stringBuffer = new StringBuffer("[");
        int ccur = data[MAXSIZE - 1].cur;
        while (data[ccur].data != null) {
            stringBuffer.append("{data:" + data[ccur].data + ",cur:");
            stringBuffer.append(data[ccur].cur + "}");
            if (data[ccur].cur != 0) {
                stringBuffer.append(" ");
            }
            ccur = data[ccur].cur;
        }
        return stringBuffer.append("]").toString();
    }
}
