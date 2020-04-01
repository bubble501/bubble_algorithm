package bubble.graph;
import java.util.*;

/**
 * IsValidTree
 */
public class IsValidTree {
    static class BFS {
        public boolean solve(int n ,int[][] edges) {
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
            Arrays.stream(edges).forEach(edge->{
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            });

            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (visited[node]) return false;
                visited[node] = true;
                for (int neighbour : graph.get(node)) {
                    queue.offer(neighbour);
                    graph.get(neighbour).remove((Integer) node);
                }
                
            }
            for(boolean result : visited) {
                if(!result) return false;
            }
            return true;
        }
    }

    static class DFS {
        public boolean solve(int n, int[][] edges) {
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
            Arrays.stream(edges).forEach(edge->{
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            });
            boolean[] visited = new boolean[n];
            if (!helper(0, -1, graph, visited)) {
                return false;
            }

            for (boolean b: visited) {
                if(!b) return false;
            }

            return false;
        }

        private boolean helper(int curr, int parent, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited) {
            if (visited[curr]) return false;
            visited[curr] = true;
            for(int i : map.get(curr)) {
                if (1!= parent && !helper(i, curr, map, visited)) {
                    return false;
                }
            }
            return true;
        }
    }
    
}