package 笔试;

import java.util.*;

public class NO拼多多3 {

/*        现在一共有N个待执行的任务，每个任务需要Pi的时间完成执行。
        同时任务之间可能会有一些依赖关系，比如任务1可能依赖任务2和任务3，
        那么任务1必须等任务2和任务3执行完成后才能开始执行。为了最小化任务的平均返回时长，
        请安排所有任务的执行顺序。假设在零时刻，所有N个任务已到达系统。*/

/*    本题应该是考察图的拓扑序，即所有的任务根据依赖关系可以画出一张依赖图，
    每轮迭代执行一批入度为0的任务，为了满足平均返回时长最小的要求，
    入度为0的任务再根据任务时长短的优先执行的贪心策略执行，可以使用优先队列实现*/
    static class Task {
        int seq;
        int weight;

        public Task(int n, int w) {
            seq = n;
            weight = w;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            Task[] t = new Task[n + 1];
            for (int i = 1; i < n + 1; ++i) {
                t[i] = new Task(i, in.nextInt());
            }
            // construct dependency raph
            Map<Integer, List<Integer>> graph = new HashMap<>();
            int[] indegree = new int[n + 1];
            for (int i = 0; i < m; ++i) {
                int u = in.nextInt();
                int v = in.nextInt();
                /*if (graph.containsKey(u)) {
                    graph.get(u).add(v);
                } else {
                    List<Integer> edges = new ArrayList<>();
                    edges.add(v);
                    graph.put(u, edges);
                }*/
                List<Integer> edges = graph.getOrDefault(u, new ArrayList<>());
                edges.add(v);
                graph.put(u, edges);
                indegree[v]++;
            }
            //topological sort
            PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    return o1.weight - o2.weight;
                }
            });
            for (int i = 1; i < n + 1; ++i) {
                if (indegree[i] == 0) queue.offer(t[i]);
            }
            List<Integer> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                Task complete = queue.poll();
                res.add(complete.seq);
                if (graph.containsKey(complete.seq)) {
                    for (int i : graph.get(complete.seq)) {
                        if (--indegree[i] == 0) {
                            queue.offer(t[i]);
                        }
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                System.out.print(res.get(i));
                if (i != n - 1) System.out.print(" ");
            }
        }
    }

}
