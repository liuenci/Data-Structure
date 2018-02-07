package com.stucture.list.doublelinkedlist;

/**
 * @author cier
 * @date 2018/1/28 17:30
 */
public class DoubleLinkedListTest {

    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.insert("aaaa",0);
        System.out.println(list);
        list.add("bbbb");
        System.out.println(list);
        list.insert("cccc",1);
        System.out.println(list);
        list.delete(1);
        System.out.println(list);
        System.out.println(list.locate("cccc"));
        System.out.println(list.get(1));
    }

}
