package com.stucture.stack.application.intopost;

/**
 * @author cier
 * @date 2018/2/6 11:00
 */
public class InToPost {
    private Stack stack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in;
        int stackSize = input.length();
        stack = new Stack(stackSize);
    }

    public String doTrans() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                    gotOper(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            output = output + stack.pop();
        }
        System.out.println(output);
        return output;
    }
    public void gotOper(char opThis, int prec1) {
        while(!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            }else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                } else {
                    output = output + opTop;
                }
            }
        }
        stack.push(opThis);
    }

    public void gotParen(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output = output + chx;
            }
        }
    }

    public static void main(String[] args) {
        String input = "1+2*4/5-7+3/6";
        InToPost theTrans = new InToPost(input);
        String output = theTrans.doTrans();
        System.out.println("Postfix is "+output);
    }
    class Stack {
        private int maxSize;
        private char[] stackArray;
        private int top;

        /**
         * 构造栈
         * @param max
         */
        public Stack(int max) {
            maxSize = max;
            stackArray = new char[maxSize];
            top = -1;
        }

        /**
         * 压栈
         * @param j
         */
        public void push(char j) {
            stackArray[++top] = j;
        }

        /**
         * 弹栈
         * @return
         */
        public char pop() {
            return stackArray[top--];
        }

        /**
         * 获取栈顶元素
         * @return
         */
        public char getTop() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }
}
