package com.stucture.tree.child;
import com.stucture.tree.child.TreeChild.Node;

import java.util.List;

/**
 * created by cier on 2018/3/5 9:56
 */
public class TreeChildTest {
    public static void main(String[] args) {
        TreeChild<String> tree = new TreeChild<String>("root");
        Node<String> root = tree.getRoot();
        System.out.println("根节点："+root);
        tree.addNode("结点1",root);
        tree.addNode("结点2",root);
        tree.addNode("结点3",root);
        System.out.println("==================================");
        System.out.println("添加子结点后的根节点:"+root);
        System.out.println("树的深度："+tree.getAllDeepth());
        System.out.println("==================================");
        List<Node<String>> nodes = tree.getChildren(root);
        System.out.println("根节点的第一个子结点:"+nodes.get(0));
        System.out.println("==================================");
        tree.addNode("结点4",nodes.get(0));
        System.out.println("==================================");
        List<Node<String>> node3 = tree.getChildren(nodes.get(0));
        System.out.println("第三层结点的第一个子结点:"+node3.get(0));
        System.out.println("树的深度:"+tree.getDeepth(root));
    }
}
