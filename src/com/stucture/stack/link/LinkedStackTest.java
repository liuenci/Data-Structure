package com.stucture.stack.link;

import java.util.Scanner;

/**
 * @author cier
 * @date 2018/2/2 12:11
 */
public class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStackImpl linkedStack = new LinkedStackImpl();
        Scanner input = new Scanner(System.in);
        int temp;
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第"+(i+1)+"个整数:");
            temp = input.nextInt();
            linkedStack.push(temp);
        }
        while (!linkedStack.isEmpty()) {
            System.out.println(linkedStack.pop());
        }
    }


}
