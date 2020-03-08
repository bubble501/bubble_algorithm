package bubble.dfs;

/**
 * MaxAreaOfIsland
 */
public class MaxAreaOfIsland {

    private static final int[][] offsets = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int calculate(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] count = new int[1];
                dfs(grid, i, j, count);
                res = Math.max(res, count[0]);
            }
        }
        return res;
    }

    private void dfs (int[][] grid, int i, int j, int [] count) {
        int m = grid.length, n=grid[0].length;
        if (i < 0 || i >=m || j< 0 || j >=n || grid[i][j]==0) return;
        grid[i][j] = 0;
        count[0]++;
        for (int[] offset : offsets) {
            dfs(grid, i+offset[0], j+offset[1], count);
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland instance = new MaxAreaOfIsland();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(instance.calculate(grid));
    }
}