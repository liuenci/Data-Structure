package com.stucture.tree.binary.linked;

/**
 * created by cier on 2018/3/6 9:21
 */
public class TwoLinkedTree<E> {
    public TreeNode root;

    public static class TreeNode {
        Object data;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 创建一颗空树
     */
    public TwoLinkedTree() {
        this.root = new TreeNode();
    }

    /**
     * 以指定根元素创建树
     *
     * @param data
     */
    public TwoLinkedTree(E data) {
        this.root = new TreeNode(data);
    }
}
