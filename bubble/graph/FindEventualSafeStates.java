package bubble.graph;
import java.util.*;
/**
 * FindEventualSafeStates
 */
public class FindEventualSafeStates {
    public List<Integer> solve(int[][] graph) {
        List<Integer> rst = new ArrayList<>();
        byte[] visited = new byte[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, visited)) {
                rst.add(i);
            }
        }
        return rst;
    }
    
    private boolean dfs(int[][] graph, int index, byte[] visited) {
        if (visited[index] == -1) {
            return false;
        }

        if (visited[index] == 1) {
            return true;
        }

        visited[index] = -1;
        for (int neigh : graph[index]) {
            if (!dfs(graph, neigh, visited)) {
                return false;
            }
        }
        visited[index] = 1;
        return true;
    }
}