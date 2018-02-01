package com.stucture.stack.sequence;

import java.util.Scanner;

/**
 * @author cier
 * @date 2018/2/1 12:25
 */
public class SequenceStackTest {
    public static void main(String[] args) {
        SequenceStackImpl sequenceStack = new SequenceStackImpl();
        Scanner input = new Scanner(System.in);
        for(int i = 0;i<10;i++) {
            System.out.println("请输入第"+(i + 1)+"个整数：");
            sequenceStack.push(input.next());
        }
        while (!sequenceStack.isEmpty()){
            System.out.println(sequenceStack.pop());
        }
    }
}
