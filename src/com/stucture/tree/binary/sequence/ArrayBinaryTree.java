package com.stucture.tree.binary.sequence;

import java.util.Arrays;

/**
 * created by cier on 2018/3/5 20:32
 */
public class ArrayBinaryTree<T> {
    private Object[] arr; // 用数组来存储树的所有结点
    private int deep; // 保存树的深度
    private int size; // 数组大小
    private static final int DEFAULT_DEEP = 5; // 树的默认深度

    /**
     * 以默认的深度来创建二叉树
     */
    public ArrayBinaryTree() {
        this.deep = DEFAULT_DEEP;
        this.size = (int) Math.pow(2, deep) - 1;
        arr = new Object[size];
    }

    /**
     * 以指定深度来创建二叉树
     *
     * @param deep
     */
    public ArrayBinaryTree(int deep) {
        this.deep = deep;
        this.size = (int) Math.pow(2, deep) - 1;
        arr = new Object[size];
    }

    /**
     * 以指定深度和根节点来创建二叉树
     *
     * @param deep
     */
    public ArrayBinaryTree(int deep, T data) {
        this.deep = deep;
        this.size = (int) Math.pow(2, deep) - 1;
        arr = new Object[size];
        arr[0] = data;
    }

    /**
     * 为指定节点添加子节点
     *
     * @param index 需要添加子结点的父节点的索引
     * @param data  新结点的数据
     * @param left  是否为左结点
     */
    public void add(int index, T data, boolean left) {
        if (arr[index] == null) {
            System.out.println("该结点为空，无法添加结点");
            return;
        }
        if (2 * index + 1 >= size) {
            System.out.println("树已满，无法添加结点");
        }
        if (left) {
            // +1 是因为树的存储是从 0 开始的，所以少算了一位
            arr[2 * index + 1] = data; // 添加左子结点
        } else {
            arr[2 * index + 2] = data; // 添加右子节点
        }
    }

    /**
     * 判断二叉树是否为空
     * @return
     */
    public boolean isEmpty() {
        return arr[0] == null; //根据根元素来判断二叉树是否为空
    }

    /**
     * 获取根节点
     * @return
     */
    public T getRoot() {
        return (T)arr[0];
    }

    /**
     * 返回指定节点(非根节点)的双亲结点
     * @param index
     * @return
     */
    public T getParents(int index) {
        return (T)arr[(index - 1) / 2];
    }

    /**
     * 返回
     * @param index
     * @return
     */
    public T getLeft(int index) {
        if (2 * index + 1 >= size) {
            System.out.println("该结点为叶子结点，无子结点。");
            return null;
        }
        return (T)arr[index * 2 + 1];
    }

    /**
     * 返回指定节点(非叶子)的右子节点，当右子结点不存在时返回 null
     * @param index
     * @return
     */
    public T getRight(int index){
        if (2 * index +1 >=size) {
            System.out.println("该结点为叶子节点，无子结点");
            return null;
        }
        return (T)arr[index * 2 + 2];
    }

    /**
     * 返回该二叉树的深度
     * @return
     */
    public int getDeepth() {
        return deep;
    }

    /**
     * 返回指定位置在数组中的位置
     * @param data
     * @return
     */
    public int index(T data) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 打印数组
     * @return
     */
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        ArrayBinaryTree<String> binaryTree = new ArrayBinaryTree<>(4,"根节点");
        binaryTree.add(0,"第二层右子结点",false);
        binaryTree.add(2,"第三层右子结点",false);
        binaryTree.add(6,"第四层右子结点",false);
        System.out.println("树的深度为:"+binaryTree.getDeepth());
        System.out.println(binaryTree.getLeft(0));
        System.out.println(binaryTree);
        System.out.println(binaryTree.getRight(0));
        System.out.println(binaryTree.index("根节点"));
    }
}
