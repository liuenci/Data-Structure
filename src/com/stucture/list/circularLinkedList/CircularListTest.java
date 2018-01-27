package com.stucture.list.circularLinkedList;

/**
 * @author cier
 * @date 2018/1/27 11:15
 */
public class CircularListTest {
    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.addHead(new Node(111));
       /* for (int i = 0; i < 10; i++) {
            list.addHead(new Node(i));
        }*/
        list.printList();
        list.addNode(1,new Node(11111));
        System.out.println("\n"+list.toString());
        list.delNode(2);
        System.out.println("\n"+list.toString());
        list.delNode(1);
        System.out.println("\n"+list.toString());
        /*list.delHead();
        System.out.println(list.toString());
        list.delHead();
        System.out.println(list.toString());
        list.delTail();
        System.out.println(list.toString());
        System.out.println(list.toString());*/
    }
}
