package com.stucture.tree.parentalrepresentation;

/**
 * created by cier on 2018/3/4 15:05
 */
public class IParentalTreeTest {
    public static void main(String[] args) {
        // 根据值创建树
        IParentalTreeImpl<String> tree = new IParentalTreeImpl<String>("根节点");
        // 添加子节点
        Node<String> root = new Node<String>("根节点", -1);

        Node<String> node1 = new Node<String>("节点1", 0);
        tree.addNode(node1.getData(), root);

        Node<String> node2 = new Node<String>("节点2", 0);
        tree.addNode(node2.getData(), root);

        Node<String> node3 = new Node<String>("节点3", 1);
        tree.addNode(node3.getData(), node1);

        Node<String> node4 = new Node<String>("节点4", 1);
        tree.addNode(node4.getData(), node1);

        Node<String> node5 = new Node<String>("节点5", 2);
        tree.addNode(node5.getData(), node2);

        Node<String> node6 = new Node<String>("节点6", 2);
        tree.addNode(node6.getData(), node2);

        // 输出根节点
        System.out.println("根节点为:" + tree.getRoot());

        // 输出树的深度
        System.out.println("树的深度为:"+tree.getDeepth());

        // 获得某个节点的双亲节点
        // System.out.println("node5的双亲节点为:"+tree.getParent(root));
        System.out.println("node1 的双亲节点为:"+tree.getParent(node1));
        System.out.println("node2 的双亲节点为:"+tree.getParent(node2));
        System.out.println("node3 的双亲节点为:"+tree.getParent(node3));
        System.out.println("node4 的双亲节点为:"+tree.getParent(node4));
        System.out.println("node5 的双亲节点为:"+tree.getParent(node5));
        System.out.println("node6 的双亲节点为:"+tree.getParent(node6));



    }
}
