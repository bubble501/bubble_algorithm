package bubble.graph.color;
import java.util.*;

 
public class IsBipartiteSoluation {
    static class Solution1 {
        public boolean execute(int[][] graph) {
            int n = graph.length;
            if (n==0) return false;
            Map<Integer, Integer> s = new HashMap<>();
            for (int i = 0; i < graph.length; i++) {
                if (s.containsKey(i)==false) {
                    s.put(i, 0);
                    Stack<Integer> stack = new Stack<>();
                    stack.push(i);
                    while(stack.isEmpty()==false) {
                        int n1 = stack.pop();
                        for (int n2 : graph[n1]) {
                            if (s.containsKey(n2)==false) {
                                stack.push(n2);
                                s.put(n2, s.get(n1)^1);
                            } else if(s.get(n2)==s.get(n1)){
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
   

    static class Solution2 {
        private int[] colors;
        public boolean isBipartite(int[][] graph) {
            colors = new int[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if ((colors[i]==0) &&
                    (dfs(graph, i, 1)==false)) {
                        return false;
                }
            }
            return true;
        }

        private boolean dfs(int[][] graph, int node, int color) {
            colors[node] = color;
            for (int neighbor : graph[node]) {
                if (colors[neighbor]==0) {
                    if (dfs(graph, neighbor, -color)==false) {
                        return false;
                    } else if(colors[neighbor] == color) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static class Solution3 {
        public boolean isBipartite(int[][] graph) {
            int[] colors = new int[graph.length];
            for (int i = 0; i < colors.length; i++) {
                if (colors[i] == 0) {
                    colors[i] = 1;
                    Queue<Integer> queue = new ArrayDeque<>();
                    queue.offer(i);
                    while (queue.isEmpty()==false) {
                        int cur = queue.poll();
                        for (int n : graph[cur]) {
                            if(colors[n]==colors[cur]) return false;
                            if(colors[n]!=0) continue;
                            colors[n] = -colors[cur];
                            queue.offer(n);                           
                        }
                    }
                }
            }
            return true;
        }
    }
}