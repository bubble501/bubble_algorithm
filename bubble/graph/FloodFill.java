package bubble.graph;
import java.util.*;

/**
 * FloodFill
 */
public class FloodFill {

    static class BFS {
        private static final int[][] directions = {
            {1, 0}, {1, -1}, {1, 1}, 
            {0, 1}, {0, -1},
            {-1, 0}, {-1, -1}, {-1, 1}};

        public boolean isSafe(char[][] M, int m, int n, int x , int y, char target) {
            return x>=0 && x <m && y>=0 && y<n && M[x][y]== target;
        }
        
        public void solve(char[][] M, int x, int y, char replacement) {
            if (M == null || M[0] == null) return;
            int m = M.length;
            int n = M[0].length;
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{x, y});
            char target = M[x][y];
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                M[cur[0]][cur[1]] = replacement;
                for (int i = 0; i < directions.length; i++) {
                    if (isSafe(M, m, n, x+directions[i][0], y+directions[i][1], target)) {
                        q.offer(new int[]{x+directions[i][0], y+directions[i][1]});
                    }
                }
            }
        }
    }
}