package StackandQueue;

import java.util.Stack;

public class TwoStackQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPop=new Stack<>();
        stackPush=new Stack<>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }
    public int pop(){
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException();
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    public int peep(){
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException();
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
