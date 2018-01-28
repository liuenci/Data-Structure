package com.stucture.list.doublelinkedlist;

/**
 * @author cier
 * @date 2018/1/28 11:01
 */
public class DoubleLinkedList<T> {
    // 定义一个内部类Node,Node实例代表链表的结点
    private class Node {
        // 保存结点的数据
        private T data;
        // 保存上一个结点的引用
        private Node prev;
        // 保存下一个结点的引用
        private Node next;

        public Node() {

        }

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // 指向第一个元素
    private Node head;
    // 指向最后一个元素
    private Node tail;
    // 链表长度
    private int size;

    /**
     * 创建空链表
     */
    public DoubleLinkedList() {
        // 空链表的头结点和尾结点都是null
        head = null;
        tail = null;
    }

    /**
     * 以制定数据元素来创建链表，该链表只有一个元素
     *
     * @param element
     */
    public DoubleLinkedList(T element) {
        head = new Node(element, null, null);
        tail = head;
        size++;
    }

    /**
     * 返回链表的长度
     */
    public int length() {
        return size;
    }

    /**
     * 获取双向链表中索引为index处的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    public Node getNodeByIndex(int index) {
        if (size == 0) {
            return null;
        } else if (index < 1 || index > size) {
            System.out.println("双向链表索引位置不合法");
            return null;
        } else if (index <= size / 2) {
            // 从 head 结点开始遍历
            Node node = head;
            for (int i = 1; i <= size / 2 && node != null; i++, node = node.next) {
                if (i == index) {
                    return node;
                }
            }
        } else {
            // 从 tail 结点开始遍历
            Node node = tail;
            for (int i = size; i > size / 2 && node != null; i--, node = node.prev) {
                if (i == index) {
                    return node;
                }
            }
        }
        return null;
    }

    /**
     * 查找链式线性表中指定元素的索引
     * @param element
     * @return
     */
    public int locate(T element) {
        // 从 head 结点开始遍历
        Node node = head;
        for (int i = 1; i <= size && node != null; i++, node = node.next) {
            if (node.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void insert(T element, int index) {
        // 如果是空链表直接插入
        if (head == null) {
            add(element);
        } else {
            if (index < 1 || index > size) {
                System.out.println("插入位置不合理");
            } else if (index == 1) {
                addAtHead(element);
            } else {
                // 获取插入结点的前一个结点
                Node prev = getNodeByIndex(index - 1);
                // 获取插入点的结点
                Node next = prev.next;
                // 让新结点的 next 引用指向 next 结点， prev 引用指向 prev 结点
                Node newNode = new Node(element,prev,next);
                // 让 prev 的 next 结点指向新结点
                prev.next = newNode;
                // 让 prev 的下一个结点的 prev 指向新结点
                next.prev = newNode;
                size++;
            }
        }
    }

    /**
     * 尾插法添加新结点
     * @param element
     */
    public void add(T element) {
        // 如果该链表是空链表
        if (head == null) {
            head = new Node(element,null,null);
            tail = head;
        } else {
            // 创建新的结点，新结点的 prev 指向 tail 结点
            Node newNode = new Node(element, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * 使用头插法插入新结点
     * @param element
     */
    public void addAtHead(T element) {
        // 创建新结点指向原来的 head 结点
        head = new Node(element,null,head);
        // 如果插入之前是空链表
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    /**
     * 删除双向链表中指定索引处的元素
     * @param index
     * @return
     */
    public T delete(int index) {
        if (size == 0) {
            System.out.println("该链表是空链表无法删除");
        }else if (index < 0 || index > size - 1) {
            System.out.println("删除的位置不合法");
            return null;
        }
        Node node = null;
        if (index == 0) {
            node = head;
            head = head.next;
            head.prev = null;
        } else {
            // 获取删除结点的前一个结点
            Node prev = getNodeByIndex(index - 1);
            // 获得将要被删除的结点
            node = prev.next;
            // 让被删除结点的 next 指向被删除结点的下一个结点
            prev.next = node.next;
            // 让被删除结点的下一个结点的 prev 指向 prev 结点
            if (node.next!=null) {
                node.next.prev = prev;
            }
            // 将被删除结点的 prev,next 引用赋给 null
            node.prev = null;
            node.next = null;
        }
        size--;
        return node.data;
    }

    /**
     * 删除链表中最后一个元素
     * @return
     */
    public T remove(){
        return delete(size - 1);
    }

    /**
     * 判断链表是否为空链表
     * @return
     */
    public boolean empty(){
        return size == 0;
    }

    /**
     * 清空链表
     */
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuffer stringBuffer = new StringBuffer("[");
            for (Node node = head; node!= null;node = node.next) {
                stringBuffer.append(node.data + ",");
            }
            int len = stringBuffer.length();
            return stringBuffer.delete(len -1,len).append("]").toString();
        }
    }
}

