package com.stucture.tree.parent;

import java.util.List;

public interface IParentalTree<E> {
    /**
     * 添加子节点
     * @param data
     * @param parent
     */
    public void addNode(E data, Node<E> parent);

    /**
     * 获取根节点
     * @return
     */
    public Node<E> getRoot();

    /**
     * 获取双亲节点
     * @param node
     * @return
     */
    public Node<E> getParent(Node<E> node);

    /**
     * 获取子节点
     * @param node
     * @return
     */
    public List<Node<E>> getChild(Node<E> node);

    /**
     * 获取所有的节点
     * @return
     */
    public List<Node<E>> getAllNode();

    /**
     * 获取指定节点的位置
     * @param node
     * @return
     */
    public int getPos(Node<E> node);

    /**
     * 获取树的深度
     * @return
     */
    public int getDeepth();
}
