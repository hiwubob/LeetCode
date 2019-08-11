package Í¼;

import java.util.*;

public class No210¿Î³Ì±í2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible=true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = map.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            map.put(src, lst);
            degree[dest]+=1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        int i=0;
        while (!q.isEmpty()) {
            int node=q.remove();
            topologicalOrder[i++]=node;
            if (map.containsKey(node)) {
                for (Integer nei :
                        map.get(node)) {
                    degree[nei]--;
                    if (degree[nei] == 0) {
                        q.add(nei);
                    }
                }

            }
        }

        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];

    }
}
