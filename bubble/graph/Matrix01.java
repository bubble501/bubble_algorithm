package bubble.graph;
import java.util.*;

/**
 * Matrix01
 */
public class Matrix01 {

    void solve(int[][] matrix) {
        if (matrix == null || matrix[0] == null) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j]= Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for(int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length 
                    || matrix[r][c] <= matrix[cell[0]][cell[1]]+1) {
                    continue;
                }
                queue.add(new int[]{r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
    }

    
}