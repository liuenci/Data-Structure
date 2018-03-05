package com.stucture.tree.childbrother;

/**
 * created by cier on 2018/3/5 10:57
 */
public class MyTree<T> {
    // 记录根结点
    private Node root;
    private int nodeCount;
    private int superFlag;

    /**
     * 创建只有根结点的树
     * @param data
     */
    public MyTree(T data) {
        root = new Node(data);
    }

    /**
     * 在指定位置添加结点
     * @param data
     * @param flag
     */
    public void add (T data, int flag) {
        // 定位到指定的位置
        Node point = getNodePost(flag);
        // 错误检查，判断是否为空，如果为空抛出异常
        if (point == null) {
            System.out.println("没有此元素");
            return;
        }else {
            // 判断孩子结点为空或者是非空，然后进行不同的操作
            if (point.getChild() == null) {
                point.setChild(new Node(data));
            }else{
                Node temp = point.getChild();
                Node newNode = new Node(data);
                point.setChild(newNode);
            }
        }
        // 元素标识 +1
        flag++;
    }

    /**
     * 定位结点位置，找出该结点
     * @param flag
     * @return
     */
    public Node getNodePost(int flag) {
        // 调用另外一个复用方法实现
        return getNodePost(flag,root);
    }

    public Node getNodePost(int flag, Node node) {
        // 结点指针，先从 root 结点开始递归
        Node point = root;

        // 当递归到一个元素的 flag 等于要查找的 flag 则返回当前的指针
        if (point.flag == flag) {
            return point;
        }

        // 若兄弟结点非空，则递归取出元素
        if (point.getBrother() != null) {
            return getNodePost(flag,point.getBrother());
        }
        // 若子结点非空，则递归取出元素
        if (point.getChild() != null) {
            return getNodePost(flag,point.getChild());
        }

        // 若没找到则返回 null
        return null;
    }
    private class Node {
        T data;
        Node child;
        Node brother;
        int flag;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getChild() {
            return child;
        }

        public void setChild(Node child) {
            this.child = child;
        }

        public Node getBrother() {
            return brother;
        }

        public void setBrother(Node brother) {
            this.brother = brother;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public Node(T data, Node child, Node brother, int flag) {
            this.data = data;
            this.child = child;
            this.brother = brother;
            this.flag = flag;
        }

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(12);
        myTree.add(1,0);
        myTree.add(2,0);
        System.out.println(myTree.root.child.getData());
    }
}
