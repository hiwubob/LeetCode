package Í¼;

import java.util.LinkedList;

public class No207¿Î³Ì±í {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        for (int[] cp : prerequisites) {
            degrees[cp[0]]++;
        }
        LinkedList<Integer> queue=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer pre=queue.removeFirst();
            numCourses--;
            for (int[] req :
                    prerequisites) {
                if (req[1] != pre) {
                    continue;
                }
                if (--degrees[req[0]] == 0) {
                    queue.add(req[0]);
                }
            }

        }return numCourses==0;
    }
}
