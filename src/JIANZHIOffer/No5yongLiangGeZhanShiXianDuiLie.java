package JIANZHIOffer;

import java.util.Stack;

public class No5yongLiangGeZhanShiXianDuiLie {
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public void push(int node) {
        s1.push(node);
    }

    public int pop() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
