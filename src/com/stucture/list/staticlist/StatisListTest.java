package com.stucture.list.staticlist;

/**
 * @author cier
 * @date 2018/1/24 16:01
 */
public class StatisListTest {
    public static void main(String[] args) {
        NodeList<String> nodeList = new NodeList<String>();
        String[] strings = {"甲","乙","丁","戊","己","庚"};
        for (int i = 0; i < 6; i++) {
            nodeList.insert(strings[i],1+1);
        }
        for (int i = 1; i < 6; i++){
            System.out.println(nodeList.data[i].cur);
        }
        System.out.println(nodeList.toString());
        System.out.println("静态链表的长度为:" + nodeList.length());
        System.out.println("========================");
        nodeList.insert("丙",3);
        System.out.println(nodeList.toString());
        System.out.println("静态链表的长度为:" + nodeList.length());
        System.out.println("========================");
        nodeList.remove(1);
        System.out.println(nodeList.toString());
        System.out.println("静态链表的长度为:" + nodeList.length());
        System.out.println("========================");
    }
}
