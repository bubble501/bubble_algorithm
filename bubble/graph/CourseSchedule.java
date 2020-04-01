package bubble.graph;
import java.util.*;

/**
 * CourseSchedule
 */
public class CourseSchedule {

    static class TopologicalSort {
        public boolean solve(int num, int[][] preReq) {
            if (preReq == null || preReq.length < 1 || preReq[0].length < 1) return true;
            List<List<Integer>> adj = new ArrayList<>();
            int[] indegree = new int[num];
            for (int i = 0; i < num; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] e: preReq) {
                adj.get(e[0]).add(e[1]);
                indegree[e[1]]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                if (indegree[i]==0) {
                    q.add(i);
                }
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                cnt++;
                for (int next : adj.get(cur)){
                    if (--indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            return cnt == num;
        }
    }

    static class DFS {
        public boolean solve(int num, int[][] preReq) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                adj.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < preReq.length; i++) {
                int start = preReq[i][0];
                int end = preReq[i][1];
                adj.get(start).add(end);
            }

            int[] explored = new int[num];

            for (int i = 0; i < num; i++) {
                if (explored[i] == 2) {
                    continue;
                }

                if (hasCycle(adj, explored, i)) {
                    return false;
                }
            }
            return true;
        }

        public boolean hasCycle(List<List<Integer>> adj, int[] explored, int cur) {
            explored[cur] =1;
            for (int i=0; i < adj.get(cur).size(); i++) {
                int temp = adj.get(cur).get(i);
                if (explored[temp]==1){
                    return true;
                } else if (explored[temp]==0) {
                    if (hasCycle(adj, explored, temp)) {
                        return true;
                    }
                }
            }
            explored[cur] = 2;
            return false;
        }
    }
}