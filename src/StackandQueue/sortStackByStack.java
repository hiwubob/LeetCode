package StackandQueue;

import java.util.Stack;

public class sortStackByStack {
    //一个栈中的元素为整形，
    // 现在将该栈从顶到底按从大到小的顺序排列，
    // 只允许申请一个栈。可以申请新的变量，但不能额外申请额外的数据结构
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur=stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
