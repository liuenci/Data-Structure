package com.stucture.list.circularLinkedList;

/**
 * @author cier
 * @date 2018/1/27 10:44
 */
public class CircularList {
    private Node head;
    private Node tail;
    int size;

    public CircularList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 在链表头部添加结点
     *
     * @param node
     */
    public void addHead(Node node) {
        // 如果使用该方法增加链表的第一个结点，则 head = tail = node,且 next 指向自身
        if (size == 0) {
            node.setNext(node);
            head = tail = node;
        } else {
            tail.setNext(node);
            node.setNext(head);
            head = node;
        }
        size++;
    }

    /**
     * 在链表尾部添加结点
     *
     * @param node
     */
    public void addTail(Node node) {
        // 如果使用该方法增加链表的第一个结点，则 head = tail = node,且 next 指向自身
        if (size == 0) {
            node.setNext(node);
            head = tail = node;
        } else {
            tail.setNext(node);
            node.setNext(head);
            tail = node;
        }
        size++;
    }

    /**
     * 将新的结点插入到 i 位置处
     * @param i
     * @param node
     */
    public void addNode(int i, Node node) {
        if (i > size) {
            addTail(node);
            return;
        } else if (i <= 1) {
            addHead(node);
            return;
        } else {
            if (size == 0) {
                node.setNext(node);
                head = tail = node;
            } else {
                int index = 1;
                Node nd = head;
                while (index < i - 1) {
                    nd = nd.getNext();
                    index++;
                }
                node.setNext(nd.getNext());
                nd.setNext(node);
            }
        }
        size++;
    }

    /**
     * 删除头部结点，被删除的head将会被自动回收
     */
    public void delHead() {
        if (size > 1) {
            head = head.getNext();
            tail.setNext(head);
            size--;
        } else if (size == 1) {
            head = tail = null;
            size--;
        } else {
            System.out.println("该链表为空链表，无法删除");
        }
    }

    /**
     * 删除尾部结点
     */
    public void delTail() {
        if (size > 1) {
            Node node = head;
            while (node.getNext() != tail) {
                node = node.getNext();
            }
            node.setNext(head);
            size--;
        } else if (size == 1) {
            head = tail = null;
            size--;
        } else {
            System.out.println("该链表为空链表，无法删除");
        }
    }
    public void delNode(int i) {
        if (i < 1 || i > size) {
            System.out.println("要删除的位置非法，删除失败");
        } else if (i == 1){
            delHead();
            return;
        } else {
            Node node = head;
            if (node != null) {
                int index = 1;
                while (index < i - 1) {
                    node = node.getNext();
                    index++;
                }
                node.setNext(node.getNext().getNext());
            } else {
                System.out.println("循环链表为空，不能删除");
            }
        }
        size--;
    }
    //打印全部节点
    public void printList() {
        Node nd = new Node();
        nd = head;
        try {
            while (nd.getNext() != head) {
                System.out.print(nd.getData());
                System.out.print("->");
                nd = nd.getNext();
            }
            System.out.print(nd.getData());
            System.out.print("->");
            System.out.print(head.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        Node node = head;
        StringBuffer stringBuffer = new StringBuffer();
        while (node.getNext() != head) {
            stringBuffer.append(node.getData());
            stringBuffer.append("->");
            node = node.getNext();
        }
        stringBuffer.append(node.getData());
        stringBuffer.append("->");
        stringBuffer.append(head.getData());
        return stringBuffer.toString();
    }
}
