package com.stucture.list.staticlist2;

/**
 * @author cier
 * @date 2018/1/26 21:01
 */
public class StaticListTest {
    public static void main(String[] args) {
        StaticListImpl<String> list = new StaticListImpl<String>();
        list.insert("甲");
        list.insert("乙");
        /*list.insert("丙");
        list.insert("丁");
        list.insert("戊");
        list.insert("己");
        list.insert("庚");
        list.insert("辛");
        list.insert("壬");
        list.insert("奎");*/
        System.out.println(list);
        list.remove(12);
        System.out.println(list);
        list.removeAll();
        System.out.println(list);
    }
}
