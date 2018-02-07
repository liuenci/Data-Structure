package com.stucture.stack.application.intopost;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author cier
 * @date 2018/2/7 10:50
 */
public class Operators {
    public ArrayList<String> getHZBDS(String expression) {
        /**
         * 如将中缀表达式：9+(3-1)*3+10/2 转化为后缀表达式 9 3 1 - 3 * + 10 2
         * 思路：一个运算符栈 s,遇到数字就输出，而遇到操作符就有条件的进栈
         * 如果当前的运算符的优先级比栈顶元素高则进栈，否则出栈。然后再将当前操作符进栈
         * 但遇到右括号时以此栈中元素出栈直至匹配第一个右括号为止
         */
        Stack<String> expStack = new Stack<String>();
        ArrayList<String> newExp = new ArrayList<String>();
        // 在输入的字符串中，在每个字符间插入一个空格便于区分一位数和多位数
        String[] split = expression.split(" ");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if ("(".equals(s)) {
                expStack.push(s);
            } else if (")".equals(s)) {
                String pop;
                while (!expression.isEmpty()) {
                    pop = expStack.pop();
                    if (pop.equals("(")) {
                        break;
                    } else {
                        newExp.add(pop);
                    }
                }
            } else if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                if (expStack.isEmpty()) {
                    expStack.push(s);
                } else {
                    // 当前输入的运算符s优先级不高于栈顶运算符top的优先级，将比s优先级低或等于的出栈
                    while (!expStack.isEmpty()) {
                        String pop = expStack.peek();
                        if (!comparePro(s, pop)) {
                            newExp.add(expStack.pop());
                        } else {
                            break;
                        }
                    }
                    expStack.push(s);
                }
            } else {
                // 纯数字
                newExp.add(s);
            }
        }
        while (!expStack.isEmpty()) {
            newExp.add(expStack.pop());
        }
        return newExp;
    }

    /**
     * 比较优先级，若inputOper优先级小于等于sTopOperator返回false,大于返回true
     *
     * @param inputOper    输入运算符
     * @param sTopOperator 栈顶运算符
     * @return
     */
    public boolean comparePro(String inputOper, String sTopOperator) {
        // 如果栈顶运算符为左括号，直接将输入运算符压栈
        if ("(".equals(sTopOperator)) {
            return true;
        }
        // 如果当前输入的操作运算符为 "+" 或 "-",并且栈顶运算符为 "*" 或者 "/" 时，输入的运算符优先级大
        if (("*".equals(inputOper) || "/".equals(inputOper)) && ("+".equals(sTopOperator) || "-".equals(sTopOperator))) {
            return true;
        }
        return false;
    }

    public int getResult(ArrayList<String> expression) {
        Stack<Integer> resStack = new Stack<Integer>();
        for (String str : expression) {
            if (str.matches("\\d+")) {
                resStack.push(Integer.valueOf(str));
            } else {
                if (resStack.isEmpty()) {
                    return -1;
                }
                // 栈不空，取出栈中前两个元素
                int tem1 = resStack.pop();
                int tem2 = resStack.pop();
                int temRes = 0;
                switch (str) {
                    case "+":
                        temRes = tem2 + tem1;
                        break;
                    case "-":
                        temRes = tem2 - tem1;
                        break;
                    case "*":
                        temRes = tem2 * tem1;
                        break;
                    case "/":
                        temRes = tem2 / tem1;
                        break;
                    default:
                        break;
                }
                resStack.push(temRes);
            }
        }
        if (resStack.size() == 1) {
            return resStack.pop();
        } else {
            return -1;
        }
    }
}
