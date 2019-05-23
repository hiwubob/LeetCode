package StackandQueue;

import java.util.Stack;

public class Mystack {
    //    实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈的最小元素的操作
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(int newNum) {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int val = this.stackData.pop();
        if (val == this.getMin()) {
            this.stackMin.pop();
        }
        return val;
    }

    private int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("STACK IS EMPTY");
        }
        return this.stackMin.peek();
    }

}
