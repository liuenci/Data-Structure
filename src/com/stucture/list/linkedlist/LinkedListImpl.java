package com.stucture.list.linkedlist;

/**
 * 线性表的链式表示和实现，带头结点的单链表类，实现线性表接口
 *
 * @author cier
 * @date 2018/1/23 14:53
 */
public class LinkedListImpl<T> implements ILinkedList<T> {
    // 头指针，指向单链表的头结点
    public Node<T> head;

    /**
     * 默认的构造方法，构造空的单链表
     * 空的单链表中只有一个头节点
     * 头结点不计入链表长度
     */
    public LinkedListImpl() {
        // 创建头结点，data和next都为null
        this.head = new Node<T>();
    }

    /**
     * 由指定数组中的多个对象构造单链表
     * 采用尾插法插入构造单链表
     * 若 t == null,Java 将抛出空对象异常
     * 若 t.length == 0,构造空链表
     *
     * @param t
     */
    public LinkedListImpl(T[] t) {
        // 创建空单链表，只有头结点
        this();
        // rear 指向单链表最后一个结点
        Node<T> rear = this.head;
        for (int i = 0; i < t.length; i++) {
            // 把一个数据域为 t[i],地址域为 null 的结点赋给最后一个结点的下一个结点
            rear.next = new Node<T>(t[i], null);
            // 把下一个结点的地址域赋给rear
            rear = rear.next;
        }
    }

    /**
     * 判断单链表是否为空
     * 时间复杂度为O(1)
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        // 只需要判断头指针的地址域是不是为空即可
        return this.head.next == null;
    }

    /**
     * 返回单链表长度
     * 时间复杂度为O(n)
     *
     * @return
     */
    @Override
    public int length() {
        int i = 0;
        // p 从单链表第一个结点开始，头结点不算在单链表的长度中
        Node<T> p = this.head.next;
        // 判断结点是否有后继元素
        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }

    /**
     * 返回第 i (i >= 0) 个元素，若 i < 0 或者大于表长则返回null
     * 时间复杂度为O(n)
     *
     * @param i 下标索引
     * @return
     */
    @Override
    public T get(int i) {
        if (i >= 1) {
            // 从第一个结点开始
            Node<T> p = this.head.next;
            // 必须判断 p!=null ,如果 p = null，那么 null.next 会出现空指针异常
            for (int j = 1; p != null && j < i; j++) {
                p = p.next;
            }
            // 这一层判断 p!=null 也是必要的。因为上面的循环结束可能是因为 j == i 了，但是不知道 p 是否等于 null，如果 p == null,会出现空指针异常
            if (p != null) {
                return p.data;
            } else {
                System.out.println("该结点不存在");
            }
        } else {
            System.out.println("下标索引不能小于1");
        }
        return null;
    }

    /**
     * 如果 t == null ,则直接返回
     * 设置第 i (i >= 0) 的元素值为 t.若 i < 0 或者 大于表长则打印错误信息
     * 时间复杂度为 O(n)
     *
     * @param i 下标索引
     * @param t 元素值
     */
    @Override
    public void set(int i, T t) {
        if (t == null) {
            return;
        }
        Node<T> p = this.head.next;
        for (int j = 1; p != null && j < i; j++) {
            p = p.next;
        }
        if (i >= 1 && p != null) {
            p.data = t;
        } else {
            System.out.println("i 值设置有误，插入失败");
        }
    }

    /**
     * 插入第 i 个元素值为 t.
     * 如果 t = null, 则直接返回
     * 如果 i < 0,插入 t 作为 第 0 个元素
     * 如果 i > 表长，插入 t 作为 最后一个元素
     * 时间复杂度为 O(n)
     *
     * @param i 下标索引
     * @param t 元素值
     */
    @Override
    public void insert(int i, T t) {
        // 不能插入空对象
        if (t == null) {
            return;
        }

        // p 指向头结点
        Node<T> p = this.head;
        // 找到插入的位置
        for (int j = 1; p.next != null && j < i; j++) {
            // 当下一个结点不为空对象的时候才能赋值给 p;
            p = p.next;
        }
        // 插入 t 作为 p 结点的后继结点
        // 因为是插入，所以插入的结点的地址域是 p.next
        p.next = new Node<T>(t, p.next);
    }

    /**
     * 在单链表的最后追加 t 对象
     *
     * @param t 元素值
     */
    @Override
    public void append(T t) {
        // 直接追加下标索引为长度加1的结点就行
        insert(length() + 1, t);
    }

    @Override
    public T remove(int i) {
        if (i >= 1 && i <= length()) {
            // 从头结点开始
            Node<T> p = this.head;
            for (int j = 1; p.next != null && j < i; j++) {
                // 如果下一个结点不为空对象才能进行赋值
                p = p.next;
            }
            if (p != null) {
                // 获得原对象,这个地方为什么是 p.next.data可以通过简单的推导得出
                T t = p.next.data;
                // 删除 p 的后继结点
                p.next = p.next.next;
                return t;
            }
        } else {
            System.out.println("warning : 下标索引不在范围之内");
        }
        return null;
    }

    /**
     * 删除单链表中所有的元素
     * Java的垃圾回收机制会自动回收无用的对象所占的空间
     */
    @Override
    public void removeAll() {
        this.head.next = null;
    }

    /**
     * 查找关键字为 t 的元素
     * 返回首次出现的元素，找到则返回该数据，查找不成功则返回null
     * 时间复杂度为O(n)
     *
     * @param t
     * @return
     */
    @Override
    public T search(T t) {
        if (t == null) {
            return null;
        }
        // 从第一个结点开始，当遇到 p = null 的时候结束循环
        for (Node<T> p = this.head.next; p != null; p = p.next) {
            // 判断结点中数据域的值是否相等，调用的是Node类中重写的 equals 方法
            if (p.data.equals(t)) {
                return p.data;
            }
        }
        System.out.println("warning : 没有 "+t+" 这个数据");
        return null;
    }

    /**
     * 返回单链表的描述字符串
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("(");
        for (Node<T> p = this.head.next; p != null; p = p.next) {
            str.append(p.data.toString());
            if (p.next != null) {
                str.append(",");
            }
        }
        return str.append(")").toString();
    }

    /**
     * 判断两个单链表是否相等
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof LinkedListImpl) {
            LinkedListImpl<T> list = (LinkedListImpl<T>) obj;
            return equals(this.head.next, list.head.next);
        }
        return super.equals(obj);
    }

    /**
     * 递归判断两个单链表的数据域是否一一对应相等
     * @param p
     * @param q
     * @return
     */
    private boolean equals(Node<T> p, Node<T> q) {
        return (p == null && q == null) || (p != null && q != null && p.data.equals(q.data) && equals(p.next, q.next));
    }
}
