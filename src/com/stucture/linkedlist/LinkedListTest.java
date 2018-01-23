package com.stucture.linkedlist;

/**
 * @author cier
 * @date 2018/1/23 16:10
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedListImpl<String> linkedList = new LinkedListImpl<String>();
        for (int i = 1;i <= 5;i++){
            linkedList.insert(i,new String((char)('A'+i-1)+""));
        }
        System.out.println("单链表元素列表:"+linkedList.toString());
        System.out.println("单链表元素长度:"+linkedList.length());

        System.out.println();
        linkedList.insert(1,"H");
        System.out.println("单链表元素列表:"+linkedList.toString());
        System.out.println("单链表元素长度:"+linkedList.length());

        System.out.println();
        String removeOne = linkedList.remove(1);
        System.out.println("单链表元素列表:"+linkedList.toString());
        System.out.println("单链表元素长度:"+linkedList.length());
        System.out.println("移除的元素为:"+removeOne);

        System.out.println();
        String searchOne = linkedList.search("A");
        System.out.println("单链表元素列表:"+linkedList.toString());
        System.out.println("单链表元素长度:"+linkedList.length());
        System.out.println("查找的元素为:"+searchOne);

        System.out.println();
        linkedList.set(1,"W");
        System.out.println("单链表元素列表:"+linkedList.toString());
        System.out.println("单链表元素长度:"+linkedList.length());

        System.out.println();
        String[] str = new String[]{"W","B","C","D","E"};
        LinkedListImpl<String> stringLinkedList = new LinkedListImpl<>(str);
        System.out.println("单链表元素列表:"+linkedList.toString());
        System.out.println("单链表元素长度:"+linkedList.length());

        System.out.println();
        System.out.println("两个链表是否相等:"+linkedList.equals(stringLinkedList));

        System.out.println();
        linkedList.set(1,"A");
        System.out.println("两个链表是否相等:"+linkedList.equals(stringLinkedList));
    }


}
