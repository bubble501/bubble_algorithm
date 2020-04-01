package bubble.graph;
import java.util.*;
/**
 * TreeDiameter
 */
public class TreeDiameter {
    private int x;
    private int maxCount;

    int solve(List<Integer> adj[], int n) {
        maxCount = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);
        dfs(0, 0, visited, adj);
        dfs(x, 0, visited, adj);
        return maxCount;
    }

    void dfs(int node, int count, boolean[] visited, List<Integer>  adj[]) {
        visited[node] = true;
        count++;
        List<Integer> l = adj[node];
        for(Integer i: l) {
            if (count >= maxCount) {
                maxCount = count;
                x = i;
            }
            dfs(i, count, visited, adj);
        }
    }
    
}