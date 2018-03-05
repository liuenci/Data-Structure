package com.stucture.tree.parent;

/**
 * created by cier on 2018/3/4 11:15
 */
public class Node<E> {
    private E data; // 数据域
    private int parent; // 双亲

    public Node(E data, int parent) {
        this.data = data;
        this.parent = parent;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + parent;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Node other = (Node) obj;
        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!data.equals(other.data)){
            return false;
        }
        if (parent !=other.parent) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Node [data = " + data + ", parent = " + parent +"]";
    }
}
