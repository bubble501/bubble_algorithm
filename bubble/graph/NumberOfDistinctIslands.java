package bubble.graph;
import java.util.*;

/**
 * NumberOfDistinctIslands
 */
public class NumberOfDistinctIslands {

    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int solve(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        Set<String> res = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Set<String> set = new HashSet<>();
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, i, j, set);
                    res.add(set.toString());
                }
            }
        }
        return res.size();
    }

    public void dfs(int[][] grid, int i, int j, int baseX, int baseY, Set<String> set) {
        if (i < 0 || i>=grid.length || j < 0|| j >=grid[0].length || grid[i][j]==0) return;
        set.add((i-baseX)+"_" + (j - baseY));
        grid[i][j] = 0;
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j+dir[1], baseX, baseY, set);
        }
    }
}