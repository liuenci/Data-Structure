package com.stucture.list.staticlist2;

/**
 * @author cier
 * @date 2018/1/26 9:17
 */
public class Node<T> {
    private T data;
    private int cursor;

    public Node(T data,int cursor) {
        this.data = data;
        this.cursor = cursor;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("data:"+getData());
        stringBuffer.append(" ");
        stringBuffer.append("cursor:"+getCursor());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
