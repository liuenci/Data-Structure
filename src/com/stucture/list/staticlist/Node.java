package com.stucture.list.staticlist;

/**
 * @author cier
 * @date 2018/1/24 11:28
 */
public class Node<T> {
    public T data;
    public int cur;

    public Node(T data,int cur) {
        this.data = data;
        this.cur = cur;
    }
}
