package com.stucture.linkedlist;

/**
 * @author cier
 * @date 2018/1/23 16:10
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedListImpl<String> linkedList = new LinkedListImpl<String>();
        for (int i = 0;i <= 5;i++){
            linkedList.insert(i,new String((char)('A'+i)+""));
        }
        System.out.println("linkedlist:"+linkedList.toString());
        System.out.println("length:"+linkedList.length());
        linkedList.set(1,"x");
        System.out.println("linkedlist:"+linkedList.toString());
        System.out.println("length:"+linkedList.length());
        linkedList.insert(1,"Y");
        System.out.println("linkedlist:"+linkedList.toString());
        System.out.println("length:"+linkedList.length());
        /*linkedList.removeAll();
        System.out.println("linkedlist:"+linkedList.toString());
        System.out.println("length:"+linkedList.length());*/
        linkedList.remove(0);
        System.out.println("linkedlist:"+linkedList.toString());
        System.out.println("length:"+linkedList.length());
    }


}
