package com.stucture.sqlList;

import java.util.Random;

/**
 * 测试线性表
 * @author cier
 * @date 2018/1/22 11:47
 */
public class SeqListTest {
    final int MAX = 25;
    Random r = new Random();
    SeqList<Integer> seqList;

    public SeqListTest(){
        initSeqList();
    }

    /**
     * 创建一个线性表顺序存储结构
     */
    public void initSeqList(){
        seqList = new SeqList<Integer>();
        int length = Math.abs(r.nextInt(MAX));
        System.out.println("产生的数组长度为："+length);

        if (length > SeqList.MAXSIZE) {
            System.out.println("该长度不合法");
        }

        for (int i = 1; i<=length; i++){
            int j = r.nextInt(MAX);
            System.out.print(j + " ");
            if (!seqList.insertElem(i,j)) {
                System.exit(0);
            }
        }
        System.out.println("\n原始数组是：");
        display(seqList);
    }

    /**
     * 测试删除元素
     */
    public void deleteElem() {
        int i = r.nextInt(MAX);
        System.out.println("\n\n删除的位置是："+i);
        Integer deleteNumber = seqList.deleteElem(i);
        if(deleteNumber == null) {
            System.exit(0);
        } else {
            System.out.println("删除的元素是："+ deleteNumber);
            System.out.println("删除元素后数组是：");
            display(seqList);
        }
    }

    /**
     * 测试随机插入方法
     */
    public void insertByRandom() {
        int i = r.nextInt(MAX);
        System.out.println("\n\n随机插入的位置是："+i);
        int elem = r.nextInt(MAX);
        System.out.println("随机插入数据是："+elem);
        seqList.insertElem(i,elem);
        System.out.println("随机插入数据后数组是：");
        display(seqList);
    }

    /**
     * 数据展示
     */
    public void display(SeqList seqList) {
        for (int i = 1; i < seqList.getData().length; i++) {
            if (seqList.getElem(i) != null){
                System.out.print(seqList.getElem(i) + " ");
            }
        }
        System.out.println("\n数组的长度为："+seqList.getLength());
    }

    /**
     * 获取元素
     */
    public void getElem(){
        int i = r.nextInt(MAX);
        System.out.println("\n获取位置为："+i);
        System.out.println("获取到的元素为："+seqList.getElem(i));
    }

    public static void main(String[] args) {
        SeqListTest seqListTest = new SeqListTest();
        seqListTest.insertByRandom();
        seqListTest.deleteElem();
        seqListTest.getElem();
    }
}
