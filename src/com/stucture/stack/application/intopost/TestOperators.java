package com.stucture.stack.application.intopost;

import java.util.ArrayList;

/**
 * @author cier
 * @date 2018/2/7 11:30
 */
public class TestOperators {
    public static void main(String[] args) {
        Operators op = new Operators();
        String expression = "9 + ( 3 - 1 ) * 3 + 10 / 2";
        ArrayList<String> res = op.getHZBDS(expression);
        System.out.print("后缀表达式：");
        for (String string : res) {
            System.out.print(string + " ");
        }
        int result = op.getResult(res);
        System.out.println();
        System.out.println("计算结果："+result);
    }


}
