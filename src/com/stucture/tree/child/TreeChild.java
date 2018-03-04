package com.stucture.tree.child;

import java.util.ArrayList;
import java.util.List;

/**
 * created by cier on 2018/3/4 22:19
 */
public class TreeChild<E> {
    private final int DEFAULT_TREE_SIZE = 100;
    private int treeSize = 0;
    private Node<E>[] nodes; // 记录树的所有结点
    private int nodeNums; // 记录结点树

    /**
     * 指定根结点创建树
     * 不指定树大小
     *
     * @param data
     */
    public TreeChild(E data) {
        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data);
        nodeNums++;
    }

    /**
     * 指定根结点创建树
     * 并且指定树大小
     *
     * @param data
     * @param treeSize
     */
    public TreeChild(E data, int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data);
        nodeNums++;
    }

    /**
     * 为指定结点添加新结点
     *
     * @param data
     * @param node
     */
    public void addNode(E data, Node<E> node) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] != null) {
                nodes[i] = new Node<E>(data);
                // 如果该结点没有第一个子结点，那么就新建子结点
                if (node.first == null) {
                    node.first = new ChildNode(i, null);
                } else {
                    // 如果有，则以此取该结点的子结点，直到叶子结点
                    ChildNode next = node.first;
                    while (next.next != null) {
                        next = next.next;
                    }
                    // 在叶子结点处添加该结点
                    next.next = new ChildNode(i, null);
                }
                nodeNums++;
                return;
            }
        }
    }

    /**
     * 判断是否为空树
     *
     * @return
     */
    public boolean isEmpty() {
        return nodes[0] == null;
    }

    /**
     * 获取根结点
     *
     * @return
     */
    public Node<E> getRoot() {
        return nodes[0];
    }

    /**
     * 获取指定结点的所有子结点
     *
     * @param node
     * @return
     */
    public List<Node<E>> getChildren(Node<E> node) {
        List<Node<E>> list = new ArrayList<Node<E>>();
        // 获取给定结点的第一个子结点
        ChildNode next = node.first;
        // 沿着孩子链不断搜索下一个孩子结点
        while (next != null) {
            // 添加孩子链中的结点
            list.add(nodes[next.pos]);
            next = next.next;
        }
        return list;
    }

    /**
     * 返回指定结点的第 index 个子结点
     *
     * @param node
     * @param index
     * @return
     */
    public Node<E> getChildByIndex(Node<E> node, int index) {
        // 获取该结点的第一个子结点
        ChildNode next = node.first;
        // 沿着孩子链一直搜寻
        for (int i = 0; next != null; i++) {
            if (index == i) {
                return nodes[next.pos];
            }
            next = next.next;
        }
        return null;
    }

    /**
     * 递归的方式返回某个结点的深度
     *
     * @param node
     * @return
     */
    public int getDeepth(Node<E> node) {
        if (node.first == null) {
            return 1;
        } else {
            int max = 0;
            ChildNode next = node.first;
            while (next != null) {
                // 获取以其子结点为根的子树的深度
                int temp = this.getDeepth(nodes[next.pos]);
                if (temp > max) {
                    max = temp;
                }
                next = next.next;
            }
            return max + 1;
        }
    }

    /**
     * 获取最大深度
     * @return
     */
    public int getAllDeepth() {
        return this.getDeepth(getRoot());
    }

    /**
     * 返回包含指定节点的索引
     * @param node
     * @return
     */
    public int pos(Node<E> node) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 子结点数据结构
     */
    public static class ChildNode {
        public int pos; //记录当前结点位置
        public ChildNode next;

        public ChildNode(int pos, ChildNode next) {
            this.pos = pos;
            this.next = next;
        }
    }

    /**
     * 结点数据结构
     *
     * @param <T>
     */
    public static class Node<T> {
        T data;
        ChildNode first; // 记录第一个子结点

        public Node() {

        }

        public Node(T data) {
            this.data = data;
            this.first = null;
        }

        @Override
        public String toString() {
            if (first != null) {
                return "TreeChild$Node[data=" + data + ", first=" + first.pos + "]";
            }
            return "TreeChild$Node[data=" + data + ", first=-1]";
        }
    }


}
