package com.stucture.list.circularLinkedList;

/**
 * @author cier
 * @date 2018/1/27 11:15
 */
public class CircularListTest {
    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.addHead(new Node(111));
        for (int i = 0; i < 10; i++) {
            list.addHead(new Node(i));
        }
        list.printList();
        System.out.println();
        list.delHead();
        System.out.println();
        list.delHead();
        System.out.println();
        list.printList();
        System.out.println();
        list.addHead(new Node(112));
        list.printList();
    }
}
