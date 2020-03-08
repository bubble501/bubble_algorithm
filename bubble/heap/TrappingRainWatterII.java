package bubble.heap;
import java.util.*;

/**
 * TrappingRainWatterII
 */
public class TrappingRainWatterII {
    class Cell {
        int h;
        int x, y;
        public Cell(int h, int x , int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int solve(int[][] heights) {
        int res = 0;
        if (heights == null || heights.length < 1 || heights[0].length < 1) return 0;
        int m = heights.length, n = heights[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b)->a.h - b.h);
        boolean[][] visited = new boolean[m][n];
        int[] borderColumns = {0, n-1};
        int[] borderRows = {0, m-1};
        for (int i = 0; i < n; i++ ) {
            for (int row : borderRows) {
                visited[row][i] = true;
                pq.offer(new Cell(heights[row][i], row, i));
            }
        }
        for (int i = 0; i < m; i++ ) {
            for (int column: borderColumns) {
                visited[i][column] = true;
                pq.offer(new Cell(heights[i][column], i, column));
            }
        }
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            for ( int[] delta : dir) {
                int x = cur.x + delta[0];
                int y = cur.y + delta[1];
                if (x >=0 && x < m && y >=0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, cur.h - heights[x][y]);
                    pq.offer(new Cell(Math.max(cur.h, heights[x][y]), x, y));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWatterII ins = new TrappingRainWatterII();
        int[][] heights = {
            {1,4,3,1,3,2},
            {3,2,1,3,2,4},
            {2,3,3,2,3,1}
        };
        System.out.println(ins.solve(heights));
    }
}