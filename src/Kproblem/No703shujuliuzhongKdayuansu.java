package Kproblem;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k =k;
        PriorityQueue<Integer> queue=new PriorityQueue<>(k);
        for (int i :
                nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
