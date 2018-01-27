package com.stucture.list.staticlist;

/**
 * @author cier
 * @date 2018/1/26 9:27
 */
public class StaticListImpl<T> implements IStaticList<T> {
    private Node[] node = null; // 泛型数组
    private static final int MAXSIZE = 15;

    public StaticListImpl(int maxSize) {
        node = new Node[maxSize];
        for (int i = 0; i < maxSize - 1; i++) {
            node[i] = new Node<T>(null, i + 1);
        }
        node[maxSize - 1] = new Node<T>(null, 0);
    }

    public StaticListImpl() {
        this(MAXSIZE);
    }

    /**
     * 获取静态链表中已经被使用了数组空间
     *
     * @return
     */
    @Override
    public int length() {
        int j = node[MAXSIZE - 1].getCursor();
        int length = 0;
        while (j != 0) {
            j = node[j].getCursor();
            length++;
        }
        return length;
    }

    /**
     * 向备用链表申请一个数组单元，给插入操作使用；若备用链表非空，则返回备用首结点的下标，否则返回 0
     *
     * @return
     */
    public int applySpaceFromBackupList() {
        // 找到数组中第一个元素的 cursor 存的值，就是要返回备用首结点的下标
        int i = getBackupListFirstIndex();
        if (i != 0) {
            // 由于要拿出备用链表的一个单元使用，那么将该单元的下个单元设为备用首结点
            node[0].setCursor(i + 1);
        }
        return i;
    }

    /**
     * 获得备用链表首结点所处的单元下标
     *
     * @return
     */
    @Override
    public int getBackupListFirstIndex() {
        return node[0].getCursor();
    }

    /**
     * 将下标为 k 的空闲结点回收到备用链表，即将 k 作为备用链表首结点位置，数组第一个元素中的 cursor 指向第 k 个单元
     * @param k
     * @return
     */
    @Override
    public T increaseSpaceToBackupList(int k) {
        T temp = (T)node[k].getData();
        int m = node[0].getCursor();
        node[k].setCursor(m);
        node[0].setCursor(k);
        return temp;
    }

    /**
     * 尾插法插入结点
     *
     * @param element
     * @return
     */
    @Override
    public boolean insert(T element) {
        int i = length();
        return insert(i,element);
    }



    /**
     * 在表中第 i 个位置插入数据元素 element
     * @param i
     * @param element
     * @return
     */
    @Override
    public boolean insert(int i, T element) {
        if (i >= MAXSIZE - 1) {
            return false;
        }
        int l = length();
        if (i > l) {
            i = l + 1;
        }
        if (i < l) {
            i = 1;
        }
        int k = MAXSIZE - 1;
        // 向备用链表申请空间，以存放要添加的数据元素结点
        int m = applySpaceFromBackupList();
        if (m > 0) {
            // 找到数组第 i 个元素的前一个元素的位置
            for (int j = 1; j < i; j++) {
                k = node[k].getCursor();
            }
            // 创建一个新的结点，数据是element,cursor指向第 i 个元素
            // 将新生成的结点放入链表的最后一个单元，即备用链表的上一个单元
            node[m] = new Node<T>(element,node[k].getCursor());
            // 是当前数组第 i 个元素前面一个元素的 cursor 指向插入的新结点
            node[k].setCursor(m);
        }
        return true;
    }

    /**
     * 删除链表中第i个位置的数据元素
     * @param i
     * @return
     */
    @Override
    public T remove(int i) {
        if (i < 1||i > MAXSIZE - 1 || i > length()) {
            return null;
        }
        int k = MAXSIZE - 1;
        // 找到第 i 个位置的前一个元素位置
        for (int j = 1; j < i; j++) {
            k = node[k].getCursor();
        }
        int m = 0;
        // 取出前一个元素的 cursor ,也就是 i
        m = node[k].getCursor();
        // 将前一个数据元素的 cursor 设置为当前位置上的 cursor,
        // 即让当前元素的上一个元素的 cursor 指向当前元素的下一个元素
        node[k].setCursor(node[m].getCursor());
        // 将删除的元素空间回收至备用链表，并将删除位置作为添加元素的有限存储空间
        return increaseSpaceToBackupList(m);
    }

    /**
     * 删除表中所有的元素
     */
    @Override
    public void removeAll() {
        while (node[0].getCursor()!=1) {
            remove(length());
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(node[0]+ " ");
        int k = node[MAXSIZE - 1].getCursor();
        while(k != 0) {
            stringBuffer.append(node[k]);
            k = node[k].getCursor();
        }
        stringBuffer.append(node[MAXSIZE - 1]+"]");
        return stringBuffer.toString();
    }
}
