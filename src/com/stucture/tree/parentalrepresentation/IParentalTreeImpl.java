package com.stucture.tree.parentalrepresentation;

import java.util.ArrayList;
import java.util.List;

/**
 * created by cier on 2018/3/4 14:39
 */
public class IParentalTreeImpl<E> implements IParentalTree<E> {
    public final int MAX_TREE_SIZE = 100;
    public Node<E>[] nodes; // 定义节点数组
    public int treeSize;
    public int nodeNum = 0;

    /**
     * 创建空树
     */
    public IParentalTreeImpl() {
        treeSize = MAX_TREE_SIZE;
        nodes = new Node[treeSize];
    }

    /**
     * 指定根节点创建树
     *
     * @param data
     */
    public IParentalTreeImpl(E data) {
        treeSize = MAX_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data, -1); // 定义根节点
        nodeNum++;
    }

    /**
     * 指定根节点和节点数创建树
     *
     * @param data
     * @param treeSize
     */
    public IParentalTreeImpl(E data, int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data, -1); // 定义根节点
        nodeNum++;
    }

    /**
     * 添加子节点
     *
     * @param data
     * @param parent
     */
    @Override
    public void addNode(E data, Node<E> parent) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node<E>(data, getPos(parent));
                nodeNum++;
                return; // 必须 return，不然循环会继续找到下一个 nodes[i] == null;
            }
        }
    }

    /**
     * 获取根节点
     *
     * @return
     */
    @Override
    public Node<E> getRoot() {
        if (nodeNum > 0) {
            return nodes[0];
        }
        return null;
    }

    /**
     * 获取双亲节点
     *
     * @param node
     * @return
     */
    @Override
    public Node<E> getParent(Node<E> node) {
        return nodes[node.getParent()];
    }

    /**
     * 获取子节点
     *
     * @param node
     * @return
     */
    @Override
    public List<Node<E>> getChild(Node<E> node) {
        List<Node<E>> list = new ArrayList<Node<E>>();
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] != null && nodes[i].getParent() == getPos(node)) {
                list.add(nodes[i]);
            }
        }
        return list;
    }

    /**
     * 获取所有的节点
     *
     * @return
     */
    @Override
    public List<Node<E>> getAllNode() {
        List<Node<E>> list = new ArrayList<Node<E>>();
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] != null) {
                list.add(nodes[i]);
            }
        }
        return list;
    }

    /**
     * 获取指定节点的位置
     *
     * @param node
     * @return
     */
    @Override
    public int getPos(Node<E> node) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i].equals(node)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取树的深度
     *
     * @return
     */
    @Override
    public int getDeepth() {
        int max = 0; // 用于记录节点的最大深度
        for (int i = 0; i < treeSize && nodes[i] != null; i++) {
            // 初始化节点的深度
            int deepth = 1;
            // m 用于记录当前节点的双亲节点的位置
            int m = nodes[i].getParent();
            // 如果双亲节点存在，则向上继续搜索双亲节点
            while (m != -1 && nodes[m] != null) {
                m = nodes[m].getParent();
                deepth++;
            }
            if (max < deepth) {
                max = deepth;
            }
        }
        return max;
    }
}
