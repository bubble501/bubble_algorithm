package bubble.graph;

/**
 * MaxAreaOfIsland
 */
public class MaxAreaOfIsland {

    public int solve(int[][] area) {
        if (area == null || area.length ==0) return 0;
        int r = area.length, c = area[0].length;
        boolean visited[][] = new boolean[r][c];
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visited[i][j] && area[i][j]==1) {
                    int cur = bfs(area, visited, i, j);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int bfs(int[][] area, boolean[][] visited, int i, int j) {
        if (i < 0 || i >=area.length ||j < 0 || j >= area[0].length || visited[i][j] == true ||area[i][j]==0) {
            return 0;
        }
        visited[i][j] = true;
        int ans = 1;
        for (int[] dir : directions) {
            ans += bfs(area, visited, i+dir[0], j+dir[1]);
        } 
        return ans;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland instance = new MaxAreaOfIsland();
        int[][] area = {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(instance.solve(area));
    }
}