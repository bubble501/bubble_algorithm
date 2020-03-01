package bubble.unionfind;
import java.util.ArrayList;
/**
 * PathWithMaxMiniValueSolution
 */
public class PathWithMaxMiniValueSolution {

    static class DSU {
        private int[] parent;

        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while(x!=parent[x]) {
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public int findMaxMin(int[][] grid) {
        ArrayList<int[]> l = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                l.add(new int[] {grid[i][j], i, j});
            }
        }
        //sort from big to small.
        l.sort((a, b)->b[0]-a[0]);
        int totalCount = grid.length * grid[0].length;
        DSU dsu = new DSU(totalCount);
        int[][] change = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < l.size(); i++) {
            int v = l.get(i)[0];
            int x = l.get(i)[1];
            int y = l.get(i)[2];
            visited[x][y] = true;
            for (int[] offset : change) {
                int x2 = x + offset[0];
                int y2 = y + offset[1];
                if ((x2 >= 0) && (x2 < grid.length) && (y2 >= 0) && (y2 < grid[0].length)) {
                    if (visited[x2][y2]) {
                        dsu.union(x*grid[0].length+y, x2*grid[0].length+y2);
                        if (dsu.find(0) == dsu.find(totalCount-1)) {
                            return v;
                        }
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        PathWithMaxMiniValueSolution ps = new PathWithMaxMiniValueSolution();
        // int[][] grid = new int[][] {{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
        int[][] grid = new int[][]{
            {3, 4, 6, 3, 4},
            {0, 2 ,1, 1, 7},
            {8, 8, 3, 2, 7},
            {3, 2, 4, 9, 8},
            {4, 1, 2, 0, 0},
            {4, 6, 5, 4, 3}
        };
        int value = ps.findMaxMin(grid);
        System.out.println(value);
    }
}